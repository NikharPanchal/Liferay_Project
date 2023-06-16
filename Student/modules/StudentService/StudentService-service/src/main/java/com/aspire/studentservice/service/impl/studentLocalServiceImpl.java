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

package com.aspire.studentservice.service.impl;

import com.aspire.studentservice.model.student;
import com.aspire.studentservice.service.base.studentLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.aspire.studentservice.model.student",
	service = AopService.class
)
public class studentLocalServiceImpl extends studentLocalServiceBaseImpl {
	
//	public List<student> getStudentList(){
//	
//		System.out.println("sqlllllllllll");
//		List<student> studentData= null;
//		Session session1 = null;
//		String sql=CustomSQLUtil.get("Select * from student_table");
//		SQLQuery query=session1.createSQLQuery(sql);
//		studentData=(List<student>)query.list();
//		
//		return studentData;	
//	}
}
