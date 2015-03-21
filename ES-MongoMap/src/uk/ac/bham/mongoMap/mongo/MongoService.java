package uk.ac.bham.mongoMap.mongo;

import java.net.UnknownHostException;
import java.util.concurrent.BlockingQueue;

import uk.ac.bham.mongoMap.model.mongo.Collection;
import uk.ac.bham.mongoMap.model.mongo.Document;
import uk.ac.bham.mongoMap.model.mongo.MongoDB;

public interface MongoService {
	
	public boolean setMongoDBDatabase(MongoDB mDB);
	
	public BlockingQueue<Document> getCollectionQueue(Collection table);

}
