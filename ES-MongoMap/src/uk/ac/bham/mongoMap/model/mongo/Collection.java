/**
 */
package uk.ac.bham.mongoMap.model.mongo;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.bham.mongoMap.model.mongo.Collection#getDocuments <em>Documents</em>}</li>
 *   <li>{@link uk.ac.bham.mongoMap.model.mongo.Collection#getUniqueIndices <em>Unique Indices</em>}</li>
 *   <li>{@link uk.ac.bham.mongoMap.model.mongo.Collection#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see uk.ac.bham.mongoMap.model.mongo.MongoPackage#getCollection()
 * @model
 * @generated
 */
public interface Collection extends EObject {
	/**
	 * Returns the value of the '<em><b>Documents</b></em>' containment reference list.
	 * The list contents are of type {@link uk.ac.bham.mongoMap.model.mongo.Document}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Documents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Documents</em>' containment reference list.
	 * @see uk.ac.bham.mongoMap.model.mongo.MongoPackage#getCollection_Documents()
	 * @model containment="true"
	 * @generated
	 */
	EList<Document> getDocuments();

	/**
	 * Returns the value of the '<em><b>Unique Indices</b></em>' containment reference list.
	 * The list contents are of type {@link uk.ac.bham.mongoMap.model.mongo.UniqueIndex}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unique Indices</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique Indices</em>' containment reference list.
	 * @see uk.ac.bham.mongoMap.model.mongo.MongoPackage#getCollection_UniqueIndices()
	 * @model containment="true"
	 * @generated
	 */
	EList<UniqueIndex> getUniqueIndices();

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
	 * @see uk.ac.bham.mongoMap.model.mongo.MongoPackage#getCollection_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link uk.ac.bham.mongoMap.model.mongo.Collection#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Collection
