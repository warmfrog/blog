create table airticle_type
(
  id   int auto_increment
    primary key,
  type varchar(20) not null
)
  comment '文章类型' charset = utf8mb4;

create table article
(
  id           bigint auto_increment comment '自增ID'
    primary key,
  title        varchar(45)  default '""'              not null comment '文章标题',
  author       varchar(45)  default '""'              not null comment '文章作者',
  type         varchar(45)  default '""'              not null comment '文章分类',
  intro        varchar(100) default '""'              not null comment '文章简介',
  url          varchar(200) default '""'              not null comment '文章连接地址',
  date         timestamp    default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '发表日期',
  imgUrl       varchar(200) default ''                null,
  thumbnailUrl varchar(200)                           null
)
  comment '文章' charset = utf8mb4;

create table user
(
  id int auto_increment comment '用户自增ID'
    primary key,
  username varchar(45) not null comment '用户名',
  password varchar(45) not null comment '密码',
  constraint username_UNIQUE
    unique (username)
)
  charset = utf8mb4;



