package uk.ac.bham.mongoMap.sql;

import java.util.Queue;

import uk.ac.bham.mongoMap.map.Packet;
import uk.ac.bham.mongoMap.model.sql.Database;
import uk.ac.bham.mongoMap.model.sql.Row;
import uk.ac.bham.mongoMap.model.sql.Table;

public interface SqlService {

	public Database getDatabase();
	
	public Database getDatabase(String dbName);
	
	public Queue<Packet<Row>> getRowQueue(Table t, int size);

}
