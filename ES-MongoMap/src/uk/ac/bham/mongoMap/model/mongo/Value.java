/**
 */
package uk.ac.bham.mongoMap.model.mongo;

import uk.ac.bham.mongoMap.model.sql.Datatye;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.bham.mongoMap.model.mongo.Value#getType <em>Type</em>}</li>
 *   <li>{@link uk.ac.bham.mongoMap.model.mongo.Value#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see uk.ac.bham.mongoMap.model.mongo.MongoPackage#getValue()
 * @model
 * @generated
 */
public interface Value extends MongoObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link uk.ac.bham.mongoMap.model.sql.Datatye}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see uk.ac.bham.mongoMap.model.sql.Datatye
	 * @see #setType(Datatye)
	 * @see uk.ac.bham.mongoMap.model.mongo.MongoPackage#getValue_Type()
	 * @model
	 * @generated
	 */
	Datatye getType();

	/**
	 * Sets the value of the '{@link uk.ac.bham.mongoMap.model.mongo.Value#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see uk.ac.bham.mongoMap.model.sql.Datatye
	 * @see #getType()
	 * @generated
	 */
	void setType(Datatye value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see uk.ac.bham.mongoMap.model.mongo.MongoPackage#getValue_Value()
	 * @model
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link uk.ac.bham.mongoMap.model.mongo.Value#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

} // Value
