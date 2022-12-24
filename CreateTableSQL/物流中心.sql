/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/2/23 10:04:59                           */
/*==============================================================*/


drop table if exists logistics_freight_template;

/*==============================================================*/
/* Table: logistics_freight_template                            */
/*==============================================================*/
create table logistics_freight_template
(
    id                   bigint not null auto_increment comment '??',
    freight_template_name varchar(1024) not null comment '??????',
    freight_template_type tinyint not null comment '???????1??????2??X????3??????',
    freight_template_rule varchar(1024) not null comment '???????',
    freight_template_comment varchar(1024) not null comment '?????????',
    gmt_create           datetime not null comment '????',
    gmt_modified         datetime not null comment '????',
    primary key (id)
);

alter table logistics_freight_template comment '??????????';

