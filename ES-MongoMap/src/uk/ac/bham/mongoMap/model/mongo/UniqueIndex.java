/**
 */
package uk.ac.bham.mongoMap.model.mongo;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unique Index</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.bham.mongoMap.model.mongo.UniqueIndex#getKeys <em>Keys</em>}</li>
 * </ul>
 *
 * @see uk.ac.bham.mongoMap.model.mongo.MongoPackage#getUniqueIndex()
 * @model
 * @generated
 */
public interface UniqueIndex extends EObject {
	/**
	 * Returns the value of the '<em><b>Keys</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keys</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keys</em>' attribute list.
	 * @see uk.ac.bham.mongoMap.model.mongo.MongoPackage#getUniqueIndex_Keys()
	 * @model
	 * @generated
	 */
	EList<String> getKeys();

} // UniqueIndex
