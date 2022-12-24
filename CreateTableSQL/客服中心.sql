/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/2/23 10:08:45                           */
/*==============================================================*/


drop table if exists customer_return_goods_worksheet;

/*==============================================================*/
/* Table: customer_return_goods_worksheet                       */
/*==============================================================*/
create table customer_return_goods_worksheet
(
    id                   bigint not null auto_increment comment '??',
    order_id             bigint not null comment '??ID',
    order_no             varchar(1024) not null comment '????',
    return_goods_worksheet_status tinyint not null comment '???????1?????2???????3?????????4?????????5???????6???????7?????',
    return_goods_reason  tinyint not null comment '?????1??????2???????3?????4??????',
    return_goods_comment varchar(1024) not null comment '????',
    return_goods_courier_number varchar(1024) not null comment '??????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table customer_return_goods_worksheet comment '?????????';

