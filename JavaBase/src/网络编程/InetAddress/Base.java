package 网络编程.InetAddress;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Base {
    /**
     * @获取IP地址对象
     */
    @Test
    public void getByName() {
        // <SM> public static InetAddress getByName(String host)
        // <返> 在给定主机名的情况下获取 IP 地址对象。
        // <注> host可以是主机名（如 "localhost"、"www.baidu.com"）、IP地址（"127.0.0.1"）、域名（"www.baidu.com"）
        try {
            InetAddress ia = InetAddress.getByName("163.177.151.110");// /163.177.151.110
            // ia = InetAddress.getByName("www.baidu.com");// www.baidu.com/163.177.151.110
            // ia = InetAddress.getByName("localhost");// localhost/127.0.0.1
            // ia = InetAddress.getByName("PC-20200607IERO");// PC-20200607IERO/172.18.150.181

            System.out.println(ia);
            System.out.println(ia.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * @获取本机IP地址对象
     */
    @Test
    public void getLocalHost() {
        // <SM> public static InetAddress getLocalHost()
        // <返> 获取本机 IP 地址对象。
        try {
            InetAddress ia = InetAddress.getLocalHost();
            System.out.println(ia);
            System.out.println(ia.getHostName());
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
            InetAddress ia = InetAddress.getLocalHost();
            System.out.println(ia.getHostName());// PC-20200607IERO
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
            InetAddress ia = InetAddress.getLocalHost();
            System.out.println(ia.getHostAddress());// 172.18.150.181
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * @获取
     */
    @Test
    public void getAddress() {
        // <M> public String getHostAddress()
        // <返> 获取主机地址（ip地址）
        try {
            InetAddress ia = InetAddress.getLocalHost();
            System.out.println(ia.getAddress());// 172.18.150.181
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
