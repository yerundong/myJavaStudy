package IO流.各种流的使用.缓冲流.BufferedInputStream;

import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Base {
    /**
     * @构造器，创建BufferedInputStream流
     */
    @Test
    public void Constructor() throws IOException {
        // <CM> public BufferedInputStream(InputStream in)
        // <CM> public BufferedInputStream(InputStream in, int size)
        // <返> 创建 BufferedInputStream 对象
        File file = new File("IOTestFile/img/剪纸.jpg");
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        bis.close();
    }

    /**
     * @读
     */
    @Test
    public void read() throws IOException {
        // <M> public int read() throws IOException
        // <返> 读取的字节数，如果已到达流的末尾，则返回 -1;调用一次只读取一个字节，迭代读取
        File file = new File("IOTestFile/img/剪纸.jpg");
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);

        for (int i = 0; i < 200000; i++) {
            int read = bis.read();
            System.out.println(read);
        }
        bis.close();
    }

    /**
     * @读
     */
    @Test
    public void read2() throws IOException {
        // <M> public int read(byte[] b) throws IOException
        // <返> 返回读取的字节数量len（len <= b.length），如果已到达流的末尾，则返回 -1
        // <改> 读取的字节数值，将字节数读入数组b。每read()一次，b都会被重头覆盖，如果最后一次不够数组长度，则会部分保留上一次字符
        //      （比如第一次取“12,13,14,15,16”，第二次取“22,23,24”，b的最后一次更新就是：[12,13,14,15,16] => [22,23,24,15,16]）
        File file = new File("IOTestFile/img/剪纸.jpg");
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            for (int i = 0; i < len; i++) {
                System.out.println(bytes[i]);
            }
        }
        bis.close();
    }
}
