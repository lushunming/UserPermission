/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     2016/4/10 11:02:12                           */
/*==============================================================*/

drop table t_role_task_rel ;
drop table t_user_role_rel ;
drop table t_role ;
drop table t_task ;
drop table t_user ;


/*==============================================================*/
/* Table: t_role                                                */
/*==============================================================*/
create table t_role (
   id                   SERIAL not null,
   name                 VARCHAR(100)         not null,
   description          VARCHAR(256)         null,
   level                INT4                 null,
   constraint PK_T_ROLE primary key (id)
);

comment on table t_role is
'角色表';

comment on column t_role.id is
'角色id';

comment on column t_role.name is
'角色名';

comment on column t_role.description is
'对角色的描述';

comment on column t_role.level is
'角色的级别，只有级别比较高的角色可以管理级别比较低的角色，数字越大，级别越高';

/*==============================================================*/
/* Table: t_role_task_rel                                       */
/*==============================================================*/
create table t_role_task_rel (
   role_id              INT4                 not null,
   task_id              INT4                 not null,
   constraint PK_T_ROLE_TASK_REL primary key (role_id, task_id)
);

comment on table t_role_task_rel is
'角色权限关系表';

comment on column t_role_task_rel.role_id is
'角色id';

comment on column t_role_task_rel.task_id is
'任务id';

/*==============================================================*/
/* Table: t_task                                                */
/*==============================================================*/
create table t_task (
   id                   SERIAL not null,
   name                 VARCHAR(100)         not null,
   url                  VARCHAR(100)         not null,
   description          VARCHAR(100)         null,
   constraint PK_T_TASK primary key (id)
);

comment on table t_task is
'任务表';

comment on column t_task.id is
'任务id';

comment on column t_task.name is
'任务名';

comment on column t_task.url is
'到达任务页面的URL';

comment on column t_task.description is
'任务描述';

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user (
   id                   SERIAL not null,
   loginName            VARCHAR(100)         not null,
   password             VARCHAR(100)         not null,
   status               INT4                 not null,
   constraint PK_T_USER primary key (id)
);

comment on table t_user is
'用户表';

comment on column t_user.id is
'用户ID';

comment on column t_user.loginName is
'登录名';

comment on column t_user.password is
'密码';

comment on column t_user.status is
'用户的状态 0 未审核1审核通过2审核未通过 ';

/*==============================================================*/
/* Table: t_user_role_rel                                       */
/*==============================================================*/
create table t_user_role_rel (
   user_id              INT4                 not null,
   role_id              INT4                 not null,
   constraint PK_T_USER_ROLE_REL primary key (user_id, role_id)
);

comment on table t_user_role_rel is
'用户角色关系表';

comment on column t_user_role_rel.user_id is
'用户id';

comment on column t_user_role_rel.role_id is
'角色id';

alter table t_role_task_rel
   add constraint FK_T_ROLE_T_REFERENCE_T_ROLE foreign key (role_id)
      references t_role (id)
      on delete restrict on update restrict;

alter table t_role_task_rel
   add constraint FK_T_ROLE_T_REFERENCE_T_TASK foreign key (task_id)
      references t_task (id)
      on delete restrict on update restrict;

alter table t_user_role_rel
   add constraint FK_T_USER_R_REFERENCE_T_USER foreign key (user_id)
      references t_user (id)
      on delete restrict on update restrict;

alter table t_user_role_rel
   add constraint FK_T_USER_R_REFERENCE_T_ROLE foreign key (role_id)
      references t_role (id)
      on delete restrict on update restrict;

