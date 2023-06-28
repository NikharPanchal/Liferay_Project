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

package com.liferay.commerce.notification.service.base;

import com.liferay.commerce.notification.model.CommerceNotificationQueueEntry;
import com.liferay.commerce.notification.service.CommerceNotificationQueueEntryLocalService;
import com.liferay.commerce.notification.service.CommerceNotificationQueueEntryLocalServiceUtil;
import com.liferay.commerce.notification.service.persistence.CommerceNotificationAttachmentPersistence;
import com.liferay.commerce.notification.service.persistence.CommerceNotificationQueueEntryPersistence;
import com.liferay.commerce.notification.service.persistence.CommerceNotificationTemplateCommerceAccountGroupRelPersistence;
import com.liferay.commerce.notification.service.persistence.CommerceNotificationTemplatePersistence;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the commerce notification queue entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.notification.service.impl.CommerceNotificationQueueEntryLocalServiceImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see com.liferay.commerce.notification.service.impl.CommerceNotificationQueueEntryLocalServiceImpl
 * @generated
 */
public abstract class CommerceNotificationQueueEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements CommerceNotificationQueueEntryLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CommerceNotificationQueueEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CommerceNotificationQueueEntryLocalServiceUtil</code>.
	 */

	/**
	 * Adds the commerce notification queue entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommerceNotificationQueueEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commerceNotificationQueueEntry the commerce notification queue entry
	 * @return the commerce notification queue entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommerceNotificationQueueEntry addCommerceNotificationQueueEntry(
		CommerceNotificationQueueEntry commerceNotificationQueueEntry) {

		commerceNotificationQueueEntry.setNew(true);

		return commerceNotificationQueueEntryPersistence.update(
			commerceNotificationQueueEntry);
	}

	/**
	 * Creates a new commerce notification queue entry with the primary key. Does not add the commerce notification queue entry to the database.
	 *
	 * @param commerceNotificationQueueEntryId the primary key for the new commerce notification queue entry
	 * @return the new commerce notification queue entry
	 */
	@Override
	@Transactional(enabled = false)
	public CommerceNotificationQueueEntry createCommerceNotificationQueueEntry(
		long commerceNotificationQueueEntryId) {

		return commerceNotificationQueueEntryPersistence.create(
			commerceNotificationQueueEntryId);
	}

	/**
	 * Deletes the commerce notification queue entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommerceNotificationQueueEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commerceNotificationQueueEntryId the primary key of the commerce notification queue entry
	 * @return the commerce notification queue entry that was removed
	 * @throws PortalException if a commerce notification queue entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommerceNotificationQueueEntry deleteCommerceNotificationQueueEntry(
			long commerceNotificationQueueEntryId)
		throws PortalException {

		return commerceNotificationQueueEntryPersistence.remove(
			commerceNotificationQueueEntryId);
	}

	/**
	 * Deletes the commerce notification queue entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommerceNotificationQueueEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commerceNotificationQueueEntry the commerce notification queue entry
	 * @return the commerce notification queue entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommerceNotificationQueueEntry deleteCommerceNotificationQueueEntry(
		CommerceNotificationQueueEntry commerceNotificationQueueEntry) {

		return commerceNotificationQueueEntryPersistence.remove(
			commerceNotificationQueueEntry);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return commerceNotificationQueueEntryPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CommerceNotificationQueueEntry.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return commerceNotificationQueueEntryPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.notification.model.impl.CommerceNotificationQueueEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return commerceNotificationQueueEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.notification.model.impl.CommerceNotificationQueueEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return commerceNotificationQueueEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return commerceNotificationQueueEntryPersistence.countWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return commerceNotificationQueueEntryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public CommerceNotificationQueueEntry fetchCommerceNotificationQueueEntry(
		long commerceNotificationQueueEntryId) {

		return commerceNotificationQueueEntryPersistence.fetchByPrimaryKey(
			commerceNotificationQueueEntryId);
	}

	/**
	 * Returns the commerce notification queue entry with the primary key.
	 *
	 * @param commerceNotificationQueueEntryId the primary key of the commerce notification queue entry
	 * @return the commerce notification queue entry
	 * @throws PortalException if a commerce notification queue entry with the primary key could not be found
	 */
	@Override
	public CommerceNotificationQueueEntry getCommerceNotificationQueueEntry(
			long commerceNotificationQueueEntryId)
		throws PortalException {

		return commerceNotificationQueueEntryPersistence.findByPrimaryKey(
			commerceNotificationQueueEntryId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			commerceNotificationQueueEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(
			CommerceNotificationQueueEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"commerceNotificationQueueEntryId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			commerceNotificationQueueEntryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			CommerceNotificationQueueEntry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"commerceNotificationQueueEntryId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			commerceNotificationQueueEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(
			CommerceNotificationQueueEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"commerceNotificationQueueEntryId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return commerceNotificationQueueEntryPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return commerceNotificationQueueEntryLocalService.
			deleteCommerceNotificationQueueEntry(
				(CommerceNotificationQueueEntry)persistedModel);
	}

	@Override
	public BasePersistence<CommerceNotificationQueueEntry>
		getBasePersistence() {

		return commerceNotificationQueueEntryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return commerceNotificationQueueEntryPersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns a range of all the commerce notification queue entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.notification.model.impl.CommerceNotificationQueueEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce notification queue entries
	 * @param end the upper bound of the range of commerce notification queue entries (not inclusive)
	 * @return the range of commerce notification queue entries
	 */
	@Override
	public List<CommerceNotificationQueueEntry>
		getCommerceNotificationQueueEntries(int start, int end) {

		return commerceNotificationQueueEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of commerce notification queue entries.
	 *
	 * @return the number of commerce notification queue entries
	 */
	@Override
	public int getCommerceNotificationQueueEntriesCount() {
		return commerceNotificationQueueEntryPersistence.countAll();
	}

	/**
	 * Updates the commerce notification queue entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommerceNotificationQueueEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commerceNotificationQueueEntry the commerce notification queue entry
	 * @return the commerce notification queue entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommerceNotificationQueueEntry updateCommerceNotificationQueueEntry(
		CommerceNotificationQueueEntry commerceNotificationQueueEntry) {

		return commerceNotificationQueueEntryPersistence.update(
			commerceNotificationQueueEntry);
	}

	/**
	 * Returns the commerce notification attachment local service.
	 *
	 * @return the commerce notification attachment local service
	 */
	public com.liferay.commerce.notification.service.
		CommerceNotificationAttachmentLocalService
			getCommerceNotificationAttachmentLocalService() {

		return commerceNotificationAttachmentLocalService;
	}

	/**
	 * Sets the commerce notification attachment local service.
	 *
	 * @param commerceNotificationAttachmentLocalService the commerce notification attachment local service
	 */
	public void setCommerceNotificationAttachmentLocalService(
		com.liferay.commerce.notification.service.
			CommerceNotificationAttachmentLocalService
				commerceNotificationAttachmentLocalService) {

		this.commerceNotificationAttachmentLocalService =
			commerceNotificationAttachmentLocalService;
	}

	/**
	 * Returns the commerce notification attachment persistence.
	 *
	 * @return the commerce notification attachment persistence
	 */
	public CommerceNotificationAttachmentPersistence
		getCommerceNotificationAttachmentPersistence() {

		return commerceNotificationAttachmentPersistence;
	}

	/**
	 * Sets the commerce notification attachment persistence.
	 *
	 * @param commerceNotificationAttachmentPersistence the commerce notification attachment persistence
	 */
	public void setCommerceNotificationAttachmentPersistence(
		CommerceNotificationAttachmentPersistence
			commerceNotificationAttachmentPersistence) {

		this.commerceNotificationAttachmentPersistence =
			commerceNotificationAttachmentPersistence;
	}

	/**
	 * Returns the commerce notification queue entry local service.
	 *
	 * @return the commerce notification queue entry local service
	 */
	public CommerceNotificationQueueEntryLocalService
		getCommerceNotificationQueueEntryLocalService() {

		return commerceNotificationQueueEntryLocalService;
	}

	/**
	 * Sets the commerce notification queue entry local service.
	 *
	 * @param commerceNotificationQueueEntryLocalService the commerce notification queue entry local service
	 */
	public void setCommerceNotificationQueueEntryLocalService(
		CommerceNotificationQueueEntryLocalService
			commerceNotificationQueueEntryLocalService) {

		this.commerceNotificationQueueEntryLocalService =
			commerceNotificationQueueEntryLocalService;
	}

	/**
	 * Returns the commerce notification queue entry persistence.
	 *
	 * @return the commerce notification queue entry persistence
	 */
	public CommerceNotificationQueueEntryPersistence
		getCommerceNotificationQueueEntryPersistence() {

		return commerceNotificationQueueEntryPersistence;
	}

	/**
	 * Sets the commerce notification queue entry persistence.
	 *
	 * @param commerceNotificationQueueEntryPersistence the commerce notification queue entry persistence
	 */
	public void setCommerceNotificationQueueEntryPersistence(
		CommerceNotificationQueueEntryPersistence
			commerceNotificationQueueEntryPersistence) {

		this.commerceNotificationQueueEntryPersistence =
			commerceNotificationQueueEntryPersistence;
	}

	/**
	 * Returns the commerce notification template local service.
	 *
	 * @return the commerce notification template local service
	 */
	public com.liferay.commerce.notification.service.
		CommerceNotificationTemplateLocalService
			getCommerceNotificationTemplateLocalService() {

		return commerceNotificationTemplateLocalService;
	}

	/**
	 * Sets the commerce notification template local service.
	 *
	 * @param commerceNotificationTemplateLocalService the commerce notification template local service
	 */
	public void setCommerceNotificationTemplateLocalService(
		com.liferay.commerce.notification.service.
			CommerceNotificationTemplateLocalService
				commerceNotificationTemplateLocalService) {

		this.commerceNotificationTemplateLocalService =
			commerceNotificationTemplateLocalService;
	}

	/**
	 * Returns the commerce notification template persistence.
	 *
	 * @return the commerce notification template persistence
	 */
	public CommerceNotificationTemplatePersistence
		getCommerceNotificationTemplatePersistence() {

		return commerceNotificationTemplatePersistence;
	}

	/**
	 * Sets the commerce notification template persistence.
	 *
	 * @param commerceNotificationTemplatePersistence the commerce notification template persistence
	 */
	public void setCommerceNotificationTemplatePersistence(
		CommerceNotificationTemplatePersistence
			commerceNotificationTemplatePersistence) {

		this.commerceNotificationTemplatePersistence =
			commerceNotificationTemplatePersistence;
	}

	/**
	 * Returns the commerce notification template commerce account group rel local service.
	 *
	 * @return the commerce notification template commerce account group rel local service
	 */
	public com.liferay.commerce.notification.service.
		CommerceNotificationTemplateCommerceAccountGroupRelLocalService
			getCommerceNotificationTemplateCommerceAccountGroupRelLocalService() {

		return commerceNotificationTemplateCommerceAccountGroupRelLocalService;
	}

	/**
	 * Sets the commerce notification template commerce account group rel local service.
	 *
	 * @param commerceNotificationTemplateCommerceAccountGroupRelLocalService the commerce notification template commerce account group rel local service
	 */
	public void
		setCommerceNotificationTemplateCommerceAccountGroupRelLocalService(
			com.liferay.commerce.notification.service.
				CommerceNotificationTemplateCommerceAccountGroupRelLocalService
					commerceNotificationTemplateCommerceAccountGroupRelLocalService) {

		this.commerceNotificationTemplateCommerceAccountGroupRelLocalService =
			commerceNotificationTemplateCommerceAccountGroupRelLocalService;
	}

	/**
	 * Returns the commerce notification template commerce account group rel persistence.
	 *
	 * @return the commerce notification template commerce account group rel persistence
	 */
	public CommerceNotificationTemplateCommerceAccountGroupRelPersistence
		getCommerceNotificationTemplateCommerceAccountGroupRelPersistence() {

		return commerceNotificationTemplateCommerceAccountGroupRelPersistence;
	}

	/**
	 * Sets the commerce notification template commerce account group rel persistence.
	 *
	 * @param commerceNotificationTemplateCommerceAccountGroupRelPersistence the commerce notification template commerce account group rel persistence
	 */
	public void
		setCommerceNotificationTemplateCommerceAccountGroupRelPersistence(
			CommerceNotificationTemplateCommerceAccountGroupRelPersistence
				commerceNotificationTemplateCommerceAccountGroupRelPersistence) {

		this.commerceNotificationTemplateCommerceAccountGroupRelPersistence =
			commerceNotificationTemplateCommerceAccountGroupRelPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {

		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {

		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register(
			"com.liferay.commerce.notification.model.CommerceNotificationQueueEntry",
			commerceNotificationQueueEntryLocalService);

		_setLocalServiceUtilService(commerceNotificationQueueEntryLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.commerce.notification.model.CommerceNotificationQueueEntry");

		_setLocalServiceUtilService(null);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CommerceNotificationQueueEntryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CommerceNotificationQueueEntry.class;
	}

	protected String getModelClassName() {
		return CommerceNotificationQueueEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				commerceNotificationQueueEntryPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		CommerceNotificationQueueEntryLocalService
			commerceNotificationQueueEntryLocalService) {

		try {
			Field field =
				CommerceNotificationQueueEntryLocalServiceUtil.class.
					getDeclaredField("_service");

			field.setAccessible(true);

			field.set(null, commerceNotificationQueueEntryLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@BeanReference(
		type = com.liferay.commerce.notification.service.CommerceNotificationAttachmentLocalService.class
	)
	protected com.liferay.commerce.notification.service.
		CommerceNotificationAttachmentLocalService
			commerceNotificationAttachmentLocalService;

	@BeanReference(type = CommerceNotificationAttachmentPersistence.class)
	protected CommerceNotificationAttachmentPersistence
		commerceNotificationAttachmentPersistence;

	@BeanReference(type = CommerceNotificationQueueEntryLocalService.class)
	protected CommerceNotificationQueueEntryLocalService
		commerceNotificationQueueEntryLocalService;

	@BeanReference(type = CommerceNotificationQueueEntryPersistence.class)
	protected CommerceNotificationQueueEntryPersistence
		commerceNotificationQueueEntryPersistence;

	@BeanReference(
		type = com.liferay.commerce.notification.service.CommerceNotificationTemplateLocalService.class
	)
	protected com.liferay.commerce.notification.service.
		CommerceNotificationTemplateLocalService
			commerceNotificationTemplateLocalService;

	@BeanReference(type = CommerceNotificationTemplatePersistence.class)
	protected CommerceNotificationTemplatePersistence
		commerceNotificationTemplatePersistence;

	@BeanReference(
		type = com.liferay.commerce.notification.service.CommerceNotificationTemplateCommerceAccountGroupRelLocalService.class
	)
	protected com.liferay.commerce.notification.service.
		CommerceNotificationTemplateCommerceAccountGroupRelLocalService
			commerceNotificationTemplateCommerceAccountGroupRelLocalService;

	@BeanReference(
		type = CommerceNotificationTemplateCommerceAccountGroupRelPersistence.class
	)
	protected CommerceNotificationTemplateCommerceAccountGroupRelPersistence
		commerceNotificationTemplateCommerceAccountGroupRelPersistence;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}