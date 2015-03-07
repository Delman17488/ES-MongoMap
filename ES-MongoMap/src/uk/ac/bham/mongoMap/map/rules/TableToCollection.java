package uk.ac.bham.mongoMap.map.rules;

import uk.ac.bham.mongoMap.model.mongo.Collection;
import uk.ac.bham.mongoMap.model.mongo.MongoDB;
import uk.ac.bham.mongoMap.model.mongo.MongoFactory;
import uk.ac.bham.mongoMap.model.mongo.impl.MongoFactoryImpl;
import uk.ac.bham.mongoMap.model.sql.Table;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.Transformer;

public class TableToCollection implements Rule<Table, Collection> {

	public TableToCollection() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean check(Table source) {
		return true;
	}

	@Override
	public Collection build(Table source, Transformer t) {
		MongoFactory mf = new MongoFactoryImpl();
		Collection coll = mf.createCollection();
		coll.setName(source.getName());
		
		return coll;
	}

	@Override
	public void setProperties(Collection target, Table source, Transformer t) {
		// TODO Auto-generated method stub
		
	}

}
