package uk.ac.bham.mongoMap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
import uk.ac.bham.mongoMap.model.mongo.MongoDB;
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

			Properties properties = getProperties();
			SqlService sqlService = getSqlService(properties);
			MongoService mongoService = getMongoService(properties);

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
		try {
			return sqlService.getDatabase();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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

		String databaseUrl = null;
		String databaseName = props.getProperty("sql.database.name");
		if (databaseName != null)
			databaseUrl = props.getProperty("sql.database.url") + databaseName;

		if (databaseUrl == null) {
			System.err.println("Error: No database url specified in the"
					+ "\"database.url\" attribute of the property file");
			System.exit(1);
		}
		String username = props.getProperty("sql.database.user");
		String password = props.getProperty("sql.database.password");

		conJDBC.getConnectionJDBC(databaseUrl, username, password);

		return new SqlServiceImpl(conJDBC.getConnection(), databaseName);
	}

	private static MongoService getMongoService(Properties props)
			throws Exception {
		String ip = props.getProperty("mongo.database.ip");
		int port = Integer.parseInt(props.getProperty("mongo.database.port"));

		return new MongoServiceimpl(ip, port);
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
