package IO流.commonIO.缓冲流.BufferedOutputStream;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class Base {
    /**
     * @构造器，创建BufferedOutputStream流
     */
    @Test
    public void Constructor() throws IOException {
        // <CM> public BufferedOutputStream(OutputStream out)
        // <CM> public BufferedOutputStream(OutputStream out, int size)
        // <返> 创建 BufferedOutputStream 对象
        File file = new File("IOTestFile/img/剪纸.jpg");
        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.close();
    }

    /**
     * @写
     */
    @Test
    public void write() throws IOException {
        // <M> public void write(int b) throws IOException
        // <M> public void write(byte[] b) throws IOException
        // <M> public void write(byte[] b, int off, int len) throws IOException
        // <改> 通过 BufferedOutputStream 流对文件写入字节
        File file = new File("IOTestFile/img/剪纸.jpg");
        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write(123);
        byte[] bytes = {12, 13, 122, 122};
        bos.write(bytes);
        bos.close();
    }
}
