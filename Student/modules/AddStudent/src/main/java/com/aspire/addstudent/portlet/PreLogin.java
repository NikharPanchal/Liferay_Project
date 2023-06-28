/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aspire.addstudent.portlet;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
//		"com.liferay.portlet.display-category=category.sample",
//		"com.liferay.portlet.instanceable=true",
//		"javax.portlet.security-role-ref=power-user,user",
//		"javax.portlet.display-name=PreLogin Portlet",
			"key=login.events.pre"
	},
	service = LifecycleAction.class
)
public class PreLogin implements LifecycleAction{

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		HttpServletRequest request = lifecycleEvent.getRequest();
		String method = request.getMethod();
		System.out.println(method);
		System.out.println("print before login");
	}
}