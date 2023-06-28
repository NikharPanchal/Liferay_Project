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

package com.liferay.commerce.term.model.impl;

import com.liferay.commerce.term.model.CTermEntryLocalization;
import com.liferay.commerce.term.model.CTermEntryLocalizationModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
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
 * The base model implementation for the CTermEntryLocalization service. Represents a row in the &quot;CTermEntryLocalization&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CTermEntryLocalizationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CTermEntryLocalizationImpl}.
 * </p>
 *
 * @author Luca Pellizzon
 * @see CTermEntryLocalizationImpl
 * @generated
 */
public class CTermEntryLocalizationModelImpl
	extends BaseModelImpl<CTermEntryLocalization>
	implements CTermEntryLocalizationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a c term entry localization model instance should use the <code>CTermEntryLocalization</code> interface instead.
	 */
	public static final String TABLE_NAME = "CTermEntryLocalization";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT},
		{"cTermEntryLocalizationId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"commerceTermEntryId", Types.BIGINT}, {"languageId", Types.VARCHAR},
		{"description", Types.CLOB}, {"label", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("cTermEntryLocalizationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("commerceTermEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("languageId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.CLOB);
		TABLE_COLUMNS_MAP.put("label", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CTermEntryLocalization (mvccVersion LONG default 0 not null,cTermEntryLocalizationId LONG not null primary key,companyId LONG,commerceTermEntryId LONG,languageId VARCHAR(75) null,description TEXT null,label VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table CTermEntryLocalization";

	public static final String ORDER_BY_JPQL =
		" ORDER BY cTermEntryLocalization.cTermEntryLocalizationId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CTermEntryLocalization.cTermEntryLocalizationId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMMERCETERMENTRYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long LANGUAGEID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CTERMENTRYLOCALIZATIONID_COLUMN_BITMASK = 4L;

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

	public CTermEntryLocalizationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _cTermEntryLocalizationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCTermEntryLocalizationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cTermEntryLocalizationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CTermEntryLocalization.class;
	}

	@Override
	public String getModelClassName() {
		return CTermEntryLocalization.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CTermEntryLocalization, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CTermEntryLocalization, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CTermEntryLocalization, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CTermEntryLocalization)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CTermEntryLocalization, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CTermEntryLocalization, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CTermEntryLocalization)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CTermEntryLocalization, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CTermEntryLocalization, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<CTermEntryLocalization, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CTermEntryLocalization, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CTermEntryLocalization, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CTermEntryLocalization, Object>>();
		Map<String, BiConsumer<CTermEntryLocalization, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<CTermEntryLocalization, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", CTermEntryLocalization::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<CTermEntryLocalization, Long>)
				CTermEntryLocalization::setMvccVersion);
		attributeGetterFunctions.put(
			"cTermEntryLocalizationId",
			CTermEntryLocalization::getCTermEntryLocalizationId);
		attributeSetterBiConsumers.put(
			"cTermEntryLocalizationId",
			(BiConsumer<CTermEntryLocalization, Long>)
				CTermEntryLocalization::setCTermEntryLocalizationId);
		attributeGetterFunctions.put(
			"companyId", CTermEntryLocalization::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CTermEntryLocalization, Long>)
				CTermEntryLocalization::setCompanyId);
		attributeGetterFunctions.put(
			"commerceTermEntryId",
			CTermEntryLocalization::getCommerceTermEntryId);
		attributeSetterBiConsumers.put(
			"commerceTermEntryId",
			(BiConsumer<CTermEntryLocalization, Long>)
				CTermEntryLocalization::setCommerceTermEntryId);
		attributeGetterFunctions.put(
			"languageId", CTermEntryLocalization::getLanguageId);
		attributeSetterBiConsumers.put(
			"languageId",
			(BiConsumer<CTermEntryLocalization, String>)
				CTermEntryLocalization::setLanguageId);
		attributeGetterFunctions.put(
			"description", CTermEntryLocalization::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<CTermEntryLocalization, String>)
				CTermEntryLocalization::setDescription);
		attributeGetterFunctions.put("label", CTermEntryLocalization::getLabel);
		attributeSetterBiConsumers.put(
			"label",
			(BiConsumer<CTermEntryLocalization, String>)
				CTermEntryLocalization::setLabel);

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
	public long getCTermEntryLocalizationId() {
		return _cTermEntryLocalizationId;
	}

	@Override
	public void setCTermEntryLocalizationId(long cTermEntryLocalizationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cTermEntryLocalizationId = cTermEntryLocalizationId;
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
	public long getCommerceTermEntryId() {
		return _commerceTermEntryId;
	}

	@Override
	public void setCommerceTermEntryId(long commerceTermEntryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_commerceTermEntryId = commerceTermEntryId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCommerceTermEntryId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("commerceTermEntryId"));
	}

	@Override
	public String getLanguageId() {
		if (_languageId == null) {
			return "";
		}
		else {
			return _languageId;
		}
	}

	@Override
	public void setLanguageId(String languageId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_languageId = languageId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalLanguageId() {
		return getColumnOriginalValue("languageId");
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@Override
	public String getLabel() {
		if (_label == null) {
			return "";
		}
		else {
			return _label;
		}
	}

	@Override
	public void setLabel(String label) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_label = label;
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
			getCompanyId(), CTermEntryLocalization.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CTermEntryLocalization toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CTermEntryLocalization>
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
		CTermEntryLocalizationImpl cTermEntryLocalizationImpl =
			new CTermEntryLocalizationImpl();

		cTermEntryLocalizationImpl.setMvccVersion(getMvccVersion());
		cTermEntryLocalizationImpl.setCTermEntryLocalizationId(
			getCTermEntryLocalizationId());
		cTermEntryLocalizationImpl.setCompanyId(getCompanyId());
		cTermEntryLocalizationImpl.setCommerceTermEntryId(
			getCommerceTermEntryId());
		cTermEntryLocalizationImpl.setLanguageId(getLanguageId());
		cTermEntryLocalizationImpl.setDescription(getDescription());
		cTermEntryLocalizationImpl.setLabel(getLabel());

		cTermEntryLocalizationImpl.resetOriginalValues();

		return cTermEntryLocalizationImpl;
	}

	@Override
	public CTermEntryLocalization cloneWithOriginalValues() {
		CTermEntryLocalizationImpl cTermEntryLocalizationImpl =
			new CTermEntryLocalizationImpl();

		cTermEntryLocalizationImpl.setMvccVersion(
			this.<Long>getColumnOriginalValue("mvccVersion"));
		cTermEntryLocalizationImpl.setCTermEntryLocalizationId(
			this.<Long>getColumnOriginalValue("cTermEntryLocalizationId"));
		cTermEntryLocalizationImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		cTermEntryLocalizationImpl.setCommerceTermEntryId(
			this.<Long>getColumnOriginalValue("commerceTermEntryId"));
		cTermEntryLocalizationImpl.setLanguageId(
			this.<String>getColumnOriginalValue("languageId"));
		cTermEntryLocalizationImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		cTermEntryLocalizationImpl.setLabel(
			this.<String>getColumnOriginalValue("label"));

		return cTermEntryLocalizationImpl;
	}

	@Override
	public int compareTo(CTermEntryLocalization cTermEntryLocalization) {
		long primaryKey = cTermEntryLocalization.getPrimaryKey();

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

		if (!(object instanceof CTermEntryLocalization)) {
			return false;
		}

		CTermEntryLocalization cTermEntryLocalization =
			(CTermEntryLocalization)object;

		long primaryKey = cTermEntryLocalization.getPrimaryKey();

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

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CTermEntryLocalization> toCacheModel() {
		CTermEntryLocalizationCacheModel cTermEntryLocalizationCacheModel =
			new CTermEntryLocalizationCacheModel();

		cTermEntryLocalizationCacheModel.mvccVersion = getMvccVersion();

		cTermEntryLocalizationCacheModel.cTermEntryLocalizationId =
			getCTermEntryLocalizationId();

		cTermEntryLocalizationCacheModel.companyId = getCompanyId();

		cTermEntryLocalizationCacheModel.commerceTermEntryId =
			getCommerceTermEntryId();

		cTermEntryLocalizationCacheModel.languageId = getLanguageId();

		String languageId = cTermEntryLocalizationCacheModel.languageId;

		if ((languageId != null) && (languageId.length() == 0)) {
			cTermEntryLocalizationCacheModel.languageId = null;
		}

		cTermEntryLocalizationCacheModel.description = getDescription();

		String description = cTermEntryLocalizationCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			cTermEntryLocalizationCacheModel.description = null;
		}

		cTermEntryLocalizationCacheModel.label = getLabel();

		String label = cTermEntryLocalizationCacheModel.label;

		if ((label != null) && (label.length() == 0)) {
			cTermEntryLocalizationCacheModel.label = null;
		}

		return cTermEntryLocalizationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CTermEntryLocalization, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CTermEntryLocalization, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CTermEntryLocalization, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(CTermEntryLocalization)this);

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
		Map<String, Function<CTermEntryLocalization, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CTermEntryLocalization, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CTermEntryLocalization, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((CTermEntryLocalization)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CTermEntryLocalization>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					CTermEntryLocalization.class, ModelWrapper.class);

	}

	private long _mvccVersion;
	private long _cTermEntryLocalizationId;
	private long _companyId;
	private long _commerceTermEntryId;
	private String _languageId;
	private String _description;
	private String _label;

	public <T> T getColumnValue(String columnName) {
		Function<CTermEntryLocalization, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CTermEntryLocalization)this);
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
		_columnOriginalValues.put(
			"cTermEntryLocalizationId", _cTermEntryLocalizationId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("commerceTermEntryId", _commerceTermEntryId);
		_columnOriginalValues.put("languageId", _languageId);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("label", _label);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("mvccVersion", 1L);

		columnBitmasks.put("cTermEntryLocalizationId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("commerceTermEntryId", 8L);

		columnBitmasks.put("languageId", 16L);

		columnBitmasks.put("description", 32L);

		columnBitmasks.put("label", 64L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CTermEntryLocalization _escapedModel;

}