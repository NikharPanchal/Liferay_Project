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

package com.aspire.studentservice.model.impl;

import com.aspire.studentservice.model.student;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing student in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class studentCacheModel implements CacheModel<student>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof studentCacheModel)) {
			return false;
		}

		studentCacheModel studentCacheModel = (studentCacheModel)object;

		if (id == studentCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", enrollmentno=");
		sb.append(enrollmentno);
		sb.append(", fname=");
		sb.append(fname);
		sb.append(", lname=");
		sb.append(lname);
		sb.append(", contactno=");
		sb.append(contactno);
		sb.append(", city=");
		sb.append(city);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public student toEntityModel() {
		studentImpl studentImpl = new studentImpl();

		studentImpl.setId(id);

		if (enrollmentno == null) {
			studentImpl.setEnrollmentno("");
		}
		else {
			studentImpl.setEnrollmentno(enrollmentno);
		}

		if (fname == null) {
			studentImpl.setFname("");
		}
		else {
			studentImpl.setFname(fname);
		}

		if (lname == null) {
			studentImpl.setLname("");
		}
		else {
			studentImpl.setLname(lname);
		}

		if (contactno == null) {
			studentImpl.setContactno("");
		}
		else {
			studentImpl.setContactno(contactno);
		}

		if (city == null) {
			studentImpl.setCity("");
		}
		else {
			studentImpl.setCity(city);
		}

		studentImpl.resetOriginalValues();

		return studentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		enrollmentno = objectInput.readUTF();
		fname = objectInput.readUTF();
		lname = objectInput.readUTF();
		contactno = objectInput.readUTF();
		city = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (enrollmentno == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(enrollmentno);
		}

		if (fname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fname);
		}

		if (lname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lname);
		}

		if (contactno == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactno);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}
	}

	public long id;
	public String enrollmentno;
	public String fname;
	public String lname;
	public String contactno;
	public String city;

}