/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/2/23 9:50:10                            */
/*==============================================================*/


drop table if exists commodity_brand;

drop table if exists commodity_category;

drop table if exists commodity_category_property_relationship;

drop table if exists commodity_goods;

drop table if exists commodity_goods_desc;

drop table if exists commodity_goods_desc_picture;

drop table if exists commodity_goods_picture;

drop table if exists commodity_goods_proprety_group_value;

drop table if exists commodity_goods_proprety_value;

drop table if exists commodity_goods_sku;

drop table if exists commodity_goods_sku_property_value;

drop table if exists commodity_property;

drop table if exists commodity_property_group;

drop table if exists commodity_property_group_relationship;

/*==============================================================*/
/* Table: commodity_brand                                       */
/*==============================================================*/
create table commodity_brand
(
    id                   bigint not null auto_increment comment '??',
    brand_chinese_name   varchar(1024) not null comment '?????',
    brand_english_name   varchar(1024) not null comment '?????',
    brand_alias_name     varchar(1024) not null comment '????',
    logo                 longblob not null comment 'logo??',
    brand_intro          varchar(1024) not null comment '????',
    brand_authorization_voucher longblob not null comment '??????',
    location             varchar(1024) not null comment '?????',
    brand_comment        varchar(1024) comment '??????',
    is_enabled           tinyint not null comment '?????1????0????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table commodity_brand comment '????????';

/*==============================================================*/
/* Table: commodity_category                                    */
/*==============================================================*/
create table commodity_category
(
    id                   bigint not null auto_increment comment '??',
    category_name        varchar(1024) not null comment '????',
    category_desc        varchar(1024) comment '????',
    is_leaf              tinyint not null default 0 comment '????????1???????0???????',
    parent_id            bigint not null comment '??????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table commodity_category comment '????????';

/*==============================================================*/
/* Table: commodity_category_property_relationship              */
/*==============================================================*/
create table commodity_category_property_relationship
(
    id                   bigint not null auto_increment comment '??',
    category_id          bigint not null comment '??ID',
    property_id          bigint not null comment '??ID',
    is_required          tinyint not null comment '???????1?????0????',
    property_type        tinyint not null comment '?????1??????2??????3???????4??????????????????????1,2?2,4',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table commodity_category_property_relationship comment '????????????????';

/*==============================================================*/
/* Table: commodity_goods                                       */
/*==============================================================*/
create table commodity_goods
(
    id                   bigint not null auto_increment comment '??',
    category_id          bigint not null comment '??ID',
    brand_id             bigint not null comment '??ID',
    spu_code             varchar(1024) not null comment 'SPU??',
    goods_name           varchar(1024) not null comment '????',
    goods_sub_name       varchar(1024) not null comment '?????',
    gross_weight         decimal(8,2) not null comment '????????g',
    goods_length         decimal(8,2) not null comment '?????????cm',
    goods_width          decimal(8,2) not null comment '????????cm',
    goods_height         decimal(8,2) not null comment '????????cm',
    goods_status         tinyint not null comment '?????1?????2?????3???????4????',
    service_guarantees   varchar(1024) not null comment '????',
    package_list         varchar(1024) not null comment '????',
    freight_template_id  bigint not null comment '????ID',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table commodity_goods comment '????????????';

/*==============================================================*/
/* Table: commodity_goods_desc                                  */
/*==============================================================*/
create table commodity_goods_desc
(
    id                   bigint not null auto_increment comment '??',
    goods_id             bigint not null comment '??ID',
    goods_desc           longtext not null comment '??????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table commodity_goods_desc comment '??????';

/*==============================================================*/
/* Table: commodity_goods_desc_picture                          */
/*==============================================================*/
create table commodity_goods_desc_picture
(
    id                   bigint not null auto_increment comment '??',
    goods_desc_id        bigint not null comment '??????ID',
    goods_desc_picture   longblob not null comment '????????????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table commodity_goods_desc_picture comment '??????????';

/*==============================================================*/
/* Table: commodity_goods_picture                               */
/*==============================================================*/
create table commodity_goods_picture
(
    id                   bigint not null auto_increment comment '??',
    goods_id             bigint not null comment '??ID',
    sequence             tinyint not null comment '?????',
    goods_picture        longblob not null comment '????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table commodity_goods_picture comment '????????';

/*==============================================================*/
/* Table: commodity_goods_proprety_group_value                  */
/*==============================================================*/
create table commodity_goods_proprety_group_value
(
    id                   bigint not null auto_increment comment '??',
    goods_id             bigint not null comment '??ID',
    property_group_relationship_id bigint not null comment '????????????ID',
    property_value       varchar(1024) not null comment '?????????????????,??????????????????????????????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table commodity_goods_proprety_group_value comment '???????????????';

/*==============================================================*/
/* Table: commodity_goods_proprety_value                        */
/*==============================================================*/
create table commodity_goods_proprety_value
(
    id                   bigint not null auto_increment comment '??',
    goods_id             bigint not null comment '??ID',
    category_property_relationship_id bigint not null comment '??????????ID',
    property_value       varchar(1024) not null comment '?????????????????,??????????????????????????????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table commodity_goods_proprety_value comment '?????';

/*==============================================================*/
/* Table: commodity_goods_sku                                   */
/*==============================================================*/
create table commodity_goods_sku
(
    id                   bigint not null auto_increment comment '??',
    goods_id             bigint not null comment '??ID',
    goods_sku_code       varchar(1024) not null comment 'sku??',
    purchase_price       decimal(8,2) not null comment '????',
    sale_price           decimal(8,2) not null comment '????',
    discount_price       decimal(8,2) not null comment '????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table commodity_goods_sku comment '??sku??';

/*==============================================================*/
/* Table: commodity_goods_sku_property_value                    */
/*==============================================================*/
create table commodity_goods_sku_property_value
(
    id                   bigint not null auto_increment comment '??',
    goods_sku_id         bigint not null comment 'sku ID',
    category_property_relationship_id bigint not null comment '??????????ID',
    property_value       varchar(1024) not null comment 'sku?????????????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table commodity_goods_sku_property_value comment 'sku???????????????';

/*==============================================================*/
/* Table: commodity_property                                    */
/*==============================================================*/
create table commodity_property
(
    id                   bigint not null auto_increment comment '??',
    property_name        national varchar(255) not null comment '????',
    property_desc        varchar(1024) comment '????',
    input_type           tinyint not null comment '?????1????2???',
    input_values         varchar(1024) not null comment '???????????????????????????????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table commodity_property comment '????????';

/*==============================================================*/
/* Table: commodity_property_group                              */
/*==============================================================*/
create table commodity_property_group
(
    id                   bigint not null auto_increment comment '??',
    property_group_name  varchar(1024) not null comment '??????',
    category_id          bigint not null comment '?????ID',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table commodity_property_group comment '??????????';

/*==============================================================*/
/* Table: commodity_property_group_relationship                 */
/*==============================================================*/
create table commodity_property_group_relationship
(
    id                   bigint not null auto_increment comment '??',
    property_group_id    bigint not null comment '????ID',
    property_id          bigint not null comment '??ID',
    is_required          tinyint not null comment '???????1?????0????',
    property_type        tinyint not null comment '?????1??????2??????3???????4??????????????????????1,2?2,4',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table commodity_property_group_relationship comment '??????????????????';
