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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;student_table&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see student
 * @generated
 */
public class studentTable extends BaseTable<studentTable> {

	public static final studentTable INSTANCE = new studentTable();

	public final Column<studentTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<studentTable, String> enrollmentno = createColumn(
		"enrollmentno", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<studentTable, String> fname = createColumn(
		"fname", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<studentTable, String> lname = createColumn(
		"lname", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<studentTable, String> contactno = createColumn(
		"contactno", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<studentTable, String> city = createColumn(
		"city", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private studentTable() {
		super("student_table", studentTable::new);
	}

}