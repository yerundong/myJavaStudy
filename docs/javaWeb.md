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

> 注：方式一无效，方式二有效



### IDEA Tomcat控制台输出中文乱码解决方案

https://blog.csdn.net/liu865033503/article/details/81094575



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



# IDEA 创建Web工程

## 普通方式创建Web工程

![20220105114621](E:\Desktop\myJavaStudy\docs\images\javaWeb\20220105114621.png)

生成完目录结构如下。与maven生成的目录有所不同。

![20220106143828](E:\Desktop\myJavaStudy\docs\images\javaWeb\20220106143828.png)

WEB-INF是Java的WEB应用的安全目录。所谓安全就是客户端无法访问，只有服务端可以访问的目录。如果想在页面中直接访问其中的文件，必须通过web.xm文件对要访问的文件进行相应映射才能访问。

web.xml是Web应用程序配置文件，描述了 servlet 和其他的应用组件配置及命名规则。



## 使用maven模板创建一个Web项目

![20220104160553](E:\Desktop\myJavaStudy\docs\images\javaWeb\20220104160553.png)



# IDEA 整合 Tomcat 服务器

File -> Settings：

![20211231171118](.\images\javaWeb\20211231171118.png)



# IDEA Tomcat 部署运行Web项目

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



## 概念解释

### 一、jar包和war包

https://www.jianshu.com/p/3b5c45e8e5bd



### 二、Facet

Facet表述了在Module中使用的各种各样的框架、技术和语言。这些Facets让Intellij IDEA知道怎么对待module内容，并保证与相应的框架和语言保持一致。

Facet表示某个module有的特征，比如web、strtus2、spring、hibernate等。

它的作用就是配置项目框架类支持。比如我们现在要开发的是一个 web 项目，那就需要 web 相关的 Facet，事实上，如果没有这个配置支持，编译器也不知道这个项目是个 web 项目，也就不会去读取 web.xml 的配置，更无法被 tomcat 这种容器支持。

Facet 是和 Module 紧密结合的，你如果是在 Module 里配置了，那么 Facet 里边也会出现，而如果你先在 Facet 里配置，它会要求你选择 Module，所以结果是一致的。



### 三、Artifact

Artifact是maven中的一个概念，表示某个module要如何打包，例如war exploded、war、jar、ear等等这种打包形式。

它的作用是整合编译后的 java 文件，资源文件等，有不同的整合方式，比如war、jar、war exploded 等，对于 Module 而言，有了 Artifact 就可以部署到 web 容器中了。其中 war 和 war exploded 区别就是后者不压缩，开发时选后者便于看到修改文件后的效果。



### 四、web application exploded和web application archive

- web application exploded：这个是以文件夹形式发布项目，发布项目时就会自动生成文件夹在指定的output directory

- web application archive：就是war包形式,将项目打成一个war包在指定位置



# Servlet 技术

Servlet（Server Applet）是Java Servlet的简称，称为==小服务程序==或==服务连接器==，用Java编写的服务器端程序，具有独立于平台和协议的特性，主要功能在于==交互式地浏览和生成数据==，生成动态Web内容。

狭义的Servlet是指Java语言实现的一个接口，广义的Servlet是指任何实现了这个Servlet接口的类，一般情况下，人们将Servlet理解为后者。Servlet运行于支持Java的应用服务器中。从原理上讲，Servlet可以响应任何类型的请求，但绝大多数情况下Servlet只用来扩展基于HTTP协议的Web服务器。

一个 Servlet 就是 Java 编程语言中的一个类，它被用来扩展服务器的性能，服务器上驻留着可以通过==“请求-响应”编程模型==来访问的应用程序。虽然 Servlet 可以对任何类型的请求产生响应，但通常只用来扩展 ==Web 服务器==的应用程序。

Java Servlet 是运行在 Web 服务器或应用服务器上的程序，它是作为来自 Web 浏览器或其他 HTTP 客户端的请求和 HTTP 服务器上的数据库或应用程序之间的中间层。

使用 Servlet，您可以收集来自网页表单的用户输入，呈现来自数据库或者其他源的记录，还可以动态创建网页。

Java Servlet 是运行在带有支持 Java Servlet 规范的解释器的 web 服务器上的 Java 类。

我们通常把实现了Servlet接口的 Java 类叫作Servlet 。

Servlet 是 Java 企业版（JavaEE）的标准组成部分，Java 企业版是支持大型开发项目的 Java 类库的扩展版本。

Servlet是JavaEE的规范之一，规范即接口。

Servlet是javaWeb三大组件之一。三大组件分别是：Servlet程序、Filter过滤器、Listener监听器。



**开发一个Servlet程序需要两个步骤：**

1. 编写一个实现Servlet接口的类
2. 把这个类部署到web服务器上



## Servlet 优势

Java Servlet 通常情况下与使用 ==CGI（Common Gateway Interface，公共网关接口）==实现的程序可以达到异曲同工的效果。但是相比于 CGI，Servlet 有以下几点优势：

- 性能明显更好（因为各个用户请求被激活成单个程序中的一个线程，而无需创建单独的进程）。
- Servlet 在 Web 服务器的地址空间内执行。这样它就没有必要再创建一个单独的进程来处理每个客户端请求。
- Servlet 是独立于平台的，因为它们是用 Java 编写的。
- 服务器上的 Java 安全管理器执行了一系列限制，以保护服务器计算机上的资源。因此，Servlet 是可信的。
- Java 类库的全部功能对 Servlet 来说都是可用的。它可以通过 sockets 和 RMI 机制与 applets、数据库或其他软件进行交互。



## Servlet 架构

下图显示了 Servlet 在 Web 应用程序中的位置。



![servlet-arch](E:\Desktop\myJavaStudy\docs\images\javaWeb\servlet-arch.jpg)



## Servlet 任务

Servlet 执行以下主要任务：

- 读取客户端（浏览器）发送的显式的数据。这包括网页上的 HTML 表单，或者也可以是来自 applet 或自定义的 HTTP 客户端程序的表单。
- 读取客户端（浏览器）发送的隐式的 HTTP 请求数据。这包括 cookies、媒体类型和浏览器能理解的压缩格式等等。
- 处理数据并生成结果。这个过程可能需要访问数据库，执行 RMI 或 CORBA 调用，调用 Web 服务，或者直接计算得出对应的响应。
- 发送显式的数据（即文档）到客户端（浏览器）。该文档的格式可以是多种多样的，包括文本文件（HTML 或 XML）、二进制文件（GIF 图像）、Excel 等。
- 发送隐式的 HTTP 响应到客户端（浏览器）。这包括告诉浏览器或其他客户端被返回的文档类型（例如 HTML），设置 cookies 和缓存参数，以及其他类似的任务。



## Servlet 包结构

使用Servlet 需要导入 **javax.servlet** 相关包：https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api

### Servlet接口

Servlet接口定义所有servlet类都必须实现的方法（==规范==）。 这些方法称为==生命周期方法==。

除了生命周期方法之外，此接口还提供了 `getServletConfig` 方法和 `getServletInfo`  方法，servlet 可使用前一种方法获得任何启动信息，而后一种方法允许 servlet 返回有关其自身的基本信息，比如作者、版本和版权。

开发中一般==不直接实现该接口==，而是选择继承GenericServlet类或HttpServlet类，更为便捷。



### ServletConfig 类

ServletConfig 类从类名上来看，就知道是 Servlet 程序的==配置信息==类（web.xml中的配置信息）。 

Servlet 程序和 ServletConfig 对象都是由 Tomcat 负责创建，我们负责使用。 

Servlet 程序默认是第一次访问的时候创建，ServletConfig 是每个 Servlet 程序创建时，就创建一个对应的 ServletConfig 对象。

**ServletConfig** **类的三大作用：** 

1. 可以获取 Servlet 程序的别名 servlet-name 的值 
2. 获取初始化参数 init-param 
3. 获取 ServletContext 对象 



### GenericServlet类

抽象类，定义一般的、与协议无关的 servlet。

`GenericServlet`类 实现 `Servlet` 和 `ServletConfig`  接口。

`GenericServlet` 使编写 servlet 变得更容易。它提供生命周期方法 `init` 和  `destroy` 的简单版本，以及 `ServletConfig`  接口中的方法的简单版本。`GenericServlet` 还实现 `log` 方法，在  `ServletContext` 接口中对此进行了声明。 

要编写一般的 servlet，只需重写抽象 `service` 方法即可。 



### HttpServlet类

抽象类，提供将要被子类化以创建适用于 Web 站点的 HTTP servlet 的抽象类。`HttpServlet`  的子类至少必须重写一个方法，该方法通常是以下这些方法之一： 

- `doGet`，如果 servlet 支持 HTTP GET 请求 
- `doPost`，用于 HTTP POST 请求 
- `doPut`，用于 HTTP PUT 请求 
- `doDelete`，用于 HTTP DELETE 请求 
- `init` 和 `destroy`，用于管理 servlet 的生命周期内保存的资源 
- `getServletInfo`，servlet 使用它提供有关其自身的信息 

==几乎没有理由重写 `service` 方法==。`service` 通过将标准 HTTP 请求分发给每个 HTTP  请求类型的处理程序方法（上面列出的 `do`*XXX* 方法）来处理它们。 

==同样，几乎没有理由重写 `doOptions` 和 `doTrace` 方法==。 

![6323142341234212ffd](E:\Desktop\myJavaStudy\docs\images\javaWeb\6323142341234212ffd.jpg)

![20220107165058](E:\Desktop\myJavaStudy\docs\images\javaWeb\20220107165058.png)



# 编写一个servlet 类步骤

1. 创建一个类，继承HttpServlet类
2. 根据实际需求，重写doGet或doPost或其他doXxx方法。
3. web.xml配置servlet
4. tomcat部署运行测试



# web.xml配置servlet

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee
                      https://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd"
         version="5.0">

    <!-- request-character-encoding标签用请求编码 -->
    <request-character-encoding>UTF-8</request-character-encoding>
    <!-- response-character-encoding标签用返回编码 -->
    <response-character-encoding>UTF-8</response-character-encoding>
    
    <!-- context-para标签用来配置上下文参数(它属于整个 web 工程) -->
    <context-param>
        <param-name>context1</param-name>
        <param-value>ct1</param-value>
  	</context-param>
    <context-param>
        <param-name>context2</param-name>
        <param-value>ct2</param-value>
    </context-param>
    
    <!-- servlet标签给TomCat配置servlet程序 -->
    <servlet>
        <!-- servlet-name标签给servlet程序起一个别名（一般是servlet类名） -->
        <servlet-name>HelloServlet</servlet-name>
        <!-- servlet-class标签是servlet程序的全类名 -->
        <servlet-class>servlet.HelloServlet</servlet-class>
        <!-- init-param标签是servlet程序的初始化参数 -->
        <init-param>
          <!-- 参数名 -->
          <param-name>key1</param-name>
          <!-- 参数值 -->
          <param-value>value1</param-value>
        </init-param>
        <init-param>
          <param-name>key2</param-name>
          <param-value>value2</param-value>
        </init-param>
    </servlet>

    <!-- servlet-mapping标签给servlet程序配置访问地址 -->
    <servlet-mapping>
        <!-- servlet-name标签是配置目标servlet程序的别名（对应上面servlet-name） -->
        <servlet-name>HelloServlet</servlet-name>
        <!-- servlet-pattern标签配置访问地址 -->
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
</web-app>
```

最终访问地址：http://localhost:8099/webapp/hello

- http://localhost:8099：协议+主机名+端口

- webapp：web上下文，一般为web应用的根目录
- hello：资源路径，映射到servlet.HelloServlet类

![20220107145005](E:\Desktop\myJavaStudy\docs\images\javaWeb\20220107145005.png)



## 问题

### 一、tomcat10 实例化servlet HTTP 500

解决方式一：tomcat10 降级为 tomcat9

解决方式二：https://blog.csdn.net/qq_38149542/article/details/115979379



# IDEA 快捷方式创建Servlet并配置

![20220107162417](E:\Desktop\myJavaStudy\docs\images\javaWeb\20220107162417.png)

![20220107162829](E:\Desktop\myJavaStudy\docs\images\javaWeb\20220107162829.png)

# Servlet 生命周期

- Servlet 初始化后调用 **init ()** 方法。==只调用一次==。它在第一次创建 Servlet 时被调用，在后续每次用户请求时不再调用。
- Servlet 调用 **service()** 方法来处理客户端的请求。==每次请求都会调用==，是执行实际任务的主要方法。每次服务器接收到一个 Servlet 请求时，服务器会产生一个==新的线程==并调用服务。service() 方法检查 HTTP 请求类型（GET、POST、PUT、DELETE 等），并在适当的时候调用 doGet、doPost、doPut，doDelete 等方法。
- Servlet ==销毁前==调用 **destroy()** 方法。

https://www.runoob.com/servlet/servlet-life-cycle.html



# 获取Servlet 配置信息

**ServletConfig** **类**提供了获取Servlet 配置信息的功能。GenericServlet中在==初始化==时，会取到配置信息，并存下来。

![20220107174359](E:\Desktop\myJavaStudy\docs\images\javaWeb\20220107174359.png)

配置信息中包含：servlet-name、init-param、servletContext等配置信息。



## servletContext

servletContext表示上下文信息对象。

1、ServletContext 是一个接口，它表示 Servlet 上下文对象 

2、一个 web 工程，==只有一个== ServletContext 对象实例。 

3、ServletContext 对象是一个==域对象==。 

4、ServletContext 是在 web 工程部署启动的时候创建。在 web 工程停止的时候销毁。 



**什么是域对象?** 

域对象，是可以像 Map 一样存取数据的对象，叫域对象。 

这里的域指的是存取数据的操作范围，整个 web 工程。

![20220107174951](E:\Desktop\myJavaStudy\docs\images\javaWeb\20220107174951.png)



**ServletContext** **类的四个作用** 

1、获取 web.xml 中配置的上下文参数 context-param 

2、获取当前的工程路径，格式: /工程路径 

3、获取工程部署后在服务器硬盘上的绝对路径 

4、像 Map 一样存取数据
