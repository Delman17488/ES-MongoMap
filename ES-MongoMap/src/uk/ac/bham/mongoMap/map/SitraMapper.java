package uk.ac.bham.mongoMap.map;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;
import java.util.Queue;
import java.util.Set;

import uk.ac.bham.mongoMap.model.mongo.Collection;
import uk.ac.bham.mongoMap.model.mongo.Document;
import uk.ac.bham.mongoMap.model.mongo.MongoDB;
import uk.ac.bham.mongoMap.model.mongo.UniqueIndex;
import uk.ac.bham.mongoMap.model.sql.Column;
import uk.ac.bham.mongoMap.model.sql.Constraint;
import uk.ac.bham.mongoMap.model.sql.ConstraintType;
import uk.ac.bham.mongoMap.model.sql.Database;
import uk.ac.bham.mongoMap.model.sql.Row;
import uk.ac.bham.mongoMap.model.sql.Table;
import uk.ac.bham.mongoMap.mongo.MongoService;
import uk.ac.bham.mongoMap.sql.SqlService;
import uk.ac.bham.sitra.Rule;
import uk.ac.bham.sitra.RuleNotFoundException;
import uk.ac.bham.sitra.SimpleTransformerImpl;
import uk.ac.bham.sitra.Transformer;

public class SitraMapper {

	private Transformer transformer;
	private Set<Entry<Table, Collection>> map = new HashSet<Entry<Table, Collection>>();

	public SitraMapper(List<Class<? extends Rule<?, ?>>> rules) {
		transformer = new SimpleTransformerImpl(rules);
	}

	public MongoDB performTransformation(SqlService sqlService,
			MongoService mongoService) throws Exception {
		try {
			Database db = sqlService.getDatabase();

			// transform SQL-DB to MongoDB
			MongoDB mongoDB = (MongoDB) transformer.transform(db);

			for (Table table : db.getTable()) {
				// transform table to collection
				Collection coll = (Collection) transformer.transform(table);

				// map unique constraints to unique indices and add them to the
				// collection
				for (Constraint constraint : table.getConstraints()) {
					switch (constraint.getType()) {
					case UNIQUE:
						// add unique constraint only if it does not belong to a
						// primary key constraint
						// otherwise the MongoDB tries to add a unique index on
						// columns which do not exist (_id is primary key)
						if (!isPrimaryKeyUniqueConstraint(constraint)) {
							UniqueIndex index = (UniqueIndex) transformer
									.transform(constraint);
							coll.getUniqueIndices().add(index);
						}
						break;
					default:
						break;
					}
				}

				// add collection to mongoDB
				mongoDB.getCollections().add(coll);

				map.add(new AbstractMap.SimpleEntry<Table, Collection>(table,
						coll));
			}

			mongoService.setMongoDBDatabase(mongoDB);

			int size = 500;
			for (Entry<Table, Collection> entry : map) {
				BlockingQueue<Packet<Row>> src = sqlService.getRowQueue(entry.getKey(),
						size);
				BlockingQueue<Packet<Document>> trg = mongoService.getDocumentQueue(
						entry.getValue(), size);
				ConsumerAndProducer cap = new ConsumerAndProducer(src, trg,
						size);

				Thread consumerAndProducer = new Thread(cap);
				consumerAndProducer.start();
				consumerAndProducer.join();
				System.out.println("Table done: " + entry.getKey().getName());
				// execute garbage collection
				System.gc();
			}

			return mongoDB;
		} catch (RuleNotFoundException e) {
			throw new Exception("A rule could not have been found.", e);
		}
	}

	private boolean isPrimaryKeyUniqueConstraint(Constraint unique) {
		// we only need to check whether the first column belongs to a
		// primary/composite key as a unique constraint is
		// never defined on partial primary key columns unless the unique
		// constraint belongs to the primary key constraint.
		Column col = unique.getColumn().get(0);
		for (Constraint constraint : col.getConstraint()) {
			if (constraint.getType() == ConstraintType.PRIMARY_KEY
					|| constraint.getType() == ConstraintType.COMPOSITE_PRIMARY_KEY) {
				return true;
			}
		}
		return false;
	}

	private class ConsumerAndProducer implements Runnable {

		private BlockingQueue<Packet<Row>> src;
		private BlockingQueue<Packet<Document>> trg;

		private int queueSize;

		public ConsumerAndProducer(BlockingQueue<Packet<Row>> src,
				BlockingQueue<Packet<Document>> trg, int size) {
			this.src = src;
			this.trg = trg;
			queueSize = size;
		}

		public void consumeAndProduce() {
			boolean lastPackage = false;
			int i = 0;
			while (!lastPackage) {
				try {
					Packet<Row> pRow = consume();

					Document doc = (Document) transformer.transform(pRow
							.getPayload());
					Packet<Document> pDoc = new Packet<Document>(doc);
					pDoc.setLastPacket(pRow.isLastPacket());
					lastPackage = pRow.isLastPacket();

					System.out.println("i = " + i);
					i++;
					produce(pDoc);
				} catch (RuleNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		public void produce(Packet<Document> pDoc) {
			try {
				trg.put(pDoc);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public Packet<Row> consume() {
			Packet<Row> pRow = null;
			try {
				pRow = src.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return pRow;
		}

		@Override
		public void run() {
			consumeAndProduce();
		}

	}
}
