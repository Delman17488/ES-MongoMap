package uk.ac.bham.mongoMap.sql;

import uk.ac.bham.mongoMap.model.sql.Database;

public interface SqlService {
	
	public Database getDatabase(String dbName);

}
