package uk.ac.bham.mongoMap.map.rules;

import java.util.List;

import uk.ac.bham.mongoMap.model.mongo.Document;
import uk.ac.bham.mongoMap.model.mongo.Id;
import uk.ac.bham.mongoMap.model.mongo.Key;
import uk.ac.bham.mongoMap.model.mongo.MongoFactory;
import uk.ac.bham.mongoMap.model.mongo.Value;
import uk.ac.bham.mongoMap.model.sql.Cell;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.RuleNotFoundException;
import uk.ac.bham.sitra.Transformer;

public class PrimaryKeyToID implements Rule<List<Cell>, Id> {

	public PrimaryKeyToID() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean check(List<Cell> source) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Id build(List<Cell> source, Transformer t) {
		MongoFactory mongoFactory = MongoFactory.eINSTANCE;
		Id id = mongoFactory.createId();
		id.setName("_id");
		
		if (source.size() ==1) {
			
			Value val = mongoFactory.createValue();
			
			val.setType(source.get(0).getColumn().getType());
			val.setValue(source.get(0).getValue());
			
			id.setValue(val);
			
		} else {
			Document doc = mongoFactory.createDocument();
			for (Cell cell : source) {
				Key keyVal;
				try {
					keyVal = (Key) t.transform(cell);
					doc.getKeys().add(keyVal);
				} catch (RuleNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			id.setValue(doc);
		}
		return id;
	}

	@Override
	public void setProperties(Id target, List<Cell> source, Transformer t) {
		// TODO Auto-generated method stub
		
	}

}
