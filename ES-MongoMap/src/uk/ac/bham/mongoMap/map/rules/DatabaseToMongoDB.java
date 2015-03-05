package uk.ac.bham.mongoMap.map.rules;

import uk.ac.bham.mongoMap.model.mongo.MongoDB;
import uk.ac.bham.mongoMap.model.sql.Database;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.Transformer;

public class DatabaseToMongoDB implements Rule<Database, MongoDB> {

	public DatabaseToMongoDB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean check(Database source) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MongoDB build(Database source, Transformer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperties(MongoDB target, Database source, Transformer t) {
		// TODO Auto-generated method stub
		
	}


}
