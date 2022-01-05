package 网络编程.InetAddress;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Base {
    /**
     * @实例化，获取IP地址对象
     */
    @Test
    public void getByName() {
        // <SM> public static InetAddress getByName(String host)
        // <返> 在给定主机名\IP地址\域名的情况下获取 IP 地址对象。
        // <注> host可以是主机名（如 "localhost"、"www.baidu.com"）、IP地址（"127.0.0.1"）、域名（"www.baidu.com"）
        try {
            // InetAddress ip = InetAddress.getByName("163.177.151.110");// /163.177.151.110
            InetAddress ip = InetAddress.getByName("www.baidu.com");// www.baidu.com/163.177.151.110
            // InetAddress ip = InetAddress.getByName("localhost");// localhost/127.0.0.1
            // InetAddress ip = InetAddress.getByName("PC-20200607IERO");// PC-20200607IERO/172.18.150.181

            System.out.println(ip);
            System.out.println(ip.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * @实例化，获取本机IP地址对象
     */
    @Test
    public void getLocalHost() {
        // <SM> public static InetAddress getLocalHost()
        // <返> 获取本机 IP 地址对象。
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println(ip);
            System.out.println(ip.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    /**
     * @获取主机名
     */
    @Test
    public void getHostName() {
        // <M> public String getHostName()
        // <返> 获取主机名
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println(ip.getHostName());// PC-20200607IERO
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * @获取主机地址（ip地址）
     */
    @Test
    public void getHostAddress() {
        // <M> public String getHostAddress()
        // <返> 获取主机地址（ip地址）
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println(ip.getHostAddress());// 172.18.150.181
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * @获取原始 IP 地址
     */
    @Test
    public void getAddress() {
        // <M> public byte[] getAddress()
        // <返> 返回此 InetAddress 对象的原始 IP 地址。结果按网络字节顺序
        try {
            InetAddress ip = InetAddress.getLocalHost();
            byte[] address = ip.getAddress();
            System.out.println(address);

            System.out.println(Arrays.toString(address));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * @测试是否可以达到该地址
     */
    @Test
    public void reachable() {
        // <M> public boolean isReachable(int timeout)
        // <返> 测试是否可以达到该地址。实现尽最大努力试图到达主机，但防火墙和服务器配置可能阻塞请求，使其在某些特定的端口可以访问时处于不可到达状态。
        // <注> timeout - 调用中止前的时间（以毫秒为单位）
        try {
            InetAddress ip = InetAddress.getByName("172.18.166.134");
            boolean reachable = ip.isReachable(5000);
            System.out.println(reachable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
