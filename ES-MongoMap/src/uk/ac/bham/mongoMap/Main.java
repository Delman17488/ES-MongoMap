package uk.ac.bham.mongoMap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import uk.ac.bham.mongoMap.map.SitraMapper;
import uk.ac.bham.mongoMap.map.rules.CellToKeyVal;
import uk.ac.bham.mongoMap.map.rules.DatabaseToMongoDB;
import uk.ac.bham.mongoMap.map.rules.PrimaryKeyToID;
import uk.ac.bham.mongoMap.map.rules.RowToDocument;
import uk.ac.bham.mongoMap.map.rules.TableToCollection;
import uk.ac.bham.mongoMap.map.rules.UniqueToUniqueIndex;
import uk.ac.bham.mongoMap.model.sql.Database;
import uk.ac.bham.mongoMap.mongo.MongoService;
import uk.ac.bham.mongoMap.mongo.MongoServiceimpl;
import uk.ac.bham.mongoMap.sql.ConnectionJDBC;
import uk.ac.bham.mongoMap.sql.SqlService;
import uk.ac.bham.mongoMap.sql.SqlServiceImpl;
import uk.ac.bham.mongoMap.sql.SqlServiceTestingImpl;
import uk.ac.bham.sitra.Rule;

public class Main {

	public static final String PROPERTIES_FILE_NAME = "database.properties";

	public static void main(String[] args) {
		try {
			System.out.println("Press any key if you are ready for profiling:");
			Scanner input = new Scanner(System.in);
			input.nextLine();

			long startTime = System.currentTimeMillis();
			
			// Create a property object from "database.properties" file, which contains Database name, User Name, ..ect
			// This object contains all necessary information about source and target Databases	 
		    Properties properties = getProperties();
			
		    // SqlService interface is used to access the source database
		    // MongoService interface is used to access the target database
			SqlService sqlService = getSqlService(properties);
			MongoService mongoService = getMongoService(properties);

			// Create a SitraMapper object
			// The created object contains all rules that are needed for the transformation
			SitraMapper sitraMapper = setupSitraMapper();

			// perform the transformation from SQL-DB to MongoDB
			sitraMapper.performTransformation(sqlService, mongoService);

			System.out.println("Transformation finished in "
					+ (System.currentTimeMillis() - startTime)
					+ " milliseconds");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static SitraMapper setupSitraMapper() {
		
		// Create a list in order to hold the rules
		List<Class<? extends Rule<?, ?>>> rules = new ArrayList<Class<? extends Rule<?, ?>>>();
		
		// add rules to list
		rules.add(CellToKeyVal.class);
		rules.add(DatabaseToMongoDB.class);
		rules.add(PrimaryKeyToID.class);
		rules.add(RowToDocument.class);
		rules.add(TableToCollection.class);
		rules.add(UniqueToUniqueIndex.class);

		return new SitraMapper(rules);
	}
	
	/**
	 * In SqlServiceTestingImpl class, the source database is created manually.
	 * 
	 * At first, this was used for testing our software,but then 
	 * MySQL database samples(Sakila & Employee) are used as the source database. 
	 * 
	 * This method returns the manually created database
	 * @throws SQLException 
	 * @return{@link Database}
	 */
	private static Database getTestingDatabase() throws SQLException {
		SqlService sqlService = new SqlServiceTestingImpl();
		try {
			return sqlService.getDatabase();
		} catch (SQLException e) {
			throw new SQLException(
					"Error: Failed to load the database from SqlServiceTestingImpl.");		
			}
	}

	/**
	 * Sets up the SqlService.
	 * 
	 * @return {@link SqlService}
	 */
	private static SqlService getSqlService(Properties props)
			throws ClassNotFoundException {
		
		ConnectionJDBC conJDBC = new ConnectionJDBC();
		
		// load the JDBC driver
		String drivers = props.getProperty("sql.jdbc.drivers");
		if (drivers == null) {
			System.err.println("Error: No JDBC driver specified in the"
					+ "\"jdbc.driver\" attribute of the property file");
			System.exit(1);
		}
		Class.forName(drivers);
		
		// load the source database property
		String database = props.getProperty("sql.database.url");
		String databaseName = props.getProperty("sql.database.name");
		if (database == null) {
			System.err.println("Error: No database url specified in the"
					+ "\"database.url\" attribute of the property file");
			System.exit(1);
		}
		
		// Read the username and password
		String username = props.getProperty("sql.database.user");
		String password = props.getProperty("sql.database.password");

		//Create the connection to the source database
		conJDBC.getConnectionJDBC(database, username, password);

		return new SqlServiceImpl(conJDBC.getConnection(), databaseName);
	}

	private static MongoService getMongoService(Properties props) throws Exception {
	
		// load the target database property		
		String ip = props.getProperty("mongo.database.ip");
		int port = Integer.parseInt(props.getProperty("mongo.database.port"));

		try {
			return new MongoServiceimpl(ip, port);
		} catch (UnknownHostException e) {
			throw new Exception(
					"Error: Unknown host while trying to connect to MongoDB.", e);
		}
	}

	private static Properties getProperties() throws IOException {
		Properties props = new Properties();
		InputStream in = Main.class.getResourceAsStream(PROPERTIES_FILE_NAME);

		if (in == null) {
			throw new FileNotFoundException(String.format(
					"Error: Failed to find the '%s' file.",
					PROPERTIES_FILE_NAME));
		}
		props.load(in);

		return props;
	}
}
