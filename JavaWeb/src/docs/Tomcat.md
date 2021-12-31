# 什么是JavaWeb ？

JavaWeb，是用Java技术来解决相关web互联网领域的技术栈。web包括：web[服务端](https://baike.baidu.com/item/服务端/6492316)和web[客户端](https://baike.baidu.com/item/客户端/101081)两部分。Java在客户端的应用有Java Applet，不过[使用](https://baike.baidu.com/item/使用/7741550)得很少，Java在[服务器端](https://baike.baidu.com/item/服务器端/3369401)的应用非常的丰富，比如[Servlet](https://baike.baidu.com/item/Servlet/477555)，[JSP](https://baike.baidu.com/item/JSP/141543)、第三方[框架](https://baike.baidu.com/item/框架/1212667)等等。Java技术对Web领域的发展注入了强大的动力。



**Internet上供外界访问的Web资源分为：**

- 静态web资源：指web页面中供人们浏览的数据始终是不变。如：html、css、js、txt、mp4 、jpg 等。
  - 静态web资源开发技术：HTML、CSS。
- 动态web资源：指web页面中供人们浏览的数据是由程序产生的，不同时间点访问web页面看到的内容各不相同。如：jsp 页面、Servlet 程序等。
  - 动态web资源开发技术：JavaScript、JSP/Servlet、ASP、PHP等。在Java中，==动态web资源开发技术统称为Java Web==。



JavaWeb 是指，所有通过 Java 语言编写可以通过==浏览器访问==的程序的总称，叫 JavaWeb。 JavaWeb 是基于==请求==和==响应==来开发的。 





# 服务器

**服务器分类：**

- Web服务器
  - Apache
  - Nginx
  - IIS
- 应用服务器
  - Tomcat
  - WebLogic
  - JBoss



Web服务器一般指网站服务器，是指驻留于[因特网](https://baike.baidu.com/item/因特网/114119)上某种类型计算机的程序，可以处理浏览器等Web客户端的请求并返回相应响应，也可以放置网站文件，让全世界浏览；可以放置数据文件，让全世界下载。WEB服务器也称为==WWW(WORLD WIDE WEB)服务器==，主要功能是提供网上信息浏览服务。

目前最主流的三个Web服务器是==Apache、 Nginx 、IIS==。

严格意义上Web服务器==只负责处理HTTP协议==，只能发送==静态资源==。而JSP，ASP，PHP等==动态资源==需要通过CGI、FastCGI、ISAPI等接口交给==应用服务器==去处理。应用服务器包括Tomcat、WebLogic、JBoss等。应用服务器一般==也支持HTTP协议==，因此界限没这么清晰。但是应用服务器的HTTP协议部分==仅仅是支持，一般不会做特别优化==，所以很少有见Tomcat直接暴露给外面，而是和Nginx、Apache等配合，只让Tomcat处理JSP和Servlet部分。





# Tomcat

## 安装

官网下载：https://tomcat.apache.org/whichversion.html

找到你需要用的 Tomcat 版本对应的 zip 压缩包，解压到需要安装的目录即可。



## 目录介绍

![20211231153428](E:\Desktop\myJavaStudy\JavaWeb\src\docs\images\20211231153428.png)

## 环境变量

需要新增JAVA_HOME和CATALINA_HOME两个系统变量。

1. 新增一个系统变量，变量名：JAVA_HOME，变量值：jdk的安装路径。

2. 编辑path系统变量，新建一个`%JAVA_HOME%\bin`

CATALINA_HOME同此步骤。



## 更改端口号

Tomcat 默认的端口号是：8080。

找到 Tomcat 目录下的 conf 目录，找到 server.xml 配置文件。

端口号：1-65535之间。

http默认端口号是80，80端口不显示。

![20211231162426056](E:\Desktop\myJavaStudy\JavaWeb\src\docs\images\20211231162426056.png)

改完重启生效。



## 启动和关闭

### 方式一

进入bin目录：

![20211231153947](E:\Desktop\myJavaStudy\JavaWeb\src\docs\images\20211231153947.png)



### 方式二

Tomcat 的 bin 目录下打开cmd，执行`catalina run`，即启动。



## 问题

### 启动时小黑窗口一闪而过 

失败的原因基本上都是因为没有配置好 JAVA_HOME 环境变量



### Tomcat启动窗口中文乱码解决方案

https://www.cnblogs.com/fanshuyao/p/13813340.html



## 部署

默认目标，工程默认为ROOT工程，资源默认是index.html。



### 方式一

把 web 工程的目录拷贝到 Tomcat 的 webapps 目录下即可。



### 方式二

到 Tomcat 的 conf\Catalina\localhost目录下建一个xml配置文件，可通过服务器上访问任意路径的文件夹。

```xml
<Context path="/abc" docBase="E:\book" />
```

> Context 表示一个工程上下文，path 表示工程的访问路径:/abc，docBase 表示你的工程目录在哪里 



## IDEA 整合 Tomcat 服务器

File -> Settings：

![20211231171118](E:\Desktop\myJavaStudy\JavaWeb\src\docs\images\20211231171118.png)



