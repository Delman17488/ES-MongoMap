package uk.ac.bham.mongoMap.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import uk.ac.bham.mongoMap.model.sql.Cell;
import uk.ac.bham.mongoMap.model.sql.Column;
import uk.ac.bham.mongoMap.model.sql.Constraint;
import uk.ac.bham.mongoMap.model.sql.ConstraintType;
import uk.ac.bham.mongoMap.model.sql.Database;
import uk.ac.bham.mongoMap.model.sql.Datatye;
import uk.ac.bham.mongoMap.model.sql.Datatype;
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
		Table personsTable = sqlFac.createTable();
		Column idCol = sqlFac.createColumn();
		Column nameCol = sqlFac.createColumn();
		Column dobCol = sqlFac.createColumn();
		
		db.getTable().add(personsTable);


		personsTable.setName("Persons");

		idCol.setName("person_id");
		idCol.setType(Datatype.BIGINT);

		nameCol.setName("name");
		nameCol.setType(Datatype.TEXT);

		dobCol.setName("date_of_birth");
		dobCol.setType(Datatype.DATE);
		
		personsTable.getColumns().add(idCol);
		personsTable.getColumns().add(nameCol);
		personsTable.getColumns().add(dobCol);

		Constraint pkey = sqlFac.createConstraint();
		pkey.setName("PKEY");
		pkey.setType(ConstraintType.PRIMARY_KEY);
		pkey.getColumn().add(idCol);
		
		Constraint uniqueName2 = sqlFac.createConstraint();
		uniqueName2.setName("unique_pkey");
		uniqueName2.setType(ConstraintType.UNIQUE);
		uniqueName2.getColumn().add(idCol);
		
		Constraint uniqueName = sqlFac.createConstraint();
		uniqueName.setName("unique_name");
		uniqueName.setType(ConstraintType.UNIQUE);
		uniqueName.getColumn().add(nameCol);

		personsTable.getConstraints().add(pkey);
		personsTable.getConstraints().add(uniqueName);
		personsTable.getConstraints().add(uniqueName2);
		
		List<Row> rows = new ArrayList<Row>();

		for (int i = 0; i < 2; i++) {
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
		
		//temp
		Cell c1 = sqlFac.createCell();
		Cell c2 = sqlFac.createCell();
		Cell c3 = sqlFac.createCell();

		c1.setColumn(idCol);
		c1.setValue(new Long(2));

		c2.setColumn(nameCol);
		c2.setValue("Name " + 1);

		c3.setColumn(dobCol);
		c3.setValue(Date.valueOf("1987-11-" + (1 + (2 % 30))));
		
		Row row = sqlFac.createRow();
		
		row.getCells().add(c1);
		row.getCells().add(c2);
		row.getCells().add(c3);
		
		rows.add(row);

		personsTable.getRows().addAll(rows);
		
		createAddressTable(db, personsTable);
		Table rolesTable = createRolesTable(db);
		createRolesPersons(db, personsTable, rolesTable);
		createTableWithNoPkey(db);
		
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
		personIdCol.setType(Datatype.BIGINT);

		streetCol.setName("street");
		streetCol.setType(Datatype.TEXT);

		numberCol.setName("number");
		numberCol.setType(Datatype.INT);
		
		table.getColumns().add(personIdCol);
		table.getColumns().add(streetCol);
		table.getColumns().add(numberCol);

		Constraint pkey = sqlFac.createConstraint();
		pkey.setName("PKEY");
		pkey.setType(ConstraintType.COMPOSITE_PRIMARY_KEY);
		pkey.getColumn().add(personIdCol);
		pkey.getColumn().add(streetCol);
		
		Constraint pkeyUnique = sqlFac.createConstraint();
		pkeyUnique.setName("PKEY_UNIQUE");
		pkeyUnique.setType(ConstraintType.UNIQUE);
		pkeyUnique.getColumn().add(personIdCol);
		pkeyUnique.getColumn().add(streetCol);
		
		Constraint fkey = sqlFac.createConstraint();
		fkey.setName("person_fkey");
		fkey.setType(ConstraintType.FOREIGN_KEY);
		fkey.getColumn().add(personIdCol);

		table.getConstraints().add(pkey);
		table.getConstraints().add(fkey);
		table.getConstraints().add(pkeyUnique);
		
		List<Row> rows = new ArrayList<Row>();

		for (int i = 0; i < 2; i++) {
			Cell c1 = sqlFac.createCell();
			Cell c2 = sqlFac.createCell();
			Cell c3 = sqlFac.createCell();

			c1.setColumn(personIdCol);
			c1.setValue(persons.getRows().get(i).getCells().get(0).getValue());

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

	@Override
	public Database getDatabase() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void createTableWithNoPkey(Database db) {
		SqlFactory sqlFac = SqlFactory.eINSTANCE;
		Table table = sqlFac.createTable();
		Column unique1 = sqlFac.createColumn();
		Column unique2 = sqlFac.createColumn();
		Column bool = sqlFac.createColumn();
		Column charCol = sqlFac.createColumn();
		Column blobCol = sqlFac.createColumn();

		db.getTable().add(table);

		table.setName("NoPkeyButUnique");

		unique1.setName("uniqueTimeStamp");
		unique1.setType(Datatype.TIMESTAMP);

		unique2.setName("uniqueText");
		unique2.setType(Datatype.TEXT);
		
		bool.setName("bool");
		bool.setType(Datatype.BOOLEAN);
		
		charCol.setName("char");
		charCol.setType(Datatype.CHAR);
		
		blobCol.setName("blob");
		blobCol.setType(Datatype.BLOB);
		
		table.getColumns().add(unique1);
		table.getColumns().add(unique2);
		table.getColumns().add(bool);
		table.getColumns().add(charCol);
		table.getColumns().add(blobCol);

		Constraint uniqueName = sqlFac.createConstraint();
		uniqueName.setName("unique");
		uniqueName.setType(ConstraintType.UNIQUE);
		uniqueName.getColumn().add(unique1);
		uniqueName.getColumn().add(unique2);

		table.getConstraints().add(uniqueName);

		List<Row> rows = new ArrayList<Row>();

		for (int i = 0; i < 2; i++) {
			Row row = sqlFac.createRow();

			Cell c1 = sqlFac.createCell();
			c1.setColumn(unique2);
			c1.setValue("unique" + i);
			row.getCells().add(c1);

			Cell c2 = sqlFac.createCell();
			c2.setColumn(unique1);
			c2.setValue(new Timestamp(System.currentTimeMillis()));
			row.getCells().add(c2);

			Cell c3 = sqlFac.createCell();
			c3.setColumn(bool);
			c3.setValue(true);
			row.getCells().add(c3);

			Cell c4 = sqlFac.createCell();
			c4.setColumn(charCol);
			c4.setValue('c');
			row.getCells().add(c4);
			
			Cell c5 = sqlFac.createCell();
			c5.setColumn(blobCol);
			byte[] bytes = {'0', '0', '0', '1'};
			try {
				c5.setValue(new SerialBlob(bytes));
			} catch (SerialException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			row.getCells().add(c5);
			
			rows.add(row);
		}

		table.getRows().addAll(rows);
	}
	
	private Table createRolesTable(Database db) {
		SqlFactory sqlFac = SqlFactory.eINSTANCE;
		Table table = sqlFac.createTable();
		Column roleId = sqlFac.createColumn();
		Column roleName = sqlFac.createColumn();
		Column roleSerial = sqlFac.createColumn();

		db.getTable().add(table);
		table.setName("Roles");

		roleId.setName("role_id");
		roleId.setType(Datatype.INT);

		roleName.setName("name");
		roleName.setType(Datatype.TEXT);

		roleSerial.setName("role_serial");
		roleSerial.setType(Datatype.DECIMAL);

		table.getColumns().add(roleId);
		table.getColumns().add(roleName);
		table.getColumns().add(roleSerial);

		Constraint pkey = sqlFac.createConstraint();
		pkey.setName("PKEY");
		pkey.setType(ConstraintType.PRIMARY_KEY);
		pkey.getColumn().add(roleId);

		Constraint uniqueName = sqlFac.createConstraint();
		uniqueName.setName("unique_name");
		uniqueName.setType(ConstraintType.UNIQUE);
		uniqueName.getColumn().add(roleId);

		table.getConstraints().add(pkey);
		table.getConstraints().add(uniqueName);

		List<Row> rows = new ArrayList<Row>();

		for (int i = 0; i < 2; i++) {
			Cell c1 = sqlFac.createCell();
			Cell c2 = sqlFac.createCell();
			Cell c3 = sqlFac.createCell();

			c1.setColumn(roleId);
			c1.setValue(i);

			c2.setColumn(roleName);
			c2.setValue("Role " + i);

			c3.setColumn(roleSerial);
			c3.setValue(0.12315 + i);

			Row row = sqlFac.createRow();

			row.getCells().add(c1);
			row.getCells().add(c2);
			row.getCells().add(c3);

			rows.add(row);
		}

		table.getRows().addAll(rows);
		return table;
	}

	private void createRolesPersons(Database db, Table persons, Table roles) {
		SqlFactory sqlFac = SqlFactory.eINSTANCE;
		Table table = sqlFac.createTable();
		Column roleId = sqlFac.createColumn();
		Column personId = sqlFac.createColumn();

		db.getTable().add(table);
		table.setName("RolesPersons");

		roleId.setName("role_id");
		roleId.setType(Datatype.INT);

		personId.setName("person_id");
		personId.setType(Datatype.BIGINT);

		table.getColumns().add(roleId);
		table.getColumns().add(personId);

		Constraint fkey_persons = sqlFac.createConstraint();
		fkey_persons.setName("FKEY_Persons");
		fkey_persons.setType(ConstraintType.FOREIGN_KEY);
		fkey_persons.getColumn().add(personId);

		Constraint fkey_roles = sqlFac.createConstraint();
		fkey_roles.setName("FKEY_Roles");
		fkey_roles.setType(ConstraintType.FOREIGN_KEY);
		fkey_roles.getColumn().add(roleId);

		Constraint cpkey = sqlFac.createConstraint();
		cpkey.setName("pkey");
		cpkey.setType(ConstraintType.COMPOSITE_PRIMARY_KEY);
		cpkey.getColumn().add(roleId);
		cpkey.getColumn().add(personId);

		table.getConstraints().add(fkey_persons);
		table.getConstraints().add(fkey_roles);
		table.getConstraints().add(cpkey);

		List<Row> rows = new ArrayList<Row>();

		Integer[] p = { 0, 1 };
		Integer[] p2 = { 1 };

		// person id to role id
		HashMap<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
		map.put(0, p);
		map.put(1, p2);

		for (int key : map.keySet()) {
			for (Integer integer : map.get(key)) {

				Cell c1 = sqlFac.createCell();
				Cell c2 = sqlFac.createCell();

				c1.setColumn(roleId);
				c1.setValue(integer);

				c2.setColumn(personId);
				c2.setValue(key);

				Row row = sqlFac.createRow();

				row.getCells().add(c1);
				row.getCells().add(c2);

				rows.add(row);
			}
		}

		table.getRows().addAll(rows);
	}

}
