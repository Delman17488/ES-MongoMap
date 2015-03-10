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

public class SqlServiceTestingImpl implements SqlService {

	public SqlServiceTestingImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Database getDatabase(String dbName) {
		SqlFactory sqlFac = SqlFactory.eINSTANCE;

		Database db = sqlFac.createDatabase();
		db.setName("AAMService");
		Table table = sqlFac.createTable();
		Column idCol = sqlFac.createColumn();
		Column nameCol = sqlFac.createColumn();
		Column dobCol = sqlFac.createColumn();
		
		db.getTable().add(table);


		table.setName("Persons");

		idCol.setName("person_id");
		idCol.setType(Datatye.BIGINT);

		nameCol.setName("name");
		nameCol.setType(Datatye.TEXT);

		dobCol.setName("date_of_birth");
		dobCol.setType(Datatye.DATE);
		
		table.getColumns().add(idCol);
		table.getColumns().add(nameCol);
		table.getColumns().add(dobCol);

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
		
		createAddressTable(db, table);
		
		return db;
	}
	
	private void createAddressTable(Database db, Table persons) {
		SqlFactory sqlFac = SqlFactory.eINSTANCE;
		Table table = sqlFac.createTable();
		Column personIdCol = sqlFac.createColumn();
		Column streetCol = sqlFac.createColumn();
		Column numberCol = sqlFac.createColumn();
		
		db.getTable().add(table);


		table.setName("Addresses");

		personIdCol.setName("person_id");
		personIdCol.setType(Datatye.BIGINT);

		streetCol.setName("street");
		streetCol.setType(Datatye.TEXT);

		numberCol.setName("number");
		numberCol.setType(Datatye.INT);
		
		table.getColumns().add(personIdCol);
		table.getColumns().add(streetCol);
		table.getColumns().add(numberCol);

		Constraint pkey = sqlFac.createConstraint();
		pkey.setName("PKEY");
		pkey.setType(ConstraintType.COMPOSITE_PRIMARY_KEY);
		pkey.getColumn().add(personIdCol);
		pkey.getColumn().add(streetCol);
		
		Constraint uniqueName = sqlFac.createConstraint();
		uniqueName.setName("person_fkey");
		uniqueName.setType(ConstraintType.FOREIGN_KEY);
		uniqueName.getColumn().add(personIdCol);

		table.getConstraints().add(pkey);
		table.getConstraints().add(uniqueName);
		
		List<Row> rows = new ArrayList<Row>();

		for (int i = 0; i < 10; i++) {
			Cell c1 = sqlFac.createCell();
			Cell c2 = sqlFac.createCell();
			Cell c3 = sqlFac.createCell();

			c1.setColumn(personIdCol);
			c1.setValue(persons.getRows().get(0).getCells().get(0).getValue());

			c2.setColumn(streetCol);
			c2.setValue("Street Name " + i);
			
			c3.setColumn(numberCol);
			c3.setValue(i);

			Row row = sqlFac.createRow();
			
			row.getCells().add(c1);
			row.getCells().add(c2);
			row.getCells().add(c3);
			
			rows.add(row);
		}

		table.getRows().addAll(rows);
	}

}
