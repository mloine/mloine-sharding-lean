
create database t_user_1;
create database t_user_3;


create database t_user_2;
create database t_user_4;


create table sys_dict
(
    dict_key               text           not null,
    dict_value              text  not null
);



create table SYS_USER_0
(
    ID                     bigint            not null
        primary key,
    STAFF_NO               character(30)           not null,
    NAME                   character(50),
    SEX                    smallint,
    MOBILE                 character(20),
    EMAIL                  character(50),
    REMARK                 character(250),
    PASSWORD               character(150),
    IS_ENABLE              smallint     default 1 not null,
    IS_DELETE              smallint     default 1 not null,
    CREATE_BY              bigint,
    UPDATE_BY              bigint,
    CREATE_BY_NAME         character(50),
    UPDATE_BY_NAME         character(50),
    CREATE_TIME            DATE,
    UPDATE_TIME            DATE
);



create table SYS_USER_1
(
    ID                     bigint            not null
        primary key,
    STAFF_NO               character(30)           not null,
    NAME                   character(50),
    SEX                    smallint,
    MOBILE                 character(20),
    EMAIL                  character(50),
    REMARK                 character(250),
    PASSWORD               character(150),
    IS_ENABLE              smallint     default 1 not null,
    IS_DELETE              smallint     default 1 not null,
    CREATE_BY              bigint,
    UPDATE_BY              bigint,
    CREATE_BY_NAME         character(50),
    UPDATE_BY_NAME         character(50),
    CREATE_TIME            DATE,
    UPDATE_TIME            DATE
);






-- Execute SQL Script through logical-database connection , eg: sharding_db. Docker samples configuration in the 'conf/config-sharding.yaml' file
-- CREATE TABLE t_order ("order_id" serial4, "user_id" int4 NOT NULL, PRIMARY KEY ("order_id"));
-- CREATE TABLE t_order_item ("order_item_id" serial4, "order_id" int4 NOT NULL, "user_id" int4 NOT NULL, "status" varchar(50), PRIMARY KEY ("order_item_id"));
