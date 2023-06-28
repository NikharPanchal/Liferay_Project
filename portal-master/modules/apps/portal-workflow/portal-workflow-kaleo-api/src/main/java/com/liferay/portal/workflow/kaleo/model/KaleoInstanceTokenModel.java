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

package com.liferay.portal.workflow.kaleo.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the KaleoInstanceToken service. Represents a row in the &quot;KaleoInstanceToken&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.portal.workflow.kaleo.model.impl.KaleoInstanceTokenModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.portal.workflow.kaleo.model.impl.KaleoInstanceTokenImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoInstanceToken
 * @generated
 */
@ProviderType
public interface KaleoInstanceTokenModel
	extends BaseModel<KaleoInstanceToken>, GroupedModel, MVCCModel,
			ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a kaleo instance token model instance should use the {@link KaleoInstanceToken} interface instead.
	 */

	/**
	 * Returns the primary key of this kaleo instance token.
	 *
	 * @return the primary key of this kaleo instance token
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this kaleo instance token.
	 *
	 * @param primaryKey the primary key of this kaleo instance token
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this kaleo instance token.
	 *
	 * @return the mvcc version of this kaleo instance token
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this kaleo instance token.
	 *
	 * @param mvccVersion the mvcc version of this kaleo instance token
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the kaleo instance token ID of this kaleo instance token.
	 *
	 * @return the kaleo instance token ID of this kaleo instance token
	 */
	public long getKaleoInstanceTokenId();

	/**
	 * Sets the kaleo instance token ID of this kaleo instance token.
	 *
	 * @param kaleoInstanceTokenId the kaleo instance token ID of this kaleo instance token
	 */
	public void setKaleoInstanceTokenId(long kaleoInstanceTokenId);

	/**
	 * Returns the group ID of this kaleo instance token.
	 *
	 * @return the group ID of this kaleo instance token
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this kaleo instance token.
	 *
	 * @param groupId the group ID of this kaleo instance token
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this kaleo instance token.
	 *
	 * @return the company ID of this kaleo instance token
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this kaleo instance token.
	 *
	 * @param companyId the company ID of this kaleo instance token
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this kaleo instance token.
	 *
	 * @return the user ID of this kaleo instance token
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this kaleo instance token.
	 *
	 * @param userId the user ID of this kaleo instance token
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this kaleo instance token.
	 *
	 * @return the user uuid of this kaleo instance token
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this kaleo instance token.
	 *
	 * @param userUuid the user uuid of this kaleo instance token
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this kaleo instance token.
	 *
	 * @return the user name of this kaleo instance token
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this kaleo instance token.
	 *
	 * @param userName the user name of this kaleo instance token
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this kaleo instance token.
	 *
	 * @return the create date of this kaleo instance token
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this kaleo instance token.
	 *
	 * @param createDate the create date of this kaleo instance token
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this kaleo instance token.
	 *
	 * @return the modified date of this kaleo instance token
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this kaleo instance token.
	 *
	 * @param modifiedDate the modified date of this kaleo instance token
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the kaleo definition ID of this kaleo instance token.
	 *
	 * @return the kaleo definition ID of this kaleo instance token
	 */
	public long getKaleoDefinitionId();

	/**
	 * Sets the kaleo definition ID of this kaleo instance token.
	 *
	 * @param kaleoDefinitionId the kaleo definition ID of this kaleo instance token
	 */
	public void setKaleoDefinitionId(long kaleoDefinitionId);

	/**
	 * Returns the kaleo definition version ID of this kaleo instance token.
	 *
	 * @return the kaleo definition version ID of this kaleo instance token
	 */
	public long getKaleoDefinitionVersionId();

	/**
	 * Sets the kaleo definition version ID of this kaleo instance token.
	 *
	 * @param kaleoDefinitionVersionId the kaleo definition version ID of this kaleo instance token
	 */
	public void setKaleoDefinitionVersionId(long kaleoDefinitionVersionId);

	/**
	 * Returns the kaleo instance ID of this kaleo instance token.
	 *
	 * @return the kaleo instance ID of this kaleo instance token
	 */
	public long getKaleoInstanceId();

	/**
	 * Sets the kaleo instance ID of this kaleo instance token.
	 *
	 * @param kaleoInstanceId the kaleo instance ID of this kaleo instance token
	 */
	public void setKaleoInstanceId(long kaleoInstanceId);

	/**
	 * Returns the parent kaleo instance token ID of this kaleo instance token.
	 *
	 * @return the parent kaleo instance token ID of this kaleo instance token
	 */
	public long getParentKaleoInstanceTokenId();

	/**
	 * Sets the parent kaleo instance token ID of this kaleo instance token.
	 *
	 * @param parentKaleoInstanceTokenId the parent kaleo instance token ID of this kaleo instance token
	 */
	public void setParentKaleoInstanceTokenId(long parentKaleoInstanceTokenId);

	/**
	 * Returns the current kaleo node ID of this kaleo instance token.
	 *
	 * @return the current kaleo node ID of this kaleo instance token
	 */
	public long getCurrentKaleoNodeId();

	/**
	 * Sets the current kaleo node ID of this kaleo instance token.
	 *
	 * @param currentKaleoNodeId the current kaleo node ID of this kaleo instance token
	 */
	public void setCurrentKaleoNodeId(long currentKaleoNodeId);

	/**
	 * Returns the current kaleo node name of this kaleo instance token.
	 *
	 * @return the current kaleo node name of this kaleo instance token
	 */
	@AutoEscape
	public String getCurrentKaleoNodeName();

	/**
	 * Sets the current kaleo node name of this kaleo instance token.
	 *
	 * @param currentKaleoNodeName the current kaleo node name of this kaleo instance token
	 */
	public void setCurrentKaleoNodeName(String currentKaleoNodeName);

	/**
	 * Returns the class name of this kaleo instance token.
	 *
	 * @return the class name of this kaleo instance token
	 */
	@AutoEscape
	public String getClassName();

	/**
	 * Sets the class name of this kaleo instance token.
	 *
	 * @param className the class name of this kaleo instance token
	 */
	public void setClassName(String className);

	/**
	 * Returns the class pk of this kaleo instance token.
	 *
	 * @return the class pk of this kaleo instance token
	 */
	public long getClassPK();

	/**
	 * Sets the class pk of this kaleo instance token.
	 *
	 * @param classPK the class pk of this kaleo instance token
	 */
	public void setClassPK(long classPK);

	/**
	 * Returns the completed of this kaleo instance token.
	 *
	 * @return the completed of this kaleo instance token
	 */
	public boolean getCompleted();

	/**
	 * Returns <code>true</code> if this kaleo instance token is completed.
	 *
	 * @return <code>true</code> if this kaleo instance token is completed; <code>false</code> otherwise
	 */
	public boolean isCompleted();

	/**
	 * Sets whether this kaleo instance token is completed.
	 *
	 * @param completed the completed of this kaleo instance token
	 */
	public void setCompleted(boolean completed);

	/**
	 * Returns the completion date of this kaleo instance token.
	 *
	 * @return the completion date of this kaleo instance token
	 */
	public Date getCompletionDate();

	/**
	 * Sets the completion date of this kaleo instance token.
	 *
	 * @param completionDate the completion date of this kaleo instance token
	 */
	public void setCompletionDate(Date completionDate);

	@Override
	public KaleoInstanceToken cloneWithOriginalValues();

}