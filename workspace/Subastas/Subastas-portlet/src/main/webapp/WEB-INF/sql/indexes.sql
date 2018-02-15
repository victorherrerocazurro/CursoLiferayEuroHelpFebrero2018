create index IX_20661EA2 on SB_Puja (uuid_);
create index IX_511FCC46 on SB_Puja (uuid_, companyId);
create unique index IX_C69AAC48 on SB_Puja (uuid_, groupId);

create index IX_2726C2D7 on SB_Subasta (fechaFin);
create index IX_8FD825BF on SB_Subasta (uuid_);
create index IX_E1132109 on SB_Subasta (uuid_, companyId);
create unique index IX_45D255CB on SB_Subasta (uuid_, groupId);