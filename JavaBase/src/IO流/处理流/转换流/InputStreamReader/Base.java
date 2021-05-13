package IO流.处理流.转换流.InputStreamReader;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 @InputStreamReader：字节转字符输入流。期间做了一个解码的操作
 */
public class Base {
    /**
     * @构造器，创建InputStreamReader流
     */
    @Test
    public void Constructor() throws IOException {
        // <CM> public InputStreamReader(InputStream in)
        // <CM> public InputStreamReader(InputStream in, String charsetName)
        // <返> 创建 InputStreamReader 对象
        FileInputStream fis = new FileInputStream("IOTestFile/hello-io.txt");
        // InputStreamReader isr = new InputStreamReader(fis);// 使用系统默认字符集
        InputStreamReader isr = new InputStreamReader(fis, "utf-8");// 使用什么字符集取决于fis文件保存时的字符集，否则会乱码
        isr.close();
    }

    /**
     * @读
     */
    @Test
    public void read() throws IOException {
        // <M> public int read() throws IOException
        // <返> 读取的字符数值，如果已到达流的末尾，则返回 -1;调用一次只读取一个字符，迭代读取
        FileInputStream fis = new FileInputStream("IOTestFile/hello-io.txt");
        // InputStreamReader isr = new InputStreamReader(fis);
        // InputStreamReader isr = new InputStreamReader(fis, "gbk");
        InputStreamReader isr = new InputStreamReader(fis, "utf-8");
        int read;
        while ((read = isr.read()) != -1) {
            System.out.print((char) read);
        }
        isr.close();
    }

    /**
     * @读
     */
    @Test
    public void read2() throws IOException {
        // <M>  public int read(char[] cbuf) throws IOException
        // <返> 返回读取的字符数len（len <= cbuf.length），如果已到达流的末尾，则返回 -1
        // <改> 读取的字数，将字符数读入数组cbuf。每read()一次，cbuf都会被重头覆盖，如果最后一次不够数组长度，则会部分保留上一次字符
        //      （比如第一次取“hello”，第二次取”java“，cbuf的最后一次更新就是：[h,e,l,l,o] => [j,a,v,a,o]）
        FileInputStream fis = new FileInputStream("IOTestFile/hello-io.txt");
        // InputStreamReader isr = new InputStreamReader(fis);
        // InputStreamReader isr = new InputStreamReader(fis, "gbk");
        InputStreamReader isr = new InputStreamReader(fis, "utf-8");
        int len;
        char[] chars = new char[1024];
        while ((len = isr.read(chars)) != -1) {
            System.out.print(new String(chars, 0, len));
        }
        isr.close();
    }
}
