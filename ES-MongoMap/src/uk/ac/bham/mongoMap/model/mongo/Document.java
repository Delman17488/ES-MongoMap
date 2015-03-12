/**
 */
package uk.ac.bham.mongoMap.model.mongo;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.bham.mongoMap.model.mongo.Document#getKeys <em>Keys</em>}</li>
 *   <li>{@link uk.ac.bham.mongoMap.model.mongo.Document#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see uk.ac.bham.mongoMap.model.mongo.MongoPackage#getDocument()
 * @model
 * @generated
 */
public interface Document extends MongoObject {
	/**
	 * Returns the value of the '<em><b>Keys</b></em>' containment reference list.
	 * The list contents are of type {@link uk.ac.bham.mongoMap.model.mongo.Key}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keys</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keys</em>' containment reference list.
	 * @see uk.ac.bham.mongoMap.model.mongo.MongoPackage#getDocument_Keys()
	 * @model containment="true"
	 * @generated
	 */
	EList<Key> getKeys();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' containment reference.
	 * @see #setId(Id)
	 * @see uk.ac.bham.mongoMap.model.mongo.MongoPackage#getDocument_Id()
	 * @model containment="true"
	 * @generated
	 */
	Id getId();

	/**
	 * Sets the value of the '{@link uk.ac.bham.mongoMap.model.mongo.Document#getId <em>Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' containment reference.
	 * @see #getId()
	 * @generated
	 */
	void setId(Id value);

} // Document
