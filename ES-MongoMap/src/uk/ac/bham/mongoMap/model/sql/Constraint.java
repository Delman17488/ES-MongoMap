/**
 */
package uk.ac.bham.mongoMap.model.sql;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.bham.mongoMap.model.sql.Constraint#getName <em>Name</em>}</li>
 *   <li>{@link uk.ac.bham.mongoMap.model.sql.Constraint#getType <em>Type</em>}</li>
 *   <li>{@link uk.ac.bham.mongoMap.model.sql.Constraint#getReference <em>Reference</em>}</li>
 *   <li>{@link uk.ac.bham.mongoMap.model.sql.Constraint#getColumn <em>Column</em>}</li>
 * </ul>
 *
 * @see uk.ac.bham.mongoMap.model.sql.SqlPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends EObject {
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
	 * @see uk.ac.bham.mongoMap.model.sql.SqlPackage#getConstraint_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link uk.ac.bham.mongoMap.model.sql.Constraint#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link uk.ac.bham.mongoMap.model.sql.ConstraintType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see uk.ac.bham.mongoMap.model.sql.ConstraintType
	 * @see #setType(ConstraintType)
	 * @see uk.ac.bham.mongoMap.model.sql.SqlPackage#getConstraint_Type()
	 * @model
	 * @generated
	 */
	ConstraintType getType();

	/**
	 * Sets the value of the '{@link uk.ac.bham.mongoMap.model.sql.Constraint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see uk.ac.bham.mongoMap.model.sql.ConstraintType
	 * @see #getType()
	 * @generated
	 */
	void setType(ConstraintType value);

	/**
	 * Returns the value of the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' attribute.
	 * @see #setReference(String)
	 * @see uk.ac.bham.mongoMap.model.sql.SqlPackage#getConstraint_Reference()
	 * @model id="true"
	 * @generated
	 */
	String getReference();

	/**
	 * Sets the value of the '{@link uk.ac.bham.mongoMap.model.sql.Constraint#getReference <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' attribute.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(String value);

	/**
	 * Returns the value of the '<em><b>Column</b></em>' reference list.
	 * The list contents are of type {@link uk.ac.bham.mongoMap.model.sql.Column}.
	 * It is bidirectional and its opposite is '{@link uk.ac.bham.mongoMap.model.sql.Column#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' reference list.
	 * @see uk.ac.bham.mongoMap.model.sql.SqlPackage#getConstraint_Column()
	 * @see uk.ac.bham.mongoMap.model.sql.Column#getConstraint
	 * @model opposite="constraint" required="true"
	 * @generated
	 */
	EList<Column> getColumn();

} // Constraint
