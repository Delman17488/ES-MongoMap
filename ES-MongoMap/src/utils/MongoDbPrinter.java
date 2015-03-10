package utils;

import uk.ac.bham.mongoMap.model.mongo.Collection;
import uk.ac.bham.mongoMap.model.mongo.Document;
import uk.ac.bham.mongoMap.model.mongo.Key;
import uk.ac.bham.mongoMap.model.mongo.MongoDB;
import uk.ac.bham.mongoMap.model.mongo.UniqueIndex;
import uk.ac.bham.mongoMap.model.mongo.Value;

public class MongoDbPrinter {
	
	private int indentLevel = 0;
	private StringBuilder stringBuilder = new StringBuilder();
	
	private void appendIndented(String string) {
		for (int i = 0; i < indentLevel; i++) {
			stringBuilder.append("  ");
		}
		stringBuilder.append(string);
	}
	
	private void append(String string) {
		stringBuilder.append(string);
	}
	
	public String printMongoDB(MongoDB mDb) {
		appendIndented("Database: " + mDb.getName() + "\n\n");
		appendIndented("Collections\n");
		appendIndented("===========\n\n");

		for (Collection coll : mDb.getCollections()) {
			appendIndented("[Collection]\n");
			
			indentLevel++;
			appendIndented("Name: " + coll.getName() + "\n");
			appendIndented("[Indices]\n");
		
			indentLevel++;
			for (UniqueIndex index : coll.getUniqueIndices()) {
				appendIndented("Index: ");
				append(index.getKeys().toString() + "\n");
			}
			indentLevel--;

			appendIndented("[Documents]\n");
			
			indentLevel++;
			for (Document doc : coll.getDocuments()) {
				appendIndented("");
				printDocument(doc);
			}
			indentLevel--;
			indentLevel--;
			appendIndented("\n");
		}
		return stringBuilder.toString();
	}

	private void printDocument(Document doc) {
		append("{\n");
		indentLevel++;
		// print the id
		if (doc.getId() != null) {
			printKey(doc.getId());
		} else {
			appendIndented("_id : null\n");
		}
		// print the key value pairs
		for (Key key : doc.getKeys()) {
			printKey(key);
		}
		indentLevel--;
		appendIndented("}\n");
	}

	private void printKey(Key key) {
		appendIndented(key.getName() + ": ");
		if (key.getValue() instanceof Document) {
			Document subDoc = (Document) key.getValue();
			indentLevel++;
			printDocument(subDoc);
			indentLevel--;
		} else {
			Value val = (Value) key.getValue();
			append(val.getValue().toString() + " [" + val.getType() + "]\n");
		}
	}

}
