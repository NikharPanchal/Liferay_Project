create index IX_1E190683 on MBBan (banUserId, ctCollectionId);
create unique index IX_80F14E99 on MBBan (groupId, banUserId, ctCollectionId);
create index IX_B9873388 on MBBan (groupId, ctCollectionId);
create index IX_1B616E18 on MBBan (userId, ctCollectionId);
create index IX_D91D83D2 on MBBan (uuid_[$COLUMN_LENGTH:75$], companyId, ctCollectionId);
create index IX_5DB3B492 on MBBan (uuid_[$COLUMN_LENGTH:75$], ctCollectionId);
create unique index IX_6F119354 on MBBan (uuid_[$COLUMN_LENGTH:75$], groupId, ctCollectionId);

create index IX_194E0FD9 on MBCategory (categoryId, groupId, parentCategoryId, ctCollectionId);
create index IX_E88617BF on MBCategory (categoryId, groupId, parentCategoryId, status, ctCollectionId);
create index IX_FADEB62D on MBCategory (companyId, ctCollectionId);
create index IX_40852A13 on MBCategory (companyId, status, ctCollectionId);
create index IX_B4A1A06F on MBCategory (groupId, ctCollectionId);
create index IX_22F8EB66 on MBCategory (groupId, parentCategoryId, ctCollectionId);
create index IX_DCD7164C on MBCategory (groupId, parentCategoryId, status, ctCollectionId);
create index IX_DF62B255 on MBCategory (groupId, status, ctCollectionId);
create index IX_2541AACB on MBCategory (uuid_[$COLUMN_LENGTH:75$], companyId, ctCollectionId);
create index IX_52822F39 on MBCategory (uuid_[$COLUMN_LENGTH:75$], ctCollectionId);
create unique index IX_5DD5248D on MBCategory (uuid_[$COLUMN_LENGTH:75$], groupId, ctCollectionId);

create unique index IX_F4BC4496 on MBDiscussion (classNameId, classPK, ctCollectionId);
create unique index IX_393E413A on MBDiscussion (threadId, ctCollectionId);
create index IX_4C2D9FB5 on MBDiscussion (uuid_[$COLUMN_LENGTH:75$], companyId, ctCollectionId);
create index IX_383E288F on MBDiscussion (uuid_[$COLUMN_LENGTH:75$], ctCollectionId);
create unique index IX_3A2D4BF7 on MBDiscussion (uuid_[$COLUMN_LENGTH:75$], groupId, ctCollectionId);

create index IX_DF91F0AD on MBMailingList (active_, ctCollectionId);
create unique index IX_D626193B on MBMailingList (groupId, categoryId, ctCollectionId);
create index IX_B11BA1CC on MBMailingList (uuid_[$COLUMN_LENGTH:75$], companyId, ctCollectionId);
create index IX_161C8ED8 on MBMailingList (uuid_[$COLUMN_LENGTH:75$], ctCollectionId);
create unique index IX_212E7CE on MBMailingList (uuid_[$COLUMN_LENGTH:75$], groupId, ctCollectionId);

create index IX_860370AB on MBMessage (classNameId, classPK, ctCollectionId);
create index IX_19FE8691 on MBMessage (classNameId, classPK, status, ctCollectionId);
create index IX_5C8DA38E on MBMessage (companyId, ctCollectionId);
create index IX_9CE52674 on MBMessage (companyId, status, ctCollectionId);
create index IX_F0A963FD on MBMessage (groupId, categoryId, ctCollectionId);
create index IX_82ED07E3 on MBMessage (groupId, categoryId, status, ctCollectionId);
create index IX_AAAD4168 on MBMessage (groupId, categoryId, threadId, answer, ctCollectionId);
create index IX_158DD1B6 on MBMessage (groupId, categoryId, threadId, ctCollectionId);
create index IX_CC88AC9C on MBMessage (groupId, categoryId, threadId, status, ctCollectionId);
create index IX_A3E7210 on MBMessage (groupId, ctCollectionId);
create unique index IX_7BEA05A9 on MBMessage (groupId, externalReferenceCode[$COLUMN_LENGTH:75$], ctCollectionId);
create index IX_F6A852F6 on MBMessage (groupId, status, ctCollectionId);
create unique index IX_8813E901 on MBMessage (groupId, urlSubject[$COLUMN_LENGTH:255$], ctCollectionId);
create index IX_C892444A on MBMessage (groupId, userId, ctCollectionId);
create index IX_6C8B4B30 on MBMessage (groupId, userId, status, ctCollectionId);
create index IX_D6EAC68E on MBMessage (parentMessageId, ctCollectionId);
create index IX_C56F4974 on MBMessage (parentMessageId, status, ctCollectionId);
create index IX_E84A6B81 on MBMessage (threadId, answer, ctCollectionId);
create index IX_297F24CF on MBMessage (threadId, ctCollectionId);
create index IX_7A7FD535 on MBMessage (threadId, parentMessageId, ctCollectionId);
create index IX_A25D6B5 on MBMessage (threadId, status, ctCollectionId);
create index IX_93815565 on MBMessage (userId, classNameId, classPK, ctCollectionId);
create index IX_711114B on MBMessage (userId, classNameId, classPK, status, ctCollectionId);
create index IX_8B146CBA on MBMessage (userId, classNameId, ctCollectionId);
create index IX_1C5603A0 on MBMessage (userId, classNameId, status, ctCollectionId);
create index IX_3F043E90 on MBMessage (userId, ctCollectionId);
create index IX_F6B01E4A on MBMessage (uuid_[$COLUMN_LENGTH:75$], companyId, ctCollectionId);
create index IX_DAB8F51A on MBMessage (uuid_[$COLUMN_LENGTH:75$], ctCollectionId);
create unique index IX_EAF86BCC on MBMessage (uuid_[$COLUMN_LENGTH:75$], groupId, ctCollectionId);

create index IX_523B9129 on MBSuspiciousActivity (messageId, ctCollectionId);
create index IX_C17AAB9E on MBSuspiciousActivity (threadId, ctCollectionId);
create index IX_72C5BBAF on MBSuspiciousActivity (userId, messageId, ctCollectionId);
create index IX_191B6619 on MBSuspiciousActivity (uuid_[$COLUMN_LENGTH:75$], companyId, ctCollectionId);
create index IX_B5AC78AB on MBSuspiciousActivity (uuid_[$COLUMN_LENGTH:75$], ctCollectionId);
create unique index IX_A3E15B5B on MBSuspiciousActivity (uuid_[$COLUMN_LENGTH:75$], groupId, ctCollectionId);

create index IX_A1BB5EE8 on MBThread (categoryId, priority, ctCollectionId);
create index IX_93724410 on MBThread (groupId, categoryId, ctCollectionId);
create index IX_C25692A8 on MBThread (groupId, categoryId, lastPostDate, ctCollectionId);
create index IX_BFEA24F6 on MBThread (groupId, categoryId, status, ctCollectionId);
create index IX_ADE096A3 on MBThread (groupId, ctCollectionId);
create index IX_9B323489 on MBThread (groupId, status, ctCollectionId);
create index IX_75AA6913 on MBThread (lastPostDate, priority, ctCollectionId);
create index IX_2A7B1F29 on MBThread (rootMessageId, ctCollectionId);
create index IX_E3626F17 on MBThread (uuid_[$COLUMN_LENGTH:75$], companyId, ctCollectionId);
create index IX_DBB1226D on MBThread (uuid_[$COLUMN_LENGTH:75$], ctCollectionId);
create unique index IX_9DB28BD9 on MBThread (uuid_[$COLUMN_LENGTH:75$], groupId, ctCollectionId);

create index IX_91B1A4A8 on MBThreadFlag (threadId, ctCollectionId);
create index IX_F156E0A9 on MBThreadFlag (userId, ctCollectionId);
create unique index IX_B2386762 on MBThreadFlag (userId, threadId, ctCollectionId);
create index IX_ADF5B523 on MBThreadFlag (uuid_[$COLUMN_LENGTH:75$], companyId, ctCollectionId);
create index IX_AEED2BE1 on MBThreadFlag (uuid_[$COLUMN_LENGTH:75$], ctCollectionId);
create unique index IX_F437E4E5 on MBThreadFlag (uuid_[$COLUMN_LENGTH:75$], groupId, ctCollectionId);