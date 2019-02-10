# 支持markdown的博客webapp

博客系统,分为前台和后台.前台只负责显示博客列表.后台对博客进行增删改查. 使用Spring Security 控制后台
访问权限. 

博客上传: 上传markdown文件和图片,保存在服务器.将文件和图片索引保存至数据库.

博客浏览: 从数据库获取博客列表,根据markdown文件地址从服务器获取markdown文件,使用showdown.js在浏览器
中将markdown文件转为html,然后使用highlight.js对代码部分高亮,完成markdown渲染.

默认每页显示10条博文,使用数据库分页.

数据库使用mysql, 使用mybatis 持久化框架, 自行编写mysql 语句,设计数据库, 使用 mybatis-maven-generator 生成实体类和Dao类.

网站后台使用AdminLTE模板, 前台使用linux.cn的样式.

## 技术

* Spring Boot
* Spring Security
* Mybatis
* Thymeleaf
* jQuery
* mysql

