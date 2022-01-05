package 网络编程.Socket编程.基于Socket的TCP编程;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description 基于socket的TCP协议网络编程：模拟客户端、服务端
 */
public class Base {
    /**
     * @客户端
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStreamWriter osw = null;
        InputStreamReader isr = null;
        try {
            // 1.创建socket对象，指明服务端ip和端口号
            // 创建的同时会自动向服务器方发起连接。客户端建立socket对象的过程就是向服务器发出套接字连接请求
            System.out.println("正在连接服务……");
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            socket = new Socket(ip, 18765);
            System.out.println("连接成功！");

            // 2.创建一个输出流，输出数据
            System.out.println("开始传出数据！");
            OutputStream os = socket.getOutputStream();
            osw = new OutputStreamWriter(os);// 转换流，防止乱码
            osw.write("你好，我是客户端！——来自客户端");
            osw.flush();
            socket.shutdownOutput();// 关闭socket的输出，防止阻塞
            System.out.println("传出成功！");

            // 3.创建一个输入流，读数据
            System.out.println("开始传入数据！");
            InputStream is = socket.getInputStream();
            isr = new InputStreamReader(is);// 转换流，防止乱码
            char[] buffer = new char[5];
            int len;
            while ((len = isr.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, len));
            }
            System.out.println("\n传入成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.资源关闭
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @服务端
     */
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            // 1.创建服务端ServerSocket，指明自己的端口号。用于监听客户端的请求。
            serverSocket = new ServerSocket(18765);
            System.out.println("服务端正在监听请求……");

            // 2.监听连接请求，如果客户端请求连接，则接受连接，获得通信套接字对象
            socket = serverSocket.accept();
            System.out.println("客户端已连接成功！客户端ip为：" + socket.getInetAddress().getHostAddress());

            // 3.创建输入流，读入数据
            System.out.println("开始传入数据！");
            InputStream is = socket.getInputStream();
            isr = new InputStreamReader(is);// 字节转字符输入
            char[] buffer = new char[5];
            int len;
            while ((len = isr.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, len));
            }
            socket.shutdownInput();
            System.out.println("\n传入成功！");

            // 4.创建输出流，写出数据
            System.out.println("开始传出数据！");
            OutputStream os = socket.getOutputStream();
            osw = new OutputStreamWriter(os);
            osw.write("你好！客户端！——来自服务端");
            System.out.println("传出成功！");
            // socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5.关闭资源
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
