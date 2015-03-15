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
import uk.ac.bham.mongoMap.model.sql.Database;
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

		// Grabbing SQL database and setting up SitraMapper 
//		Database sqlDb = getTestingDatabase();
		Database sqlDb = getSqlDatabase();
		SitraMapper sitraMapper = setupSitraMapper();
		
		// perform the transformation from SQL-DB to MongoDB
		MongoDB mDB = null;
		try {
			mDB = (MongoDB) sitraMapper.performTransformation(sqlDb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	if (mDB != null) {
			// print the new and shiny mongoDB
//			System.out.println("MongoDB: ------");
//			MongoDbPrinter printer = new MongoDbPrinter();
//			System.out.println(printer.printMongoDB(mDB));
			
			// persist the new and shiny mongoDB to a MongoDB database 
			 MongoService ms = new MongoServiceimpl();
			 ms.setMongoDBDatabase(mDB);
		}

	}

	private static SitraMapper setupSitraMapper() {
		// add rules to list
		List<Class<? extends Rule<?, ?>>> rules = new ArrayList<Class<? extends Rule<?, ?>>>();
		rules.add(CellToKeyVal.class);
		rules.add(DatabaseToMongoDB.class);
		rules.add(PrimaryKeyToID.class);
		rules.add(RowToDocument.class);
		rules.add(TableToCollection.class);
		rules.add(UniqueToUniqueIndex.class);

		return new SitraMapper(rules);
	}

	private static Database getTestingDatabase() {
		SqlService sqlService = new SqlServiceTestingImpl();
		return sqlService.getDatabase(null);
	}

	/**
	 * Getting data from MySQL
	 * @return {@link Database}
	 */
	private static Database getSqlDatabase() {
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
		String url = "jdbc:mysql://localhost/" + databaseName;
		conJDBC.getConnectionJDBC(url, user, password);
		SqlService sqlImp = new SqlServiceImpl();
		return sqlImp.getDatabase(conJDBC.getConnection(), databaseName);

	}
}
