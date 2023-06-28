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

package com.liferay.bookmarks.uad.display;

import com.liferay.bookmarks.model.BookmarksFolder;
import com.liferay.bookmarks.service.BookmarksFolderLocalService;
import com.liferay.bookmarks.uad.constants.BookmarksUADConstants;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.user.associated.data.display.BaseModelUADDisplay;

import java.io.Serializable;

import java.util.List;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the BookmarksFolder UAD display.
 *
 * <p>
 * This implementation exists only as a container for the default methods
 * generated by ServiceBuilder. All custom methods should be put in
 * {@link BookmarksFolderUADDisplay}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class BaseBookmarksFolderUADDisplay
	extends BaseModelUADDisplay<BookmarksFolder> {

	@Override
	public BookmarksFolder get(Serializable primaryKey) throws PortalException {
		return bookmarksFolderLocalService.getBookmarksFolder(
			Long.valueOf(primaryKey.toString()));
	}

	@Override
	public String[] getDisplayFieldNames() {
		return new String[] {"treePath", "name", "description"};
	}

	@Override
	public Class<BookmarksFolder> getTypeClass() {
		return BookmarksFolder.class;
	}

	@Override
	protected long doCount(DynamicQuery dynamicQuery) {
		return bookmarksFolderLocalService.dynamicQueryCount(dynamicQuery);
	}

	@Override
	protected DynamicQuery doGetDynamicQuery() {
		return bookmarksFolderLocalService.dynamicQuery();
	}

	@Override
	protected List<BookmarksFolder> doGetRange(
		DynamicQuery dynamicQuery, int start, int end) {

		return bookmarksFolderLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	@Override
	protected String[] doGetUserIdFieldNames() {
		return BookmarksUADConstants.USER_ID_FIELD_NAMES_BOOKMARKS_FOLDER;
	}

	@Reference
	protected BookmarksFolderLocalService bookmarksFolderLocalService;

}