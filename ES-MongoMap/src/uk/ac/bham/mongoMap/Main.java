package uk.ac.bham.mongoMap;

import java.util.ArrayList;
import java.util.List;

import uk.ac.bham.mongoMap.map.SitraMapper;
import uk.ac.bham.mongoMap.map.rules.CellToKeyVal;
import uk.ac.bham.mongoMap.map.rules.DatabaseToMongoDB;
import uk.ac.bham.mongoMap.map.rules.PrimaryKeyToID;
import uk.ac.bham.mongoMap.map.rules.RowToDocument;
import uk.ac.bham.mongoMap.map.rules.TableToCollection;
import uk.ac.bham.mongoMap.map.rules.UniqueToUniqueIndex;
import uk.ac.bham.mongoMap.model.mongo.MongoDB;
import uk.ac.bham.mongoMap.mongo.MongoService;
import uk.ac.bham.mongoMap.mongo.MongoServiceimpl;
import uk.ac.bham.mongoMap.sql.ConnectionJDBC;
import uk.ac.bham.mongoMap.sql.SqlService;
import uk.ac.bham.mongoMap.sql.SqlServiceImpl;
import uk.ac.bham.mongoMap.sql.SqlServiceTestingImpl;
import uk.ac.bham.sitra.Rule;
import utils.MongoDbPrinter;

public class Main {

	public static void main(String[] args) {

		// add rules to list
		List<Class<? extends Rule<?, ?>>> rules = new ArrayList<Class<? extends Rule<?, ?>>>();
		rules.add(CellToKeyVal.class);
		rules.add(DatabaseToMongoDB.class);
		rules.add(PrimaryKeyToID.class);
		rules.add(RowToDocument.class);
		rules.add(TableToCollection.class);
		rules.add(UniqueToUniqueIndex.class);

		// instantiate sqlService and sitraMapper with rules
		SitraMapper sitraMapper = new SitraMapper(rules);
		SqlService service = new SqlServiceTestingImpl();

		// perform the transformation from SQL-DB to MongoDB
		MongoDB mDB = null;
		try {
			mDB = (MongoDB) sitraMapper.performTransformation(service
					.getDatabase(null));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// print the new and shiny mongoDB
/*		if (mDB != null) {
			
			System.out.println("MongoDB: ------");
			MongoDbPrinter printer = new MongoDbPrinter();
			System.out.println(printer.printMongoDB(mDB));
			MongoService ms = new MongoServiceimpl();
			ms.setMongoDBDatabase(mDB);
		}*/
		
		
		
		
		//Getting data from MySQL
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectionJDBC conJDBC = new ConnectionJDBC();
		String databaseName = "sakila";
		String user = "root";
		String password = "";
		String url = "jdbc:mysql://localhost/"+databaseName;
		conJDBC.getConnectionJDBC(url,user,password);
		SqlService sqlImp = new SqlServiceImpl();
		sqlImp.getDatabase(conJDBC.getConnection(), databaseName);
		
		MongoDB mDB2 = null;
		try {
			mDB2 = (MongoDB) sitraMapper.performTransformation(sqlImp
					.getDatabase(null));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
