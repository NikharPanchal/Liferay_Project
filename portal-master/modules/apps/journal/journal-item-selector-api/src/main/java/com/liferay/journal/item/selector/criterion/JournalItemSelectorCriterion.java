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

package com.liferay.journal.item.selector.criterion;

import com.liferay.item.selector.BaseItemSelectorCriterion;
import com.liferay.item.selector.constants.ItemSelectorCriterionConstants;

/**
 * @author Eduardo García
 * @author Roberto Díaz
 */
public class JournalItemSelectorCriterion extends BaseItemSelectorCriterion {

	public JournalItemSelectorCriterion() {
	}

	public JournalItemSelectorCriterion(long resourcePrimKey) {
		_resourcePrimKey = resourcePrimKey;
	}

	public JournalItemSelectorCriterion(long resourcePrimKey, long folderId) {
		_resourcePrimKey = resourcePrimKey;
		_folderId = folderId;
	}

	public long getFolderId() {
		return _folderId;
	}

	@Override
	public String getMimeTypeRestriction() {
		return ItemSelectorCriterionConstants.MIME_TYPE_RESTRICTION_IMAGE;
	}

	public long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	public void setResourcePrimKey(long resourcePrimKey) {
		_resourcePrimKey = resourcePrimKey;
	}

	private long _folderId;
	private long _resourcePrimKey;

}