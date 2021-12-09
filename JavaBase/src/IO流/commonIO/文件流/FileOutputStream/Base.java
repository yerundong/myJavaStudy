package IO流.commonIO.文件流.FileOutputStream;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Base {
    /**
     * @ 构造器，创建 FileOutputStream 流
     */
    @Test
    public void Constructor() throws IOException {
        // <CM> public FileOutputStream(File file) throws FileNotFoundException
        // <CM> public FileOutputStream(String name, boolean append) throws FileNotFoundException
        // <返> 创建 FileOutputStream 流，并返回
        // <改> 如果该文件路径不存在，则会自动创建文件，如果存在，会创建一个同名空文件覆盖它；
        // <注> 如果父目录不存在，则报错 FileNotFoundException

        // <CM> public FileOutputStream(File file, boolean append) throws FileNotFoundException
        // <CM> public FileOutputStream(String name, boolean append) throws FileNotFoundException
        // <改> 如果该文件路径不存在，则会自动创建文件，如果存在，在它基础上追加；

        File file = new File("IOTestFile/img/剪纸.jpg");
        // file = new File("IOTestFile/none/剪纸.jpg");// 父目录不存在

        // FileOutputStream fos = new FileOutputStream(file);
        // FileOutputStream fos = new FileOutputStream(file, true);
        FileOutputStream fos = new FileOutputStream("IOTestFile/img2/剪纸.jpg", true);
        fos.close();
    }

    /**
     * @写
     */
    @Test
    public void write() throws IOException {
        // <M> public void write(int b) throws IOException
        // <M> public void write(byte[] b) throws IOException
        // <M> public void write(byte[] b, int off, int len) throws IOException
        // <改> 通过 FileOutputStream 流对文件写入字节
        File file = new File("IOTestFile/img/剪纸.jpg");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(123);
        byte[] bytes = {12, 13, 122, 122};
        fos.write(bytes);
        fos.close();
    }
}
