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

package com.liferay.petra.sql.dsl.spi.expression;

import com.liferay.petra.sql.dsl.ast.ASTNodeListener;
import com.liferay.petra.sql.dsl.expression.Alias;
import com.liferay.petra.sql.dsl.expression.Expression;
import com.liferay.petra.sql.dsl.spi.ast.BaseASTNode;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author Preston Crary
 */
public class DefaultAlias<T>
	extends BaseASTNode implements Alias<T>, DefaultExpression<T> {

	public DefaultAlias(Expression<T> expression, String name) {
		_expression = Objects.requireNonNull(expression);
		_name = Objects.requireNonNull(name);
	}

	@Override
	public Expression<T> getExpression() {
		return _expression;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	protected void doToSQL(
		Consumer<String> consumer, ASTNodeListener astNodeListener) {

		consumer.accept(_name);
	}

	private final Expression<T> _expression;
	private final String _name;

}