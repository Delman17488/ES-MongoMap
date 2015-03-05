package uk.ac.bham.mongoMap.map.rules;

import uk.ac.bham.mongoMap.model.mongo.Id;
import uk.ac.bham.mongoMap.model.sql.Column;
import uk.ac.bham.mongoMap.model.sql.Constraint;
import uk.ac.bham.mongoMap.model.sql.ConstraintType;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.Transformer;

public class CompositePrimaryKeyToID implements Rule<Constraint, Id> {

	public CompositePrimaryKeyToID() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean check(Constraint source) {
		if (source.getType() == ConstraintType.COMPOSITE_PRIMARY_KEY) {
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
