/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/2/23 10:11:57                           */
/*==============================================================*/


drop table if exists schedule_goods_allocation_stock;

drop table if exists schedule_warehouse_goods_stock;

/*==============================================================*/
/* Table: schedule_goods_allocation_stock                       */
/*==============================================================*/
create table schedule_goods_allocation_stock
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

alter table schedule_goods_allocation_stock comment '?????????';

/*==============================================================*/
/* Table: schedule_warehouse_goods_stock                        */
/*==============================================================*/
create table schedule_warehouse_goods_stock
(
    id                   bigint not null auto_increment comment '??',
    goods_sku_id         bigint not null comment '??sku ID',
    available_stock_quantity bigint not null comment '??????',
    locked_stock_quantity bigint not null comment '??????',
    deliveried_stock_quantity bigint not null comment '???????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table schedule_warehouse_goods_stock comment '?????????';

