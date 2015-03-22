package uk.ac.bham.mongoMap.map.rules;

import uk.ac.bham.mongoMap.model.mongo.Collection;
import uk.ac.bham.mongoMap.model.mongo.MongoDB;
import uk.ac.bham.mongoMap.model.mongo.MongoFactory;
import uk.ac.bham.mongoMap.model.mongo.impl.MongoFactoryImpl;
import uk.ac.bham.mongoMap.model.sql.Table;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.Transformer;

public class TableToCollection implements Rule<Table, Collection> {

	private int id = 5;
	
	public TableToCollection() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean check(Table source) {
		return true;
	}

	@Override
	public Collection build(Table source, Transformer t) {
		MongoFactory mf = MongoFactory.eINSTANCE;
		Collection coll = mf.createCollection();
		coll.setName(source.getName());
		
		return coll;
	}

	@Override
	public void setProperties(Collection target, Table source, Transformer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TableToCollection other = (TableToCollection) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
