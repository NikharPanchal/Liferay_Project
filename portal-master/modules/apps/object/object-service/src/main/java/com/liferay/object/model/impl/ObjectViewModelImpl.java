/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.object.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.object.model.ObjectView;
import com.liferay.object.model.ObjectViewModel;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the ObjectView service. Represents a row in the &quot;ObjectView&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ObjectViewModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ObjectViewImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see ObjectViewImpl
 * @generated
 */
@JSON(strict = true)
public class ObjectViewModelImpl
	extends BaseModelImpl<ObjectView> implements ObjectViewModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a object view model instance should use the <code>ObjectView</code> interface instead.
	 */
	public static final String TABLE_NAME = "ObjectView";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"objectViewId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"objectDefinitionId", Types.BIGINT},
		{"defaultObjectView", Types.BOOLEAN}, {"name", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("objectViewId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("objectDefinitionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("defaultObjectView", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ObjectView (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,objectViewId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,objectDefinitionId LONG,defaultObjectView BOOLEAN,name STRING null)";

	public static final String TABLE_SQL_DROP = "drop table ObjectView";

	public static final String ORDER_BY_JPQL =
		" ORDER BY objectView.objectViewId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ObjectView.objectViewId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DEFAULTOBJECTVIEW_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long OBJECTDEFINITIONID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long OBJECTVIEWID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public ObjectViewModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _objectViewId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setObjectViewId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _objectViewId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ObjectView.class;
	}

	@Override
	public String getModelClassName() {
		return ObjectView.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ObjectView, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ObjectView, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ObjectView, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((ObjectView)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ObjectView, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ObjectView, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ObjectView)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ObjectView, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ObjectView, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<ObjectView, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ObjectView, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ObjectView, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<ObjectView, Object>>();
		Map<String, BiConsumer<ObjectView, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ObjectView, ?>>();

		attributeGetterFunctions.put("mvccVersion", ObjectView::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<ObjectView, Long>)ObjectView::setMvccVersion);
		attributeGetterFunctions.put("uuid", ObjectView::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<ObjectView, String>)ObjectView::setUuid);
		attributeGetterFunctions.put(
			"objectViewId", ObjectView::getObjectViewId);
		attributeSetterBiConsumers.put(
			"objectViewId",
			(BiConsumer<ObjectView, Long>)ObjectView::setObjectViewId);
		attributeGetterFunctions.put("companyId", ObjectView::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ObjectView, Long>)ObjectView::setCompanyId);
		attributeGetterFunctions.put("userId", ObjectView::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<ObjectView, Long>)ObjectView::setUserId);
		attributeGetterFunctions.put("userName", ObjectView::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<ObjectView, String>)ObjectView::setUserName);
		attributeGetterFunctions.put("createDate", ObjectView::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ObjectView, Date>)ObjectView::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", ObjectView::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ObjectView, Date>)ObjectView::setModifiedDate);
		attributeGetterFunctions.put(
			"objectDefinitionId", ObjectView::getObjectDefinitionId);
		attributeSetterBiConsumers.put(
			"objectDefinitionId",
			(BiConsumer<ObjectView, Long>)ObjectView::setObjectDefinitionId);
		attributeGetterFunctions.put(
			"defaultObjectView", ObjectView::getDefaultObjectView);
		attributeSetterBiConsumers.put(
			"defaultObjectView",
			(BiConsumer<ObjectView, Boolean>)ObjectView::setDefaultObjectView);
		attributeGetterFunctions.put("name", ObjectView::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<ObjectView, String>)ObjectView::setName);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mvccVersion = mvccVersion;
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getObjectViewId() {
		return _objectViewId;
	}

	@Override
	public void setObjectViewId(long objectViewId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_objectViewId = objectViewId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getObjectDefinitionId() {
		return _objectDefinitionId;
	}

	@Override
	public void setObjectDefinitionId(long objectDefinitionId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_objectDefinitionId = objectDefinitionId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalObjectDefinitionId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("objectDefinitionId"));
	}

	@JSON
	@Override
	public boolean getDefaultObjectView() {
		return _defaultObjectView;
	}

	@JSON
	@Override
	public boolean isDefaultObjectView() {
		return _defaultObjectView;
	}

	@Override
	public void setDefaultObjectView(boolean defaultObjectView) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_defaultObjectView = defaultObjectView;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalDefaultObjectView() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("defaultObjectView"));
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId);
	}

	@Override
	public String getName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId, useDefault);
	}

	@Override
	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(), languageId);
	}

	@Override
	public String getName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getName(), languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	@JSON
	@Override
	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	@Override
	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	@Override
	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setName(String name, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(
				LocalizationUtil.updateLocalization(
					getName(), "Name", name, languageId, defaultLanguageId));
		}
		else {
			setName(
				LocalizationUtil.removeLocalization(
					getName(), "Name", languageId));
		}
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap) {
		setNameMap(nameMap, LocaleUtil.getDefault());
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
		if (nameMap == null) {
			return;
		}

		setName(
			LocalizationUtil.updateLocalization(
				nameMap, getName(), "Name",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(ObjectView.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), ObjectView.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> nameMap = getNameMap();

		for (Map.Entry<Locale, String> entry : nameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(
			new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getName();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(
			getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(
			getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(
			ObjectView.class.getName(), getPrimaryKey(), defaultLocale,
			availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String name = getName(defaultLocale);

		if (Validator.isNull(name)) {
			setName(getName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setName(getName(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public ObjectView toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ObjectView>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ObjectViewImpl objectViewImpl = new ObjectViewImpl();

		objectViewImpl.setMvccVersion(getMvccVersion());
		objectViewImpl.setUuid(getUuid());
		objectViewImpl.setObjectViewId(getObjectViewId());
		objectViewImpl.setCompanyId(getCompanyId());
		objectViewImpl.setUserId(getUserId());
		objectViewImpl.setUserName(getUserName());
		objectViewImpl.setCreateDate(getCreateDate());
		objectViewImpl.setModifiedDate(getModifiedDate());
		objectViewImpl.setObjectDefinitionId(getObjectDefinitionId());
		objectViewImpl.setDefaultObjectView(isDefaultObjectView());
		objectViewImpl.setName(getName());

		objectViewImpl.resetOriginalValues();

		return objectViewImpl;
	}

	@Override
	public ObjectView cloneWithOriginalValues() {
		ObjectViewImpl objectViewImpl = new ObjectViewImpl();

		objectViewImpl.setMvccVersion(
			this.<Long>getColumnOriginalValue("mvccVersion"));
		objectViewImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		objectViewImpl.setObjectViewId(
			this.<Long>getColumnOriginalValue("objectViewId"));
		objectViewImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		objectViewImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		objectViewImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		objectViewImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		objectViewImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		objectViewImpl.setObjectDefinitionId(
			this.<Long>getColumnOriginalValue("objectDefinitionId"));
		objectViewImpl.setDefaultObjectView(
			this.<Boolean>getColumnOriginalValue("defaultObjectView"));
		objectViewImpl.setName(this.<String>getColumnOriginalValue("name"));

		return objectViewImpl;
	}

	@Override
	public int compareTo(ObjectView objectView) {
		long primaryKey = objectView.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ObjectView)) {
			return false;
		}

		ObjectView objectView = (ObjectView)object;

		long primaryKey = objectView.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<ObjectView> toCacheModel() {
		ObjectViewCacheModel objectViewCacheModel = new ObjectViewCacheModel();

		objectViewCacheModel.mvccVersion = getMvccVersion();

		objectViewCacheModel.uuid = getUuid();

		String uuid = objectViewCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			objectViewCacheModel.uuid = null;
		}

		objectViewCacheModel.objectViewId = getObjectViewId();

		objectViewCacheModel.companyId = getCompanyId();

		objectViewCacheModel.userId = getUserId();

		objectViewCacheModel.userName = getUserName();

		String userName = objectViewCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			objectViewCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			objectViewCacheModel.createDate = createDate.getTime();
		}
		else {
			objectViewCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			objectViewCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			objectViewCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		objectViewCacheModel.objectDefinitionId = getObjectDefinitionId();

		objectViewCacheModel.defaultObjectView = isDefaultObjectView();

		objectViewCacheModel.name = getName();

		String name = objectViewCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			objectViewCacheModel.name = null;
		}

		return objectViewCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ObjectView, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ObjectView, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ObjectView, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((ObjectView)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<ObjectView, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ObjectView, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ObjectView, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ObjectView)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ObjectView>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					ObjectView.class, ModelWrapper.class);

	}

	private long _mvccVersion;
	private String _uuid;
	private long _objectViewId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _objectDefinitionId;
	private boolean _defaultObjectView;
	private String _name;
	private String _nameCurrentLanguageId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ObjectView, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ObjectView)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("mvccVersion", _mvccVersion);
		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("objectViewId", _objectViewId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("objectDefinitionId", _objectDefinitionId);
		_columnOriginalValues.put("defaultObjectView", _defaultObjectView);
		_columnOriginalValues.put("name", _name);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("mvccVersion", 1L);

		columnBitmasks.put("uuid_", 2L);

		columnBitmasks.put("objectViewId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("objectDefinitionId", 256L);

		columnBitmasks.put("defaultObjectView", 512L);

		columnBitmasks.put("name", 1024L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ObjectView _escapedModel;

}