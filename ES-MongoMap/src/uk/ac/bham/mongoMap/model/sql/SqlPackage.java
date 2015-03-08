/**
 */
package uk.ac.bham.mongoMap.model.sql;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see uk.ac.bham.mongoMap.model.sql.SqlFactory
 * @model kind="package"
 * @generated
 */
public interface SqlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sql";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "uk.ac.bham.mongoMap.sql";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "uk.ac.bham.mongoMap.sql";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SqlPackage eINSTANCE = uk.ac.bham.mongoMap.model.sql.impl.SqlPackageImpl.init();

	/**
	 * The meta object id for the '{@link uk.ac.bham.mongoMap.model.sql.impl.DatabaseImpl <em>Database</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.bham.mongoMap.model.sql.impl.DatabaseImpl
	 * @see uk.ac.bham.mongoMap.model.sql.impl.SqlPackageImpl#getDatabase()
	 * @generated
	 */
	int DATABASE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Table</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__TABLE = 1;

	/**
	 * The feature id for the '<em><b>Sequences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__SEQUENCES = 2;

	/**
	 * The number of structural features of the '<em>Database</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Database</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.bham.mongoMap.model.sql.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.bham.mongoMap.model.sql.impl.TableImpl
	 * @see uk.ac.bham.mongoMap.model.sql.impl.SqlPackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__CONSTRAINTS = 1;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__COLUMNS = 2;

	/**
	 * The feature id for the '<em><b>Rows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__ROWS = 3;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.bham.mongoMap.model.sql.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.bham.mongoMap.model.sql.impl.ConstraintImpl
	 * @see uk.ac.bham.mongoMap.model.sql.impl.SqlPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__COLUMN = 3;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.bham.mongoMap.model.sql.impl.ColumnImpl <em>Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.bham.mongoMap.model.sql.impl.ColumnImpl
	 * @see uk.ac.bham.mongoMap.model.sql.impl.SqlPackageImpl#getColumn()
	 * @generated
	 */
	int COLUMN = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__NULLABLE = 2;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__SIZE = 3;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__CONSTRAINT = 4;

	/**
	 * The number of structural features of the '<em>Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.bham.mongoMap.model.sql.impl.SequenceImpl <em>Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.bham.mongoMap.model.sql.impl.SequenceImpl
	 * @see uk.ac.bham.mongoMap.model.sql.impl.SqlPackageImpl#getSequence()
	 * @generated
	 */
	int SEQUENCE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Min Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__MIN_VALUE = 1;

	/**
	 * The feature id for the '<em><b>Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__MAX_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Incrementby</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__INCREMENTBY = 3;

	/**
	 * The feature id for the '<em><b>Startwith</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__STARTWITH = 4;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__CURRENT_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__CYCLE = 6;

	/**
	 * The number of structural features of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.bham.mongoMap.model.sql.impl.RowImpl <em>Row</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.bham.mongoMap.model.sql.impl.RowImpl
	 * @see uk.ac.bham.mongoMap.model.sql.impl.SqlPackageImpl#getRow()
	 * @generated
	 */
	int ROW = 5;

	/**
	 * The feature id for the '<em><b>Cells</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__CELLS = 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__CONSTRAINTS = 1;

	/**
	 * The number of structural features of the '<em>Row</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Row</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.bham.mongoMap.model.sql.impl.CellImpl <em>Cell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.bham.mongoMap.model.sql.impl.CellImpl
	 * @see uk.ac.bham.mongoMap.model.sql.impl.SqlPackageImpl#getCell()
	 * @generated
	 */
	int CELL = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL__COLUMN = 1;

	/**
	 * The number of structural features of the '<em>Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uk.ac.bham.mongoMap.model.sql.Datatye <em>Datatye</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.bham.mongoMap.model.sql.Datatye
	 * @see uk.ac.bham.mongoMap.model.sql.impl.SqlPackageImpl#getDatatye()
	 * @generated
	 */
	int DATATYE = 7;

	/**
	 * The meta object id for the '{@link uk.ac.bham.mongoMap.model.sql.ConstraintType <em>Constraint Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uk.ac.bham.mongoMap.model.sql.ConstraintType
	 * @see uk.ac.bham.mongoMap.model.sql.impl.SqlPackageImpl#getConstraintType()
	 * @generated
	 */
	int CONSTRAINT_TYPE = 8;


	/**
	 * Returns the meta object for class '{@link uk.ac.bham.mongoMap.model.sql.Database <em>Database</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Database</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Database
	 * @generated
	 */
	EClass getDatabase();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.sql.Database#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Database#getName()
	 * @see #getDatabase()
	 * @generated
	 */
	EAttribute getDatabase_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.bham.mongoMap.model.sql.Database#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Table</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Database#getTable()
	 * @see #getDatabase()
	 * @generated
	 */
	EReference getDatabase_Table();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.bham.mongoMap.model.sql.Database#getSequences <em>Sequences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sequences</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Database#getSequences()
	 * @see #getDatabase()
	 * @generated
	 */
	EReference getDatabase_Sequences();

	/**
	 * Returns the meta object for class '{@link uk.ac.bham.mongoMap.model.sql.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.sql.Table#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Table#getName()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.bham.mongoMap.model.sql.Table#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Table#getConstraints()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Constraints();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.bham.mongoMap.model.sql.Table#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Table#getColumns()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Columns();

	/**
	 * Returns the meta object for the reference list '{@link uk.ac.bham.mongoMap.model.sql.Table#getRows <em>Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Rows</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Table#getRows()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Rows();

	/**
	 * Returns the meta object for class '{@link uk.ac.bham.mongoMap.model.sql.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.sql.Constraint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Constraint#getName()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Name();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.sql.Constraint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Constraint#getType()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Type();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.sql.Constraint#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Constraint#getReference()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Reference();

	/**
	 * Returns the meta object for the reference list '{@link uk.ac.bham.mongoMap.model.sql.Constraint#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Column</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Constraint#getColumn()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Column();

	/**
	 * Returns the meta object for class '{@link uk.ac.bham.mongoMap.model.sql.Column <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Column</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Column
	 * @generated
	 */
	EClass getColumn();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.sql.Column#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Column#getName()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Name();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.sql.Column#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Column#getType()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Type();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.sql.Column#isNullable <em>Nullable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nullable</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Column#isNullable()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Nullable();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.sql.Column#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Column#getSize()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Size();

	/**
	 * Returns the meta object for the reference list '{@link uk.ac.bham.mongoMap.model.sql.Column#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constraint</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Column#getConstraint()
	 * @see #getColumn()
	 * @generated
	 */
	EReference getColumn_Constraint();

	/**
	 * Returns the meta object for class '{@link uk.ac.bham.mongoMap.model.sql.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Sequence
	 * @generated
	 */
	EClass getSequence();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.sql.Sequence#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Sequence#getName()
	 * @see #getSequence()
	 * @generated
	 */
	EAttribute getSequence_Name();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.sql.Sequence#getMinValue <em>Min Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Value</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Sequence#getMinValue()
	 * @see #getSequence()
	 * @generated
	 */
	EAttribute getSequence_MinValue();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.sql.Sequence#getMaxValue <em>Max Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Value</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Sequence#getMaxValue()
	 * @see #getSequence()
	 * @generated
	 */
	EAttribute getSequence_MaxValue();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.sql.Sequence#getIncrementby <em>Incrementby</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Incrementby</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Sequence#getIncrementby()
	 * @see #getSequence()
	 * @generated
	 */
	EAttribute getSequence_Incrementby();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.sql.Sequence#getStartwith <em>Startwith</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startwith</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Sequence#getStartwith()
	 * @see #getSequence()
	 * @generated
	 */
	EAttribute getSequence_Startwith();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.sql.Sequence#getCurrentValue <em>Current Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Value</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Sequence#getCurrentValue()
	 * @see #getSequence()
	 * @generated
	 */
	EAttribute getSequence_CurrentValue();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.sql.Sequence#isCycle <em>Cycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cycle</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Sequence#isCycle()
	 * @see #getSequence()
	 * @generated
	 */
	EAttribute getSequence_Cycle();

	/**
	 * Returns the meta object for class '{@link uk.ac.bham.mongoMap.model.sql.Row <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Row</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Row
	 * @generated
	 */
	EClass getRow();

	/**
	 * Returns the meta object for the containment reference list '{@link uk.ac.bham.mongoMap.model.sql.Row#getCells <em>Cells</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cells</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Row#getCells()
	 * @see #getRow()
	 * @generated
	 */
	EReference getRow_Cells();

	/**
	 * Returns the meta object for the reference list '{@link uk.ac.bham.mongoMap.model.sql.Row#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constraints</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Row#getConstraints()
	 * @see #getRow()
	 * @generated
	 */
	EReference getRow_Constraints();

	/**
	 * Returns the meta object for class '{@link uk.ac.bham.mongoMap.model.sql.Cell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cell</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Cell
	 * @generated
	 */
	EClass getCell();

	/**
	 * Returns the meta object for the attribute '{@link uk.ac.bham.mongoMap.model.sql.Cell#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Cell#getValue()
	 * @see #getCell()
	 * @generated
	 */
	EAttribute getCell_Value();

	/**
	 * Returns the meta object for the reference '{@link uk.ac.bham.mongoMap.model.sql.Cell#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Column</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Cell#getColumn()
	 * @see #getCell()
	 * @generated
	 */
	EReference getCell_Column();

	/**
	 * Returns the meta object for enum '{@link uk.ac.bham.mongoMap.model.sql.Datatye <em>Datatye</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Datatye</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.Datatye
	 * @generated
	 */
	EEnum getDatatye();

	/**
	 * Returns the meta object for enum '{@link uk.ac.bham.mongoMap.model.sql.ConstraintType <em>Constraint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Constraint Type</em>'.
	 * @see uk.ac.bham.mongoMap.model.sql.ConstraintType
	 * @generated
	 */
	EEnum getConstraintType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SqlFactory getSqlFactory();

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
		 * The meta object literal for the '{@link uk.ac.bham.mongoMap.model.sql.impl.DatabaseImpl <em>Database</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.bham.mongoMap.model.sql.impl.DatabaseImpl
		 * @see uk.ac.bham.mongoMap.model.sql.impl.SqlPackageImpl#getDatabase()
		 * @generated
		 */
		EClass DATABASE = eINSTANCE.getDatabase();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE__NAME = eINSTANCE.getDatabase_Name();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE__TABLE = eINSTANCE.getDatabase_Table();

		/**
		 * The meta object literal for the '<em><b>Sequences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE__SEQUENCES = eINSTANCE.getDatabase_Sequences();

		/**
		 * The meta object literal for the '{@link uk.ac.bham.mongoMap.model.sql.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.bham.mongoMap.model.sql.impl.TableImpl
		 * @see uk.ac.bham.mongoMap.model.sql.impl.SqlPackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE__NAME = eINSTANCE.getTable_Name();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__CONSTRAINTS = eINSTANCE.getTable_Constraints();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__COLUMNS = eINSTANCE.getTable_Columns();

		/**
		 * The meta object literal for the '<em><b>Rows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__ROWS = eINSTANCE.getTable_Rows();

		/**
		 * The meta object literal for the '{@link uk.ac.bham.mongoMap.model.sql.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.bham.mongoMap.model.sql.impl.ConstraintImpl
		 * @see uk.ac.bham.mongoMap.model.sql.impl.SqlPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__NAME = eINSTANCE.getConstraint_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__TYPE = eINSTANCE.getConstraint_Type();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__REFERENCE = eINSTANCE.getConstraint_Reference();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__COLUMN = eINSTANCE.getConstraint_Column();

		/**
		 * The meta object literal for the '{@link uk.ac.bham.mongoMap.model.sql.impl.ColumnImpl <em>Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.bham.mongoMap.model.sql.impl.ColumnImpl
		 * @see uk.ac.bham.mongoMap.model.sql.impl.SqlPackageImpl#getColumn()
		 * @generated
		 */
		EClass COLUMN = eINSTANCE.getColumn();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__NAME = eINSTANCE.getColumn_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__TYPE = eINSTANCE.getColumn_Type();

		/**
		 * The meta object literal for the '<em><b>Nullable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__NULLABLE = eINSTANCE.getColumn_Nullable();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__SIZE = eINSTANCE.getColumn_Size();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLUMN__CONSTRAINT = eINSTANCE.getColumn_Constraint();

		/**
		 * The meta object literal for the '{@link uk.ac.bham.mongoMap.model.sql.impl.SequenceImpl <em>Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.bham.mongoMap.model.sql.impl.SequenceImpl
		 * @see uk.ac.bham.mongoMap.model.sql.impl.SqlPackageImpl#getSequence()
		 * @generated
		 */
		EClass SEQUENCE = eINSTANCE.getSequence();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCE__NAME = eINSTANCE.getSequence_Name();

		/**
		 * The meta object literal for the '<em><b>Min Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCE__MIN_VALUE = eINSTANCE.getSequence_MinValue();

		/**
		 * The meta object literal for the '<em><b>Max Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCE__MAX_VALUE = eINSTANCE.getSequence_MaxValue();

		/**
		 * The meta object literal for the '<em><b>Incrementby</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCE__INCREMENTBY = eINSTANCE.getSequence_Incrementby();

		/**
		 * The meta object literal for the '<em><b>Startwith</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCE__STARTWITH = eINSTANCE.getSequence_Startwith();

		/**
		 * The meta object literal for the '<em><b>Current Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCE__CURRENT_VALUE = eINSTANCE.getSequence_CurrentValue();

		/**
		 * The meta object literal for the '<em><b>Cycle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCE__CYCLE = eINSTANCE.getSequence_Cycle();

		/**
		 * The meta object literal for the '{@link uk.ac.bham.mongoMap.model.sql.impl.RowImpl <em>Row</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.bham.mongoMap.model.sql.impl.RowImpl
		 * @see uk.ac.bham.mongoMap.model.sql.impl.SqlPackageImpl#getRow()
		 * @generated
		 */
		EClass ROW = eINSTANCE.getRow();

		/**
		 * The meta object literal for the '<em><b>Cells</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROW__CELLS = eINSTANCE.getRow_Cells();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROW__CONSTRAINTS = eINSTANCE.getRow_Constraints();

		/**
		 * The meta object literal for the '{@link uk.ac.bham.mongoMap.model.sql.impl.CellImpl <em>Cell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.bham.mongoMap.model.sql.impl.CellImpl
		 * @see uk.ac.bham.mongoMap.model.sql.impl.SqlPackageImpl#getCell()
		 * @generated
		 */
		EClass CELL = eINSTANCE.getCell();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CELL__VALUE = eINSTANCE.getCell_Value();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CELL__COLUMN = eINSTANCE.getCell_Column();

		/**
		 * The meta object literal for the '{@link uk.ac.bham.mongoMap.model.sql.Datatye <em>Datatye</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.bham.mongoMap.model.sql.Datatye
		 * @see uk.ac.bham.mongoMap.model.sql.impl.SqlPackageImpl#getDatatye()
		 * @generated
		 */
		EEnum DATATYE = eINSTANCE.getDatatye();

		/**
		 * The meta object literal for the '{@link uk.ac.bham.mongoMap.model.sql.ConstraintType <em>Constraint Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uk.ac.bham.mongoMap.model.sql.ConstraintType
		 * @see uk.ac.bham.mongoMap.model.sql.impl.SqlPackageImpl#getConstraintType()
		 * @generated
		 */
		EEnum CONSTRAINT_TYPE = eINSTANCE.getConstraintType();

	}

} //SqlPackage
