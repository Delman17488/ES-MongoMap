package uk.ac.bham.mongoMap.map.rules;

import uk.ac.bham.mongoMap.model.mongo.Key;
import uk.ac.bham.mongoMap.model.mongo.MongoFactory;
import uk.ac.bham.mongoMap.model.mongo.Value;
import uk.ac.bham.mongoMap.model.sql.Cell;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.Transformer;

public class CellToKeyVal implements Rule<Cell, Key> {
	
	private int id = 1;
	
	@Override
	public boolean check(Cell source) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Key build(Cell source, Transformer t) {
		MongoFactory mongoFactory = MongoFactory.eINSTANCE;
		Key key = mongoFactory.createKey();
		
		Value val = mongoFactory.createValue();
		//Take the datatype from the column inside of the cell
		val.setType(source.getColumn().getType());
		//Take the value from the cell 
		val.setValue(source.getValue());
		//Take the name of the key from the column inside of the cell
		key.setName(source.getColumn().getName());
		key.setValue(val);
		
		return key;
	}

	@Override
	public void setProperties(Key target, Cell source, Transformer t) {
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
		CellToKeyVal other = (CellToKeyVal) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
