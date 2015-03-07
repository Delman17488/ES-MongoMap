package uk.ac.bham.mongoMap.map.rules;

import java.util.List;

import uk.ac.bham.mongoMap.model.mongo.Collection;
import uk.ac.bham.mongoMap.model.mongo.Document;
import uk.ac.bham.mongoMap.model.mongo.Id;
import uk.ac.bham.mongoMap.model.mongo.Key;
import uk.ac.bham.mongoMap.model.mongo.MongoFactory;
import uk.ac.bham.mongoMap.model.mongo.Value;
import uk.ac.bham.mongoMap.model.mongo.impl.MongoFactoryImpl;
import uk.ac.bham.mongoMap.model.sql.Cell;
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
		MongoFactory mf = new MongoFactoryImpl();
		Document doc = mf.createDocument();

		for (Cell cell : source.getCells()) {
			Key key = null;
			try {
				key = (Key) t.transform(cell);
			} catch (RuleNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(cell.getColumn().getConstraint()!= null /* && it has a constraint type = primary or composite */){
				Id id = mf.createId();//the document should have list of ids and if there is just 1 in the list it is a primary key, 
										//else it is composite key
				id.setName(key.getName());
				id.setValue(key.getValue());
				
				doc.setId(id);
			}else				
				doc.getKeys().add(key);
		}
		
		return doc;
	}


	@Override
	public void setProperties(Document target, Row source, Transformer t) {
		// TODO Auto-generated method stub
		
	}
}
