/**
 */
package metamodel.impl;

import metamodel.Column;
import metamodel.ColumnType;
import metamodel.MetamodelPackage;
import metamodel.Sequence;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link metamodel.impl.ColumnImpl#getName <em>Name</em>}</li>
 *   <li>{@link metamodel.impl.ColumnImpl#getType <em>Type</em>}</li>
 *   <li>{@link metamodel.impl.ColumnImpl#isNullable <em>Nullable</em>}</li>
 *   <li>{@link metamodel.impl.ColumnImpl#getSequenceColumn <em>Sequence Column</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColumnImpl extends MinimalEObjectImpl.Container implements Column {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ColumnType TYPE_EDEFAULT = ColumnType.INT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ColumnType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NULLABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullable()
	 * @generated
	 * @ordered
	 */
	protected boolean nullable = NULLABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSequenceColumn() <em>Sequence Column</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceColumn()
	 * @generated
	 * @ordered
	 */
	protected Sequence sequenceColumn;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.COLUMN;
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
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.COLUMN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColumnType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ColumnType newType) {
		ColumnType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.COLUMN__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNullable() {
		return nullable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNullable(boolean newNullable) {
		boolean oldNullable = nullable;
		nullable = newNullable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.COLUMN__NULLABLE, oldNullable, nullable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sequence getSequenceColumn() {
		return sequenceColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSequenceColumn(Sequence newSequenceColumn, NotificationChain msgs) {
		Sequence oldSequenceColumn = sequenceColumn;
		sequenceColumn = newSequenceColumn;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetamodelPackage.COLUMN__SEQUENCE_COLUMN, oldSequenceColumn, newSequenceColumn);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceColumn(Sequence newSequenceColumn) {
		if (newSequenceColumn != sequenceColumn) {
			NotificationChain msgs = null;
			if (sequenceColumn != null)
				msgs = ((InternalEObject)sequenceColumn).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.COLUMN__SEQUENCE_COLUMN, null, msgs);
			if (newSequenceColumn != null)
				msgs = ((InternalEObject)newSequenceColumn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.COLUMN__SEQUENCE_COLUMN, null, msgs);
			msgs = basicSetSequenceColumn(newSequenceColumn, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.COLUMN__SEQUENCE_COLUMN, newSequenceColumn, newSequenceColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.COLUMN__SEQUENCE_COLUMN:
				return basicSetSequenceColumn(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.COLUMN__NAME:
				return getName();
			case MetamodelPackage.COLUMN__TYPE:
				return getType();
			case MetamodelPackage.COLUMN__NULLABLE:
				return isNullable();
			case MetamodelPackage.COLUMN__SEQUENCE_COLUMN:
				return getSequenceColumn();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetamodelPackage.COLUMN__NAME:
				setName((String)newValue);
				return;
			case MetamodelPackage.COLUMN__TYPE:
				setType((ColumnType)newValue);
				return;
			case MetamodelPackage.COLUMN__NULLABLE:
				setNullable((Boolean)newValue);
				return;
			case MetamodelPackage.COLUMN__SEQUENCE_COLUMN:
				setSequenceColumn((Sequence)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MetamodelPackage.COLUMN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MetamodelPackage.COLUMN__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case MetamodelPackage.COLUMN__NULLABLE:
				setNullable(NULLABLE_EDEFAULT);
				return;
			case MetamodelPackage.COLUMN__SEQUENCE_COLUMN:
				setSequenceColumn((Sequence)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetamodelPackage.COLUMN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MetamodelPackage.COLUMN__TYPE:
				return type != TYPE_EDEFAULT;
			case MetamodelPackage.COLUMN__NULLABLE:
				return nullable != NULLABLE_EDEFAULT;
			case MetamodelPackage.COLUMN__SEQUENCE_COLUMN:
				return sequenceColumn != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", type: ");
		result.append(type);
		result.append(", nullable: ");
		result.append(nullable);
		result.append(')');
		return result.toString();
	}

} //ColumnImpl
