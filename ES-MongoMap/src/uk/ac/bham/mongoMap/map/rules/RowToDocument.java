package uk.ac.bham.mongoMap.map.rules;

import uk.ac.bham.mongoMap.model.mongo.Document;
import uk.ac.bham.mongoMap.model.sql.Row;
import uk.ac.bham.sitra.Rule;
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
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setProperties(Document target, Row source, Transformer t) {
		// TODO Auto-generated method stub
		
	}
}
