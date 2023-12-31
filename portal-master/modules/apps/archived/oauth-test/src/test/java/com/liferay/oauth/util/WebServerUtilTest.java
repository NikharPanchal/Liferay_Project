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

package com.liferay.oauth.util;

import com.liferay.portal.kernel.util.Props;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.test.rule.LiferayUnitTestRule;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.mockito.Mockito;

/**
 * @author Igor Beslic
 */
public class WebServerUtilTest {

	@ClassRule
	@Rule
	public static final LiferayUnitTestRule liferayUnitTestRule =
		LiferayUnitTestRule.INSTANCE;

	@Test
	public void testNoWebServerGetOriginalURL() throws Exception {
		setUpPropsUtil(null, "-1", "-1");

		StringBuffer portalServerURL = new StringBuffer(
			"http://liferay.com:8080/path/to/resource");

		Assert.assertNull(WebServerUtil.getWebServerURL(portalServerURL));

		setUpPropsUtil("https", "-1", "-1");

		Assert.assertNull(WebServerUtil.getWebServerURL(portalServerURL));
	}

	@Test
	public void testProxyWebServerGetOriginalURL() throws Exception {
		setUpPropsUtil(null, "80", "-1");

		StringBuffer portalServerURL = new StringBuffer(
			"http://liferay.com:8080/path/to/resource");

		Assert.assertEquals(
			"http://liferay.com/path/to/resource",
			WebServerUtil.getWebServerURL(portalServerURL));

		setUpPropsUtil(null, "80", "443");

		Assert.assertEquals(
			"http://liferay.com/path/to/resource",
			WebServerUtil.getWebServerURL(portalServerURL));

		setUpPropsUtil(null, "9080", "443");

		Assert.assertEquals(
			"http://liferay.com:9080/path/to/resource",
			WebServerUtil.getWebServerURL(portalServerURL));

		portalServerURL = new StringBuffer(
			"https://liferay.com:8443/path/to/resource");

		setUpPropsUtil("https", "-1", "443");

		Assert.assertEquals(
			"https://liferay.com/path/to/resource",
			WebServerUtil.getWebServerURL(portalServerURL));

		setUpPropsUtil("https", "80", "443");

		Assert.assertEquals(
			"https://liferay.com/path/to/resource",
			WebServerUtil.getWebServerURL(portalServerURL));

		setUpPropsUtil("https", "80", "9443");

		Assert.assertEquals(
			"https://liferay.com:9443/path/to/resource",
			WebServerUtil.getWebServerURL(portalServerURL));
	}

	@Test
	public void testTerminateHTTPSWebServerGetOriginalURL() throws Exception {
		setUpPropsUtil("https", "80", "443");

		StringBuffer portalServerURL = new StringBuffer(
			"http://liferay.com:8080/path/to/resource");

		Assert.assertEquals(
			"https://liferay.com/path/to/resource",
			WebServerUtil.getWebServerURL(portalServerURL));
	}

	protected void setUpPropsUtil(
		String protocol, String httpPort, String httpsPort) {

		Props props = Mockito.mock(Props.class);

		PropsUtil.setProps(props);

		Mockito.when(
			props.get(PropsKeys.WEB_SERVER_PROTOCOL)
		).thenReturn(
			protocol
		);

		Mockito.when(
			props.get(PropsKeys.WEB_SERVER_HTTP_PORT)
		).thenReturn(
			httpPort
		);

		Mockito.when(
			props.get(PropsKeys.WEB_SERVER_HTTPS_PORT)
		).thenReturn(
			httpsPort
		);
	}

}