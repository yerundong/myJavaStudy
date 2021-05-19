package 网络编程.UDP通讯;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Base {
    /**
     * @发送端
     */
    @Test
    public void sender() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            byte[] data = "发送导弹！".getBytes();
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println(ip.getHostAddress());
            DatagramPacket packet = new DatagramPacket(data, 0, data.length, ip, 8090);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }

    /**
     * @接收端
     */
    @Test
    public void receiver() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(8090);
            byte[] buffer = new byte[100];
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
            socket.receive(packet);
            byte[] data = packet.getData();
            System.out.println(new String(data, 0, data.length));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
