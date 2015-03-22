package uk.ac.bham.mongoMap.sql;

import java.util.concurrent.BlockingQueue;

import uk.ac.bham.mongoMap.map.Packet;
import uk.ac.bham.mongoMap.model.sql.Database;
import uk.ac.bham.mongoMap.model.sql.Row;
import uk.ac.bham.mongoMap.model.sql.Table;

public interface SqlService {

	public Database getDatabase();
	
	public BlockingQueue<Packet<Row>> getRowQueue(Table t, int size);

}
