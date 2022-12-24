/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/2/23 10:09:34                           */
/*==============================================================*/


drop table if exists finance_logistics_settlement_detail;

drop table if exists finance_purchase_settlement_order;

drop table if exists finance_purchase_settlement_order_item;

drop table if exists finance_return_goods_refund_detail;

drop table if exists finance_supplier_settlement_detail;

/*==============================================================*/
/* Table: finance_logistics_settlement_detail                   */
/*==============================================================*/
create table finance_logistics_settlement_detail
(
    id                   bigint not null auto_increment comment '??',
    order_id             bigint not null comment '??ID',
    order_no             varchar(1024) not null comment '????',
    total_settlement_amount decimal(8,2) not null comment '????',
    bank_account         varchar(1024) not null comment '????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table finance_logistics_settlement_detail comment '?????????????????';

/*==============================================================*/
/* Table: finance_purchase_settlement_order                     */
/*==============================================================*/
create table finance_purchase_settlement_order
(
    id                   bigint not null auto_increment comment '??',
    supplier_id          bigint not null comment '???ID',
    expect_arrival_time  datetime not null comment '??????',
    arrival_time         datetime not null comment '??????',
    purchase_contactor   varchar(1024) not null comment '?????',
    purchase_contact_phone_number varchar(1024) not null comment '??????',
    purchase_contact_email varchar(1024) not null comment '??????',
    purchase_warehouse_entry_order_comment varchar(1024) not null comment '??????????',
    purchaser            varchar(1024) not null comment '???',
    purchase_settlement_order_status tinyint not null comment '????????1?????2?????3????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    total_settlement_amount decimal(8,2) not null comment '??????????????? * ??????',
    primary key (id)
);

alter table finance_purchase_settlement_order comment '??????????';

/*==============================================================*/
/* Table: finance_purchase_settlement_order_item                */
/*==============================================================*/
create table finance_purchase_settlement_order_item
(
    id                   bigint not null auto_increment comment '??',
    purchase_settlement_order_id bigint not null comment '?????ID',
    goods_sku_id         bigint not null comment '??SKU ID',
    purchase_count       bigint not null comment '????',
    purchase_price       bigint not null comment '????',
    qualified_count      bigint not null comment '???????',
    arrival_count        bigint not null comment '???????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table finance_purchase_settlement_order_item comment '??????????';

/*==============================================================*/
/* Table: finance_return_goods_refund_detail                    */
/*==============================================================*/
create table finance_return_goods_refund_detail
(
    id                   bigint not null auto_increment comment '??',
    order_id             bigint not null comment '??ID',
    order_no             varchar(1024) not null comment '????',
    return_goods_worksheet_id bigint not null comment '????ID',
    return_goods_warehouse_entry_order_id bigint not null comment '?????ID',
    user_account_id      bigint not null comment '????ID',
    refundl_amount       decimal(8,2) not null comment '????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table finance_return_goods_refund_detail comment '?????????????';

/*==============================================================*/
/* Table: finance_supplier_settlement_detail                    */
/*==============================================================*/
create table finance_supplier_settlement_detail
(
    id                   bigint not null auto_increment comment '??',
    supplier_id          bigint not null comment '???ID',
    settlement_period    tinyint not null comment '?????1???2???3???',
    purcahse_settlement_order_ids varchar(1024) not null comment '?????????????ids',
    total_settlement_amount decimal(8,2) not null comment '???????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table finance_supplier_settlement_detail comment '?????????????';

