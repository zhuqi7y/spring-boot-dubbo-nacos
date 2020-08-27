#执行nacos\conf目录下nacos-mysql.sql文件之前，创建nacos数据库和用户
create database nacos;
create user 'nacos'@'localhost' IDENTIFIED BY 'nacos';
grant all on nacos.* to 'nacos'@'localhost';

