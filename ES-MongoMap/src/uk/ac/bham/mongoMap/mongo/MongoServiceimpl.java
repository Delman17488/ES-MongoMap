package uk.ac.bham.mongoMap.mongo;

import java.net.UnknownHostException;
import java.util.Queue;
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

	public MongoServiceimpl(String ip, int port) {
		// connect to mongoDB
		try {
			mongoConnection = new Mongo(ip, port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean setMongoDBDatabase(MongoDB mDB) {
		// open mongoDB database
		String dbname = mDB.getName();
		db = mongoConnection.getDB(dbname);

		// EList<Collection> col = mDB.getCollections();
		//
		// long startTime = System.currentTimeMillis();
		//
		//
		// JFrame frame = new JFrame("JOptionPane showMessageDialog ");
		// JLabel status = new JLabel();
		// final JOptionPane optionPane = new JOptionPane(status);
		//
		// // create dialog box to show status
		// final JDialog dialog = new JDialog(frame, "Write Status", true);
		// dialog.setSize(600, 110);
		// dialog.setContentPane(optionPane);
		// Thread t = new Thread(new Runnable() {
		// public void run() {
		// dialog.setVisible(true);
		// }
		// });
		// t.start();
		//
		// int colcount = 0;
		//
		// for (Collection c : col) {
		// String colname = c.getName();
		// colcount++;
		// DBCollection collection = db.getCollection(colname);
		// collection.drop();
		// System.out.println("Collection : " + colname);
		//
		// // create indices
		//
		// for (UniqueIndex list : c.getUniqueIndices()) {
		//
		// for (String key : list.getKeys()) {
		//
		// System.out.println("unique index " + key);
		// collection.ensureIndex(new BasicDBObject(key, 1),
		// new BasicDBObject("unique", true));
		// }
		//
		// }
		//
		// // add each document to the collection
		//
		// EList<Document> doc = c.getDocuments();
		// int count = 0;
		// for (Document document : doc) {
		// count++;
		// status.setText("<html>Working on Collection: " + colcount + "/"
		// + col.size() + "<br>" + "Collection: " + colname
		// + " Documents added: " + count + "</html>");
		// status.repaint();
		//
		// BasicDBObject documentObject = buildDocument(document);
		// // documentObject.
		// try {
		// collection.insert(documentObject);
		// } catch (IllegalArgumentException e) {
		// System.out.println("Illegal Argument");
		// }
		//
		// }
		//
		// // display all documents in the collection
		// /*
		// * DBCursor cursorDocJSON = collection.find(); while
		// * (cursorDocJSON.hasNext()) {
		// * System.out.println(cursorDocJSON.next()); } System.out.println();
		// */
		//
		// }
		// // TODO Auto-generated method stub
		// dialog.setVisible(false);
		// long endTime = System.currentTimeMillis();
		// System.out.println("Time taken for writing data to mongoDB :"
		// + ((endTime - startTime) / 1000) + " Seconds");
		// // System.exit(0);
		return true;

	}

	public BasicDBObject buildDocument(Document document) {
		// TODO Auto-generated method stub
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

	private Object checktype(Object value) {
		// TODO Auto-generated method stub
		DBCollection c = db.getCollection("testbigdb");
		c.drop();
		BasicDBObject temp = new BasicDBObject();
		temp.put("sam", value);
		try {
			c.insert(temp);
		} catch (IllegalArgumentException e) {

			// change to string if non compatible
			String tempstring = value.toString();
			value = tempstring;

		}
		return value;
	}

	@Override
	public BlockingQueue<Packet<Document>> getDocumentQueue(Collection c, int size) {
		if (this.consumer != null && this.consumer.isAlive()) {
			try {
				this.consumer.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String colname = c.getName();
		DBCollection collection = db.getCollection(colname);
		collection.drop();
		System.out.println("Collection : " + colname);

		// create indices

		for (UniqueIndex list : c.getUniqueIndices()) {

			for (String key : list.getKeys()) {

				System.out.println("unique index " + key);
				collection.ensureIndex(new BasicDBObject(key, 1),
						new BasicDBObject("unique", true));
			}

		}

		Consumer consumer = new Consumer(collection, size);
		this.consumer = new Thread(consumer);
		this.consumer.start();
		return consumer.getQueue();
	}

	private class Consumer implements Runnable {

		private BlockingQueue<Packet<Document>> queue;
		private DBCollection dbCollection;

		public Consumer(DBCollection dbCollection, int size) {
			queue = new ArrayBlockingQueue<Packet<Document>>(size);
			this.dbCollection = dbCollection;
		}

		public void consume() {
			boolean lastPacket = false;
			while (!lastPacket) {
				try {
					Packet<Document> packet;
					packet = queue.take();

					BasicDBObject documentObject = buildDocument(packet
							.getPayload());
					try {
						dbCollection.insert(documentObject);
					} catch (IllegalArgumentException e) {
						System.out.println("Illegal Argument");
					}

					if (packet.isLastPacket())
						lastPacket = true;
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		@Override
		public void run() {
			consume();
		}

		public BlockingQueue<Packet<Document>> getQueue() {
			return queue;
		}

	}

}
