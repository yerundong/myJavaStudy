# InetAddress
InetAddress类主要表示IP地址，两个子类：Inet4Address、Inet6Address。
InetAddress类没有提供公共的构造器，而是提供了如下几个静态方法来获取InetAddress实例：
- public static InetAddress getLocalHost()
- public static InetAddress getByName(String host)