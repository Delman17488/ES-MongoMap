package uk.ac.bham.mongoMap.map.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import uk.ac.bham.mongoMap.model.mongo.Document;
import uk.ac.bham.mongoMap.model.mongo.Id;
import uk.ac.bham.mongoMap.model.mongo.Key;
import uk.ac.bham.mongoMap.model.mongo.MongoFactory;
import uk.ac.bham.mongoMap.model.mongo.impl.MongoFactoryImpl;
import uk.ac.bham.mongoMap.model.sql.Cell;
import uk.ac.bham.mongoMap.model.sql.Constraint;
import uk.ac.bham.mongoMap.model.sql.ConstraintType;
import uk.ac.bham.mongoMap.model.sql.Row;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.RuleNotFoundException;
import uk.ac.bham.sitra.Transformer;

public class RowToDocument implements Rule<Row, Document> {

	public RowToDocument() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean check(Row source) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Document build(Row source, Transformer t) {
		MongoFactory mf = MongoFactory.eINSTANCE;
		Document doc = mf.createDocument();
		List<Cell> primeCells = new ArrayList<Cell>();

		for (Cell cell : source.getCells()) {
			EList<Constraint> c = cell.getColumn().getConstraint();
			boolean isID = false;

			if (!c.isEmpty()) {
				for (Constraint constraint : c) {
					if (constraint.getType().equals(
							ConstraintType.COMPOSITE_PRIMARY_KEY)
							|| constraint.getType().equals(
									ConstraintType.PRIMARY_KEY)) {
						primeCells.add(cell);
						isID = true;
					}

				}
			}
			if (!isID) {
				try {
					Key key = (Key) t.transform(cell);
					doc.getKeys().add(key);
				} catch (RuleNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		if (!primeCells.isEmpty()) {
			try {
				Id id = (Id) t.transform(PrimaryKeyToID.class, primeCells);
				doc.setId(id);
			} catch (RuleNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return doc;
	}

	@Override
	public void setProperties(Document target, Row source, Transformer t) {
		// TODO Auto-generated method stub

	}
}
