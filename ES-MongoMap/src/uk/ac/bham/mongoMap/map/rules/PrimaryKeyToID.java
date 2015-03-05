package uk.ac.bham.mongoMap.map.rules;

import uk.ac.bham.mongoMap.model.mongo.Id;
import uk.ac.bham.mongoMap.model.sql.Constraint;
import uk.ac.bham.mongoMap.model.sql.ConstraintType;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.Transformer;

public class PrimaryKeyToID implements Rule<Constraint, Id> {

	public PrimaryKeyToID() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean check(Constraint source) {
		if (source.getType() == ConstraintType.PRIMARY_KEY) {
			return true;
		}
		return false;
	}

	
	@Override
	public Id build(Constraint source, Transformer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperties(Id target, Constraint source, Transformer t) {
		// TODO Auto-generated method stub
		
	}

}
