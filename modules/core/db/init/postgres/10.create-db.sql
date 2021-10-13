CREATE TABLE EXT_OWNERSHIP(
ID uuid,
CREATE_TS TIMESTAMP,
CREATED_BY VARCHAR(50),
VERSION INTEGER,
UPDATE_TS TIMESTAMP,
UPDATED_BY VARCHAR(50),
DELETE_TS TIMESTAMP,
DELETED_BY VARCHAR(50),
NAME VARCHAR(100),
CODE VARCHAR(50) NOT NULL,
PRIMARY KEY(ID)
)^

INSERT INTO SEC_PERMISSION (ID,CREATE_TS,CREATED_BY,VERSION,UPDATE_TS,UPDATED_BY,DELETE_TS,DELETED_BY,PERMISSION_TYPE,TARGET,VALUE,ROLE_ID)
VALUES(NEWID(),NOW(),'SYSTEM',1,NOW(),NULL,NULL,NULL,20,'ext$Ownership:create',0,(select id from sec_role where name = 'SimpleUser'));
INSERT INTO SEC_PERMISSION (ID,CREATE_TS,CREATED_BY,VERSION,UPDATE_TS,UPDATED_BY,DELETE_TS,DELETED_BY,PERMISSION_TYPE,TARGET,VALUE,ROLE_ID)
VALUES(NEWID(),NOW(),'SYSTEM',1,NOW(),NULL,NULL,NULL,20,'ext$Ownership:update',0,(select id from sec_role where name = 'SimpleUser'));
INSERT INTO SEC_PERMISSION (ID,CREATE_TS,CREATED_BY,VERSION,UPDATE_TS,UPDATED_BY,DELETE_TS,DELETED_BY,PERMISSION_TYPE,TARGET,VALUE,ROLE_ID)
VALUES(NEWID(),NOW(),'SYSTEM',1,NOW(),NULL,NULL,NULL,20,'ext$Ownership:delete',0,(select id from sec_role where name = 'SimpleUser'));
INSERT INTO SEC_PERMISSION (ID,CREATE_TS,CREATED_BY,VERSION,UPDATE_TS,UPDATED_BY,DELETE_TS,DELETED_BY,PERMISSION_TYPE,TARGET,VALUE,ROLE_ID)
VALUES(NEWID(),NOW(),'SYSTEM',1,NOW(),NULL,NULL,NULL,20,'ext$Ownership:create',0,(select id from sec_role where name = 'ReferenceEditor'));
INSERT INTO SEC_PERMISSION (ID,CREATE_TS,CREATED_BY,VERSION,UPDATE_TS,UPDATED_BY,DELETE_TS,DELETED_BY,PERMISSION_TYPE,TARGET,VALUE,ROLE_ID)
VALUES(NEWID(),NOW(),'SYSTEM',1,NOW(),NULL,NULL,NULL,20,'ext$Ownership:update',0,(select id from sec_role where name = 'ReferenceEditor'));
INSERT INTO SEC_PERMISSION (ID,CREATE_TS,CREATED_BY,VERSION,UPDATE_TS,UPDATED_BY,DELETE_TS,DELETED_BY,PERMISSION_TYPE,TARGET,VALUE,ROLE_ID)
VALUES(NEWID(),NOW(),'SYSTEM',1,NOW(),NULL,NULL,NULL,20,'ext$Ownership:delete',0,(select id from sec_role where name = 'ReferenceEditor'))^


--end EXT_OWNERSHIP
--begin DF_COMPANY
alter table DF_COMPANY add column OWNERSHIP_ID uuid^
--end DF_COMPANY