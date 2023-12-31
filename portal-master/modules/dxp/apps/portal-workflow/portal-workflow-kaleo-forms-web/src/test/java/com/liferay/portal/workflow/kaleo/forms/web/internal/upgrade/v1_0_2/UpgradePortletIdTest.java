/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.portal.workflow.kaleo.forms.web.internal.upgrade.v1_0_2;

import com.liferay.portal.kernel.test.util.PropsTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.test.rule.LiferayUnitTestRule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Inácio Nery
 */
public class UpgradePortletIdTest {

	@ClassRule
	@Rule
	public static final LiferayUnitTestRule liferayUnitTestRule =
		LiferayUnitTestRule.INSTANCE;

	@BeforeClass
	public static void setUpClass() {
		PropsTestUtil.setProps(
			HashMapBuilder.<String, Object>put(
				PropsKeys.UPGRADE_CONCURRENT_FETCH_SIZE, "1000"
			).build());
	}

	@Before
	public void setUp() throws Exception {
		_upgradePortletId = new UpgradePortletId();
	}

	@Test
	public void testOldTypeSettingsShouldBeUpdate1() {
		String oldTypeSettings =
			"column-1=1_WAR_kaleoformsportlet,\ncolumn-2=" + _PORTLET_KEY;

		String newTypeSettings = _upgradePortletId.getNewTypeSettings(
			oldTypeSettings, "1_WAR_kaleoformsportlet");

		String expectedTypeSettings = "column-2=" + _PORTLET_KEY + "\n";

		Assert.assertEquals(expectedTypeSettings, newTypeSettings);
	}

	@Test
	public void testOldTypeSettingsShouldBeUpdate2() {
		String oldTypeSettings =
			"column-1=" + _PORTLET_KEY + ",\ncolumn-2=1_WAR_kaleoformsportlet";

		String newTypeSettings = _upgradePortletId.getNewTypeSettings(
			oldTypeSettings, "1_WAR_kaleoformsportlet");

		String expectedTypeSettings = "column-1=" + _PORTLET_KEY + ",\n";

		Assert.assertEquals(expectedTypeSettings, newTypeSettings);
	}

	private static final String _PORTLET_KEY = RandomTestUtil.randomString();

	private UpgradePortletId _upgradePortletId;

}