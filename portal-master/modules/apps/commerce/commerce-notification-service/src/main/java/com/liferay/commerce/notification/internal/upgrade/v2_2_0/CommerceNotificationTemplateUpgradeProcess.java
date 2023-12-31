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

package com.liferay.commerce.notification.internal.upgrade.v2_2_0;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Luca Pellizzon
 */
public class CommerceNotificationTemplateUpgradeProcess extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_addColumn("CommerceNotificationTemplate", "to_", "VARCHAR(75)");
	}

	private void _addColumn(
			String tableName, String columnName, String columnType)
		throws Exception {

		if (_log.isInfoEnabled()) {
			_log.info(
				String.format(
					"Adding column %s to table %s", columnName, tableName));
		}

		alterTableAddColumn(tableName, columnName, columnType);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CommerceNotificationTemplateUpgradeProcess.class);

}