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

package com.aspire.studentservice.service.persistence;

import com.aspire.studentservice.model.student;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the student service. This utility wraps <code>com.aspire.studentservice.service.persistence.impl.studentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see studentPersistence
 * @generated
 */
public class studentUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(student student) {
		getPersistence().clearCache(student);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, student> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<student> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<student> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<student> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<student> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static student update(student student) {
		return getPersistence().update(student);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static student update(
		student student, ServiceContext serviceContext) {

		return getPersistence().update(student, serviceContext);
	}

	/**
	 * Returns all the students where fname = &#63;.
	 *
	 * @param fname the fname
	 * @return the matching students
	 */
	public static List<student> findByfirstName(String fname) {
		return getPersistence().findByfirstName(fname);
	}

	/**
	 * Returns a range of all the students where fname = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>studentModelImpl</code>.
	 * </p>
	 *
	 * @param fname the fname
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of matching students
	 */
	public static List<student> findByfirstName(
		String fname, int start, int end) {

		return getPersistence().findByfirstName(fname, start, end);
	}

	/**
	 * Returns an ordered range of all the students where fname = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>studentModelImpl</code>.
	 * </p>
	 *
	 * @param fname the fname
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching students
	 */
	public static List<student> findByfirstName(
		String fname, int start, int end,
		OrderByComparator<student> orderByComparator) {

		return getPersistence().findByfirstName(
			fname, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the students where fname = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>studentModelImpl</code>.
	 * </p>
	 *
	 * @param fname the fname
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching students
	 */
	public static List<student> findByfirstName(
		String fname, int start, int end,
		OrderByComparator<student> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByfirstName(
			fname, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first student in the ordered set where fname = &#63;.
	 *
	 * @param fname the fname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student
	 * @throws NoSuchstudentException if a matching student could not be found
	 */
	public static student findByfirstName_First(
			String fname, OrderByComparator<student> orderByComparator)
		throws com.aspire.studentservice.exception.NoSuchstudentException {

		return getPersistence().findByfirstName_First(fname, orderByComparator);
	}

	/**
	 * Returns the first student in the ordered set where fname = &#63;.
	 *
	 * @param fname the fname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student, or <code>null</code> if a matching student could not be found
	 */
	public static student fetchByfirstName_First(
		String fname, OrderByComparator<student> orderByComparator) {

		return getPersistence().fetchByfirstName_First(
			fname, orderByComparator);
	}

	/**
	 * Returns the last student in the ordered set where fname = &#63;.
	 *
	 * @param fname the fname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student
	 * @throws NoSuchstudentException if a matching student could not be found
	 */
	public static student findByfirstName_Last(
			String fname, OrderByComparator<student> orderByComparator)
		throws com.aspire.studentservice.exception.NoSuchstudentException {

		return getPersistence().findByfirstName_Last(fname, orderByComparator);
	}

	/**
	 * Returns the last student in the ordered set where fname = &#63;.
	 *
	 * @param fname the fname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student, or <code>null</code> if a matching student could not be found
	 */
	public static student fetchByfirstName_Last(
		String fname, OrderByComparator<student> orderByComparator) {

		return getPersistence().fetchByfirstName_Last(fname, orderByComparator);
	}

	/**
	 * Returns the students before and after the current student in the ordered set where fname = &#63;.
	 *
	 * @param id the primary key of the current student
	 * @param fname the fname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student
	 * @throws NoSuchstudentException if a student with the primary key could not be found
	 */
	public static student[] findByfirstName_PrevAndNext(
			long id, String fname, OrderByComparator<student> orderByComparator)
		throws com.aspire.studentservice.exception.NoSuchstudentException {

		return getPersistence().findByfirstName_PrevAndNext(
			id, fname, orderByComparator);
	}

	/**
	 * Removes all the students where fname = &#63; from the database.
	 *
	 * @param fname the fname
	 */
	public static void removeByfirstName(String fname) {
		getPersistence().removeByfirstName(fname);
	}

	/**
	 * Returns the number of students where fname = &#63;.
	 *
	 * @param fname the fname
	 * @return the number of matching students
	 */
	public static int countByfirstName(String fname) {
		return getPersistence().countByfirstName(fname);
	}

	/**
	 * Caches the student in the entity cache if it is enabled.
	 *
	 * @param student the student
	 */
	public static void cacheResult(student student) {
		getPersistence().cacheResult(student);
	}

	/**
	 * Caches the students in the entity cache if it is enabled.
	 *
	 * @param students the students
	 */
	public static void cacheResult(List<student> students) {
		getPersistence().cacheResult(students);
	}

	/**
	 * Creates a new student with the primary key. Does not add the student to the database.
	 *
	 * @param id the primary key for the new student
	 * @return the new student
	 */
	public static student create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the student
	 * @return the student that was removed
	 * @throws NoSuchstudentException if a student with the primary key could not be found
	 */
	public static student remove(long id)
		throws com.aspire.studentservice.exception.NoSuchstudentException {

		return getPersistence().remove(id);
	}

	public static student updateImpl(student student) {
		return getPersistence().updateImpl(student);
	}

	/**
	 * Returns the student with the primary key or throws a <code>NoSuchstudentException</code> if it could not be found.
	 *
	 * @param id the primary key of the student
	 * @return the student
	 * @throws NoSuchstudentException if a student with the primary key could not be found
	 */
	public static student findByPrimaryKey(long id)
		throws com.aspire.studentservice.exception.NoSuchstudentException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the student
	 * @return the student, or <code>null</code> if a student with the primary key could not be found
	 */
	public static student fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the students.
	 *
	 * @return the students
	 */
	public static List<student> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>studentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of students
	 */
	public static List<student> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>studentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of students
	 */
	public static List<student> findAll(
		int start, int end, OrderByComparator<student> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>studentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of students
	 */
	public static List<student> findAll(
		int start, int end, OrderByComparator<student> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the students from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of students.
	 *
	 * @return the number of students
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static studentPersistence getPersistence() {
		return _persistence;
	}

	private static volatile studentPersistence _persistence;

}