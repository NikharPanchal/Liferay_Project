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

package com.liferay.dynamic.data.mapping.internal.upgrade.v1_0_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.LoggingTimer;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Marcellus Tavares
 */
public class SchemaUpgradeProcess extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_updateSQL();

		_alterTables();
	}

	private void _alterTables() throws Exception {
		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			alterColumnName("DDMContent", "xml", "data_ TEXT null");

			alterColumnName("DDMStructure", "xsd", "definition TEXT null");
			alterColumnType("DDMStructure", "description", "TEXT null");

			alterColumnType("DDMTemplate", "description", "TEXT null");
		}
	}

	private void _updateSQL() throws Exception {
		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			String template = StringUtil.read(
				SchemaUpgradeProcess.class.getResourceAsStream(
					"dependencies/update.sql"));

			runSQLTemplateString(template, false);
		}
	}

}