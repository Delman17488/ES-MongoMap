/**
 */
package uk.ac.bham.mongoMap.model.mongo;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see uk.ac.bham.mongoMap.model.mongo.MongoFactory
 * @model kind="package"
 * @generated
 */
public interface MongoPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mongo";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "uk.ac.bham.mongoMap.mongo";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "uk.ac.bham.mongoMap.mongo";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MongoPackage eINSTANCE = uk.ac.bham.mongoMap.model.mongo.impl.MongoPackageImpl.init();

	/**
	 * The meta object id for the '{@link uk.ac.bham.mongoMap.model.mongo.impl.MongoDBImpl <em>DB</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.bham.mongoMap.model.mongo.impl.MongoDBImpl
	 * @see uk.ac.bham.mongoMap.model.mongo.impl.MongoPackageImpl#getMongoDB()
	 * @generated
	 */
	int MONGO_DB = 0;

	/**
	 * The feature id for the '<em><b>Collections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONGO_DB__COLLECTIONS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONGO_DB__NAME = 1;

	/**
	 * The number of structural features of the '<em>DB</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONGO_DB_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>DB</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONGO_DB_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.bham.mongoMap.model.mongo.impl.CollectionImpl <em>Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.bham.mongoMap.model.mongo.impl.CollectionImpl
	 * @see uk.ac.bham.mongoMap.model.mongo.impl.MongoPackageImpl#getCollection()
	 * @generated
	 */
	int COLLECTION = 1;

	/**
	 * The feature id for the '<em><b>Documents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__DOCUMENTS = 0;

	/**
	 * The feature id for the '<em><b>Unique Indices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__UNIQUE_INDICES = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__NAME = 2;

	/**
	 * The number of structural features of the '<em>Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.bham.mongoMap.model.mongo.impl.KeyImpl <em>Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.bham.mongoMap.model.mongo.impl.KeyImpl
	 * @see uk.ac.bham.mongoMap.model.mongo.impl.MongoPackageImpl#getKey()
	 * @generated
	 */
	int KEY = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__NAME = 1;

	/**
	 * The number of structural features of the '<em>Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.bham.mongoMap.model.mongo.impl.MongoObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.bham.mongoMap.model.mongo.impl.MongoObjectImpl
	 * @see uk.ac.bham.mongoMap.model.mongo.impl.MongoPackageImpl#getMongoObject()
	 * @generated
	 */
	int MONGO_OBJECT = 3;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONGO_OBJECT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONGO_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.bham.mongoMap.model.mongo.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.bham.mongoMap.model.mongo.impl.ValueImpl
	 * @see uk.ac.bham.mongoMap.model.mongo.impl.MongoPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__TYPE = MONGO_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__VALUE = MONGO_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = MONGO_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_OPERATION_COUNT = MONGO_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.bham.mongoMap.model.mongo.impl.UniqueIndexImpl <em>Unique Index</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.bham.mongoMap.model.mongo.impl.UniqueIndexImpl
	 * @see uk.ac.bham.mongoMap.model.mongo.impl.MongoPackageImpl#getUniqueIndex()
	 * @generated
	 */
	int UNIQUE_INDEX = 5;

	/**
	 * The feature id for the '<em><b>Keys</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_INDEX__KEYS = 0;

	/**
	 * The number of structural features of the '<em>Unique Index</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_INDEX_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Unique Index</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIQUE_INDEX_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.bham.mongoMap.model.mongo.impl.DocumentImpl <em>Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.bham.mongoMap.model.mongo.impl.DocumentImpl
	 * @see uk.ac.bham.mongoMap.model.mongo.impl.MongoPackageImpl#getDocument()
	 * @generated
	 */
	int DOCUMENT = 6;

	/**
	 * The feature id for the '<em><b>Keys</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__KEYS = MONGO_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__ID = MONGO_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_FEATURE_COUNT = MONGO_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_OPERATION_COUNT = MONGO_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uk.ac.bham.mongoMap.model.mongo.impl.IdImpl <em>Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.bham.mongoMap.model.mongo.impl.IdImpl
	 * @see uk.ac.bham.mongoMap.model.mongo.impl.MongoPackageImpl#getId()
	 * @generated
	 */
	int ID = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID__VALUE = KEY__VALUE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID__NAME = KEY__NAME;

	/**
	 * The number of structural features of the '<em>Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_FEATURE_COUNT = KEY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_OPERATION_COUNT = KEY_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link uk.ac.bham.mongoMap.model.mongo.MongoDB <em>DB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB</em>'.
	 * @see uk.ac.bham.mongoMap.model.mongo.MongoDB
	 * @generated
	 */
	EClass getMongoDB();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.bham.mongoMap.model.mongo.MongoDB#getCollections <em>Collections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Collections</em>'.
	 * @see uk.ac.bham.mongoMap.model.mongo.MongoDB#getCollections()
	 * @see #getMongoDB()
	 * @generated
	 */
	EReference getMongoDB_Collections();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.mongo.MongoDB#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.bham.mongoMap.model.mongo.MongoDB#getName()
	 * @see #getMongoDB()
	 * @generated
	 */
	EAttribute getMongoDB_Name();

	/**
	 * Returns the meta object for class '{@link uk.ac.bham.mongoMap.model.mongo.Collection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection</em>'.
	 * @see uk.ac.bham.mongoMap.model.mongo.Collection
	 * @generated
	 */
	EClass getCollection();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.bham.mongoMap.model.mongo.Collection#getDocuments <em>Documents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Documents</em>'.
	 * @see uk.ac.bham.mongoMap.model.mongo.Collection#getDocuments()
	 * @see #getCollection()
	 * @generated
	 */
	EReference getCollection_Documents();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.bham.mongoMap.model.mongo.Collection#getUniqueIndices <em>Unique Indices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unique Indices</em>'.
	 * @see uk.ac.bham.mongoMap.model.mongo.Collection#getUniqueIndices()
	 * @see #getCollection()
	 * @generated
	 */
	EReference getCollection_UniqueIndices();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.mongo.Collection#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.bham.mongoMap.model.mongo.Collection#getName()
	 * @see #getCollection()
	 * @generated
	 */
	EAttribute getCollection_Name();

	/**
	 * Returns the meta object for class '{@link uk.ac.bham.mongoMap.model.mongo.Key <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key</em>'.
	 * @see uk.ac.bham.mongoMap.model.mongo.Key
	 * @generated
	 */
	EClass getKey();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.bham.mongoMap.model.mongo.Key#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see uk.ac.bham.mongoMap.model.mongo.Key#getValue()
	 * @see #getKey()
	 * @generated
	 */
	EReference getKey_Value();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.mongo.Key#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.bham.mongoMap.model.mongo.Key#getName()
	 * @see #getKey()
	 * @generated
	 */
	EAttribute getKey_Name();

	/**
	 * Returns the meta object for class '{@link uk.ac.bham.mongoMap.model.mongo.MongoObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see uk.ac.bham.mongoMap.model.mongo.MongoObject
	 * @generated
	 */
	EClass getMongoObject();

	/**
	 * Returns the meta object for class '{@link uk.ac.bham.mongoMap.model.mongo.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see uk.ac.bham.mongoMap.model.mongo.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.mongo.Value#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see uk.ac.bham.mongoMap.model.mongo.Value#getType()
	 * @see #getValue()
	 * @generated
	 */
	EAttribute getValue_Type();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.mongo.Value#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see uk.ac.bham.mongoMap.model.mongo.Value#getValue()
	 * @see #getValue()
	 * @generated
	 */
	EAttribute getValue_Value();

	/**
	 * Returns the meta object for class '{@link uk.ac.bham.mongoMap.model.mongo.UniqueIndex <em>Unique Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unique Index</em>'.
	 * @see uk.ac.bham.mongoMap.model.mongo.UniqueIndex
	 * @generated
	 */
	EClass getUniqueIndex();

	/**
	 * Returns the meta object for the attribute list '{@link uk.ac.bham.mongoMap.model.mongo.UniqueIndex#getKeys <em>Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Keys</em>'.
	 * @see uk.ac.bham.mongoMap.model.mongo.UniqueIndex#getKeys()
	 * @see #getUniqueIndex()
	 * @generated
	 */
	EAttribute getUniqueIndex_Keys();

	/**
	 * Returns the meta object for class '{@link uk.ac.bham.mongoMap.model.mongo.Document <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document</em>'.
	 * @see uk.ac.bham.mongoMap.model.mongo.Document
	 * @generated
	 */
	EClass getDocument();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.bham.mongoMap.model.mongo.Document#getKeys <em>Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Keys</em>'.
	 * @see uk.ac.bham.mongoMap.model.mongo.Document#getKeys()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Keys();

	/**
	 * Returns the meta object for the containment reference '{@link uk.ac.bham.mongoMap.model.mongo.Document#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Id</em>'.
	 * @see uk.ac.bham.mongoMap.model.mongo.Document#getId()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Id();

	/**
	 * Returns the meta object for class '{@link uk.ac.bham.mongoMap.model.mongo.Id <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Id</em>'.
	 * @see uk.ac.bham.mongoMap.model.mongo.Id
	 * @generated
	 */
	EClass getId();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MongoFactory getMongoFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link uk.ac.bham.mongoMap.model.mongo.impl.MongoDBImpl <em>DB</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.bham.mongoMap.model.mongo.impl.MongoDBImpl
		 * @see uk.ac.bham.mongoMap.model.mongo.impl.MongoPackageImpl#getMongoDB()
		 * @generated
		 */
		EClass MONGO_DB = eINSTANCE.getMongoDB();

		/**
		 * The meta object literal for the '<em><b>Collections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONGO_DB__COLLECTIONS = eINSTANCE.getMongoDB_Collections();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONGO_DB__NAME = eINSTANCE.getMongoDB_Name();

		/**
		 * The meta object literal for the '{@link uk.ac.bham.mongoMap.model.mongo.impl.CollectionImpl <em>Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.bham.mongoMap.model.mongo.impl.CollectionImpl
		 * @see uk.ac.bham.mongoMap.model.mongo.impl.MongoPackageImpl#getCollection()
		 * @generated
		 */
		EClass COLLECTION = eINSTANCE.getCollection();

		/**
		 * The meta object literal for the '<em><b>Documents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION__DOCUMENTS = eINSTANCE.getCollection_Documents();

		/**
		 * The meta object literal for the '<em><b>Unique Indices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION__UNIQUE_INDICES = eINSTANCE.getCollection_UniqueIndices();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION__NAME = eINSTANCE.getCollection_Name();

		/**
		 * The meta object literal for the '{@link uk.ac.bham.mongoMap.model.mongo.impl.KeyImpl <em>Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.bham.mongoMap.model.mongo.impl.KeyImpl
		 * @see uk.ac.bham.mongoMap.model.mongo.impl.MongoPackageImpl#getKey()
		 * @generated
		 */
		EClass KEY = eINSTANCE.getKey();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY__VALUE = eINSTANCE.getKey_Value();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY__NAME = eINSTANCE.getKey_Name();

		/**
		 * The meta object literal for the '{@link uk.ac.bham.mongoMap.model.mongo.impl.MongoObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.bham.mongoMap.model.mongo.impl.MongoObjectImpl
		 * @see uk.ac.bham.mongoMap.model.mongo.impl.MongoPackageImpl#getMongoObject()
		 * @generated
		 */
		EClass MONGO_OBJECT = eINSTANCE.getMongoObject();

		/**
		 * The meta object literal for the '{@link uk.ac.bham.mongoMap.model.mongo.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.bham.mongoMap.model.mongo.impl.ValueImpl
		 * @see uk.ac.bham.mongoMap.model.mongo.impl.MongoPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE__TYPE = eINSTANCE.getValue_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE__VALUE = eINSTANCE.getValue_Value();

		/**
		 * The meta object literal for the '{@link uk.ac.bham.mongoMap.model.mongo.impl.UniqueIndexImpl <em>Unique Index</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.bham.mongoMap.model.mongo.impl.UniqueIndexImpl
		 * @see uk.ac.bham.mongoMap.model.mongo.impl.MongoPackageImpl#getUniqueIndex()
		 * @generated
		 */
		EClass UNIQUE_INDEX = eINSTANCE.getUniqueIndex();

		/**
		 * The meta object literal for the '<em><b>Keys</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIQUE_INDEX__KEYS = eINSTANCE.getUniqueIndex_Keys();

		/**
		 * The meta object literal for the '{@link uk.ac.bham.mongoMap.model.mongo.impl.DocumentImpl <em>Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.bham.mongoMap.model.mongo.impl.DocumentImpl
		 * @see uk.ac.bham.mongoMap.model.mongo.impl.MongoPackageImpl#getDocument()
		 * @generated
		 */
		EClass DOCUMENT = eINSTANCE.getDocument();

		/**
		 * The meta object literal for the '<em><b>Keys</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__KEYS = eINSTANCE.getDocument_Keys();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__ID = eINSTANCE.getDocument_Id();

		/**
		 * The meta object literal for the '{@link uk.ac.bham.mongoMap.model.mongo.impl.IdImpl <em>Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.bham.mongoMap.model.mongo.impl.IdImpl
		 * @see uk.ac.bham.mongoMap.model.mongo.impl.MongoPackageImpl#getId()
		 * @generated
		 */
		EClass ID = eINSTANCE.getId();

	}

} //MongoPackage
