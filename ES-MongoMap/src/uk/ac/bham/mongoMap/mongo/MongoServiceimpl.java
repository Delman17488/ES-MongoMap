package uk.ac.bham.mongoMap.mongo;

import java.net.UnknownHostException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.eclipse.emf.common.util.EList;

import uk.ac.bham.mongoMap.map.Packet;
import uk.ac.bham.mongoMap.model.mongo.Collection;
import uk.ac.bham.mongoMap.model.mongo.Document;
import uk.ac.bham.mongoMap.model.mongo.Id;
import uk.ac.bham.mongoMap.model.mongo.Key;
import uk.ac.bham.mongoMap.model.mongo.MongoDB;
import uk.ac.bham.mongoMap.model.mongo.MongoObject;
import uk.ac.bham.mongoMap.model.mongo.UniqueIndex;
import uk.ac.bham.mongoMap.model.mongo.Value;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class MongoServiceimpl implements MongoService {

	private DB db;
	private Mongo mongoConnection = null;

	private Thread consumer;

	public MongoServiceimpl(String ip, int port) throws Exception {
		// connect to mongoDB
		try {
			mongoConnection = new Mongo(ip, port);
		} catch (UnknownHostException e) {
			throw new Exception(
					"Error: Unknown host while trying to connect to MongoDB.", e);
		}
	}

	@Override
	public void setMongoDBDatabase(MongoDB mDB) {
		// open mongoDB database
		String dbname = mDB.getName();
		db = mongoConnection.getDB(dbname);
	}

	public BasicDBObject buildDocument(Document document) {
		BasicDBObject documentObject = new BasicDBObject();

		// add _id
		Id id = document.getId();
		if (id != null) {
			MongoObject m = id.getValue();
			if (m instanceof Document) {

				BasicDBObject value = buildDocument((Document) m);
				documentObject.put("_id", value);
			} else {
				Value val = (Value) m;
				Object value = val.getValue();

				// check if given object datatype is supported for mongoDB
				// value= checktype(value);

				documentObject.put("_id", value);
			}
		}

		// add other key value pairs
		EList<Key> keys = document.getKeys();
		documentObject = addValues(keys, documentObject);

		return documentObject;
	}

	private BasicDBObject addValues(EList<Key> keys,
			BasicDBObject documentObject) {
		// TODO Auto-generated method stub
		for (Key key : keys) {
			String name = key.getName();

			MongoObject m = key.getValue();
			if (m instanceof Value) {
				// if document
				Value val = (Value) m;
				Object value = val.getValue();

				// check if given object datatype is supported for mongoDB
				// value= checktype(value);

				documentObject.put(name, value);
			} else {
				// if value
				BasicDBObject value = buildDocument((Document) m);

				documentObject.put(name, value);
			}
		}
		return documentObject;
	}

	@Override
	public BlockingQueue<Packet<Document>> getDocumentQueue(Collection c,
			int size) throws Exception {
		/*
		 * This implementation of the interface just allows to insert documents
		 * to one collection at a time. Therefore, if this method is called
		 * twice the method blocks until the thread finished.
		 */
		if (this.consumer != null && this.consumer.isAlive()) {
			try {
				this.consumer.join();
			} catch (InterruptedException e) {
				throw new Exception(
						"Error: Consumer thread has been interrupted.", e);
			}
		}

		/*
		 * Drop collection before inserting documents. This way we avoid
		 * unwanted duplicates and id violation errors.
		 */
		String colname = c.getName();
		DBCollection collection = db.getCollection(colname);
		collection.drop();
		System.out.println("Collection : " + colname);

		// Add indices to the collection.
		for (UniqueIndex list : c.getUniqueIndices()) {
			for (String key : list.getKeys()) {
				collection.ensureIndex(new BasicDBObject(key, 1),
						new BasicDBObject("unique", true));
			}
		}

		/*
		 * Start thread which receives documents from the Sitra mapper for
		 * inserting them to MongoDB.
		 */
		DocumentConsumer consumer = new DocumentConsumer(collection, size);
		this.consumer = new Thread(consumer);
		this.consumer.start();
		return consumer.getQueue();
	}

	private class DocumentConsumer implements Runnable {

		private BlockingQueue<Packet<Document>> queue;
		private DBCollection dbCollection;

		public DocumentConsumer(DBCollection dbCollection, int size) {
			queue = new ArrayBlockingQueue<Packet<Document>>(size);
			this.dbCollection = dbCollection;
		}

		public void consume() throws Exception {
			boolean lastPacket = false;
			while (!lastPacket) {
				try {
					Packet<Document> packet;

					// get document packet
					packet = queue.take();

					// insert document to MongoDB
					BasicDBObject documentObject = buildDocument(packet
							.getPayload());
					dbCollection.insert(documentObject);

					if (packet.isLastPacket())
						lastPacket = true;
				} catch (InterruptedException e) {
					throw new Exception(
							"Error: Taking package from queue failed.", e);
				}
			}
		}

		@Override
		public void run() {
			try {
				consume();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public BlockingQueue<Packet<Document>> getQueue() {
			return queue;
		}

	}

}
