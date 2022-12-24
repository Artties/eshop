/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/2/23 9:54:09                            */
/*==============================================================*/


drop table if exists purchase_order;

drop table if exists purchase_order_item;

drop table if exists purchase_supplier;

/*==============================================================*/
/* Table: purchase_order                                        */
/*==============================================================*/
create table purchase_order
(
    id                   bigint not null auto_increment comment '??',
    supplier_id          bigint not null comment '???ID',
    expect_arrival_time  datetime not null comment '??????',
    contactor            varchar(1024) not null comment '???',
    contact_phone_number varchar(1024) not null comment '????',
    contact_email        varchar(1024) not null comment '????',
    purchase_order_comment varchar(1024) not null comment '????',
    purchaser            varchar(1024) not null comment '???',
    purchase_order_status tinyint not null comment '??????1?????2?????3?????4?????5?????6????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table purchase_order comment '????????';

/*==============================================================*/
/* Table: purchase_order_item                                   */
/*==============================================================*/
create table purchase_order_item
(
    id                   bigint not null auto_increment comment '??',
    purchase_order_id    bigint not null comment '???ID',
    goods_sku_id         bigint not null comment '??SKU ID',
    purchase_count       bigint not null comment '????',
    purchase_price       bigint not null comment '????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table purchase_order_item comment '?????????';

/*==============================================================*/
/* Table: purchase_supplier                                     */
/*==============================================================*/
create table purchase_supplier
(
    id                   bigint not null auto_increment comment '??',
    supplier_name        varchar(1024) not null comment '?????',
    company_name         varchar(1024) not null comment '????',
    company_address      varchar(1024) not null comment '????',
    contactor            varchar(1024) not null comment '???',
    contact_phone_number varchar(1024) not null comment '????',
    account_period       tinyint not null comment '???1?????2?????3?????',
    bank_name            varchar(1024) not null comment '????',
    bank_account         varchar(1024) not null comment '????',
    account_holder       varchar(1024) not null comment '???',
    invoice_title        varchar(1024) not null comment '????',
    taxpayer_id          varchar(1024) not null comment '??????',
    business_scope       varchar(1024) not null comment '????',
    supplier_comment     varchar(1024) comment '????',
    enterprise_qualification varchar(1024) not null comment '????',
    cooperate_contract   longblob not null comment '????',
    price_contract       longblob not null comment '?????',
    purchase_contract    longblob not null comment '????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table purchase_supplier comment '?????????';
