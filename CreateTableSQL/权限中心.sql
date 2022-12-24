/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/2/23 9:46:47                            */
/*==============================================================*/


drop table if exists auth_account;

drop table if exists auth_account_priority_relationship;

drop table if exists auth_account_role_relationship;

drop table if exists auth_priority;

drop table if exists auth_role;

drop table if exists auth_role_priority_relationship;

/*==============================================================*/
/* Table: auth_account                                          */
/*==============================================================*/
create table auth_account
(
    id                   bigint not null auto_increment comment '??????',
    username             varchar(1024) not null comment '??????',
    password             tinyint not null comment '?????',
    employe_name         varchar(1024) not null comment '?????',
    account_comment      varchar(1024) comment '???????',
    is_enabled           tinyint not null default 1 comment '???????1????0????',
    gmt_create           datetime not null comment '???????',
    gmt_modified         datetime not null comment '???????',
    primary key (id)
);

alter table auth_account comment '??????????????????????????????????????????????????';

/*==============================================================*/
/* Table: auth_account_priority_relationship                    */
/*==============================================================*/
create table auth_account_priority_relationship
(
    id                   bigint not null auto_increment comment '??????',
    account_id           bigint not null comment '?????',
    priority_id          bigint not null comment '?????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table auth_account_priority_relationship comment '????????????????????????????????????';

/*==============================================================*/
/* Table: auth_account_role_relationship                        */
/*==============================================================*/
create table auth_account_role_relationship
(
    id                   bigint not null auto_increment comment '??????',
    account_id           bigint not null comment '?????',
    role_id              bigint not null comment '?????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table auth_account_role_relationship comment '????????????????????????????????????';

/*==============================================================*/
/* Table: auth_priority                                         */
/*==============================================================*/
create table auth_priority
(
    id                   bigint not null auto_increment comment '??????',
    code                 varchar(1024) not null comment '????',
    url                  varchar(1024) not null comment '???????URL',
    priority_comment     varchar(1024) comment '???????',
    priority_type        tinyint not null default 1 comment '?????1????2???',
    parent_id            bigint comment '??????',
    gmt_create           datetime not null comment '???????',
    gmt_modified         datetime not null comment '???????',
    primary key (id)
);

alter table auth_priority comment '???????????????????????URL??';

/*==============================================================*/
/* Table: auth_role                                             */
/*==============================================================*/
create table auth_role
(
    id                   bigint not null auto_increment comment '??????',
    code                 varchar(1024) not null comment '????',
    role_name            varchar(1024) not null comment '????',
    role_comment         varchar(1024) comment '???????',
    is_enabled           tinyint not null default 1 comment '???????1????0????',
    gmt_create           datetime not null comment '???????',
    gmt_modified         datetime not null comment '???????',
    primary key (id)
);

alter table auth_role comment '??????????????????????????';

/*==============================================================*/
/* Table: auth_role_priority_relationship                       */
/*==============================================================*/
create table auth_role_priority_relationship
(
    id                   bigint not null auto_increment comment '??????',
    priority_id          bigint not null comment '?????',
    role_id              bigint not null comment '?????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table auth_role_priority_relationship comment '????????????????????????????????????????????????';
