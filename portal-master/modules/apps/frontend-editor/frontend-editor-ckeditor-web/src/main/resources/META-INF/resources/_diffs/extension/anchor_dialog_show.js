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

ckEditor.on('dialogShow', (event) => {
	const dialog = event.data.definition.dialog;

	if (dialog.getName() === 'anchor') {
		const originalFn = dialog.getValueOf.bind(dialog);

		dialog.getValueOf = function (pageId, elementId) {
			let value = originalFn(pageId, elementId);

			if (pageId === 'info' && elementId === 'txtName') {
				value = value.replace(/ /g, '_');
			}

			return value;
		};
	}
});
