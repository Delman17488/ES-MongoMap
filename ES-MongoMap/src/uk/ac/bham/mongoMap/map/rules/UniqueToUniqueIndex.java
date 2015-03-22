package uk.ac.bham.mongoMap.map.rules;

import uk.ac.bham.mongoMap.model.mongo.MongoFactory;
import uk.ac.bham.mongoMap.model.mongo.UniqueIndex;
import uk.ac.bham.mongoMap.model.sql.Column;
import uk.ac.bham.mongoMap.model.sql.Constraint;
import uk.ac.bham.mongoMap.model.sql.ConstraintType;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.Transformer;

public class UniqueToUniqueIndex implements Rule<Constraint, UniqueIndex> {

	private int id = 6;
	
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
		MongoFactory mongoFactory = MongoFactory.eINSTANCE;
		UniqueIndex uniqueIndex = mongoFactory.createUniqueIndex();
		
		for (Column col : source.getColumn()) {
			uniqueIndex.getKeys().add(col.getName());
		}
		
		return uniqueIndex;
	}

	@Override
	public void setProperties(UniqueIndex target, Constraint source,
			Transformer t) {
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
		UniqueToUniqueIndex other = (UniqueToUniqueIndex) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
