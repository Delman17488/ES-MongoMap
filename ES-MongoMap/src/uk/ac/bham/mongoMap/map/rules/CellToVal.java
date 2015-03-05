package uk.ac.bham.mongoMap.map.rules;

import uk.ac.bham.mongoMap.model.mongo.Value;
import uk.ac.bham.mongoMap.model.sql.Cell;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.Transformer;

public class CellToVal implements Rule<Cell, Value> {

	public CellToVal() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean check(Cell source) {
		return true;
	}

	@Override
	public Value build(Cell source, Transformer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperties(Value target, Cell source, Transformer t) {
		// TODO Auto-generated method stub
		
	}

}
