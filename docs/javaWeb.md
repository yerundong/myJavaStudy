

# 什么是JavaWeb ？

JavaWeb，是用Java技术来解决相关web互联网领域的技术栈。web包括：web[服务端](https://baike.baidu.com/item/服务端/6492316)和web[客户端](https://baike.baidu.com/item/客户端/101081)两部分。Java在客户端的应用有Java Applet，不过[使用](https://baike.baidu.com/item/使用/7741550)得很少，Java在[服务器端](https://baike.baidu.com/item/服务器端/3369401)的应用非常的丰富，比如[Servlet](https://baike.baidu.com/item/Servlet/477555)，[JSP](https://baike.baidu.com/item/JSP/141543)、第三方[框架](https://baike.baidu.com/item/框架/1212667)等等。Java技术对Web领域的发展注入了强大的动力。



**Internet上供外界访问的Web资源分为：**

- 静态web资源：指web页面中供人们浏览的数据始终是不变。如：html、css、js、txt、mp4 、jpg 等。
  - 静态web资源开发技术：HTML、CSS。
- 动态web资源：指web页面中供人们浏览的数据是由程序产生的，不同时间点访问web页面看到的内容各不相同。如：jsp 页面、Servlet 程序等。
  - 动态web资源开发技术：JavaScript、JSP/Servlet、ASP、PHP等。在Java中，==动态web资源开发技术统称为Java Web==。



JavaWeb 是指，所有通过 Java 语言编写可以通过==浏览器访问==的程序的总称，叫 JavaWeb。 JavaWeb 是基于==请求==和==响应==来开发的。 



javaWeb学习网站：

http://c.biancheng.net/view/3980.html

https://www.runoob.com/servlet/servlet-tutorial.html



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



# Servlet容器

Servlet容器也叫做Servlet引擎，是Web服务器或应用程序服务器的一部分，用于在发送的请求和响应之上提供网络服务，解码基于 MIME的请求，格式化基于MIME的响应。

Servlet==没有main方法==，==不能独立运行==，它必须被部署到Servlet容器中，由容器来实例化和调用 Servlet的方法（如doGet()和doPost()），Servlet容器在Servlet的生命周期内包容和管理Servlet。在JSP技术 推出后，管理和运行Servlet/JSP的容器也称为Web容器。

（注：常用的MIME类型：text/html，application/pdf，video/quicktime，application /java，image/jpeg，application/jar，application/octet-stream，application/x- zip）

有了servlet之后，用户通过单击某个链接或者直接在浏览器的地址栏中输入URL来访问Servlet，Web服务器接收到该请求后，并不是将 请求直接交给Servlet，而是交给Servlet容器。Servlet容器实例化Servlet，调用Servlet的一个特定方法对请求进行处理， 并产生一个响应。这个响应由Servlet容器返回给Web服务器，Web服务器包装这个响应，以HTTP响应的形式发送给Web浏览器。



我们知道需要由servlet容器来管理和运行servlet，但是为什么要这样做呢？

**使用servlet容器的原因有：**

- **通信支持**：利用容器提供的方法，你能轻松的让servlet与web服务器对话，而不用自己建立serversocket、监听某个端口、创建流等 等。容器知道自己与web服务器之间的协议，所以你的servlet不用担心web服务器（如Apache）和你自己的web代码之间的API，只需要考虑如何在servlet中实现业务逻辑（如处理一个订单）。
- **生命周期管理**：servlet容器控制着servlet的生与死，它负责加载类、实例化和初始化servlet，调用servlet方法，以及使servlet实例被垃圾回收，有了servlet容器，你不需要太多的考虑资源管理。
- **多线程支持**：容器会自动为它所接收的每个servlet请求创建一个新的java线程。针对用户的请求，如果servlet已经运行完相应的http服务方法，这个线程就会结束。这并不是说你不需要考虑线程安全性，其实你还会遇到同步问题，不过这样能使你少做很多工作。
  声明方式实现安全：利用servlet容器，你可以使用xml部署描述文件来配置和修改安全性，而不必将其硬编码写到servlet类代码中。
- **JSP支持**：servlet容器负责将jsp代码翻译为真正的java代码。



**Servlet容器的分类：**

根据Servlet容器工作模式的不同，可以将Servlet容器分为以下三类：

1. **独立的Servlet容器**

   当我们使用基于Java技术的Web服务器时，Servlet容器作为构成Web服务器的一部分而存在。然而大多数的Web服务器并非基于Java，因此，就有了下面两种Servlet容器的工作模式。

2. **进程内的Servlet容器**

   Servlet容器由Web服务器插件和Java容器两部分的实现组成。Web服务器插件在某个Web服务器内部地址空间中打开一个 JVM（Java虚拟机），使得Java容器可以在此JVM中加载并运行Servlet。如有客户端调用Servlet的请求到来，插件取得对此请求的控 制并将它传递（使用JNI技术）给Java容器，然后由Java容器将此请求交由Servlet进行处理。进程内的Servlet容器对于单进程、多线程 的服务器非常适合，提供了较高的运行速度，但伸缩性有所不足。

3. **进程外的Servlet容器**

   Servlet容器运行于Web服务器之外的地址空间，它也是由Web服务器插件和Java容器两部分的实现组成的。Web服务器插件和Java容 器（在外部JVM中运行）使用IPC机制（通常是TCP/IP）进行通信。当一个调用Servlet的请求到达时，插件取得对此请求的控制并将其传递（使 用IPC机制）给Java容器。进程外Servlet容器对客户请求的响应速度不如进程内的Servlet容器，但进程外容器具有更好的伸缩性和稳定性。



# Tomcat

Tomcat是一个免费的开放源代码的Servlet容器，它是Apache软件基金会（Apache Software Foundation）的一个顶级项目，由Apache、Sun和其他一些公司及个人共同开发而成。由于有了Sun的参与和支持，最新的Servlet和 JSP规范总是能在Tomcat中得到体现，Tomcat 6支持最新的Servlet 2.5和JSP 2.1规范。因为Tomcat==技术先进、性能稳定，而且免费==，因而深受Java爱好者的喜爱，并得到了部分软件开发商的认可，成为==目前比较流行的Web服务器==。

Tomcat和IIS、Apache等Web服务器一样，具有==处理HTML页面的功能==，另外它还是一个==Servlet和JSP容器==，独立的 Servlet容器是Tomcat的默认模式。不过，Tomcat处理静态HTML的能力==不如Apache==，我们可以将Apache和Tomcat==集成==在 一起使用，Apache作为HTTP Web服务器，Tomcat作为Web容器。

Tomcat服务器接受客户请求并做出响应的过程如下：

1）客户端（通常都是浏览器）访问Web服务器，发送HTTP请求。
2）Web服务器接收到请求后，传递给Servlet容器。
3）Servlet容器加载Servlet，产生Servlet实例后，向其传递表示请求和响应的对象。
4）Servlet实例使用请求对象得到客户端的请求信息，然后进行相应的处理。
5）Servlet实例将处理结果通过响应对象发送回客户端，容器负责确保响应正确送出，同时将控制返回给Web服务器。

## 安装

官网下载：https://tomcat.apache.org/whichversion.html

找到你需要用的 Tomcat 版本对应的 zip 压缩包，解压到需要安装的目录即可。



## 目录介绍

![20211231153428](.\images\javaWeb\20211231153428.png)

## 环境变量

需要新增JAVA_HOME和CATALINA_HOME两个系统变量。

1. 新增一个系统变量，变量名：JAVA_HOME，变量值：jdk的安装路径。
2. 编辑path系统变量，新建一个`%JAVA_HOME%\bin`
2. 新增一个系统变量，变量名：CATALINA_HOME，变量值：tomcat的安装路径。
4. 编辑path系统变量，新建一个`%CATALINA_HOME%\bin



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

![20220105114621](.\images\javaWeb\20220105114621.png)

生成完目录结构如下。与maven生成的目录有所不同。

![20220106143828](.\images\javaWeb\20220106143828.png)

WEB-INF是Java的WEB应用的安全目录。所谓安全就是客户端无法访问，只有服务端可以访问的目录。如果想在页面中直接访问其中的文件，必须通过web.xm文件对要访问的文件进行相应映射才能访问。

web.xml是Web应用程序配置文件，描述了 servlet 和其他的应用组件配置及命名规则。



## 使用maven模板创建一个Web项目

![20220104160553](.\images\javaWeb\20220104160553.png)



## WEB资源目录（web resource directory）

WEB资源是指存放浏览器可以访问的资源，前端代码（html、css、js）、文件（图片、视频...）、虚拟路径等。

外部允许==直接访问==WEB资源目录下的资源，==除了WEB-INF目录==，但可以==通过转发间接访问==WEB-INF下的资源。



**IDEA中WEB资源目录的图标标识：**![20220112164928](.\images\javaWeb\20220112164928.png)



**设置WEB资源目录：**

![20220112164716](.\images\javaWeb\20220112164716.png)



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

[Servlet](http://c.biancheng.net/servlet/)（Server Applet）是 Java Servlet 的简称，称为==小服务程序==或==服务连接器==，是使用 Java 语言编写的运行在服务器端的程序。具有==独立于平台和协议==的特性，==主要功能在于交互式地浏览和生成数据，生成动态Web内容==。它是作为来自 Web 浏览器或其他 HTTP 客户端的请求和 HTTP 服务器上的数据库或应用程序之间的==中间层==。

Servlet ==主要用于处理客户端传来的 HTTP 请求，并返回一个响应==，它能够处理的请求有 doGet() 和 doPost() 等。

==狭义==的Servlet是指Java语言实现的一个接口，==广义==的Servlet是指任何实现了这个Servlet接口的类，一般情况下，人们将Servlet理解为==后者==。Servlet运行于支持Java的应用服务器中。从原理上讲，Servlet==可以响应任何类型的请求==，但==绝大多数情况下Servlet只用来扩展基于HTTP协议的Web服务器==。

Servlet 就是被用来==扩展服务器的性能==，服务器上驻留着可以通过==“请求-响应”编程模型==来访问的应用程序。虽然 Servlet 可以对任何类型的请求产生响应，但通常只用来扩展 ==Web 服务器==的应用程序。

使用 Servlet，您可以收集来自网页表单的用户输入，呈现来自数据库或者其他源的记录，还可以动态创建网页。

Servlet 是 Java 企业版（JavaEE）的==标准组成部分==，Java 企业版（JavaEE）是支持大型开发项目的 Java 类库的==扩展版本==。

Servlet是JavaEE的规范之一，规范即接口。

Servlet是javaWeb==三大组件==之一。三大组件分别是：Servlet程序、Filter过滤器、Listener监听器。

Servlet 由 ==Servlet 容器==提供，==Servlet 容器是指提供了 Servlet 功能的服务器==（如 Tomcat）。

Servlet 容器会将 Servlet 动态加载到服务器上，然后通过 HTTP 请求和 HTTP 应与客户端进行交互。

Servlet 应用程序的体系结构如下图所示。

![5-1Z6061I51XX](.\images\javaWeb\5-1Z6061I51XX.gif)

在上图中，Servlet 的请求首先会==被 HTTP 服务器（如 Apache）接收==，HTTP 服务器只负责静态 HTML 页面的解析，而 Servlet 的请求会==转交给 Servlet 容器==（如 Tomcat），Servlet 容器会根据 web.xml 文件中的==映射关系==，调用相应的 Servlet，Servlet 再将处理的结果==返回给 Servlet 容器==，并通过 HTTP 服务器将响应==传输给客户端==。



针对 Servlet 的每次请求，Web 服务器在调用 service() 方法==之前==，都会创建 HttpServletRequest 和 HttpServletResponse 对象。其中，HttpServletRequest 对象用于封装 HTTP 请求消息，简称 request 对象。HttpServletResponse 对象用于封装 HTTP 响应消息，简称 response 对象。Servlet 的交互过程如下图所示。

![5-1Z610154349322](.\images\javaWeb\5-1Z610154349322.png)

在上图中，首先浏览器向 Web 服务器发送了一个 HTTP 请求，Web 服务器根据收到的请求，会先创建一个 HttpServletRequest 和 HttpServletResponse 对象，然后再调用相应的 Servlet 程序。

在 Servlet 程序运行时，它首先会从 HttpServletRequest 对象中读取数据信息，然后通过 service() 方法处理请求消息，并将处理后的响应数据写入到 HttpServletResponse 对象中。最后，Web 服务器会从 HttpServletResponse 对象中读取到响应数据，并发送给浏览器。

需要注意的是，在 Web 服务器运行阶段，每个 Servlet 都==只会创建一个实例对象==，针对==每次==HTTP 请求，Web 服务器==都会调用==所请求 Servlet 实例的 ==service==（HttpServletRequest request，HttpServletResponse response）方法，并==重新创建==一个 request 对象和一个 response 对象。



## Servlet 优势

Java Servlet 通常情况下与使用 ==CGI（Common Gateway Interface，公共网关接口）==实现的程序可以达到异曲同工的效果。但是相比于 CGI，Servlet 有以下几点优势：

- **性能明显更好**。因为Servlet 在 Web 服务器的地址空间内执行，它没有必要再创建一个单独的==进程==来处理每个客户端请求，各个用户请求被激活成单个程序中的一个==线程==，而无需创建单独的进程。
- **跨平台**。Servlet 是独立于平台的，因为它们是用 Java 编写的，可以在不同的操作系统平台和不同的应用服务器平台运行。
- **安全性强**。服务器上的 Java 安全管理器执行了一系列限制，以保护服务器计算机上的资源。因此，Servlet 是可信的。
- **灵活性和可扩展性强。**采用 Servlet 开发的 Web 应用程序，由于 Java 类的继承性及构造函数等特点，使得应用灵活，可随意扩展。Java 类库的全部功能对 Servlet 来说都是可用的。
- **交互性强**。Servlet 可以通过 sockets 和 RMI 机制与 applets、数据库或其他软件进行交互。能够在各个程序之间共享数据。



## Servlet 架构

下图显示了 Servlet 在 Web 应用程序中的位置。



![servlet-arch](.\images\javaWeb\servlet-arch.jpg)



## Servlet 任务

Servlet 执行以下主要任务：

- 读取客户端（浏览器）发送的显式的数据。这包括网页上的 HTML 表单，或者也可以是来自 applet 或自定义的 HTTP 客户端程序的表单。
- 读取客户端（浏览器）发送的隐式的 HTTP 请求数据。这包括 cookies、媒体类型和浏览器能理解的压缩格式等等。
- 处理数据并生成结果。这个过程可能需要访问数据库，执行 RMI 或 CORBA 调用，调用 Web 服务，或者直接计算得出对应的响应。
- 发送显式的数据（即文档）到客户端（浏览器）。该文档的格式可以是多种多样的，包括文本文件（HTML 或 XML）、二进制文件（GIF 图像）、Excel 等。
- 发送隐式的 HTTP 响应到客户端（浏览器）。这包括告诉浏览器或其他客户端被返回的文档类型（例如 HTML），设置 cookies 和缓存参数，以及其他类似的任务。



## Servlet 生命周期

- Servlet 初始化后调用 **init ()** 方法。==只调用一次==。它在第一次创建 Servlet 时被调用，在后续每次用户请求时不再调用。
- Servlet 调用 **service()** 方法来处理客户端的请求。==每次请求都会调用==，是执行实际任务的主要方法。每次服务器接收到一个 Servlet 请求时，服务器会产生一个==新的线程==并调用服务。service() 方法检查 HTTP 请求类型（GET、POST、PUT、DELETE 等），并在适当的时候调用 doGet、doPost、doPut，doDelete 等方法。
- Servlet ==销毁前==调用 **destroy()** 方法。

https://www.runoob.com/servlet/servlet-life-cycle.html



## Servlet 包结构

使用Servlet 需要导入 **javax.servlet** 相关包：https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api



### 继承图

![6323142341234212ffd](.\images\javaWeb\6323142341234212ffd.jpg)

![20220107165058](.\images\javaWeb\20220107165058.png)



### Servlet接口

Servlet接口定义所有servlet类都必须实现的方法（==规范==）。 这些方法称为==生命周期方法==。

除了生命周期方法之外，此接口还提供了 `getServletConfig` 方法和 `getServletInfo`  方法，servlet 可使用前一种方法获得任何启动信息，而后一种方法允许 servlet 返回有关其自身的基本信息，比如作者、版本和版权。

开发中一般==不直接实现该接口==，而是选择继承GenericServlet类或HttpServlet类，更为便捷。



### ServletConfig 类

ServletConfig 类从类名上来看，就知道是 Servlet 程序的==配置信息==类（web.xml中的配置信息）。 通过 ServletConfig 对象可以获得 web.xml 文件中的参数信息。

Servlet 程序和 ServletConfig 对象都是由 Tomcat 负责创建，我们负责使用。 

Servlet 程序默认是==第一次访问==的时候创建，ServletConfig 是每个 Servlet 程序创建时，只创建==一个==对应的 ServletConfig 对象。

ServletConfig 类提供了获取Servlet 配置信息的功能。GenericServlet中在==初始化==时，会取到配置信息，并存下来。

![20220107174359](.\images\javaWeb\20220107174359.png)

配置信息中包含：servlet-name、init-param、servletContext等配置信息。



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



### servletContext接口

当 Tomcat 启动时，Tomcat 会为每个 Web 应用创建一个唯一的 ServletContext 对象代表当前的 Web 应用，该对象封装了当前 Web 应用的所有信息。可以利用该对象获取 Web 应用程序的==初始化参数信息、读取资源文件==等。下面对 ServletContext 接口的不同作用分别进行讲解。

ServletConfig对象是由ServletConfig 对象获取到的。

1、ServletContext 是一个接口，它表示 Servlet 上下文对象 

2、一个 web 工程，==只有一个== ServletContext 对象实例。 

3、ServletContext 对象是一个==域对象==。 

4、ServletContext 是在 web 工程部署启动的时候创建。在 web 工程停止的时候销毁。 



**什么是域对象?** 

域对象，是可以像 Map 一样存取数据的对象，叫域对象。 

这里的域指的是==存取数据的操作范围==，整个 web 工程，所有Servlet类都能访问。

![20220107174951](.\images\javaWeb\20220107174951.png)



**ServletContext** **类的四个作用** 

1、获取 web.xml 中配置的上下文参数 context-param 

2、获取当前的工程路径，格式: /工程路径 

3、获取工程部署后在服务器硬盘上的绝对路径 

4、像 Map 一样存取数据



## 编写一个servlet 类步骤

1. 创建一个类，继承HttpServlet类
2. 根据实际需求，重写doGet或doPost或其他doXxx方法。
3. web.xml配置servlet
4. tomcat部署运行测试



### IDEA 快捷方式创建Servlet

![20220107162417](.\images\javaWeb\20220107162417.png)

![20220107162829](.\images\javaWeb\20220107162829.png)





## web.xml配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee
                      https://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd"
         version="5.0">

    <!-- request-character-encoding标签用来配置请求编码，可在ServletContext对象中获得 -->
    <request-character-encoding>UTF-8</request-character-encoding>
    <!-- response-character-encoding标签用来配置返回编码，可在ServletContext对象中获得 -->
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

    <!-- servlet-mapping标签给servlet程序配置访问虚拟地址（servlet映射成虚拟路径） -->
    <servlet-mapping>
        <!-- servlet-name标签是配置目标servlet程序的别名（对应上面servlet-name） -->
        <servlet-name>HelloServlet</servlet-name>
        <!-- servlet-pattern标签配置虚拟地址 -->
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
</web-app>
```

最终访问地址：http://localhost:8099/webapp/hello

- http://localhost:8099：协议+主机名+端口

- webapp：web上下文，一般为web应用的根目录
- hello：资源路径，映射到servlet.HelloServlet类

![20220107145005](.\images\javaWeb\20220107145005.png)



## Servlet配置虚拟路径映射

虚拟路径，也就是我们通常所说的==接口请求地址==，它是对外访问servlet的一个路径。

配置完虚拟路径，虚拟路径会成为==web资源目录下的一个资源==，提供外部的==浏览器地址访问==或==接口请求==。

http://c.biancheng.net/view/3996.html



## 请求与响应

### 获取请求信息

HttpServletRequest 接口继承自 ServletRequest 接口，其对象==代表客户端的请求==，其主要作用是==封装 HTTP 请求消息==。由于 HTTP 请求消息分为请求行、请求消息头和请求消息体三部分。因此，在 HttpServletRequest 接口中定义了==获取请求行、请求头和请求消息体==的相关方法。



#### 获取请求行信息的相关方法

| 方法声明                     | 功能描述                                                     |
| ---------------------------- | ------------------------------------------------------------ |
| String getMethod()           | 获取 HTTP 请求消息中的==请求方式==（如 GET、POST 等）        |
| String getRequestURI()       | 获取请求行中的==资源名称部分==，即位于 URL 的主机和端门==之后==、参数部分==之前==的部分 |
| String getQueryString()      | 获取请求行中的参数部分，也就是资源路径后问号（？）以后的所有内容 |
| String getContextPath()      | 获取请求 URL 中属于 Web 应用程序的路径，这个路径以 / 开头，表示相对于整个 Web 站点的根目录，路径结尾不含 /。如果请求 URL 属于 Web 站点的根目录，那么返回结果为空字符串（""） |
| String getPathInfo()         | 返回在 servlet 名称之后但在查询字符串之前的额外路径信息，并将它转换为实际路径。 |
| String getServletPath()      | 获取 Servlet 的名称或 Servlet 所映射的路径                   |
| String getRemoteAddr()       | 获取请求客户端的 IP 地址，其格式类似于 192.168.0.3           |
| String getRemoteHost()       | 获取请求客户端的完整主机名，其格式类似于 pcl.mengma.com。需要注意的是，如果无法解析出客户机的完整主机名，那么该方法将会返回客户端的 IP 地址 |
| int getRemotePort()          | 获取请求客户端网络连接的端口号                               |
| String getLocaIAddr()        | 获取 Web 服务器上接收当前请求网络连接的 IP 地址              |
| String getLocalName()        | 获取 Web 服务器上接收当前网络连接 IP 所对应的主机名          |
| int getLocalPort()           | 获取 Web 服务器上接收当前网络连接的端口号                    |
| String getServerName()       | 获取当前请求所指向的主机名，即 HTTP 请求消息中 Host 头字段所对应的主机名部分 |
| int getServerPort()          | 获取当前请求所连接的服务器端口号，即 HTTP 请求消息中 Host 头字段所对应的端口号部分 |
| StringBuffcr getRequestURL() | 获取客户端发出请求时的完整 URL，包括协议、服务器名、端口号、 资源路径等信息，但不包括后面的査询参数部分。注意，getRequcstURL() 方法返冋的结果是 StringBuffer 类型，而不是 String 类型，这样更便于对结果进行修改 |



#### 获取请求消息头的相关方法

| 方法声明                            | 功能描述                                                     |
| ----------------------------------- | ------------------------------------------------------------ |
| String getHeader(String name)       | 获取一个指定头字段的值，如果请求消息中没有包含指定的头字段，则 getHeader() 方法返回 null；如果请求消息中包含多个指定名称的头字段，则 getHeader() 方法返回其中第一个头字段的值 |
| Enumeration getHeaders(String name) | 返回一个 Enumeration 集合对象，该集合对象由请求消息中出现的某个指定名称的所有头字段值组成。在多数情况下，一个头字段名在请求消息中只出现一次，但有时可能会出现多次 |
| Enumeration getHeaderNames()        | 获取一个包含所有请求头字段的 Enumeration 对象                |
| int getIntHeader(String name)       | 获取指定名称的头字段，并且将其值转为 int 类型。需要注意的是，如果指定名称的头字段不存在，则返回值为 -1；如果获取到的头字段的值不能转为 int 类型，则将发生 NumberFormatException 异常 |
| long getDateHeader(String name)     | 获取指定头字段的值，并将其按 GMT 时间格式转换为一个代表日期/时间的长整数，该长整数是自 1970 年 1 月 1 日 0 时 0 分 0 秒算起的以毫秒为单位的时间值 |
| String getContentType()             | 获取 Content-Type 头字段的值，结果为 String 类型             |
| int getContentLength()              | 获取 Content-Length 头字段的值，结果为 int 类型              |
| String getCharacterEncoding()       | 返回请求体的字符集编码，通常是从 Content-Type 头字段中进行提取，结果为 String 类型 |



#### 获取请求参数

| 方法声明                                   | 功能描述                                                     |
| ------------------------------------------ | ------------------------------------------------------------ |
| String getParameter(String name)           | 获取某个指定名称的参数值。 如果请求消息中没有包含指定名称的参数，则 getParameter() 方法返回 null。 如果指定名称的参数存在但没有设置值，则返回一个空串。 如果请求消息中包含多个该指定名称的参数，则 getParameter() 方法返回第一个出现的参数值。 |
| String [] getParameterValues (String name) | HTTP 请求消息中可以有==多个相同名称的参数==（通常由一个包含多个同名的字段元素的 form 表单生成），如果要获得 HTTP 请求消息中的同一个参数名所对应的所有参数值，那么就应该使用 getParameterValues() 方法，该方法用于返回一个 ==String 类型的数组==。 |
| Enumeration getParameterNames()            | 返回一个包含请求消息中所有参数名的 Enumeration 对象，在此基础上，可以对请求消息中的所有参数进行遍历处理。 |
| Map getParameterMap()                      | 将请求消息中的所有参数名和值装入一个 Map 对象中返回。(编写框架时常用) |



#### 设置请求参数

| 方法声明                              | 功能描述                                                     |
| ------------------------------------- | ------------------------------------------------------------ |
| void setCharacterEncoding(String env) | 覆盖==请求体中使用的字符编码==。必须在==读取请求参数==或使用 ==getReader()== 读取输入==之前==调用此方法。否则，它没有效果。（可解决中文乱码问题） |

### 设置响应信息





## 请求转发

当一个 Web 资源收到客户端的请求后，如果希望服务器通知==另外一个资源（还是同一个服务器）==处理请求，那么这时可以通过 RequestDispatcher 接口的实例对象实现。ServletRequest 接口中定义了一个获取 RequestDispatcher 对象的方法，如下表所示。



**获取 RequestDispatcher 对象的方法：**

| 方法声明                                             | 功能描述                                                     |
| ---------------------------------------------------- | ------------------------------------------------------------ |
| RequestDispatcher getRequestDispatcher (String path) | 返回封装了某条路径所指定资源的 RequestDispatcher 对象。其中，==参数 path 必须以“/”开头==，用于表示当前 ==Web 资源根目录==。需要注意的是，==WEB-INF== 目录中的内容对 RequestDispatcher 对象也是可见的。因此，传递给 getRequestDispatcher(String path) 方法的资源可以是 WEB-INF 目录中的文件。 |



获取到 RequestDispatcher 对象后，最重要的工作就是==通知==其他 ==Web 资源==处理当前的 Servlet 请求，为此，RequestDispatcher 接口定义了两个相关方法，如下表所示。

**RequestDispatcher 接口的方法：**

| 方法声明                                                 | 功能描述                                                     |
| -------------------------------------------------------- | ------------------------------------------------------------ |
| forward(ServletRequest request,ServletResponse response) | 该方法用于将请求从一个 Servlet ==传递==给另一个 Web 资源。在 Servlet 中，可以对请求做一个初步处理，然后通过调用这个方法，将请求传递给其他资源进行响应。需要注意的是，该方法必须在响应提交给客户端之前被调用，否则将抛出 IllegalStateException 异常 |
| include(ServletRequest request,ServletResponse response) | 该方法用于将其他的资源作为当前响应内容包含进来               |



**转发的资源对象可以是web资源目录中的任意资源，包括:**

1. 其他虚拟路径

2. 前端代码（css、js、html...）

3. 文件（图片...）

4. WEB-INF 目录中的文件

5. ###### ……

> 无法转发web资源目录外的资源



### 请求转发html页面相对路径错误问题

当html标签是被使用转发访问时，其中的相对路径跳转就会出问题，此时可以在html的头部加入base标签进行解决。

具体情况查看演示代码。



## 问题

### 一、tomcat10 实例化servlet HTTP 500

解决方式一：tomcat10 降级为 tomcat9

解决方式二：https://blog.csdn.net/qq_38149542/article/details/115979379



# HTTP请求

## 常用的响应码说明

200 表示请求成功 

302 表示请求重定向

404 表示请求服务器已经收到了，但是你要的数据不存在（请求地址错误） 

500 表示服务器已经收到请求，但是服务器内部错误（代码错误）



## MIME 类型说明

MIME 是 HTTP 协议中数据类型。 

MIME 的英文全称是"Multipurpose Internet Mail Extensions" 多功能 Internet 邮件扩充服务。MIME 类型的格式是“大类型/小类型”，并与某一种文件的扩展名相对应。 

常见的 MIME 类型： 

| 类型          | 描述                                                         | 典型示例                                                     |
| :------------ | :----------------------------------------------------------- | :----------------------------------------------------------- |
| `text`        | 表明文件是普通文本，理论上是人类可读                         | `text/plain`, `text/html`, `text/css, text/javascript`       |
| `image`       | 表明是某种图像。不包括视频，但是动态图（比如动态gif）也使用image类型 | `image/gif`, `image/png`, `image/jpeg`, `image/bmp`, `image/webp`, `image/x-icon`, `image/vnd.microsoft.icon` |
| `audio`       | 表明是某种音频文件                                           | `audio/midi`, `audio/mpeg, audio/webm, audio/ogg, audio/wav` |
| `video`       | 表明是某种视频文件                                           | `video/webm`, `video/ogg`                                    |
| `application` | 表明是某种二进制数据                                         | `application/octet-stream`, `application/pkcs12`, `application/vnd.mspowerpoint`, `application/xhtml+xml`, `application/xml`, `application/pdf`,`application/x-gzip `,`application/x-tar ` |



## 请求头（HTTP Request Header）

![20220110113102](.\images\javaWeb\20220110113102.png)

## 响应头（HTTP Responses Header） 

![20220110113809](.\images\javaWeb\20220110113809.png)
