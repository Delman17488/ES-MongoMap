package uk.ac.bham.mongoMap.map.rules;

import uk.ac.bham.mongoMap.model.mongo.Id;
import uk.ac.bham.mongoMap.model.mongo.MongoFactory;
import uk.ac.bham.mongoMap.model.mongo.Value;
import uk.ac.bham.mongoMap.model.sql.Cell;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.Transformer;

public class PrimaryKeyToID implements Rule<Cell, Id> {

	public PrimaryKeyToID() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean check(Cell source) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Id build(Cell source, Transformer t) {
		MongoFactory mongoFactory = MongoFactory.eINSTANCE;
		Id id = mongoFactory.createId();
		
		Value val = mongoFactory.createValue();
		val.setType(source.getColumn().getType());
		val.setValue(source.getValue());
		
		id.setValue(val);
		
		return id;
	}

	@Override
	public void setProperties(Id target, Cell source, Transformer t) {
		// TODO Auto-generated method stub
		
	}

}
