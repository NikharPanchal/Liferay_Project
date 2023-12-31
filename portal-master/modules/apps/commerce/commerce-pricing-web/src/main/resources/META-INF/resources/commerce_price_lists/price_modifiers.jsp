<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
CommercePriceListDisplayContext commercePriceListDisplayContext = (CommercePriceListDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

long commercePriceListId = commercePriceListDisplayContext.getCommercePriceListId();
%>

<c:if test="<%= commercePriceListDisplayContext.hasPermission(commercePriceListId, ActionKeys.UPDATE) %>">
	<div class="pt-4">
		<frontend-data-set:classic-display
			contextParams='<%=
				HashMapBuilder.<String, String>put(
					"commercePriceListId", String.valueOf(commercePriceListId)
				).build()
			%>'
			creationMenu="<%= commercePriceListDisplayContext.getPriceModifiersCreationMenu() %>"
			dataProviderKey="<%= CommercePricingFDSNames.PRICE_MODIFIERS %>"
			formName="fm"
			id="<%= CommercePricingFDSNames.PRICE_MODIFIERS %>"
			itemsPerPage="<%= 10 %>"
			style="stacked"
		/>
	</div>
</c:if>