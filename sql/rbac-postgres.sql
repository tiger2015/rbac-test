/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2023/9/2 13:01:57                            */
/*==============================================================*/


drop table sys_menu;

drop table sys_permission;

drop table sys_role;

drop table sys_role_permission;

drop table sys_user;

drop table sys_user_role;

/*==============================================================*/
/* Table: sys_menu                                              */
/*==============================================================*/
create table sys_menu (
   id                   SERIAL               not null,
   name                 VARCHAR(64)          null,
   path                 VARCHAR(128)         null,
   sort                 INT4                 null,
   icon                 VARCHAR(256)         null,
   pid                  INT4                 null,
   permission           INT4                 null,
   create_time          TIMESTAMP            null,
   mod_time             TIMESTAMP            null,
   is_deleted           INT2                 null default 0,
   constraint PK_SYS_MENU primary key (id),
   constraint AK_NAME_SYS_MENU unique (name),
   constraint AK_PATH_SYS_MENU unique (path)
);

/*==============================================================*/
/* Table: sys_permission                                        */
/*==============================================================*/
create table sys_permission (
   id                   SERIAL not null,
   name                 VARCHAR(128)         not null,
   perms                VARCHAR(128)         null,
   pid                  INT4                 null,
   "order"              INT4                 null,
   description          TEXT                 null,
   create_time          TIMESTAMP            null default CURRENT_TIMESTAMP,
   mod_time             TIMESTAMP            null,
   is_deleted           INT2                 null default 0,
   constraint PK_SYS_PERMISSION primary key (id),
   constraint AK_NAME_SYS_PERM unique (name)
);

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role (
   id                   SERIAL not null,
   name                 VARCHAR(16)          null,
   code                 VARCHAR(32)          null,
   description          TEXT                 null,
   create_time          TIMESTAMP            null default CURRENT_TIMESTAMP,
   mod_time             TIMESTAMP            null,
   is_deleted           INT2                 null default 0,
   constraint PK_SYS_ROLE primary key (id),
   constraint AK_NAME_SYS_ROLE unique (name)
);

/*==============================================================*/
/* Table: sys_role_permission                                   */
/*==============================================================*/
create table sys_role_permission (
   role_id              INT4                 not null,
   permission_id        INT4                 not null,
   create_time          TIMESTAMP            null default CURRENT_TIMESTAMP,
   mod_time             TIMESTAMP            null,
   constraint PK_SYS_ROLE_PERMISSION primary key (role_id, permission_id)
);

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user (
   id                   SERIAL not null,
   name                 VARCHAR(16)          not null,
   password             VARCHAR(64)          not null,
   salt                 VARCHAR(32)          null,
   create_time          TIMESTAMP            null default CURRENT_TIMESTAMP,
   mod_time             TIMESTAMP            null,
   is_deleted           INT2                 null default 0,
   constraint PK_SYS_USER primary key (id),
   constraint AK_NAME_SYS_USER unique (name)
);

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role (
   user_id              INT8                 not null,
   role_id              INT4                 not null,
   create_time          TIMESTAMP            null,
   mod_time             TIMESTAMP            null,
   constraint PK_SYS_USER_ROLE primary key (user_id, role_id)
);

alter table sys_menu
   add constraint FK_SYS_MENU_REFERENCE_SYS_PERM foreign key (permission)
      references sys_permission (id)
      on delete set null on update cascade;

alter table sys_menu
   add constraint FK_SYS_MENU_REFERENCE_SYS_MENU foreign key (pid)
      references sys_menu (id)
      on delete set null on update cascade;

alter table sys_permission
   add constraint FK_SYS_PERM_PRIVILEGE_SYS_PERM foreign key (pid)
      references sys_permission (id)
      on delete set null on update cascade;

alter table sys_role_permission
   add constraint FK_SYS_ROLE_ROLE_PRIV_SYS_PERM foreign key (permission_id)
      references sys_permission (id)
      on delete cascade on update cascade;

alter table sys_role_permission
   add constraint FK_SYS_ROLE_ROLE_PRIV_SYS_ROLE foreign key (role_id)
      references sys_role (id)
      on delete cascade on update cascade;

alter table sys_user_role
   add constraint FK_SYS_USER_USER_ROLE_SYS_ROLE foreign key (role_id)
      references sys_role (id)
      on delete cascade on update cascade;

alter table sys_user_role
   add constraint FK_SYS_USER_USER_ROLE_SYS_USER foreign key (user_id)
      references sys_user (id)
      on delete cascade on update cascade;

