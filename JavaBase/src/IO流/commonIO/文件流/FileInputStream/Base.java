package IO流.commonIO.文件流.FileInputStream;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Base {
    /**
     * @构造器，创建FileInputStream流
     */
    @Test
    public void Constructor() throws IOException {
        // <CM> public FileInputStream(File file) throws FileNotFoundException
        // <CM> public FileInputStream(String name) throws FileNotFoundException
        // <返> 创建读取字节文件的流管道；返回 FileInputStream 对象
        // <注> file必须存在，否则报 FileNotFoundException

        // File file = new File("IOTestFile/img/剪纸.jpg");
        // FileInputStream fis = new FileInputStream(file);
        FileInputStream fis = new FileInputStream("IOTestFile/img/剪纸.jpg");
        fis.close();
    }

    /**
     * @读
     */
    @Test
    public void read() throws IOException {
        // <M> public int read() throws IOException
        // <返> 读取的字节数值，如果已到达流的末尾，则返回 -1;调用一次只读取一个字节，迭代读取
        File file = new File("IOTestFile/img/剪纸.jpg");
        FileInputStream fis = new FileInputStream(file);

        for (int i = 0; i < 200000; i++) {
            int read = fis.read();
            System.out.println(read);
        }
        fis.close();
    }

    /**
     * @读
     */
    @Test
    public void read_cbuf() throws IOException {
        // <M> public int read(byte[] b) throws IOException
        // <返> 返回读取的字节数量len（len <= b.length），如果已到达流的末尾，则返回 -1
        // <改> 读取的字节数值，将字节数读入数组b。每read()一次，b都会被重头覆盖，如果最后一次不够数组长度，则会部分保留上一次字符
        //      （比如第一次取“12,13,14,15,16”，第二次取“22,23,24”，b的最后一次更新就是：[12,13,14,15,16] => [22,23,24,15,16]）
        File file = new File("IOTestFile/img/剪纸.jpg");
        FileInputStream fis = new FileInputStream(file);
        byte[] cbuf = new byte[1024];
        int len;
        while ((len = fis.read(cbuf)) != -1) {
            for (int i = 0; i < len; i++) {
                System.out.println(cbuf[i]);
            }
        }
        fis.close();
    }
}
