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

import ClayLayout from '@clayui/layout';
import React from 'react';

export default function ResultsBar({
	children,
	...otherProps
}: React.HTMLAttributes<HTMLElement>) {
	return (
		<nav
			{...otherProps}
			className="subnav-tbar subnav-tbar-primary tbar tbar-inline-xs-down"
		>
			<ClayLayout.ContainerFluid>
				<ul className="tbar-nav tbar-nav-wrap">{children}</ul>
			</ClayLayout.ContainerFluid>
		</nav>
	);
}
