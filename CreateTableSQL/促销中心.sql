/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/2/23 10:07:29                           */
/*==============================================================*/


drop table if exists promotion_activity;

drop table if exists promotion_activity_goods_sku_relationship;

drop table if exists promotion_coupon;

drop table if exists promotion_coupon_achieve;

/*==============================================================*/
/* Table: promotion_activity                                    */
/*==============================================================*/
create table promotion_activity
(
    id                   bigint not null auto_increment comment '??',
    promotion_activity_name varchar(1024) not null comment '??????',
    promotion_activity_start_time datetime not null comment '????????',
    promotion_activity_end_time datetime not null comment '????????',
    promotion_activity_comment varchar(1024) not null comment '????????',
    promotion_activity_status tinyint not null comment '????????1????2???',
    promotion_activity_rule varchar(1024) not null comment '???????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table promotion_activity comment '?????';

/*==============================================================*/
/* Table: promotion_activity_goods_sku_relationship             */
/*==============================================================*/
create table promotion_activity_goods_sku_relationship
(
    id                   bigint not null auto_increment comment '??',
    promotion_activity_id bigint not null comment '????ID',
    goods_id             bigint not null comment '???????sku?ID?????????????-1???????????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table promotion_activity_goods_sku_relationship comment '???????sku?????';

/*==============================================================*/
/* Table: promotion_coupon                                      */
/*==============================================================*/
create table promotion_coupon
(
    id                   bigint not null auto_increment comment '??',
    coupon_name          varchar(1024) not null comment '?????',
    coupon_type          tinyint not null comment '??????1?????2????',
    coupon_rule          varchar(1024) not null comment '?????',
    valid_start_time     datetime not null comment '???????',
    valid_end_time       datetime not null comment '???????',
    coupon_count         bigint not null comment '???????',
    coupon_received_count bigint not null comment '??????????',
    coupon_receive_type  tinyint not null comment '????????1????????2??????3?????',
    coupon_status        tinyint not null comment '??????1?????2?????3???',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table promotion_coupon comment '????';

/*==============================================================*/
/* Table: promotion_coupon_achieve                              */
/*==============================================================*/
create table promotion_coupon_achieve
(
    id                   bigint not null auto_increment comment '??',
    coupon_id            bigint not null comment '???ID',
    user_account_id      bigint not null comment '????ID',
    is_used              tinyint not null comment '???????????1?????0????',
    used_time            datetime,
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table promotion_coupon_achieve comment '????????';
