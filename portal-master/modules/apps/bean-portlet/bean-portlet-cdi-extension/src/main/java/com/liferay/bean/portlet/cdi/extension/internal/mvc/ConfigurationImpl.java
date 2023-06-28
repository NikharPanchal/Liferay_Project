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

package com.liferay.bean.portlet.cdi.extension.internal.mvc;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;

import javax.ws.rs.RuntimeType;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Feature;

/**
 * @author Neil Griffin
 */
public class ConfigurationImpl implements Configuration {

	public static final String DEFAULT_VIEW_EXTENSION =
		"com.liferay.mvc.defaultViewExtension";

	public ConfigurationImpl(
		PortletConfig portletConfig, PortletContext portletContext) {

		Enumeration<String> enumeration = portletConfig.getInitParameterNames();

		while (enumeration.hasMoreElements()) {
			String initParameterName = enumeration.nextElement();

			_properties.put(
				initParameterName,
				portletConfig.getInitParameter(initParameterName));
		}

		enumeration = portletContext.getInitParameterNames();

		while (enumeration.hasMoreElements()) {
			String initParameterName = enumeration.nextElement();

			_properties.put(
				initParameterName,
				portletContext.getInitParameter(initParameterName));
		}

		if (!_properties.containsKey(DEFAULT_VIEW_EXTENSION)) {
			_properties.put(DEFAULT_VIEW_EXTENSION, "jsp");
		}
	}

	@Override
	public Set<Class<?>> getClasses() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<Class<?>, Integer> getContracts(Class<?> componentClass) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Object> getInstances() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<String, Object> getProperties() {
		return _properties;
	}

	@Override
	public Object getProperty(String name) {
		Map<String, Object> properties = getProperties();

		return properties.get(name);
	}

	@Override
	public Collection<String> getPropertyNames() {
		Map<String, Object> properties = getProperties();

		return properties.keySet();
	}

	@Override
	public RuntimeType getRuntimeType() {
		return RuntimeType.SERVER;
	}

	@Override
	public boolean isEnabled(Class<? extends Feature> featureClass) {
		return false;
	}

	@Override
	public boolean isEnabled(Feature feature) {
		return false;
	}

	@Override
	public boolean isRegistered(Class<?> componentClass) {
		return false;
	}

	@Override
	public boolean isRegistered(Object component) {
		return false;
	}

	private final Map<String, Object> _properties = new HashMap<>();

}