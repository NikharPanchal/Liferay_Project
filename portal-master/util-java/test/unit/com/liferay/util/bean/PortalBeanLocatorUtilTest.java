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

package com.liferay.util.bean;

import com.liferay.portal.kernel.bean.BeanLocator;
import com.liferay.portal.kernel.bean.BeanLocatorException;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.test.log.LogCapture;
import com.liferay.portal.test.log.LogEntry;
import com.liferay.portal.test.log.LoggerTestUtil;

import java.util.List;
import java.util.logging.Level;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;

/**
 * @author Miguel Pastor
 */
public class PortalBeanLocatorUtilTest {

	@After
	public void tearDown() {
		PortalBeanLocatorUtil.setBeanLocator(null);
	}

	@Test
	public void testBeanLocatorHasNotBeenSet() {
		try (LogCapture logCapture = LoggerTestUtil.configureJDKLogger(
				PortalBeanLocatorUtil.class.getName(), Level.SEVERE)) {

			try {
				PortalBeanLocatorUtil.locate("beanName");

				Assert.fail();
			}
			catch (BeanLocatorException beanLocatorException) {
				Assert.assertEquals(
					"BeanLocator is not set",
					beanLocatorException.getMessage());

				List<LogEntry> logEntries = logCapture.getLogEntries();

				Assert.assertEquals(
					logEntries.toString(), 1, logEntries.size());

				LogEntry logEntry = logEntries.get(0);

				Assert.assertEquals(
					"BeanLocator is null", logEntry.getMessage());
			}
		}
	}

	@Test
	public void testLocateExistingBean() {
		Mockito.when(
			_beanLocator.locate("existingBean")
		).thenReturn(
			new String("existingBean")
		);

		PortalBeanLocatorUtil.setBeanLocator(_beanLocator);

		String bean = (String)PortalBeanLocatorUtil.locate("existingBean");

		Assert.assertNotNull(bean);
		Assert.assertEquals("existingBean", bean);

		Mockito.verify(
			_beanLocator, Mockito.times(1)
		).locate(
			"existingBean"
		);
	}

	@Test
	public void testLocateNonexistingBean() {
		Mockito.when(
			_beanLocator.locate("nonExistingBean")
		).thenReturn(
			null
		);

		PortalBeanLocatorUtil.setBeanLocator(_beanLocator);

		String bean = (String)PortalBeanLocatorUtil.locate("nonExistingBean");

		Assert.assertNull(bean);

		Mockito.verify(
			_beanLocator, Mockito.times(1)
		).locate(
			"nonExistingBean"
		);
	}

	private final BeanLocator _beanLocator = Mockito.mock(BeanLocator.class);

}