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

package com.liferay.change.tracking.web.internal.helper;

import com.liferay.change.tracking.constants.CTActionKeys;
import com.liferay.change.tracking.constants.CTConstants;
import com.liferay.change.tracking.constants.CTPortletKeys;
import com.liferay.change.tracking.model.CTCollection;
import com.liferay.change.tracking.model.CTPreferences;
import com.liferay.change.tracking.service.CTCollectionLocalService;
import com.liferay.change.tracking.service.CTPreferencesLocalService;
import com.liferay.change.tracking.web.internal.configuration.helper.CTSettingsConfigurationHelper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactory;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.permission.PortletPermission;
import com.liferay.portal.kernel.util.FastDateFormatFactory;

import java.text.Format;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author David Truong
 */
@Component(immediate = true, service = SandboxHelper.class)
public class SandboxHelper {

	public void sandbox(CTPreferences ctPreferences) throws PortalException {
		if ((ctPreferences == null) ||
			(ctPreferences.getCtCollectionId() !=
				CTConstants.CT_COLLECTION_ID_PRODUCTION) ||
			!_ctSettingsConfigurationHelper.isSandboxEnabled(
				ctPreferences.getCompanyId())) {

			return;
		}

		PermissionChecker permissionChecker =
			PermissionThreadLocal.getPermissionChecker();

		if (permissionChecker == null) {
			permissionChecker = _permissionCheckerFactory.create(
				_userLocalService.getUser(ctPreferences.getUserId()));

			PermissionThreadLocal.setPermissionChecker(permissionChecker);
		}

		if (_portletPermission.contains(
				permissionChecker, CTPortletKeys.PUBLICATIONS,
				CTActionKeys.WORK_ON_PRODUCTION)) {

			return;
		}

		if (ctPreferences.getPreviousCtCollectionId() !=
				CTConstants.CT_COLLECTION_ID_PRODUCTION) {

			ctPreferences.setCtCollectionId(
				ctPreferences.getPreviousCtCollectionId());
		}
		else {
			CTCollection sandboxCTCollection = _addSandboxCTCollection(
				ctPreferences.getUserId());

			ctPreferences.setCtCollectionId(
				sandboxCTCollection.getCtCollectionId());
		}

		ctPreferences.setPreviousCtCollectionId(
			CTConstants.CT_COLLECTION_ID_PRODUCTION);

		_ctPreferencesLocalService.updateCTPreferences(ctPreferences);
	}

	private CTCollection _addSandboxCTCollection(long userId)
		throws PortalException {

		User user = _userLocalService.getUser(userId);

		Format format = _fastDateFormatFactory.getDateTime(
			user.getLocale(), user.getTimeZone());

		return _ctCollectionLocalService.addCTCollection(
			user.getCompanyId(), user.getUserId(),
			user.getScreenName() + " - " +
				format.format(System.currentTimeMillis()),
			_language.get(
				user.getLocale(), "autogenerated-by-sandbox-only-mode"));
	}

	@Reference
	private CTCollectionLocalService _ctCollectionLocalService;

	@Reference
	private CTPreferencesLocalService _ctPreferencesLocalService;

	@Reference
	private CTSettingsConfigurationHelper _ctSettingsConfigurationHelper;

	@Reference
	private FastDateFormatFactory _fastDateFormatFactory;

	@Reference
	private Language _language;

	@Reference
	private PermissionCheckerFactory _permissionCheckerFactory;

	@Reference
	private PortletPermission _portletPermission;

	@Reference
	private UserLocalService _userLocalService;

}