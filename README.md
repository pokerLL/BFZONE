

运行软件需要先配置mysql数据库

必须配置成如下

 

用户名：root

密码：123456

端口：3306

 

使用mysql官网8.0的安装包即可

 

安装完成后需要进行初始化，具体进入cmd命令行依此执行本文件夹下的四个个sql文件即可，或者复制进图形化界面也可。

mysql -uroot -p123456

source 路径/ini_1.sql

source 路径/ ini_2.sql

source 路径/ ini_3.sql

source 路径/ ini_4.sql

当然也可以只执行ini.sql文件，两者选其一即可。

 

 

软件登录管理员账号

账号：admin

密码：123456

 

一般账号

账号：gm

密码：gm

 

其余账号可以直接在管理界面看到

 

项目源码在文件夹BF中

 

jar包可以直接运行