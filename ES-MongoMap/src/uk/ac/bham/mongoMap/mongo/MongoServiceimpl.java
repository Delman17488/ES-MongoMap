package uk.ac.bham.mongoMap.mongo;

import java.math.BigDecimal;
import java.net.UnknownHostException;

import org.eclipse.emf.common.util.EList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

import uk.ac.bham.mongoMap.model.mongo.Collection;
import uk.ac.bham.mongoMap.model.mongo.Document;
import uk.ac.bham.mongoMap.model.mongo.Id;
import uk.ac.bham.mongoMap.model.mongo.Key;
import uk.ac.bham.mongoMap.model.mongo.MongoDB;
import uk.ac.bham.mongoMap.model.mongo.MongoObject;
import uk.ac.bham.mongoMap.model.mongo.UniqueIndex;
import uk.ac.bham.mongoMap.model.mongo.Value;
import uk.ac.bham.mongoMap.model.sql.Datatype;

public class MongoServiceimpl implements MongoService{
	DB db;

	@Override
	public boolean setMongoDBDatabase(MongoDB mDB) {
		EList<Collection> col = mDB.getCollections();
		Mongo mongo = null;
		//connect to mongoDB
		try {
			mongo = new Mongo("localhost", 27017);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//open mongo database
		String dbname= mDB.getName();
		 db = mongo.getDB(dbname);

		for(Collection c : col)
		{
			String  colname= c.getName();

			DBCollection collection= db.getCollection(colname);
			collection.drop();
			System.out.println("Collection : "+ colname);

			// create indices

			for (UniqueIndex list : c.getUniqueIndices()) {

				for (String key : list.getKeys()) {

					System.out.println("unique index "+key);
				//	collection.ensureIndex(new BasicDBObject(key, 1), new BasicDBObject("unique", true));
				}

			}

			//add each document to the collection

			EList<Document> doc = c.getDocuments();
			for(Document document :doc)
			{
				
				BasicDBObject documentObject=buildDocument(document);
				//documentObject.
				try{
				collection.insert(documentObject);
				}catch(IllegalArgumentException e){
					
					System.out.println("Illegal Argument");
					//e.printStackTrace();
				}

			}

			//display all documents in the collection
			DBCursor cursorDocJSON = collection.find();
			while (cursorDocJSON.hasNext()) {
				System.out.println(cursorDocJSON.next());
			}
			System.out.println();

		}
		// TODO Auto-generated method stub
		return true;
	}

	public BasicDBObject buildDocument(Document document) {
		// TODO Auto-generated method stub
		BasicDBObject documentObject = new BasicDBObject();

		//add _id
		Id id =document.getId();
		if(id!=null)
		{
			MongoObject m = id.getValue();
			if(m instanceof Document)
			{

				BasicDBObject value = buildDocument((Document) m);
				documentObject.put("_id", value);
			}
			else
			{
				Value val = (Value) m;
				Object value = val.getValue();

				documentObject.put("_id", value);
			}
		}


		//add other key value pairs
		EList<Key> keys = document.getKeys();
		documentObject = addValues(keys,documentObject);



		return documentObject;
	}

	private BasicDBObject addValues(EList<Key> keys, BasicDBObject documentObject) {
		// TODO Auto-generated method stub
		for(Key key:keys)
		{
			String name= key.getName();
			
			MongoObject m=	key.getValue();
			if(m instanceof Value )
			{
				//if document
				Value val = (Value) m;
				Object value = val.getValue();
				
				value= checktype(value);
				
												
				documentObject.put(name, value);
			}
			else
			{
				//if value
				BasicDBObject value= buildDocument((Document) m);
				documentObject.put(name, value);
			}
		}
		return documentObject;
	}

	private Object checktype(Object value) {
		// TODO Auto-generated method stub
		DBCollection c= db.getCollection("testbigdb");
		c.drop();
		BasicDBObject temp =  new BasicDBObject();
		temp.put("sam", value);
		try{
		c.insert(temp);
		}catch(IllegalArgumentException e){
			
			//System.out.println("Illegal ");
			BigDecimal tem=(BigDecimal) value;
			String t=tem.toString();
			//e.printStackTrace();
			//Double te= new Double(t);
			value= t;
		}
		return value;
	}



}
