/**
 */
package metamodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Type Constraint</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see metamodel.MetamodelPackage#getTypeConstraint()
 * @model
 * @generated
 */
public enum TypeConstraint implements Enumerator {
	/**
	 * The '<em><b>Primary Key</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRIMARY_KEY_VALUE
	 * @generated
	 * @ordered
	 */
	PRIMARY_KEY(1, "PrimaryKey", "PrimaryKey"),

	/**
	 * The '<em><b>Foreign Key</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOREIGN_KEY_VALUE
	 * @generated
	 * @ordered
	 */
	FOREIGN_KEY(2, "ForeignKey", "ForeignKey"),

	/**
	 * The '<em><b>Unique</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNIQUE_VALUE
	 * @generated
	 * @ordered
	 */
	UNIQUE(3, "Unique", "Unique"),

	/**
	 * The '<em><b>Composite Primary Key</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPOSITE_PRIMARY_KEY_VALUE
	 * @generated
	 * @ordered
	 */
	COMPOSITE_PRIMARY_KEY(4, "CompositePrimaryKey", "CompositePrimaryKey");

	/**
	 * The '<em><b>Primary Key</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Primary Key</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRIMARY_KEY
	 * @model name="PrimaryKey"
	 * @generated
	 * @ordered
	 */
	public static final int PRIMARY_KEY_VALUE = 1;

	/**
	 * The '<em><b>Foreign Key</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Foreign Key</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FOREIGN_KEY
	 * @model name="ForeignKey"
	 * @generated
	 * @ordered
	 */
	public static final int FOREIGN_KEY_VALUE = 2;

	/**
	 * The '<em><b>Unique</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unique</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNIQUE
	 * @model name="Unique"
	 * @generated
	 * @ordered
	 */
	public static final int UNIQUE_VALUE = 3;

	/**
	 * The '<em><b>Composite Primary Key</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Composite Primary Key</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPOSITE_PRIMARY_KEY
	 * @model name="CompositePrimaryKey"
	 * @generated
	 * @ordered
	 */
	public static final int COMPOSITE_PRIMARY_KEY_VALUE = 4;

	/**
	 * An array of all the '<em><b>Type Constraint</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TypeConstraint[] VALUES_ARRAY =
		new TypeConstraint[] {
			PRIMARY_KEY,
			FOREIGN_KEY,
			UNIQUE,
			COMPOSITE_PRIMARY_KEY,
		};

	/**
	 * A public read-only list of all the '<em><b>Type Constraint</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TypeConstraint> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Type Constraint</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TypeConstraint get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TypeConstraint result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type Constraint</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TypeConstraint getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TypeConstraint result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type Constraint</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TypeConstraint get(int value) {
		switch (value) {
			case PRIMARY_KEY_VALUE: return PRIMARY_KEY;
			case FOREIGN_KEY_VALUE: return FOREIGN_KEY;
			case UNIQUE_VALUE: return UNIQUE;
			case COMPOSITE_PRIMARY_KEY_VALUE: return COMPOSITE_PRIMARY_KEY;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TypeConstraint(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //TypeConstraint
