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

import {useMutation} from '@apollo/client';

import {DeleteCaseType} from '../../../graphql/mutations';
import {TestrayCaseType} from '../../../graphql/queries';
import useFormModal from '../../../hooks/useFormModal';
import i18n from '../../../i18n';

const useCaseTypeActions = () => {
	const [onDeleteCaseType] = useMutation(DeleteCaseType);

	const formModal = useFormModal();
	const modal = formModal.modal;

	return {
		actions: [
			{
				action: (item: TestrayCaseType) => modal.open(item),
				name: i18n.translate('edit'),
			},
			{
				action: ({id}: TestrayCaseType) =>
					onDeleteCaseType({variables: {id}})
						.then(() => modal.onSave())
						.catch(modal.onError),
				name: i18n.translate('delete'),
			},
		],
		formModal,
	};
};

export default useCaseTypeActions;
