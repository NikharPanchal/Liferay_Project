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

package com.liferay.document.library.item.selector.web.internal.video;

import com.liferay.document.library.item.selector.web.internal.BaseDLItemSelectorView;
import com.liferay.document.library.item.selector.web.internal.constants.DLItemSelectorViewConstants;
import com.liferay.document.library.item.selector.web.internal.display.context.DLItemSelectorViewDisplayContext;
import com.liferay.document.library.kernel.util.VideoProcessorUtil;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.ItemSelectorView;
import com.liferay.item.selector.criteria.FileEntryItemSelectorReturnType;
import com.liferay.item.selector.criteria.URLItemSelectorReturnType;
import com.liferay.item.selector.criteria.VideoEmbeddableHTMLItemSelectorReturnType;
import com.liferay.item.selector.criteria.video.criterion.VideoItemSelectorCriterion;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.util.PropsValues;

import java.util.Collections;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Roberto Díaz
 */
@Component(
	property = {
		"item.selector.view.key=" + DLItemSelectorViewConstants.DL_VIDEO_ITEM_SELECTOR_VIEW_KEY,
		"item.selector.view.order:Integer=100"
	},
	service = ItemSelectorView.class
)
public class DLVideoItemSelectorView
	extends BaseDLItemSelectorView<VideoItemSelectorCriterion> {

	@Override
	public Class<VideoItemSelectorCriterion> getItemSelectorCriterionClass() {
		return VideoItemSelectorCriterion.class;
	}

	@Override
	public String[] getMimeTypes() {
		String[] mimeTypes = {
			ContentTypes.APPLICATION_VND_LIFERAY_VIDEO_EXTERNAL_SHORTCUT_HTML
		};

		if (VideoProcessorUtil.isAvailable()) {
			mimeTypes = ArrayUtil.append(
				mimeTypes, PropsValues.DL_FILE_ENTRY_PREVIEW_VIDEO_MIME_TYPES);
		}

		return mimeTypes;
	}

	@Override
	public List<ItemSelectorReturnType> getSupportedItemSelectorReturnTypes() {
		return _supportedItemSelectorReturnTypes;
	}

	@Override
	protected void prepareDLItemSelectorViewDisplayContext(
		DLItemSelectorViewDisplayContext dlItemSelectorViewDisplayContext) {

		dlItemSelectorViewDisplayContext.setShowDragAndDropZone(
			VideoProcessorUtil.isAvailable());
	}

	private static final List<ItemSelectorReturnType>
		_supportedItemSelectorReturnTypes = Collections.unmodifiableList(
			ListUtil.fromArray(
				new FileEntryItemSelectorReturnType(),
				new URLItemSelectorReturnType(),
				new VideoEmbeddableHTMLItemSelectorReturnType()));

}