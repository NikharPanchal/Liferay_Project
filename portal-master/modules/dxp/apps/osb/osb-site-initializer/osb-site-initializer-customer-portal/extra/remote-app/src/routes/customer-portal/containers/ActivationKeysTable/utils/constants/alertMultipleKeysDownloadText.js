/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 */

import {ALERT_DOWNLOAD_TYPE} from '../../../../utils/constants/alertDownloadType';

export const ALERT_ACTIVATION_MULTIPLE_KEYS_DOWNLOAD_TEXT = {
	[ALERT_DOWNLOAD_TYPE.danger]:
		'Unable to download keys as zip file, please try again.',
	[ALERT_DOWNLOAD_TYPE.success]:
		'Activation Key(s) was downloaded successfully as zip file.',
};
