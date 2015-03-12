/**
 */
package uk.ac.bham.mongoMap.model.mongo;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uk.ac.bham.mongoMap.model.mongo.MongoObject#isDoc <em>Doc</em>}</li>
 * </ul>
 * </p>
 *
 * @see uk.ac.bham.mongoMap.model.mongo.MongoPackage#getMongoObject()
 * @model
 * @generated
 */
public interface MongoObject extends EObject {

	/**
	 * Returns the value of the '<em><b>Doc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Doc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Doc</em>' attribute.
	 * @see #setDoc(boolean)
	 * @see uk.ac.bham.mongoMap.model.mongo.MongoPackage#getMongoObject_Doc()
	 * @model
	 * @generated
	 */
	boolean isDoc();

	/**
	 * Sets the value of the '{@link uk.ac.bham.mongoMap.model.mongo.MongoObject#isDoc <em>Doc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Doc</em>' attribute.
	 * @see #isDoc()
	 * @generated
	 */
	void setDoc(boolean value);
} // MongoObject
