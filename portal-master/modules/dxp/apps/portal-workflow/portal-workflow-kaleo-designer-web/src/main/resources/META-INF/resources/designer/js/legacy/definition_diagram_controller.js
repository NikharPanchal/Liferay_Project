/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 */

AUI.add(
	'liferay-kaleo-designer-definition-diagram-controller',
	() => {
		const XMLDefinition = Liferay.KaleoDesignerXMLDefinition;

		const jsonParse = Liferay.KaleoDesignerUtils.jsonParse;
		const serializeDefinition =
			Liferay.KaleoDesignerXMLDefinitionSerializer;
		const uniformRandomInt = Liferay.KaleoDesignerUtils.uniformRandomInt;

		const FieldNormalizer = Liferay.KaleoDesignerFieldNormalizer;

		const DEFAULT_LANGUAGE = 'groovy';

		const DefinitionDiagramController = function (content, canvas) {
			const instance = this;

			instance.definition = new XMLDefinition({
				value: content,
			});

			instance.canvas = canvas;
		};

		DefinitionDiagramController.prototype = {
			_getRandomXY() {
				const instance = this;

				const region = instance.canvas.get('region');

				return [
					uniformRandomInt(0, region.width - 100),
					uniformRandomInt(0, region.height - 100),
				];
			},

			getConnectors() {
				const instance = this;

				const connectors = [];

				instance.definition.forEachField((tagName, fieldData) => {
					fieldData.results.forEach((item1) => {
						item1.transitions.forEach((item2) => {
							connectors.push({
								connector: {
									default: item2.default,
									name: item2.name,
								},
								source: item1.name,
								target: item2.target,
							});
						});
					});
				});

				return connectors;
			},

			getFields() {
				const instance = this;

				const fields = [];

				instance.definition.forEachField((tagName, fieldData) => {
					fieldData.results.forEach((item) => {
						let type = tagName;

						if (item.initial) {
							type = 'start';
						}

						let metadata = jsonParse(item.metadata);

						if (metadata) {
							if (metadata.terminal) {
								type = 'end';
							}
						}
						else {
							metadata = {
								xy: instance._getRandomXY(),
							};
						}

						fields.push({
							actions: FieldNormalizer.normalizeToActions(
								item.actions
							),
							assignments: FieldNormalizer.normalizeToAssignments(
								item.assignments
							),
							description: item.description,
							fields: [{}],
							initial: item.initial,
							metadata,
							name: item.name,
							notifications: FieldNormalizer.normalizeToNotifications(
								item.notifications
							),
							script: item.script,
							scriptLanguage:
								item.scriptLanguage || DEFAULT_LANGUAGE,
							taskTimers: FieldNormalizer.normalizeToTaskTimers(
								item.taskTimers
							),
							type,
							xy: metadata.xy,
						});
					});
				});

				return fields;
			},

			serializeDefinition(draftVersion, json) {
				const instance = this;

				const metadata = instance.definition.getAttrs([
					'description',
					'name',
				]);

				metadata.version =
					draftVersion || instance.definition.get('version');

				return serializeDefinition(
					instance.definition.get('xmlNamespace'),
					metadata,
					json
				);
			},
		};

		Liferay.KaleoDesignerDefinitionDiagramController = DefinitionDiagramController;
	},
	'',
	{
		requires: [
			'liferay-kaleo-designer-field-normalizer',
			'liferay-kaleo-designer-utils',
			'liferay-kaleo-designer-xml-definition',
			'liferay-kaleo-designer-xml-definition-serializer',
		],
	}
);
