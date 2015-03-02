/**
 */
package uk.ac.bham.mongoMap.model.metamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uk.ac.bham.mongoMap.model.metamodel.Column#getName <em>Name</em>}</li>
 *   <li>{@link uk.ac.bham.mongoMap.model.metamodel.Column#getType <em>Type</em>}</li>
 *   <li>{@link uk.ac.bham.mongoMap.model.metamodel.Column#isNullable <em>Nullable</em>}</li>
 *   <li>{@link uk.ac.bham.mongoMap.model.metamodel.Column#getSize <em>Size</em>}</li>
 *   <li>{@link uk.ac.bham.mongoMap.model.metamodel.Column#getConstraint <em>Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @see uk.ac.bham.mongoMap.model.metamodel.sqlPackage#getColumn()
 * @model
 * @generated
 */
public interface Column extends EObject {
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
	 * @see uk.ac.bham.mongoMap.model.metamodel.sqlPackage#getColumn_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link uk.ac.bham.mongoMap.model.metamodel.Column#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link uk.ac.bham.mongoMap.model.metamodel.Datatye}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see uk.ac.bham.mongoMap.model.metamodel.Datatye
	 * @see #setType(Datatye)
	 * @see uk.ac.bham.mongoMap.model.metamodel.sqlPackage#getColumn_Type()
	 * @model
	 * @generated
	 */
	Datatye getType();

	/**
	 * Sets the value of the '{@link uk.ac.bham.mongoMap.model.metamodel.Column#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see uk.ac.bham.mongoMap.model.metamodel.Datatye
	 * @see #getType()
	 * @generated
	 */
	void setType(Datatye value);

	/**
	 * Returns the value of the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nullable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nullable</em>' attribute.
	 * @see #setNullable(boolean)
	 * @see uk.ac.bham.mongoMap.model.metamodel.sqlPackage#getColumn_Nullable()
	 * @model
	 * @generated
	 */
	boolean isNullable();

	/**
	 * Sets the value of the '{@link uk.ac.bham.mongoMap.model.metamodel.Column#isNullable <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nullable</em>' attribute.
	 * @see #isNullable()
	 * @generated
	 */
	void setNullable(boolean value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(String)
	 * @see uk.ac.bham.mongoMap.model.metamodel.sqlPackage#getColumn_Size()
	 * @model
	 * @generated
	 */
	String getSize();

	/**
	 * Sets the value of the '{@link uk.ac.bham.mongoMap.model.metamodel.Column#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(String value);

	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link uk.ac.bham.mongoMap.model.metamodel.Constraint#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' reference.
	 * @see #setConstraint(Constraint)
	 * @see uk.ac.bham.mongoMap.model.metamodel.sqlPackage#getColumn_Constraint()
	 * @see uk.ac.bham.mongoMap.model.metamodel.Constraint#getColumn
	 * @model opposite="column"
	 * @generated
	 */
	Constraint getConstraint();

	/**
	 * Sets the value of the '{@link uk.ac.bham.mongoMap.model.metamodel.Column#getConstraint <em>Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint</em>' reference.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(Constraint value);

} // Column
