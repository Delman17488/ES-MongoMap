package uk.ac.bham.mongoMap.map.rules;

import uk.ac.bham.mongoMap.model.mongo.Key;
import uk.ac.bham.mongoMap.model.sql.Constraint;
import uk.ac.bham.mongoMap.model.sql.ConstraintType;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.Transformer;

public class ForeignKeyToKeyVal implements Rule<Constraint, Key> {

	public ForeignKeyToKeyVal() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean check(Constraint source) {
		if (source.getType() == ConstraintType.FOREIGN_KEY) {
			return true;
		}
		return false;
	}

	@Override
	public Key build(Constraint source, Transformer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperties(Key target, Constraint source, Transformer t) {
		// TODO Auto-generated method stub
		
	}


}
