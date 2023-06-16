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

package com.aspire.studentservice.service.persistence.test;

import com.aspire.studentservice.exception.NoSuchstudentException;
import com.aspire.studentservice.model.student;
import com.aspire.studentservice.service.persistence.studentPersistence;
import com.aspire.studentservice.service.persistence.studentUtil;
import com.aspire.studentservice.service.studentLocalServiceUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class studentPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.aspire.studentservice.service"));

	@Before
	public void setUp() {
		_persistence = studentUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<student> iterator = _students.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		student student = _persistence.create(pk);

		Assert.assertNotNull(student);

		Assert.assertEquals(student.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		student newstudent = addstudent();

		_persistence.remove(newstudent);

		student existingstudent = _persistence.fetchByPrimaryKey(
			newstudent.getPrimaryKey());

		Assert.assertNull(existingstudent);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addstudent();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		student newstudent = _persistence.create(pk);

		newstudent.setEnrollmentno(RandomTestUtil.randomString());

		newstudent.setFname(RandomTestUtil.randomString());

		newstudent.setLname(RandomTestUtil.randomString());

		newstudent.setContactno(RandomTestUtil.randomString());

		newstudent.setCity(RandomTestUtil.randomString());

		_students.add(_persistence.update(newstudent));

		student existingstudent = _persistence.findByPrimaryKey(
			newstudent.getPrimaryKey());

		Assert.assertEquals(existingstudent.getId(), newstudent.getId());
		Assert.assertEquals(
			existingstudent.getEnrollmentno(), newstudent.getEnrollmentno());
		Assert.assertEquals(existingstudent.getFname(), newstudent.getFname());
		Assert.assertEquals(existingstudent.getLname(), newstudent.getLname());
		Assert.assertEquals(
			existingstudent.getContactno(), newstudent.getContactno());
		Assert.assertEquals(existingstudent.getCity(), newstudent.getCity());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		student newstudent = addstudent();

		student existingstudent = _persistence.findByPrimaryKey(
			newstudent.getPrimaryKey());

		Assert.assertEquals(existingstudent, newstudent);
	}

	@Test(expected = NoSuchstudentException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<student> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"student_table", "id", true, "enrollmentno", true, "fname", true,
			"lname", true, "contactno", true, "city", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		student newstudent = addstudent();

		student existingstudent = _persistence.fetchByPrimaryKey(
			newstudent.getPrimaryKey());

		Assert.assertEquals(existingstudent, newstudent);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		student missingstudent = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingstudent);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		student newstudent1 = addstudent();
		student newstudent2 = addstudent();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newstudent1.getPrimaryKey());
		primaryKeys.add(newstudent2.getPrimaryKey());

		Map<Serializable, student> students = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, students.size());
		Assert.assertEquals(
			newstudent1, students.get(newstudent1.getPrimaryKey()));
		Assert.assertEquals(
			newstudent2, students.get(newstudent2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, student> students = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(students.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		student newstudent = addstudent();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newstudent.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, student> students = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, students.size());
		Assert.assertEquals(
			newstudent, students.get(newstudent.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, student> students = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(students.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		student newstudent = addstudent();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newstudent.getPrimaryKey());

		Map<Serializable, student> students = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, students.size());
		Assert.assertEquals(
			newstudent, students.get(newstudent.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			studentLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<student>() {

				@Override
				public void performAction(student student) {
					Assert.assertNotNull(student);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		student newstudent = addstudent();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			student.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newstudent.getId()));

		List<student> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		student existingstudent = result.get(0);

		Assert.assertEquals(existingstudent, newstudent);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			student.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<student> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		student newstudent = addstudent();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			student.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newstudent.getId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("id", new Object[] {newId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			student.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected student addstudent() throws Exception {
		long pk = RandomTestUtil.nextLong();

		student student = _persistence.create(pk);

		student.setEnrollmentno(RandomTestUtil.randomString());

		student.setFname(RandomTestUtil.randomString());

		student.setLname(RandomTestUtil.randomString());

		student.setContactno(RandomTestUtil.randomString());

		student.setCity(RandomTestUtil.randomString());

		_students.add(_persistence.update(student));

		return student;
	}

	private List<student> _students = new ArrayList<student>();
	private studentPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}