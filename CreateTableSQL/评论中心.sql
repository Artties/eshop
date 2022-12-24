/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/2/23 10:05:53                           */
/*==============================================================*/


drop table if exists comment_aggregate;

drop table if exists comment_info;

drop table if exists comment_picture;

/*==============================================================*/
/* Table: comment_aggregate                                     */
/*==============================================================*/
create table comment_aggregate
(
    id                   bigint not null auto_increment comment '??',
    goods_id             bigint not null comment '??ID',
    total_comment_count  bigint not null comment '?????',
    good_comment_count   bigint not null comment '????',
    good_comment_rate    decimal(8,2) not null comment '???',
    show_pictures_comment_count bigint not null comment '??????',
    medium_comment_count bigint not null comment '????',
    bad_comment_count    bigint not null comment '????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table comment_aggregate comment '???????';

/*==============================================================*/
/* Table: comment_info                                          */
/*==============================================================*/
create table comment_info
(
    id                   bigint not null auto_increment comment '??',
    user_account_id      bigint not null comment '??????????ID',
    username             varchar(1024) not null comment '???',
    order_id             bigint not null comment '??ID',
    goods_id             bigint not null comment '??ID',
    goods_sku_id         bigint not null comment '??sku ID',
    goods_sku_sale_properties varchar(1024) not null comment '??sku?????',
    total_score          tinyint not null comment '????1~5',
    goods_score          tinyint not null comment '?????1~5',
    customer_service_score tinyint not null comment '?????1~5',
    logistics_score      tinyint not null comment '?????1~5',
    comment_content      varchar(1024) not null comment '????',
    is_show_pictures     tinyint not null comment '?????1????0????',
    is_default_comment   tinyint not null comment '?????????????1???????0???????',
    comment_status       tinyint not null comment '?????1?????2?????3???????4????',
    comment_type         tinyint not null comment '?????1???????4????2????3??3????1~2?',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table comment_info comment '?????';

/*==============================================================*/
/* Table: comment_picture                                       */
/*==============================================================*/
create table comment_picture
(
    id                   bigint not null auto_increment comment '??',
    comment_info_id      bigint not null comment '??ID',
    sequence             tinyint not null comment '????',
    comment_picture      longblob not null comment '????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table comment_picture comment '?????';
