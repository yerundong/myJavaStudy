### Socket
所谓套接字(Socket)，就是对网络中不同主机上的应用进程之间进行双向通信的端点的抽象。一个套接字就是网络上进程通信的一端，提供了应用层进程利用网络协议交换数据的机制。从所处的地位来讲，套接字上联应用进程，下联网络协议栈，是应用程序通过网络协议进行通信的接口，是应用程序与网络协议根进行交互的接口
- 利用套接字(Socket)开发网络应用程序早已被广泛的采用，以至于成为事实上的标准。 
- 网络上具有唯一标识的IP地址和端口号组合在一起才能构成唯一能识别的标识符套接字。 
- 通信的两端都要有Socket，是两台机器间通信的端点。 
- 网络通信其实就是Socket间的通信。
- Socket允许程序把网络连接当成一个流，数据在两个Socket间通过IO传输。
- 一般主动发起通信的应用程序属客户端，等待通信请求的为服务端。

>Socket分类：
- 流套接字（stream socket）：使用TCP提供可依赖的字节流服务
- 数据报套接字（datagram socket）：使用UDP提供“尽力而为”的数据报服务

>Socket类的常用构造器： 
- public Socket(InetAddress address,int port)创建一个流套接字并将其连接到指定 IP 地址的指定端口号。 
- public Socket(String host,int port)创建一个流套接字并将其连接到指定主机上的指定端口号。 

> Socket类的常用方法：
- public InputStream getInputStream()返回此套接字的输入流。可以用于接收网络消息
- public OutputStream getOutputStream()返回此套接字的输出流。可以用于发送网络消息
- public InetAddress getInetAddress()此套接字连接到的远程 IP 地址；如果套接字是未连接的，则返回 null。 
- public InetAddress getLocalAddress()获取套接字绑定的本地地址。 即本端的IP地址
- public int getPort()此套接字连接到的远程端口号；如果尚未连接套接字，则返回 0。 
- public int getLocalPort()返回此套接字绑定到的本地端口。 如果尚未绑定套接字，则返回 -1。即本端的
端口号。 
- public void close()关闭此套接字。套接字被关闭后，便不可在以后的网络连接中使用（即无法重新连接
或重新绑定）。需要创建新的套接字对象。 关闭此套接字也将会关闭该套接字的 InputStream 和
OutputStream。 
- public void shutdownInput()如果在套接字上调用 shutdownInput() 后从套接字输入流读取内容，则流将
返回 EOF（文件结束符）。 即不能在从此套接字的输入流中接收任何数据。 
- public void shutdownOutput()禁用此套接字的输出流。对于 TCP 套接字，任何以前写入的数据都将被发
送，并且后跟 TCP 的正常连接终止序列。 如果在套接字上调用 shutdownOutput() 后写入套接字输出流，
则该流将抛出 IOException。 即不能通过此套接字的输出流发送任何数据。

### 基于Socket的TCP编程
> 客户端Socket的工作过程包含以下四个基本的步骤： 
1. 创建 Socket：根据指定服务端的 IP 地址或端口号构造 Socket 类对象。若服务器端响应，则建立客户端到服务器的通信线路。若连接失败，会出现异常。
1. 打开连接到 Socket 的输入/出流： 使用 getInputStream()方法获得输入流，使用getOutputStream()方法获得输出流，进行数据传输
1. 按照一定的协议对 Socket 进行读/写操作：通过输入流读取服务器放入线路的信息（但不能读取自己放入线路的信息），通过输出流将信息写入线程。
1. 关闭 Socket：断开客户端到服务器的连接，释放线路

> 服务器程序的工作过程包含以下四个基本的步骤：
2. 调用 ServerSocket(int port) ：创建一个服务器端套接字，并绑定到指定端口上。用于监听客户端的请求。
2. 调用 accept()：监听连接请求，如果客户端请求连接，则接受连接，返回通信套接字对象。 
2. 调用 该Socket类对象的 getOutputStream() 和 getInputStream ()：获取输出流和输入流，开始网络数据的发送和接收。
2. 关闭ServerSocket和Socket对象：客户端访问结束，关闭通信套接字。