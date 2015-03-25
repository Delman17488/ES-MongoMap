package uk.ac.bham.mongoMap.sql;

import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;

import uk.ac.bham.mongoMap.map.Packet;
import uk.ac.bham.mongoMap.model.sql.Database;
import uk.ac.bham.mongoMap.model.sql.Row;
import uk.ac.bham.mongoMap.model.sql.Table;

public interface SqlService {

	public Database getDatabase() throws SQLException;
	
	public BlockingQueue<Packet<Row>> getRowQueue(Table t, int size);

}
