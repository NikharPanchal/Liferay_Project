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

package com.aspire.studentservice.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link student}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see student
 * @generated
 */
public class studentWrapper
	extends BaseModelWrapper<student>
	implements ModelWrapper<student>, student {

	public studentWrapper(student student) {
		super(student);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("enrollmentno", getEnrollmentno());
		attributes.put("fname", getFname());
		attributes.put("lname", getLname());
		attributes.put("contactno", getContactno());
		attributes.put("city", getCity());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String enrollmentno = (String)attributes.get("enrollmentno");

		if (enrollmentno != null) {
			setEnrollmentno(enrollmentno);
		}

		String fname = (String)attributes.get("fname");

		if (fname != null) {
			setFname(fname);
		}

		String lname = (String)attributes.get("lname");

		if (lname != null) {
			setLname(lname);
		}

		String contactno = (String)attributes.get("contactno");

		if (contactno != null) {
			setContactno(contactno);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}
	}

	@Override
	public student cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the city of this student.
	 *
	 * @return the city of this student
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the contactno of this student.
	 *
	 * @return the contactno of this student
	 */
	@Override
	public String getContactno() {
		return model.getContactno();
	}

	/**
	 * Returns the enrollmentno of this student.
	 *
	 * @return the enrollmentno of this student
	 */
	@Override
	public String getEnrollmentno() {
		return model.getEnrollmentno();
	}

	/**
	 * Returns the fname of this student.
	 *
	 * @return the fname of this student
	 */
	@Override
	public String getFname() {
		return model.getFname();
	}

	/**
	 * Returns the ID of this student.
	 *
	 * @return the ID of this student
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the lname of this student.
	 *
	 * @return the lname of this student
	 */
	@Override
	public String getLname() {
		return model.getLname();
	}

	/**
	 * Returns the primary key of this student.
	 *
	 * @return the primary key of this student
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the city of this student.
	 *
	 * @param city the city of this student
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the contactno of this student.
	 *
	 * @param contactno the contactno of this student
	 */
	@Override
	public void setContactno(String contactno) {
		model.setContactno(contactno);
	}

	/**
	 * Sets the enrollmentno of this student.
	 *
	 * @param enrollmentno the enrollmentno of this student
	 */
	@Override
	public void setEnrollmentno(String enrollmentno) {
		model.setEnrollmentno(enrollmentno);
	}

	/**
	 * Sets the fname of this student.
	 *
	 * @param fname the fname of this student
	 */
	@Override
	public void setFname(String fname) {
		model.setFname(fname);
	}

	/**
	 * Sets the ID of this student.
	 *
	 * @param id the ID of this student
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the lname of this student.
	 *
	 * @param lname the lname of this student
	 */
	@Override
	public void setLname(String lname) {
		model.setLname(lname);
	}

	/**
	 * Sets the primary key of this student.
	 *
	 * @param primaryKey the primary key of this student
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected studentWrapper wrap(student student) {
		return new studentWrapper(student);
	}

}