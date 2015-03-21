package uk.ac.bham.mongoMap.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Queue;

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
	
	public SqlServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public SqlServiceImpl(Connection con,String dbName) {
		this.database = sqlFac.createDatabase();
		this.database.setName(dbName);
		this.con = con;
	}

	@Override
	public Database getDatabase() {		
		DatabaseMetaData dbMetaData = null;
		String catalog = null;
		String schemaPattern = null;
		String tableNamePattern = null;
		String columnNamePattern = null;
		String[] types = null;
		
		try {
			dbMetaData = con.getMetaData();
			//Getting table names from Metadata
			ResultSet tables = dbMetaData.getTables(catalog, schemaPattern, tableNamePattern, types);
			
			while(tables.next()){
				Table table = sqlFac.createTable();
				String tableName = tables.getString(3);
				tableNamePattern = tableName;
				table.setName(tableName);
				ArrayList<String> listColumns = new ArrayList<String>();
				ArrayList<Datatype> listDatatypes = new ArrayList<Datatype>();
				
				//Getting column names from Metadata
				ResultSet columns = dbMetaData.getColumns(catalog,schemaPattern,tableNamePattern,columnNamePattern);
				addColumns(columns,listColumns,table,listDatatypes);

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
				
				addRow(con,table, listDatatypes);
			}
			
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
	
	private void addColumns(ResultSet columns, ArrayList<String> listColumns, Table table,ArrayList<Datatype> listDatatypes){
		try {
			while(columns.next()){
			    String columnName = columns.getString("COLUMN_NAME");
			    
			    int columnType = columns.getInt("DATA_TYPE");//delete
			    
			    String columnTypeName = columns.getString("TYPE_NAME");
			    
			    System.out.println(columnType+" : "+columnTypeName);//delete
			    
			    Column column = sqlFac.createColumn();
			    column.setName(columnName);
				column.setType(Datatype.get(columnTypeName));
				
				listDatatypes.add(Datatype.get(columnTypeName));
				table.getColumns().add(column);
				listColumns.add(columnName);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addRow(Connection con, Table table,ArrayList<Datatype> listDatatypes){
		try{
				ResultSet rs = null;
		        Statement stmt = null;
				stmt = con.createStatement();
				
				//Selecting all rows from the current table
	            rs = stmt.executeQuery("SELECT * FROM "+table.getName());
	            ResultSetMetaData rsmd = rs.getMetaData();
	            int colCount = rsmd.getColumnCount();
	            while(rs.next()){
	            	Row row = sqlFac.createRow();
	            	for (int i = 1; i <= colCount; i++) {
	            		Cell cell = sqlFac.createCell();
	            		setJavaObject(cell,rs, i,listDatatypes.get(i-1));
	            		cell.setColumn(table.getColumns().get(i-1));
	            		row.getCells().add(cell); 
	                }
	            	table.getRows().add(row);
	            }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void setJavaObject(Cell cell, ResultSet rs, int columnIndex,Datatype dataType){
		try {
			
			if(dataType == Datatype.BIT || dataType == Datatype.BOOLEAN){
				cell.setValue(rs.getBoolean(columnIndex));
				
			}else if(dataType == Datatype.SET || dataType == Datatype.ENUM 
					|| dataType == Datatype.CHAR || dataType == Datatype.VARCHAR 
					|| dataType == Datatype.LONGVARCHAR || dataType == Datatype.LONGNVARCHAR 
					|| dataType == Datatype.NVARCHAR || dataType == Datatype.NCHAR 
					|| dataType == Datatype.TEXT || dataType == Datatype.LONGTEXT
					|| dataType == Datatype.MEDIUMTEXT){
				cell.setValue(rs.getString(columnIndex));
				
			}else if(dataType == Datatype.INT || dataType == Datatype.INTEGER || dataType == Datatype.TINYINT 
					|| dataType == Datatype.SMALLINT || dataType == Datatype.MEDIUMINT ){
				cell.setValue(rs.getInt(columnIndex));
				
			}else if(dataType == Datatype.BIGINT ){
				cell.setValue(rs.getLong(columnIndex));
				
			}else if(dataType == Datatype.NUMERIC || dataType == Datatype.DECIMAL || dataType == Datatype.DOUBLE || dataType == Datatype.FLOAT || dataType == Datatype.REAL){
				cell.setValue(rs.getDouble(columnIndex));
				
			}else if(dataType == Datatype.TIME || dataType == Datatype.TIMESTAMP || dataType == Datatype.DATETIME){
				cell.setValue(rs.getTimestamp(columnIndex));
				
			}else if(dataType == Datatype.DATE || dataType == Datatype.YEAR ){
				cell.setValue(rs.getDate(columnIndex));
				
			}else if(dataType == Datatype.JAVA_OBJECT || dataType == Datatype.OTHER){
				cell.setValue(rs.getObject(columnIndex));
				
			}else if(dataType == Datatype.ARRAY){
				cell.setValue(rs.getArray(columnIndex));
				
			}else if( dataType == Datatype.BINARY 
					|| dataType == Datatype.VARBINARY 
					|| dataType == Datatype.LONGVARBINARY || dataType == Datatype.BLOB
					|| dataType == Datatype.MEDIUMBLOB ){
				cell.setValue(rs.getBytes(columnIndex));
				
			}else if(dataType == Datatype.SQLXML){
				SQLXML xmlVal= rs.getSQLXML(columnIndex);
				cell.setValue(xmlVal.getString());
				
			}else{ 
				cell.setValue(rs.getString(columnIndex));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	@Override
	public Database getDatabase(String dbName) {
		return this.database;
	}

	@Override
	public Queue<Packet<Row>> getRowQueue(Table t, int size) {
		// TODO Auto-generated method stub
		return null;
	}


}
