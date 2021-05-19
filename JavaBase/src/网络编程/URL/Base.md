### URL
URL(Uniform Resource Locator)：统一资源定位符，它表示 Internet 上某一
资源的地址。它是一种具体的URI，即URL可以用来标识一个资源，而且还指明了如何locate
这个资源。

通过 URL 我们可以访问 Internet 上的各种网络资源，比如最常见的 www，ftp 站点。浏览器通过解析给定的 URL 可以在网络上查找相应的文件或其他资源。

URL的基本结构由5部分组成： 

    <传输协议>://<主机名>:<端口号>/<文件名>#片段名?参数列表

例如: 

    http://192.168.1.100:8080/helloworld/index.jsp#a?username=shkstart&password=123

\#片段名：即锚点，例如看小说，直接定位到章节

参数列表格式：参数名=参数值&参数名=参数值

> java.net.URL表示URL。通过下面的构造器来初始化一个 URL 对象：

1. public URL (String spec)：通过一个表示URL地址的字符串可以构造一个URL对象。例
如：URL url = new URL ("http://www. atguigu.com/"); 
1. public URL(URL context, String spec)：通过基 URL 和相对 URL 构造一个 URL 对象。
例如：URL downloadUrl = new URL(url, “download.html")
1. public URL(String protocol, String host, String file); 例如：new URL("http", 
"www.atguigu.com", “download. html");
1. public URL(String protocol, String host, int port, String file); 例如: URL gamelan = new 
URL("http", "www.atguigu.com", 80, “download.html");

URL类的构造器都声明抛出非运行时异常，必须要对这一异常进行处理，通常是用 try-catch 语句进行捕获。

一个URL对象生成后，其属性是不能被改变的，但可以通过它给定的方法来获取这些属性：

1. public String getProtocol( ) 获取该URL的协议名
1. public String getHost( ) 获取该URL的主机名
1. public String getPort( ) 获取该URL的端口号
1. public String getPath( ) 获取该URL的文件路径
1. public String getFile( ) 获取该URL的文件名
1. public String getQuery( ) 获取该URL的查询名

> 针对HTTP协议的URLConnection类 
- URL的方法 openStream()：能从网络上读取数据
- 若希望输出数据，例如向服务器端的 CGI （公共网关接口-Common Gateway 
Interface-的简称，是用户浏览器和服务器端的应用程序进行连接的接口）程序发送一
些数据，则必须先与URL建立连接，然后才能对其进行读写，此时需要使用
URLConnection 。 
- URLConnection：表示到URL所引用的远程对象的连接。当与一个URL建立连接时，
首先要在一个 URL 对象上通过方法 openConnection() 生成对应的 URLConnection
对象。如果连接过程失败，将产生IOException. 
```java
URL netchinaren = new URL ("http://www.atguigu.com/index.shtml"); 
URLConnectonn u = netchinaren.openConnection( );
```

- 通过URLConnection对象获取的输入流和输出流，即可以与现有的CGI程序进行交互。
1. public Object getContent( ) throws IOException
1. public int getContentLength( )
1. public String getContentType( )
1. public long getDate( )
1. public long getLastModified( )
1. public InputStream getInputStream( )throws IOException
1. public OutputSteram getOutputStream( )throws IOException

### URI、URL和URN的区别
URI，是uniform resource identifier，统一资源标识符，用来唯一的标识一个资源。而URL是uniform resource locator，统一资源定位符，它是一种具体的URI，即URL可以用来标识一个资源，而且还指明了如何locate这个资源。而URN，uniform resource name，统一资源命名，是通过名字来标识资源，比如mailto:java-net@java.sun.com。也就是说，URI是以一种抽象的，高层次概念定义统一资源标识，而URL和URN则是具体的资源标识的方式。URL 和URN都是一种URI。

在Java的URI中，一个URI实例可以代表绝对的，也可以是相对的，只要它符合URI的语法规则。而URL类则
不仅符合语义，还包含了定位该资源的信息，
因此它不能是相对的。