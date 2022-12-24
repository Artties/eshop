/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/2/23 10:10:56                           */
/*==============================================================*/


drop table if exists inventory_goods_stock;

/*==============================================================*/
/* Table: inventory_goods_stock                                 */
/*==============================================================*/
create table inventory_goods_stock
(
    id                   bigint not null auto_increment comment '??',
    goods_sku_id         bigint not null comment '??sku ID',
    sale_stock_quantity  bigint not null comment '????',
    locked_stock_quantity bigint not null comment '????',
    saled_stock_quantity bigint not null comment '?????',
    stock_status         tinyint not null comment '?????0?????1????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table inventory_goods_stock comment '??????????';

