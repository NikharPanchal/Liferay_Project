/* eslint-disable no-undef */
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

const div = fragmentElement.querySelector('div');
const chart = bb.generate({
	axis: {
		x: {
			tick: {
				format: '%b',
			},
			type: 'timeseries',
		},
	},
	bindto: div,
	data: {
		columns: JSON.parse(configuration.data),
		x: 'x',
	},
	grid: {
		x: {
			show: true,
		},
		y: {
			show: true,
		},
	},
	regions: [
		{
			axis: 'x',
			class: 'regionX',
			start: '2020-09-1',
		},
	],
});

chart.data.colors({
	'Category 1': '#FFB68D',
	'Category 2': '#B0DEFF',
	'Category 3': '#AD93EF',
	'Category 4': '#4BC286',
	'Category 5': '#F5B3EF',
});
