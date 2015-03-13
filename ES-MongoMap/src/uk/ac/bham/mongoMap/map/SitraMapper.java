package uk.ac.bham.mongoMap.map;

import java.util.List;

import uk.ac.bham.mongoMap.model.mongo.Collection;
import uk.ac.bham.mongoMap.model.mongo.Document;
import uk.ac.bham.mongoMap.model.mongo.MongoDB;
import uk.ac.bham.mongoMap.model.mongo.UniqueIndex;
import uk.ac.bham.mongoMap.model.sql.Column;
import uk.ac.bham.mongoMap.model.sql.Constraint;
import uk.ac.bham.mongoMap.model.sql.ConstraintType;
import uk.ac.bham.mongoMap.model.sql.Database;
import uk.ac.bham.mongoMap.model.sql.Row;
import uk.ac.bham.mongoMap.model.sql.Table;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.RuleNotFoundException;
import uk.ac.bham.sitra.SimpleTransformerImpl;
import uk.ac.bham.sitra.Transformer;

public class SitraMapper {

	private Transformer transformer;

	public SitraMapper(List<Class<? extends Rule<?, ?>>> rules) {
		transformer = new SimpleTransformerImpl(rules);
	}

	public MongoDB performTransformation(Database db) throws Exception {
		try {
			// transform SQL-DB to MongoDB
			MongoDB mongoDB = (MongoDB) transformer.transform(db);

			for (Table table : db.getTable()) {
				// transform table to collection
				Collection coll = (Collection) transformer.transform(table);

				// map unique constraints to unique indices and add them to the
				// collection
				for (Constraint constraint : table.getConstraints()) {
					switch (constraint.getType()) {
					case UNIQUE:
						// add unique constraint only if it does not belong to a
						// primary key constraint
						// otherwise the MongoDB tries to add a unique index on
						// columns which do not exist (_id is primary key)
						if (!isPrimaryKeyUniqueConstraint(constraint)) {
							UniqueIndex index = (UniqueIndex) transformer
									.transform(constraint);
							coll.getUniqueIndices().add(index);
						}
						break;
					default:
						break;
					}
				}

				// map rows to documents
				for (Row row : table.getRows()) {
					Document doc = (Document) transformer.transform(row);
					coll.getDocuments().add(doc);
				}

				// add collection to mongoDB
				mongoDB.getCollections().add(coll);
			}

			return mongoDB;
		} catch (RuleNotFoundException e) {
			throw new Exception("A rule could not have been found.", e);
		}
	}

	private boolean isPrimaryKeyUniqueConstraint(Constraint unique) {
		// we only need to check whether the first column belongs to a
		// primary/composite key as a unique constraint is
		// never defined on partial primary key columns unless the unique
		// constraint belongs to the primary key constraint.
		Column col = unique.getColumn().get(0);
		for (Constraint constraint : col.getConstraint()) {
			if (constraint.getType() == ConstraintType.PRIMARY_KEY
					|| constraint.getType() == ConstraintType.COMPOSITE_PRIMARY_KEY) {
				return true;
			}
		}
		return false;
	}
}
