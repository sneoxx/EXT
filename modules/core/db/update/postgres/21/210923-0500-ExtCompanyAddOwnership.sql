--end EXT_OWNERSHIP
--begin DF_COMPANY
alter table DF_COMPANY add column OWNERSHIP_ID uuid^
--end DF_COMPANY

--begin DF_COMPANY
alter table DF_COMPANY add constraint FK_DF_COMPANY_OWNERSHIP_ID foreign key (OWNERSHIP_ID) references EXT_OWNERSHIP(ID)^
create index IDX_DF_COMPANY_OWNERSHIP on DF_COMPANY (OWNERSHIP_ID)^
--end DF_COMPANY
