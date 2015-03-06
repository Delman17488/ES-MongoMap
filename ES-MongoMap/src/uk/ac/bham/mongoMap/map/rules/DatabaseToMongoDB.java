package uk.ac.bham.mongoMap.map.rules;

import uk.ac.bham.mongoMap.model.mongo.Collection;
import uk.ac.bham.mongoMap.model.mongo.MongoDB;
import uk.ac.bham.mongoMap.model.mongo.MongoFactory;
import uk.ac.bham.mongoMap.model.mongo.impl.MongoFactoryImpl;
import uk.ac.bham.mongoMap.model.sql.Database;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.RuleNotFoundException;
import uk.ac.bham.sitra.Transformer;

public class DatabaseToMongoDB implements Rule<Database, MongoDB> {

	public DatabaseToMongoDB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean check(Database source) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public MongoDB build(Database source, Transformer t) {
		// TODO Auto-generated method stub
		source.getTable();
		Collection coll = null;
		try {
			coll = t.transform(TableToCollection.class, source.getTable().get(0));
		} catch (RuleNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MongoFactory mf = new MongoFactoryImpl();
		MongoDB mdb = mf.createMongoDB();
		mdb.getCollections().add(coll);
		return mdb;
	}

	@Override
	public void setProperties(MongoDB target, Database source, Transformer t) {
		// TODO Auto-generated method stub
		
	}


}
