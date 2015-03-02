/**
 */
package uk.ac.bham.mongoMap.model.sql;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uk.ac.bham.mongoMap.model.sql.Table#getName <em>Name</em>}</li>
 *   <li>{@link uk.ac.bham.mongoMap.model.sql.Table#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link uk.ac.bham.mongoMap.model.sql.Table#getColumns <em>Columns</em>}</li>
 *   <li>{@link uk.ac.bham.mongoMap.model.sql.Table#getRows <em>Rows</em>}</li>
 * </ul>
 * </p>
 *
 * @see uk.ac.bham.mongoMap.model.sql.sqlPackage#getTable()
 * @model
 * @generated
 */
public interface Table extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see uk.ac.bham.mongoMap.model.sql.sqlPackage#getTable_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link uk.ac.bham.mongoMap.model.sql.Table#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link uk.ac.bham.mongoMap.model.sql.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see uk.ac.bham.mongoMap.model.sql.sqlPackage#getTable_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<Constraint> getConstraints();

	/**
	 * Returns the value of the '<em><b>Columns</b></em>' containment reference list.
	 * The list contents are of type {@link uk.ac.bham.mongoMap.model.sql.Column}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' containment reference list.
	 * @see uk.ac.bham.mongoMap.model.sql.sqlPackage#getTable_Columns()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Column> getColumns();

	/**
	 * Returns the value of the '<em><b>Rows</b></em>' reference list.
	 * The list contents are of type {@link uk.ac.bham.mongoMap.model.sql.Row}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rows</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rows</em>' reference list.
	 * @see uk.ac.bham.mongoMap.model.sql.sqlPackage#getTable_Rows()
	 * @model
	 * @generated
	 */
	EList<Row> getRows();

} // Table
