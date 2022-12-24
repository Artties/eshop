/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/2/23 9:55:34                            */
/*==============================================================*/


drop table if exists wms_goods_allocation;

drop table if exists wms_goods_allocation_stock;

drop table if exists wms_purchase_input_order;

drop table if exists wms_purchase_input_order_item;

drop table if exists wms_purchase_input_put_on_item;

drop table if exists wms_return_goods_input_order;

drop table if exists wms_return_goods_input_order_item;

drop table if exists wms_return_goods_input_put_on_item;

drop table if exists wms_sale_delivery_order;

drop table if exists wms_sale_delivery_order_item;

drop table if exists wms_sale_delivery_picking_item;

drop table if exists wms_warehouse_goods_stock;

/*==============================================================*/
/* Table: wms_goods_allocation                                  */
/*==============================================================*/
create table wms_goods_allocation
(
    id                   bigint not null auto_increment comment '??',
    goods_allocation_code varchar(1024) not null comment '????',
    goods_allocation_comment varchar(1024) comment '????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table wms_goods_allocation comment 'WMS??????';

/*==============================================================*/
/* Table: wms_goods_allocation_stock                            */
/*==============================================================*/
create table wms_goods_allocation_stock
(
    id                   bigint not null auto_increment comment '??',
    goods_allocation_id  bigint not null comment '??ID',
    goods_sku_id         bigint not null comment '??sku ID',
    available_stock_quantity bigint not null comment '??????',
    locked_stock_quantity bigint not null comment '??????',
    deliveried_stock_quantity bigint not null comment '???????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table wms_goods_allocation_stock comment '????????';

/*==============================================================*/
/* Table: wms_purchase_input_order                              */
/*==============================================================*/
create table wms_purchase_input_order
(
    id                   bigint not null auto_increment comment '??',
    supplier_id          bigint not null comment '???ID',
    expect_arrival_time  datetime not null comment '??????',
    arrival_time         datetime not null comment '??????',
    purchase_contactor   varchar(1024) not null comment '?????',
    purchase_contact_phone_number varchar(1024) not null comment '??????',
    purchase_contact_email varchar(1024) not null comment '??????',
    purchase_input_order_comment varchar(1024) not null comment '??????????',
    purchaser            varchar(1024) not null comment '???',
    purchase_input_order_status tinyint not null comment '????????1?????2?????3?????4?????5????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table wms_purchase_input_order comment 'wms????????';

/*==============================================================*/
/* Table: wms_purchase_input_order_item                         */
/*==============================================================*/
create table wms_purchase_input_order_item
(
    id                   bigint not null auto_increment comment '??',
    purchase_input_order_id bigint not null comment '?????ID',
    goods_sku_id         bigint not null comment '??SKU ID',
    purchase_count       bigint not null comment '????',
    purchase_price       bigint not null comment '????',
    qualified_count      bigint not null comment '???????',
    arrival_count        bigint not null comment '???????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table wms_purchase_input_order_item comment 'wms???????????';

/*==============================================================*/
/* Table: wms_purchase_input_put_on_item                        */
/*==============================================================*/
create table wms_purchase_input_put_on_item
(
    id                   bigint not null auto_increment comment '??',
    purchase_input_order_item_id bigint not null comment '???????ID',
    goods_allocation_id  bigint not null comment '??ID',
    put_on_shelves_count bigint not null comment '????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table wms_purchase_input_put_on_item comment '??????????????';

/*==============================================================*/
/* Table: wms_return_goods_input_order                          */
/*==============================================================*/
create table wms_return_goods_input_order
(
    id                   bigint not null auto_increment comment '??',
    user_account_id      char(10) comment '????ID',
    order_id             bigint not null comment '??ID',
    order_no             varchar(1024) not null comment '??????????UUID',
    return_goods_input_order_status tinyint not null comment '????????1?????2?????3????',
    consignee            varchar(1024) not null comment '???',
    delivery_address     varchar(1024) not null comment '????',
    consignee_cell_phone_number varchar(1024) not null comment '???????',
    freight              decimal(8,2) not null comment '??',
    pay_type             tinyint not null comment '?????1?????2???',
    total_amount         decimal(8,2) not null comment '?????',
    discount_amount      decimal(8,2) not null comment '????????',
    coupon_amount        decimal(8,2) not null comment '???????',
    payable_amount       decimal(8,2) not null comment '?????????? - ???????? - ??????? + ??',
    invoice_title        varchar(1024) not null comment '????',
    taxpayer_id          varchar(1024) not null comment '??????',
    order_comment        varchar(1024) not null comment '????',
    return_goods_reason  tinyint not null comment '?????1??????2???????3?????4??????',
    return_goods_comment varchar(1024) not null comment '????',
    arrival_time         datetime not null comment '????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table wms_return_goods_input_order comment 'wms????????';

/*==============================================================*/
/* Table: wms_return_goods_input_order_item                     */
/*==============================================================*/
create table wms_return_goods_input_order_item
(
    id                   bigint not null auto_increment comment '??',
    return_goods_input_order_id bigint not null comment '?????ID',
    goods_sku_id         bigint not null comment '??sku ID',
    goods_sku_code       varchar(1024) not null comment '??sku??',
    goods_name           varchar(1024) not null comment '????',
    sale_properties      varchar(1024) not null comment '?????????:??,????:256G',
    goods_gross_weight   decimal(8,2) not null comment '????',
    purchase_quantity    bigint not null comment '????',
    purchase_price       decimal(8,2) not null comment '??????',
    promotion_activity_id bigint not null comment '????ID',
    goods_length         decimal(8,2) not null comment '????',
    goods_width          decimal(8,2) not null comment '????',
    goods_height         decimal(8,2) not null comment '????',
    qualified_count      bigint not null comment '??????',
    arrival_count        bigint not null comment '??????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table wms_return_goods_input_order_item comment '???????';

/*==============================================================*/
/* Table: wms_return_goods_input_put_on_item                    */
/*==============================================================*/
create table wms_return_goods_input_put_on_item
(
    id                   bigint not null auto_increment comment '??',
    return_goods_input_order_item_id bigint not null comment '???????ID',
    goods_allocation_id  bigint not null comment '??ID',
    put_on_shelves_count bigint not null comment '????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table wms_return_goods_input_put_on_item comment '??????????????';

/*==============================================================*/
/* Table: wms_sale_delivery_order                               */
/*==============================================================*/
create table wms_sale_delivery_order
(
    id                   bigint not null auto_increment comment '??',
    order_id             bigint not null comment '??ID',
    order_no             varchar(1024) not null comment '??????????UUID',
    user_account_id      char(10) comment '????ID',
    consignee            varchar(1024) not null comment '???',
    delivery_address     varchar(1024) not null comment '????',
    consignee_cell_phone_number varchar(1024) not null comment '???????',
    freight              decimal(8,2) not null comment '??',
    pay_type             tinyint not null comment '?????1?????2???',
    total_amount         decimal(8,2) not null comment '?????',
    discount_amount      decimal(8,2) not null comment '????????',
    coupon_amount        decimal(8,2) not null comment '???????',
    payable_amount       decimal(8,2) not null comment '?????????? - ???????? - ??????? + ??',
    invoice_title        varchar(1024) not null comment '????',
    taxpayer_id          varchar(1024) not null comment '??????',
    order_comment        varchar(1024) not null comment '????',
    sale_delivery_order_status tinyint not null comment '?????????1?????2?????3????',
    delivery_time        datetime not null comment '????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table wms_sale_delivery_order comment 'wms????????';

/*==============================================================*/
/* Table: wms_sale_delivery_order_item                          */
/*==============================================================*/
create table wms_sale_delivery_order_item
(
    id                   bigint not null auto_increment comment '??',
    sale_delivery_order_id bigint not null comment '?????ID',
    goods_sku_id         bigint not null comment '??sku ID',
    goods_sku_code       varchar(1024) not null comment '??sku??',
    goods_name           varchar(1024) not null comment '????',
    sale_properties      varchar(1024) not null comment '?????????:??,????:256G',
    goods_gross_weight   decimal(8,2) not null comment '????',
    purchase_quantity    bigint not null comment '????',
    purchase_price       decimal(8,2) not null comment '??????',
    promotion_activity_id bigint not null comment '????ID',
    goods_length         decimal(8,2) not null comment '????',
    goods_width          decimal(8,2) not null comment '????',
    goods_height         decimal(8,2) not null comment '????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table wms_sale_delivery_order_item comment 'wms??????????';

/*==============================================================*/
/* Table: wms_sale_delivery_picking_item                        */
/*==============================================================*/
create table wms_sale_delivery_picking_item
(
    id                   bigint not null auto_increment comment '??',
    sale_delivery_order_item_id bigint not null comment '???????ID',
    goods_allocation_id  bigint not null comment '??ID',
    picking_count        bigint not null comment '??????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table wms_sale_delivery_picking_item comment '??????????';

/*==============================================================*/
/* Table: wms_warehouse_goods_stock                             */
/*==============================================================*/
create table wms_warehouse_goods_stock
(
    id                   bigint not null auto_increments comment '??',
    goods_sku_id         bigint not null comment '??sku ID',
    available_stock_quantity bigint not null comment '??????',
    locked_stock_quantity bigint not null comment '??????',
    deliveried_stock_quantity bigint not null comment '???????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table wms_warehouse_goods_stock comment '????????';
