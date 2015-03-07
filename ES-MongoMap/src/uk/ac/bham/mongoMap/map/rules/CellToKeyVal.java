package uk.ac.bham.mongoMap.map.rules;

import java.security.KeyFactory;

import uk.ac.bham.mongoMap.model.mongo.Key;
import uk.ac.bham.mongoMap.model.mongo.MongoFactory;
import uk.ac.bham.mongoMap.model.mongo.Value;
import uk.ac.bham.mongoMap.model.sql.Cell;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.Transformer;

public class CellToKeyVal implements Rule<Cell, Value> {

	@Override
	public boolean check(Cell source) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Value build(Cell source, Transformer t) {
		// TODO Auto-generated method stub
		
		MongoFactory mongoFactory = MongoFactory.eINSTANCE;
		Value value = mongoFactory.createValue();
		
		value.setType(source.getColumn().getType());
		value.setValue(source.getValue());
		
		return value;
	}

	@Override
	public void setProperties(Value target, Cell source, Transformer t) {
		// TODO Auto-generated method stub
		
	}


}
