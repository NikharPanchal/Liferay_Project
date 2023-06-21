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
import com.aspire.studentservice.model.studentModel;
import com.aspire.studentservice.service.base.studentLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.aspire.studentservice.model.student", service = AopService.class)
public class studentLocalServiceImpl extends studentLocalServiceBaseImpl {

//	public List<student> getStudentList() {

//		Connection connection = null;
//		Session session1 = null;
//		List<student> studentData = new ArrayList<>();
//		try {
//			connection = DataAccess.getConnection();
//			if (connection != null) {
//				System.out.println("connection success....");
//				String sql = "Select * from student_table";
//				try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
//						ResultSet resultSet = preparedStatement.executeQuery()) {
//					while (resultSet.next()) {
//						student s = null;
//						s.setPrimaryKey(resultSet.getLong(1));
//						s.setEnrollmentno(resultSet.getString(2));
//						s.setFname(resultSet.getString(3));
//						s.setLname(resultSet.getString(4));
//						s.setContactno(resultSet.getString(5));
//						s.setCity(resultSet.getString(6));
//						System.out.println(s);
//						studentData.add(s);
//					}
//					System.out.println(studentData);
//					return studentData;
//				}
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return studentData;
	
//		List<student> studentData= new ArrayList<>();
//		Session session = studentPersistence.openSession();
//		try {
//			
//			String sql=CustomSQLUtil.get("Select * from student_table");
//			System.out.println(sql);
//			SQLQuery query=session.createSQLQuery(sql);
//			System.out.println(query);
//			query.setCacheable(false);
//			studentData=(List<student>)query.list();
//			return studentData;
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		finally {
//			session.close();
//		}
//		return studentData;
//	}
		
	public List<student> findbyfirstname(String fname) {
		return studentPersistence.findByfirstName(fname);
	}
}
