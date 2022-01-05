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

![20211231153428](.\images\javaWeb\20211231153428.png)

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

![20211231162426056](.\images\javaWeb\20211231162426056.png)

改完重启生效。



## 启动和关闭

### 方式一

进入bin目录：

![20211231153947](.\images\javaWeb\20211231153947.png)



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



# IDEA 整合 Tomcat 服务器

File -> Settings：

![20211231171118](.\images\javaWeb\20211231171118.png)



# IDEA 创建一个Web工程

创建一个新模块：

![20220105114621](E:\Desktop\myJavaStudy\docs\images\javaWeb\20220105114621.png)



# IDEA 使用 Tomcat 服务器运行WEB项目

1. 打开项目结构，添加一个web项目所在模块的facet。

![image-20220105141206447](.\images\javaWeb\image-20220105141206447.png)

2. 打开项目结构，添加一个web项目所在模块的Artifact。

![image-20220105141529130](.\images\javaWeb\image-20220105141529130.png)

3. 打开tomcat配置信息窗口

![image-20220105141606933](.\images\javaWeb\image-20220105141606933.png)

配置以下信息

![image-20220105141708799](.\images\javaWeb\image-20220105141708799.png)

再到部署里添加web项目的Artifact，并填写上下文

![image-20220105141757216](.\images\javaWeb\image-20220105141757216.png)



# 概念解释

### jar包和war包

https://www.jianshu.com/p/3b5c45e8e5bd



### Facet

Facet表述了在Module中使用的各种各样的框架、技术和语言。这些Facets让Intellij IDEA知道怎么对待module内容，并保证与相应的框架和语言保持一致。

Facet表示某个module有的特征，比如web、strtus2、spring、hibernate等。

它的作用就是配置项目框架类支持。比如我们现在要开发的是一个 web 项目，那就需要 web 相关的 Facet，事实上，如果没有这个配置支持，编译器也不知道这个项目是个 web 项目，也就不会去读取 web.xml 的配置，更无法被 tomcat 这种容器支持。

Facet 是和 Module 紧密结合的，你如果是在 Module 里配置了，那么 Facet 里边也会出现，而如果你先在 Facet 里配置，它会要求你选择 Module，所以结果是一致的。



### Artifact

Artifact是maven中的一个概念，表示某个module要如何打包，例如war exploded、war、jar、ear等等这种打包形式。

它的作用是整合编译后的 java 文件，资源文件等，有不同的整合方式，比如war、jar、war exploded 等，对于 Module 而言，有了 Artifact 就可以部署到 web 容器中了。其中 war 和 war exploded 区别就是后者不压缩，开发时选后者便于看到修改文件后的效果。



#### web application exploded和web application archive

- web application exploded：这个是以文件夹形式发布项目，发布项目时就会自动生成文件夹在指定的output directory

- web application archive：就是war包形式,将项目打成一个war包在指定位置



# servlet

Servlet（Server Applet）是Java Servlet的简称，称为==小服务程序==或==服务连接器==，用Java编写的服务器端程序，具有独立于平台和协议的特性，主要功能在于==交互式地浏览和生成数据==，生成动态Web内容。

狭义的Servlet是指Java语言实现的一个接口，广义的Servlet是指任何实现了这个Servlet接口的类，一般情况下，人们将Servlet理解为后者。Servlet运行于支持Java的应用服务器中。从原理上讲，Servlet可以响应任何类型的请求，但绝大多数情况下Servlet只用来扩展基于HTTP协议的Web服务器。
