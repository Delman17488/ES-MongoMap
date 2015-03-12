package uk.ac.bham.mongoMap.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	public SqlServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Database getDatabase(Connection con, String dbName) {		
		DatabaseMetaData dbMetaData = null;
		String catalog = null;
		String schemaPattern = null;
		String tableNamePattern = null;
		String columnNamePattern = null;
		String[] types = null;
		
		try {
			dbMetaData = con.getMetaData();
			database = sqlFac.createDatabase();
			database.setName(dbName);
			
			//Getting table names from Metadata
			ResultSet tables = dbMetaData.getTables(catalog, schemaPattern, tableNamePattern, types);
			
			while(tables.next()){
				Table table = sqlFac.createTable();
				String tableName = tables.getString(3);
				tableNamePattern = tableName;
				table.setName(tableName);
				ArrayList<String> listColumns = new ArrayList<String>();
				
				//Getting column names from Metadata
				ResultSet columns = dbMetaData.getColumns(catalog,schemaPattern,tableNamePattern,columnNamePattern);
				addColumns(columns,listColumns,table);

				//Getting primary keys (Primary and Composite keys) from Metadata
				ResultSet primaryKeys = dbMetaData.getPrimaryKeys(catalog, schemaPattern, tableNamePattern);
				addPrimaryKeys(primaryKeys, listColumns, table);
				
				//Getting foreign keys from Metadata
				ResultSet foreignKeys = dbMetaData.getImportedKeys(catalog, schemaPattern, tableNamePattern);
				addForeignKeys(foreignKeys, listColumns, table);
				
				//Getting unique constraints from Metadata
				ResultSet uniqueConstraints = dbMetaData.getIndexInfo(catalog, schemaPattern, tableNamePattern, true, true);
				addUniqueConstraints(uniqueConstraints,listColumns, table);
				
				database.getTable().add(table);
			}
			
			addRows(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return database;
	}
	
	private int getIndexByTableName(ArrayList<String> listColumns,String columnName){
		for (int i = 0; i < listColumns.size(); i++) {
			if(listColumns.get(i).equals(columnName))
				return i;
		}
		
		return -1;
	}
	
	private void addUniqueConstraints(ResultSet uniqueConstraints,ArrayList<String> listColumns, Table table){
		try {
			while(uniqueConstraints.next()){
				if(uniqueConstraints.getString("INDEX_NAME")!= null){
					Constraint unique = sqlFac.createConstraint();
					unique.setName(uniqueConstraints.getString("INDEX_NAME")); 
					unique.setType(ConstraintType.UNIQUE);
					
				    String columnNameUnique = uniqueConstraints.getString("COLUMN_NAME");
					int indexColumn = getIndexByTableName(listColumns,columnNameUnique);
					unique.getColumn().add(table.getColumns().get(indexColumn));
					
					table.getConstraints().add(unique);
					System.out.println("Unique constraint table:"+table.getName()+" column:"+columnNameUnique);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addPrimaryKeys(ResultSet primaryKeys,ArrayList<String> listColumns, Table table){
		try {
			while(primaryKeys.next()){
				Constraint primaryKey = sqlFac.createConstraint();
				primaryKey.setName(primaryKeys.getString("PK_NAME")); 
				
			    String columnNamePrimary = primaryKeys.getString("COLUMN_NAME");
				int indexColumn = getIndexByTableName(listColumns,columnNamePrimary);
			    primaryKey.getColumn().add(table.getColumns().get(indexColumn));
			    
			    table.getConstraints().add(primaryKey);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(table.getConstraints().size() > 1){
			for (Constraint constraint : table.getConstraints()) {
				constraint.setType(ConstraintType.COMPOSITE_PRIMARY_KEY);
			}
		}else{
			for (Constraint constraint : table.getConstraints()) {
				constraint.setType(ConstraintType.PRIMARY_KEY);
			}
		}
	}

	
	private void addForeignKeys(ResultSet foreignKeys,ArrayList<String> listColumns, Table table){
		try {
			while(foreignKeys.next()){
				Constraint foreignKey = sqlFac.createConstraint();
				foreignKey.setName(foreignKeys.getString("FK_NAME"));
				foreignKey.setType(ConstraintType.FOREIGN_KEY);
				
			    String columnNameForeign = foreignKeys.getString("FKCOLUMN_NAME");
				int indexColumn = getIndexByTableName(listColumns,columnNameForeign);
				foreignKey.getColumn().add(table.getColumns().get(indexColumn));
				
			    table.getConstraints().add(foreignKey);
			    
			    System.out.println("Foreign key table:"+table.getName()+" column:"+columnNameForeign);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addColumns(ResultSet columns, ArrayList<String> listColumns, Table table){
		try {
			while(columns.next()){
			    String columnName = columns.getString(4);
			    int columnType = columns.getInt(5);
			    Column column = sqlFac.createColumn();
			    column.setName(columnName);
				column.setType(Datatype.get(columnType));
				table.getColumns().add(column);
				listColumns.add(columnName);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addRows(Connection con){
		try{
			for (Table tbNameTmp : database.getTable()) {
				ResultSet rs = null;
		        Statement stmt = null;
				stmt = con.createStatement();
				
				//Selecting all rows from the current table
	            rs = stmt.executeQuery("SELECT * FROM "+tbNameTmp.getName());
	            ResultSetMetaData rsmd = rs.getMetaData();
	            int colCount = rsmd.getColumnCount();
	            while(rs.next()){
	            	Row row = sqlFac.createRow();
	            	for (int i = 1; i <= colCount; i++) {
	            		Cell cell = sqlFac.createCell();
	            		cell.setValue(rs.getObject(i));
	            		cell.setColumn(tbNameTmp.getColumns().get(i-1));
	            		row.getCells().add(cell);
	                }
	            	tbNameTmp.getRows().add(row);
	            }
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public Database getDatabase(String dbName) {
		return this.database;
	}

}
