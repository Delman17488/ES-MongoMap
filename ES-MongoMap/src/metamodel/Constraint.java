/**
 */
package metamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link metamodel.Constraint#getName <em>Name</em>}</li>
 *   <li>{@link metamodel.Constraint#getType <em>Type</em>}</li>
 *   <li>{@link metamodel.Constraint#getRefTable <em>Ref Table</em>}</li>
 * </ul>
 * </p>
 *
 * @see metamodel.MetamodelPackage#getConstraint()
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
	 * @see metamodel.MetamodelPackage#getConstraint_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link metamodel.Constraint#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link metamodel.TypeConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see metamodel.TypeConstraint
	 * @see #setType(TypeConstraint)
	 * @see metamodel.MetamodelPackage#getConstraint_Type()
	 * @model
	 * @generated
	 */
	TypeConstraint getType();

	/**
	 * Sets the value of the '{@link metamodel.Constraint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see metamodel.TypeConstraint
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeConstraint value);

	/**
	 * Returns the value of the '<em><b>Ref Table</b></em>' containment reference list.
	 * The list contents are of type {@link metamodel.Column}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Table</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Table</em>' containment reference list.
	 * @see metamodel.MetamodelPackage#getConstraint_RefTable()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Column> getRefTable();

} // Constraint
