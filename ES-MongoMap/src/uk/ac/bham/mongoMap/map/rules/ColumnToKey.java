package uk.ac.bham.mongoMap.map.rules;

import uk.ac.bham.mongoMap.model.mongo.Key;
import uk.ac.bham.mongoMap.model.sql.Column;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.Transformer;

public class ColumnToKey implements Rule<Column, Key> {

	public ColumnToKey() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean check(Column source) {
		return true;
	}

	@Override
	public Key build(Column source, Transformer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperties(Key target, Column source, Transformer t) {
		// TODO Auto-generated method stub
		
	}

}
