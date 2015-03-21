package uk.ac.bham.mongoMap;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import java.util.Scanner;
=======
import java.util.Properties;
>>>>>>> branch 'trunk' of https://github.com/Delman17488/ES-MongoMap.git

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
	public static final String PROPERTIES_FILE_NAME = "database.properties";
	public static void main(String[] args) {
		System.out.println("Press any key if you are ready for profiling:");
		Scanner input = new Scanner(System.in);
		input.nextLine();
		long startTime = System.currentTimeMillis();
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
		System.out.println("Transformation finished in " + (System.currentTimeMillis() - startTime) + " milliseconds");
		System.exit(0);
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
		ConnectionJDBC conJDBC = new ConnectionJDBC();
		
		Properties props = new Properties();
		InputStream in = Main.class.getResourceAsStream(PROPERTIES_FILE_NAME);
        if (in == null) {
            System.err.println("Error: Failed to find the \"database.properties\" file.");
            System.exit(1);
        }
        try {
			props.load(in);
			// load the JDBC driver
	        String drivers = props.getProperty("jdbc.drivers");
	        if (drivers == null) {
	            System.err.println("Error: No JDBC driver specified in the"
	                    + "\"jdbc.driver\" attribute of the property file");
	            System.exit(1);
	        }
	        Class.forName(drivers);
	        
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD
		ConnectionJDBC conJDBC = new ConnectionJDBC();
		String databaseName = "employees";
		String user = "root";
		String password = "mongomap";
		String url = "jdbc:mysql://192.168.56.200/" + databaseName;
		conJDBC.getConnectionJDBC(url, user, password);
		SqlService sqlImp = new SqlServiceImpl();
		return sqlImp.getDatabase(conJDBC.getConnection(), databaseName);
=======

        String database = props.getProperty("database.url");
        String databaseName = props.getProperty("database.name");
        if (database == null) {
            System.err.println("Error: No database url specified in the"
                    + "\"database.url\" attribute of the property file");
            System.exit(1);
        }
        String username = props.getProperty("database.user");
        String password = props.getProperty("database.password");        
        
		conJDBC.getConnectionJDBC(database, username, password);
		
		SqlService sqlImp = new SqlServiceImpl(conJDBC.getConnection(),databaseName);
		return sqlImp.getDatabase();
>>>>>>> branch 'trunk' of https://github.com/Delman17488/ES-MongoMap.git

	}
}
