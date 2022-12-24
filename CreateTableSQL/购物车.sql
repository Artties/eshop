/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/2/23 10:00:39                           */
/*==============================================================*/


drop table if exists shopping_cart;

drop table if exists shopping_cart_item;

/*==============================================================*/
/* Table: shopping_cart                                         */
/*==============================================================*/
create table shopping_cart
(
    id                   bigint not null auto_increment comment '??',
    user_account_id      bigint not null comment '????ID',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table shopping_cart comment '???';

/*==============================================================*/
/* Table: shopping_cart_item                                    */
/*==============================================================*/
create table shopping_cart_item
(
    id                   bigint not null auto_increment comment '??',
    shopping_cart_id     bigint not null comment '???ID',
    goods_sku_id         bigint not null comment '??sku ID',
    purchase_quantity    bigint not null comment '????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table shopping_cart_item comment '????????';
