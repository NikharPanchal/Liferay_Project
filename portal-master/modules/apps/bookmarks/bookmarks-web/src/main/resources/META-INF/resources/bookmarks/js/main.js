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

AUI.add(
	'liferay-bookmarks',
	(A) => {
		const Lang = A.Lang;

		const Bookmarks = A.Component.create({
			ATTRS: {
				editEntryUrl: {
					validator: Lang.isString,
				},

				form: {
					validator: Lang.isObject,
				},

				moveEntryUrl: {
					validator: Lang.isString,
				},

				searchContainerId: {
					validator: Lang.isString,
				},
			},

			AUGMENTS: [Liferay.PortletBase],

			EXTENDS: A.Base,

			NAME: 'bookmarks',

			prototype: {
				_moveToFolder(object) {
					const instance = this;

					const namespace = instance.NS;

					const dropTarget = object.targetItem;

					const selectedItems = object.selectedItems;

					const folderId = dropTarget.attr('data-folder-id');

					if (folderId) {
						if (
							!instance._searchContainer.select ||
							selectedItems.indexOf(
								dropTarget.one('input[type=checkbox]')
							)
						) {
							const form = instance.get('form').node;

							form.get(namespace + 'newFolderId').val(folderId);

							instance._processAction(
								'move',
								instance.get('moveEntryUrl')
							);
						}
					}
				},

				_moveToTrash() {
					const instance = this;

					instance._processAction(
						'move_to_trash',
						instance.get('editEntryUrl')
					);
				},

				_processAction(action, url, redirectUrl) {
					const instance = this;

					const namespace = instance.NS;

					const form = instance.get('form').node;

					redirectUrl = redirectUrl || location.href;

					form.attr('method', instance.get('form').method);

					if (form.get(namespace + 'javax-portlet-action')) {
						form.get(namespace + 'javax-portlet-action').val(
							action
						);
					}
					else {
						form.get(namespace + 'cmd').val(action);
					}

					form.get(namespace + 'redirect').val(redirectUrl);

					submitForm(form, url);
				},

				initializer() {
					const instance = this;

					const namespace = instance.NS;

					const searchContainer = Liferay.SearchContainer.get(
						namespace + instance.get('searchContainerId')
					);

					searchContainer.registerAction(
						'move-to-folder',
						A.bind('_moveToFolder', instance)
					);
					searchContainer.registerAction(
						'move-to-trash',
						A.bind('_moveToTrash', instance)
					);

					instance._searchContainer = searchContainer;
				},
			},
		});

		Liferay.Portlet.Bookmarks = Bookmarks;
	},
	'',
	{
		requires: ['liferay-portlet-base'],
	}
);
