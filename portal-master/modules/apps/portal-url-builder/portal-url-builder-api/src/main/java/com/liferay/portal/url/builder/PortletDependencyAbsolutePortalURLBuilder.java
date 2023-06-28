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

package com.liferay.portal.url.builder;

import com.liferay.portal.url.builder.facet.BuildableAbsolutePortalURLBuilder;
import com.liferay.portal.url.builder.facet.CDNAwareAbsolutePortalURLBuilder;

/**
 * Builds a portlet dependency URL.
 *
 * <p>
 * Portlet dependency resources are retrieved from a configured CSS URN or JS
 * URN if present. (See
 * <code>com.liferay.portal.kernel.util.PropsKeys#PORTLET_DEPENDENCY_CSS_URN</code>
 * and <code>PropsKeys#PORTLET_DEPENDENCY_JAVASCRIPT_URN</code>).
 * </p>
 *
 * <p>
 * If neither are present, the resource is retrieved from a CDN host if
 * configured, or portal otherwise.
 * </p>
 *
 * @author Neil Griffin
 */
public interface PortletDependencyAbsolutePortalURLBuilder
	extends BuildableAbsolutePortalURLBuilder,
			CDNAwareAbsolutePortalURLBuilder
				<PortletDependencyAbsolutePortalURLBuilder> {
}