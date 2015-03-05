package uk.ac.bham.mongoMap.map.rules;

import uk.ac.bham.mongoMap.model.mongo.UniqueIndex;
import uk.ac.bham.mongoMap.model.sql.Constraint;
import uk.ac.bham.mongoMap.model.sql.ConstraintType;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.Transformer;

public class UniqueToUniqueIndex implements Rule<Constraint, UniqueIndex> {

	public UniqueToUniqueIndex() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean check(Constraint source) {
		if (source.getType() == ConstraintType.UNIQUE) {
			return true;
		}
		return false;
	}

	@Override
	public UniqueIndex build(Constraint source, Transformer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperties(UniqueIndex target, Constraint source,
			Transformer t) {
		// TODO Auto-generated method stub
		
	}

}
