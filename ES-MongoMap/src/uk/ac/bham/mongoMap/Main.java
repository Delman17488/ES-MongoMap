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
import uk.ac.bham.mongoMap.sql.SqlService;
import uk.ac.bham.mongoMap.sql.SqlServiceImpl;
import uk.ac.bham.sitra.Rule;

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
		SqlService service = new SqlServiceImpl();

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
		if (mDB != null) {
			System.out.println("MongoDB: ------");
			System.out.println(mDB.toString());
		}
	}
}
