package uk.ac.bham.mongoMap.sql;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import uk.ac.bham.mongoMap.model.sql.Cell;
import uk.ac.bham.mongoMap.model.sql.Column;
import uk.ac.bham.mongoMap.model.sql.Constraint;
import uk.ac.bham.mongoMap.model.sql.ConstraintType;
import uk.ac.bham.mongoMap.model.sql.Database;
import uk.ac.bham.mongoMap.model.sql.Datatye;
import uk.ac.bham.mongoMap.model.sql.Row;
import uk.ac.bham.mongoMap.model.sql.SqlFactory;
import uk.ac.bham.mongoMap.model.sql.Table;
import uk.ac.bham.mongoMap.model.sql.impl.SqlFactoryImpl;

public class SqlServiceImpl implements SqlService {

	public SqlServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Database getDatabase(String dbName) {
		SqlFactory sqlFac = SqlFactoryImpl.init();

		Database db = sqlFac.createDatabase();
		Table table = sqlFac.createTable();
		Column idCol = sqlFac.createColumn();
		Column nameCol = sqlFac.createColumn();
		Column dobCol = sqlFac.createColumn();
		
		db.getTable().add(table);

		table.getColumns().add(idCol);
		table.getColumns().add(nameCol);
		table.getColumns().add(dobCol);

		table.setName("Persons");

		idCol.setName("person_id");
		idCol.setType(Datatye.BIGINT);

		nameCol.setName("name");
		nameCol.setType(Datatye.TEXT);

		dobCol.setName("date_of_birth");
		dobCol.setType(Datatye.DATE);
		
		Constraint pkey = sqlFac.createConstraint();
		pkey.setName("PKEY");
		pkey.setType(ConstraintType.PRIMARY_KEY);
		pkey.getColumn().add(idCol);
		
		Constraint uniqueName = sqlFac.createConstraint();
		uniqueName.setName("unique_name");
		uniqueName.setType(ConstraintType.UNIQUE);
		uniqueName.getColumn().add(nameCol);

		table.getConstraints().add(pkey);
		table.getConstraints().add(uniqueName);
		
		List<Row> rows = new ArrayList<Row>();

		for (int i = 0; i < 10; i++) {
			Cell c1 = sqlFac.createCell();
			Cell c2 = sqlFac.createCell();
			Cell c3 = sqlFac.createCell();

			c1.setColumn(idCol);
			c1.setValue(new Long(i));

			c2.setColumn(nameCol);
			c2.setValue("Name " + i);

			c3.setColumn(dobCol);
			c3.setValue(Date.valueOf("1987-11-" + (1 + (i % 30))));
			
			Row row = sqlFac.createRow();
			
			row.getCells().add(c1);
			row.getCells().add(c2);
			row.getCells().add(c3);
			
			rows.add(row);
		}

		table.getRows().addAll(rows);
		
		return db;
	}

}
