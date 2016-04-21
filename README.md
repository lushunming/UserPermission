毕业设计
标签（空格分隔）：毕设
---

这是我的毕业设计项目

首先用到的技术有

 - 后端： 
     - [Spring](https://spring.io)
     - [Spring MVC](https://spring.io)
     - [Mybatis](http://www.mybatis.org/mybatis-3/)
     - [Mybatis geneator](http://www.mybatis.org/generator/)
     - [Mybatis pagehelper](https://github.com/pagehelper/Mybatis-PageHelper)
     - [Shiro](http://shiro.apache.org/)
 - 前端：
    - [EasyUI](http://www.jeasyui.com/) 
    - [Bootstrap](http://www.bootcss.com/)
 - 数据库
    - [postgreSql 9.3](http://www.postgresql.org/) 

用的是maven管理，其中用到了maven的插件：配置了jetty和tomcat
导入到eclipse然后run as build ，goles 填写jetty:run，就是用jetty运行
；goles填写tomcat7:run，就是用tomcat运行。

在运行之前首先初始化数据库，在com\lu\sql路径下有建表的脚本和初始化的脚本，先建表再初始化 。
默认的用户是 admin，密码111111。启动后进入localhost:8080。

     




