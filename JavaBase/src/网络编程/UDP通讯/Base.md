### UDP网络通信
- 类 DatagramSocket 和 DatagramPacket 实现了基于 UDP 协议网络程序。
- UDP数据报通过数据报套接字 DatagramSocket 发送和接收，系统不保证UDP数据报一定能够安全送到目的地，也不能确定什么时候可以抵达。
- DatagramPacket 对象封装了UDP数据报，在数据报中包含了发送端的IP地址和端口号以及接收端的IP地址和端口号。
- UDP协议中每个数据报都给出了完整的地址信息，因此无须建立发送方和接收方的连接。如同发快递包裹一样。

> 流 程：
1. DatagramSocket与DatagramPacket
2. 建立发送端，接收端
3. 建立数据包
4. 调用Socket的发送、接收方法
5. 关闭Socket

> DatagramSocket 类的常用方法
- public DatagramSocket(int port)创建数据报套接字并将其绑定到本地主机上的指定端口。套接字将被
绑定到通配符地址，IP 地址由内核来选择。 
- public DatagramSocket(int port,InetAddress laddr)创建数据报套接字，将其绑定到指定的本地地址。
本地端口必须在 0 到 65535 之间（包括两者）。如果 IP 地址为 0.0.0.0，套接字将被绑定到通配符地
址，IP 地址由内核选择。 
- public void close()关闭此数据报套接字。 
- public void send(DatagramPacket p)从此套接字发送数据报包。DatagramPacket 包含的信息指示：将
要发送的数据、其长度、远程主机的 IP 地址和远程主机的端口号。  
- public void receive(DatagramPacket p)从此套接字接收数据报包。当此方法返回时，DatagramPacket
的缓冲区填充了接收的数据。数据报包也包含发送方的 IP 地址和发送方机器上的端口号。 此方法
在接收到数据报前一直阻塞。数据报包对象的 length 字段包含所接收信息的长度。如果信息比包的
长度长，该信息将被截短。 
- public InetAddress getLocalAddress()获取套接字绑定的本地地址。 
- public int getLocalPort()返回此套接字绑定的本地主机上的端口号。 
- public InetAddress getInetAddress()返回此套接字连接的地址。如果套接字未连接，则返回 null。 
- public int getPort()返回此套接字的端口。如果套接字未连接，则返回 -1

> DatagramPacket类的常用方法
- public DatagramPacket(byte[] buf,int length)构造 DatagramPacket，用来接收长
度为 length 的数据包。 length 参数必须小于等于 buf.length。 
- public DatagramPacket(byte[] buf,int length,InetAddress address,int port)构造数
据报包，用来将长度为 length 的包发送到指定主机上的指定端口号。length
参数必须小于等于 buf.length。 
- public InetAddress getAddress()返回某台机器的 IP 地址，此数据报将要发往该
机器或者是从该机器接收到的。 
- public int getPort()返回某台远程主机的端口号，此数据报将要发往该主机或
者是从该主机接收到的。 
- public byte[] getData()返回数据缓冲区。接收到的或将要发送的数据从缓冲区
中的偏移量 offset 处开始，持续 length 长度。 
- public int getLength()返回将要发送或接收到的数据的长度。
