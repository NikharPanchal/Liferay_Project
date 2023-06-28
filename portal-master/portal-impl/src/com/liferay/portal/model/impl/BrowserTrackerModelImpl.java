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

package com.liferay.portal.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BrowserTracker;
import com.liferay.portal.kernel.model.BrowserTrackerModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the BrowserTracker service. Represents a row in the &quot;BrowserTracker&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>BrowserTrackerModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BrowserTrackerImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BrowserTrackerImpl
 * @generated
 */
public class BrowserTrackerModelImpl
	extends BaseModelImpl<BrowserTracker> implements BrowserTrackerModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a browser tracker model instance should use the <code>BrowserTracker</code> interface instead.
	 */
	public static final String TABLE_NAME = "BrowserTracker";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"browserTrackerId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"browserKey", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("browserTrackerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("browserKey", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table BrowserTracker (mvccVersion LONG default 0 not null,browserTrackerId LONG not null primary key,companyId LONG,userId LONG,browserKey LONG)";

	public static final String TABLE_SQL_DROP = "drop table BrowserTracker";

	public static final String ORDER_BY_JPQL =
		" ORDER BY browserTracker.browserTrackerId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY BrowserTracker.browserTrackerId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean ENTITY_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean FINDER_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean COLUMN_BITMASK_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long BROWSERTRACKERID_COLUMN_BITMASK = 2L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.portal.kernel.model.BrowserTracker"));

	public BrowserTrackerModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _browserTrackerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBrowserTrackerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _browserTrackerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return BrowserTracker.class;
	}

	@Override
	public String getModelClassName() {
		return BrowserTracker.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<BrowserTracker, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<BrowserTracker, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BrowserTracker, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((BrowserTracker)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<BrowserTracker, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<BrowserTracker, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(BrowserTracker)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<BrowserTracker, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<BrowserTracker, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<BrowserTracker, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<BrowserTracker, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<BrowserTracker, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<BrowserTracker, Object>>();
		Map<String, BiConsumer<BrowserTracker, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<BrowserTracker, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", BrowserTracker::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<BrowserTracker, Long>)BrowserTracker::setMvccVersion);
		attributeGetterFunctions.put(
			"browserTrackerId", BrowserTracker::getBrowserTrackerId);
		attributeSetterBiConsumers.put(
			"browserTrackerId",
			(BiConsumer<BrowserTracker, Long>)
				BrowserTracker::setBrowserTrackerId);
		attributeGetterFunctions.put("companyId", BrowserTracker::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<BrowserTracker, Long>)BrowserTracker::setCompanyId);
		attributeGetterFunctions.put("userId", BrowserTracker::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<BrowserTracker, Long>)BrowserTracker::setUserId);
		attributeGetterFunctions.put(
			"browserKey", BrowserTracker::getBrowserKey);
		attributeSetterBiConsumers.put(
			"browserKey",
			(BiConsumer<BrowserTracker, Long>)BrowserTracker::setBrowserKey);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

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

	@Override
	public long getBrowserTrackerId() {
		return _browserTrackerId;
	}

	@Override
	public void setBrowserTrackerId(long browserTrackerId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_browserTrackerId = browserTrackerId;
	}

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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalUserId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("userId"));
	}

	@Override
	public long getBrowserKey() {
		return _browserKey;
	}

	@Override
	public void setBrowserKey(long browserKey) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_browserKey = browserKey;
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
			getCompanyId(), BrowserTracker.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BrowserTracker toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, BrowserTracker>
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
		BrowserTrackerImpl browserTrackerImpl = new BrowserTrackerImpl();

		browserTrackerImpl.setMvccVersion(getMvccVersion());
		browserTrackerImpl.setBrowserTrackerId(getBrowserTrackerId());
		browserTrackerImpl.setCompanyId(getCompanyId());
		browserTrackerImpl.setUserId(getUserId());
		browserTrackerImpl.setBrowserKey(getBrowserKey());

		browserTrackerImpl.resetOriginalValues();

		return browserTrackerImpl;
	}

	@Override
	public BrowserTracker cloneWithOriginalValues() {
		BrowserTrackerImpl browserTrackerImpl = new BrowserTrackerImpl();

		browserTrackerImpl.setMvccVersion(
			this.<Long>getColumnOriginalValue("mvccVersion"));
		browserTrackerImpl.setBrowserTrackerId(
			this.<Long>getColumnOriginalValue("browserTrackerId"));
		browserTrackerImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		browserTrackerImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		browserTrackerImpl.setBrowserKey(
			this.<Long>getColumnOriginalValue("browserKey"));

		return browserTrackerImpl;
	}

	@Override
	public int compareTo(BrowserTracker browserTracker) {
		long primaryKey = browserTracker.getPrimaryKey();

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

		if (!(object instanceof BrowserTracker)) {
			return false;
		}

		BrowserTracker browserTracker = (BrowserTracker)object;

		long primaryKey = browserTracker.getPrimaryKey();

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
		return ENTITY_CACHE_ENABLED;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<BrowserTracker> toCacheModel() {
		BrowserTrackerCacheModel browserTrackerCacheModel =
			new BrowserTrackerCacheModel();

		browserTrackerCacheModel.mvccVersion = getMvccVersion();

		browserTrackerCacheModel.browserTrackerId = getBrowserTrackerId();

		browserTrackerCacheModel.companyId = getCompanyId();

		browserTrackerCacheModel.userId = getUserId();

		browserTrackerCacheModel.browserKey = getBrowserKey();

		return browserTrackerCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<BrowserTracker, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<BrowserTracker, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BrowserTracker, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((BrowserTracker)this);

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
		Map<String, Function<BrowserTracker, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<BrowserTracker, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BrowserTracker, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((BrowserTracker)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, BrowserTracker>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					BrowserTracker.class, ModelWrapper.class);

	}

	private long _mvccVersion;
	private long _browserTrackerId;
	private long _companyId;
	private long _userId;
	private long _browserKey;

	public <T> T getColumnValue(String columnName) {
		Function<BrowserTracker, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((BrowserTracker)this);
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
		_columnOriginalValues.put("browserTrackerId", _browserTrackerId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("browserKey", _browserKey);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("mvccVersion", 1L);

		columnBitmasks.put("browserTrackerId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("browserKey", 16L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private BrowserTracker _escapedModel;

}