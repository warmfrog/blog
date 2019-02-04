drop table if exists article_type;
create table article_type
(
  `id`   int auto_increment
    primary key,
  `type` varchar(20) not null
)
  comment '文章类型' charset = utf8mb4;

drop table if exists `article`;
create table article
(
  id           bigint auto_increment comment '自增ID'
    primary key,
  title        varchar(45)  default '""'              not null comment '文章标题',
  type         varchar(45)  default '""'              not null comment '文章分类',
  intro        varchar(100) default '""'              not null comment '文章简介',
  url          varchar(200) default '""'              not null comment 'markdown 文件路径',
  date         datetime    default CURRENT_TIMESTAMP not null comment '发表日期',
  author_id int not null comment '作者id',
  imgUrl       varchar(200) default ''                null comment '列表图像地址',
  thumbnailUrl varchar(200)                           null comment '列表缩略图地址'
)
  comment '文章' charset = utf8mb4;

drop table if exists `user`;
create table `user`
(
  id int auto_increment comment '用户自增ID'
    primary key,
  username varchar(45) not null comment '用户名',
  password varchar(45) not null comment '密码',
  admin bit not null default 0 comment '是否是管理员',
  register_time datetime default current_timestamp comment '注册时间',
  constraint username_UNIQUE
    unique (username)
)
  comment '用户表' charset = utf8mb4;



