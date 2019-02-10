create table access_log
(
  id          int auto_increment comment 'id'
    primary key,
  user_id     int          null comment '用户id',
  ipv4        varchar(20)  null comment 'ipv4地址',
  ipv6        varchar(128) null comment 'ipv6地址',
  access_time datetime     null comment '访问时间'
)
  comment '访问日志' charset = utf8;

create table article
(
  id            int auto_increment comment '自增ID'
    primary key,
  title         varchar(200) default '""'              not null comment '文章标题',
  type_id       int                                    null comment '文章类型',
  author_id     int                                    not null comment '作者id',
  intro         varchar(100) default '""'              null comment '文章简介',
  url           varchar(200) default '""'              not null comment 'markdown 文件路径',
  date          datetime     default CURRENT_TIMESTAMP not null comment '发表日期',
  img_url       varchar(200) default ''                null comment '列表图像地址',
  thumbnail_url varchar(200)                           null comment '列表缩略图地址'
)
  comment '文章表' charset = utf8;

create table book
(
  id           int(20) auto_increment comment '图书ID'
    primary key,
  book_name    varchar(100)            not null comment '书名',
  author       varchar(50)  default '' not null comment '图书作者',
  language     varchar(20)  default '' not null comment '书籍语言',
  cover        varchar(100) default '' not null comment '封面图片路径',
  url          varchar(100) default '' not null comment '资源路径',
  release_date datetime                null comment '出版时间',
  upload_time  datetime                not null comment '上传时间'
)
  comment '图书表' charset = utf8;

create table roles
(
  id   int auto_increment
    primary key,
  name varchar(50) null comment '角色'
)
  comment '角色表' charset = utf8;

create table software
(
  id           int auto_increment comment 'id'
    primary key,
  name         varchar(50)  null comment '软件名称',
  version      varchar(20)  null comment '版本',
  url          varchar(200) null comment '下载地址',
  baiduyun     varchar(100) null comment '百度网盘地址',
  csdn         varchar(150) null comment 'CSDN下载地址',
  release_time datetime     null comment '发行时间',
  upload_time  datetime     null comment '上传时间',
  intro        varchar(200) null comment '简介'
)
  comment '软件表' charset = utf8;

create table type
(
  id    int auto_increment
    primary key,
  scope varchar(20) not null comment '类型所在域,图书/文章/软件/',
  name  varchar(20) not null comment '类型名'
)
  comment '文章类型,图书类型' charset = utf8mb4;

create table user_role
(
  id      int auto_increment
    primary key,
  user_id int null comment '用户id',
  role_id int null comment '角色id'
)
  comment '用户-角色' charset = utf8;

create table users
(
  id            int auto_increment comment '用户自增ID'
    primary key,
  username      varchar(45)                        not null comment '用户名',
  password      varchar(255)                       not null comment '密码',
  email         varchar(45)                        not null comment 'email',
  register_time datetime default CURRENT_TIMESTAMP null comment '注册时间',
  constraint username_UNIQUE
    unique (username)
)
  comment '用户表' charset = utf8mb4;


