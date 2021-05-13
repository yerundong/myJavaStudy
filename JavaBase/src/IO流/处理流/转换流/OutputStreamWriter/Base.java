package IO流.处理流.转换流.OutputStreamWriter;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 @OutputStreamWriter：字符转字节输出流。期间做了一个编码的操作
 */
public class Base {
    /**
     * @构造器，创建InputStreamReader流
     */
    @Test
    public void Constructor() throws IOException {
        // <CM> public OutputStreamWriter(OutputStream out)
        // <CM> public OutputStreamWriter(OutputStream out, String charsetName)
        // <返> 创建 OutputStreamWriter 对象
        FileOutputStream fos = new FileOutputStream("IOTestFile/hello-io.txt");
        // OutputStreamWriter osw = new OutputStreamWriter(fos);// 使用系统默认字符集
        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");// 使用utf-8写入
        osw.close();
    }

    /**
     * @写
     */
    @Test
    public void write() throws IOException {
        // <M> public void write(int c) throws IOException
        // <M> public void write(String str) throws IOException
        // <M> public void write(char[] cbuf, int off, int len) throws IOException
        // <M> public void write(String str, int off, int len) throws IOException
        // <改> 通过 OutputStreamWriter 流对文件写入特定编码的字节
        FileOutputStream fos = new FileOutputStream("IOTestFile/hello-io.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "gbk");
        osw.write('中');
        osw.write("a\nbc");
        char[] chars = {'a', 'b', 'c', 'd'};
        osw.write(chars, 0, chars.length);
        osw.write("hello,io", 0, 5);
        osw.close();
    }
}
