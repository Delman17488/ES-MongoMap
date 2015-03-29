package uk.ac.bham.mongoMap.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import uk.ac.bham.mongoMap.map.Packet;
import uk.ac.bham.mongoMap.model.sql.Cell;
import uk.ac.bham.mongoMap.model.sql.Column;
import uk.ac.bham.mongoMap.model.sql.Constraint;
import uk.ac.bham.mongoMap.model.sql.ConstraintType;
import uk.ac.bham.mongoMap.model.sql.Database;
import uk.ac.bham.mongoMap.model.sql.Datatype;
import uk.ac.bham.mongoMap.model.sql.Row;
import uk.ac.bham.mongoMap.model.sql.SqlFactory;
import uk.ac.bham.mongoMap.model.sql.Table;

public class SqlServiceImpl implements SqlService {
	SqlFactory sqlFac = SqlFactory.eINSTANCE;
	Database database = null;
	Connection con = null;
	HashMap<String, ArrayList<Datatype>> dataTypesTable;

	private Thread producerThread;

	public SqlServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public SqlServiceImpl(Connection con, String dbName) {
		//Creating an instance of SQL database
		this.database = sqlFac.createDatabase();
		this.database.setName(dbName);
		this.con = con;
	}

	@Override
	public Database getDatabase() throws SQLException {
		DatabaseMetaData dbMetaData = null;
		String catalog = null;
		String schemaPattern = null;
		String tableNamePattern = null;
		String columnNamePattern = null;
		String[] types = null;
		this.dataTypesTable = new HashMap<String, ArrayList<Datatype>>();

		try {
			//Getting metadata object
			dbMetaData = con.getMetaData();
			// Getting table names from Metadata
			ResultSet tables = dbMetaData.getTables(catalog, schemaPattern,
					tableNamePattern, types);
			
			//Getting over all tables to obtain their columns, primary keys,
			//foreign keys, and unique constraints 
			while (tables.next()) {
				Table table = sqlFac.createTable();
				String tableName = tables.getString(3);
				tableNamePattern = tableName;
				table.setName(tableName);
				//List of columns that the current table has
				ArrayList<String> listColumns = new ArrayList<String>();
				//List of datatypes that the current table has. 
				//This list is used to get the correct datatype from the resultset of rows  
				ArrayList<Datatype> listDatatypes = new ArrayList<Datatype>();

				// Getting column names from Metadata
				ResultSet columns = dbMetaData.getColumns(catalog,
						schemaPattern, tableNamePattern, columnNamePattern);
				//Adding columns to the current table
				addColumns(columns, listColumns, table, listDatatypes);
				
				//Adding list of data types of the current table
				this.dataTypesTable.put(table.getName(), listDatatypes);

				// Getting primary keys (Primary and Composite keys) from
				// Metadata
				ResultSet primaryKeys = dbMetaData.getPrimaryKeys(catalog,
						schemaPattern, tableNamePattern);
				//Adding primary keys to the current table
				addPrimaryKeys(primaryKeys, listColumns, table);

				// Getting foreign keys from Metadata
				ResultSet foreignKeys = dbMetaData.getImportedKeys(catalog,
						schemaPattern, tableNamePattern);
				//Adding foreign keys to the current table
				addForeignKeys(foreignKeys, listColumns, table);

				// Getting unique constraints from Metadata
				ResultSet uniqueConstraints = dbMetaData.getIndexInfo(catalog,
						schemaPattern, tableNamePattern, true, true);
				//Adding unique constraints to the current table
				addUniqueConstraints(uniqueConstraints, listColumns, table);
				
				//Adding table to the database instance
				database.getTable().add(table);

			}

		} catch (SQLException e) {
			throw new SQLException(
					"Error: Extracting metadata from SQL database.", e);
		}
		return database;
	}

	//Getting the index or position of a particular column in the list
	private int getIndexByColumnName(ArrayList<String> listColumns,
			String columnName) {
		for (int i = 0; i < listColumns.size(); i++) {
			if (listColumns.get(i).equals(columnName))
				return i;
		}

		return -1;
	}

	private void addUniqueConstraints(ResultSet uniqueConstraints,
			ArrayList<String> listColumns, Table table) throws SQLException {
		try {
			while (uniqueConstraints.next()) {
				if (uniqueConstraints.getString("INDEX_NAME") != null) {
					Constraint unique = sqlFac.createConstraint();
					unique.setName(uniqueConstraints.getString("INDEX_NAME"));
					unique.setType(ConstraintType.UNIQUE);

					String columnNameUnique = uniqueConstraints
							.getString("COLUMN_NAME");
					int indexColumn = getIndexByColumnName(listColumns,
							columnNameUnique);
					//Adding the column to list of columns that the constraint has
					unique.getColumn().add(table.getColumns().get(indexColumn));
					
					//Adding the new constraint to list of constraints that table has
					table.getConstraints().add(unique);
				}

			}
		} catch (SQLException e) {
			throw new SQLException(
					"Error: Adding unique constraints into SQL instance.", e);
		}
	}

	private void addPrimaryKeys(ResultSet primaryKeys,
			ArrayList<String> listColumns, Table table) throws SQLException {
		try {
			while (primaryKeys.next()) {
				Constraint primaryKey = sqlFac.createConstraint();
				primaryKey.setName(primaryKeys.getString("PK_NAME"));

				String columnNamePrimary = primaryKeys.getString("COLUMN_NAME");
				int indexColumn = getIndexByColumnName(listColumns,
						columnNamePrimary);
				//Adding the column to list of columns that the primary key constraint has
				primaryKey.getColumn().add(table.getColumns().get(indexColumn));

				table.getConstraints().add(primaryKey);
			}
		} catch (SQLException e) {
			throw new SQLException(
					"Error: Adding primary keys into SQL instance.", e);
		}

		if (table.getConstraints().size() > 1) {
			//if there is more than 1 primary keys. The constraint type is set as
			//COMPOSITE_PRIMARY_KEY
			for (Constraint constraint : table.getConstraints()) {
				constraint.setType(ConstraintType.COMPOSITE_PRIMARY_KEY);
			}
		} else {
			//if there is only one primary key. The constraint type is set as
			//PRIMARY_KEY
			for (Constraint constraint : table.getConstraints()) {
				constraint.setType(ConstraintType.PRIMARY_KEY);
			}
		}
	}

	private void addForeignKeys(ResultSet foreignKeys,
			ArrayList<String> listColumns, Table table) throws SQLException {
		try {
			while (foreignKeys.next()) {
				Constraint foreignKey = sqlFac.createConstraint();
				foreignKey.setName(foreignKeys.getString("FK_NAME"));
				foreignKey.setType(ConstraintType.FOREIGN_KEY);

				String columnNameForeign = foreignKeys
						.getString("FKCOLUMN_NAME");
				int indexColumn = getIndexByColumnName(listColumns,
						columnNameForeign);
				//Adding the column to list of columns that the foreign key constraint has
				foreignKey.getColumn().add(table.getColumns().get(indexColumn));

				table.getConstraints().add(foreignKey);
			}
		} catch (SQLException e) {
			throw new SQLException(
					"Error: Adding foreign keys into SQL instance.", e);
		}
	}

	private void addColumns(ResultSet columns, ArrayList<String> listColumns,
			Table table, ArrayList<Datatype> listDatatypes) throws SQLException {
		try {
			while (columns.next()) {
				String columnName = columns.getString("COLUMN_NAME");

				String columnTypeName = columns.getString("TYPE_NAME");

				Column column = sqlFac.createColumn();
				column.setName(columnName);
				column.setType(Datatype.get(columnTypeName));

				listDatatypes.add(Datatype.get(columnTypeName));
				table.getColumns().add(column);
				listColumns.add(columnName);
			}
		} catch (SQLException e) {
			throw new SQLException("Error: Adding columns into SQL instance.",
					e);
		}
	}
	
	//This method is used to get the value of a cell in a row with his correct datatype
	//instead of using resultset.getObject()
	private void setJavaObject(Cell cell, ResultSet rs, int columnIndex,
			Datatype dataType) throws SQLException {
		try {

			if (dataType == Datatype.BIT || dataType == Datatype.BOOLEAN) {
				cell.setValue(rs.getBoolean(columnIndex));

			} else if (dataType == Datatype.SET || dataType == Datatype.ENUM
					|| dataType == Datatype.CHAR
					|| dataType == Datatype.VARCHAR
					|| dataType == Datatype.LONGVARCHAR
					|| dataType == Datatype.LONGNVARCHAR
					|| dataType == Datatype.NVARCHAR
					|| dataType == Datatype.NCHAR || dataType == Datatype.TEXT
					|| dataType == Datatype.LONGTEXT
					|| dataType == Datatype.MEDIUMTEXT) {
				cell.setValue(rs.getString(columnIndex));

			} else if (dataType == Datatype.INT || dataType == Datatype.INTEGER
					|| dataType == Datatype.TINYINT
					|| dataType == Datatype.SMALLINT
					|| dataType == Datatype.MEDIUMINT) {
				cell.setValue(rs.getInt(columnIndex));

			} else if (dataType == Datatype.BIGINT) {
				cell.setValue(rs.getLong(columnIndex));

			} else if (dataType == Datatype.NUMERIC
					|| dataType == Datatype.DECIMAL
					|| dataType == Datatype.DOUBLE
					|| dataType == Datatype.FLOAT || dataType == Datatype.REAL) {
				cell.setValue(rs.getDouble(columnIndex));

			} else if (dataType == Datatype.TIME
					|| dataType == Datatype.TIMESTAMP
					|| dataType == Datatype.DATETIME) {
				cell.setValue(rs.getTimestamp(columnIndex));

			} else if (dataType == Datatype.DATE || dataType == Datatype.YEAR) {
				cell.setValue(rs.getDate(columnIndex));

			} else if (dataType == Datatype.JAVA_OBJECT
					|| dataType == Datatype.OTHER) {
				cell.setValue(rs.getObject(columnIndex));

			} else if (dataType == Datatype.ARRAY) {
				cell.setValue(rs.getArray(columnIndex));

			} else if (dataType == Datatype.BINARY
					|| dataType == Datatype.VARBINARY
					|| dataType == Datatype.LONGVARBINARY
					|| dataType == Datatype.BLOB
					|| dataType == Datatype.MEDIUMBLOB) {
				cell.setValue(rs.getBytes(columnIndex));

			} else if (dataType == Datatype.SQLXML) {
				SQLXML xmlVal = rs.getSQLXML(columnIndex);
				cell.setValue(xmlVal.getString());

			} else {
				cell.setValue(rs.getString(columnIndex));
			}
		} catch (SQLException e) {
			throw new SQLException(
					"Error: Adding values to cells in SQL instance.", e);
		}

	}

	@Override
	public BlockingQueue<Packet<Row>> getRowQueue(Table table, int size)
			throws Exception {
		/*
		 * This implementation of the interface just allows to insert rows
		 * to one table at a time. Therefore, if this method is called
		 * twice the method blocks until the thread finished.
		 */
		if (this.producerThread != null && this.producerThread.isAlive()) {
			try {
				this.producerThread.join();
			} catch (InterruptedException e) {
				throw new Exception(
						"Error: Producer thread has been interrupted.", e);
			}
		}

		/*
		 * Start thread which get rows from database to insert into Sitra mapper for
		 * inserting them to MongoDB.
		 */
		Producer producer = new Producer(size, con,
		this.dataTypesTable.get(table.getName()), table);
		this.producerThread = new Thread(producer);
		this.producerThread.start();

		return producer.getQueue();
	}

	private class Producer implements Runnable {

		private BlockingQueue<Packet<Row>> queue;
		private int queueSize;
		private Connection con;
		private ArrayList<Datatype> listDatatypes;
		private Table table;

		public Producer(int size, Connection con,
				ArrayList<Datatype> listDatatypes, Table table) {
			queueSize = size;
			queue = new ArrayBlockingQueue<Packet<Row>>(queueSize);
			this.listDatatypes = listDatatypes;
			this.table = table;
			this.con = con;
		}

		public BlockingQueue<Packet<Row>> getQueue() {
			return queue;
		}

		public void produce() throws Exception {

			try {
				Statement stmt = null;
				stmt = con.createStatement();

				// Selecting all rows from the current table
				ResultSet rs = stmt.executeQuery("SELECT * FROM "
						+ table.getName());

				ResultSetMetaData rsmd;

				rsmd = rs.getMetaData();

				int colCount = rsmd.getColumnCount();

				while (rs.next()) {
					Row row = sqlFac.createRow();
					for (int i = 1; i <= colCount; i++) {
						Cell cell = sqlFac.createCell();
						setJavaObject(cell, rs, i, listDatatypes.get(i - 1));
						cell.setColumn(table.getColumns().get(i - 1));
						row.getCells().add(cell);
					}
					Packet<Row> packet = new Packet<Row>(row);
					if (rs.isLast())
						packet.setLastPacket(true);
					queue.put(packet);
				}
			} catch (InterruptedException e) {
				throw new Exception(
						"Error: Putting package from queue failed.", e);
			} catch (SQLException e1) {
				throw new Exception(
						"Error: Extracting rows from database failed.", e1);
			}

		}

		@Override
		public void run() {
			try {
				produce();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
