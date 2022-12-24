/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/2/23 9:58:47                            */
/*==============================================================*/


drop table if exists membership_delivery_address;

drop table if exists membership_member_level;

drop table if exists membership_member_level_detail;

drop table if exists membership_member_point;

drop table if exists membership_member_point_detail;

drop table if exists membership_user_account;

drop table if exists membership_user_detail;

/*==============================================================*/
/* Table: membership_delivery_address                           */
/*==============================================================*/
create table membership_delivery_address
(
    id                   bigint not null auto_increment comment '??',
    user_account_id      bigint not null comment '????????',
    province             varchar(1024) not null comment '?',
    city                 varchar(1024) not null comment '?',
    district             varchar(1024) not null comment '?',
    consignee            varchar(1024) not null comment '???',
    address              varchar(1024) not null comment '????',
    cell_phone_number    varchar(1024) not null comment '???????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table membership_delivery_address comment '??????????';

/*==============================================================*/
/* Table: membership_member_level                               */
/*==============================================================*/
create table membership_member_level
(
    id                   bigint not null auto_increment comment '??',
    user_account_id      bigint not null comment '????????',
    growth_value         bigint not null comment '???',
    member_level         tinyint not null comment '??????1???1??2??3??4?',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table membership_member_level comment '??????????';

/*==============================================================*/
/* Table: membership_member_level_detail                        */
/*==============================================================*/
create table membership_member_level_detail
(
    id                   bigint not null auto_increment comment '??',
    member_level_id      bigint not null comment '??????ID',
    old_growth_value     bigint not null comment '??????????',
    updated_growth_value bigint not null comment '??????????',
    new_growth_value     bigint not null comment '??????????',
    old_member_level     tinyint not null comment '???????????',
    new_member_level     tinyint not null comment '??????????',
    update_reason        varchar(1024) not null comment '????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table membership_member_level_detail comment '??????????';

/*==============================================================*/
/* Table: membership_member_point                               */
/*==============================================================*/
create table membership_member_point
(
    id                   bigint not null auto_increment comment '??',
    user_account_id      bigint not null comment '????ID',
    member_point         bigint not null comment '????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table membership_member_point comment '??????????';

/*==============================================================*/
/* Table: membership_member_point_detail                        */
/*==============================================================*/
create table membership_member_point_detail
(
    id                   bigint not null auto_increment comment '??',
    member_point_id      bigint not null comment '????ID',
    old_member_point     longtext not null comment '???????????',
    updated_member_point bigint not null comment '?????????',
    new_member_point     bigint not null comment '???????????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    update_reason        varchar(1024) not null comment '?????????',
    primary key (id)
);

alter table membership_member_point_detail comment '??????????';

/*==============================================================*/
/* Table: membership_user_account                               */
/*==============================================================*/
create table membership_user_account
(
    id                   bigint not null auto_increment comment '??',
    username             varchar(1024) not null comment '???',
    password             varchar(1024) not null comment '??',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table membership_user_account comment '???????????';

/*==============================================================*/
/* Table: membership_user_detail                                */
/*==============================================================*/
create table membership_user_detail
(
    id                   bigint not null auto_increment comment '??',
    register_time        datetime not null comment '????',
    cell_phone_number    varchar(1024) comment '???',
    gender               tinyint comment '???1???2??',
    birthday             datetime comment '??',
    email                varchar(1024) comment '??',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);
