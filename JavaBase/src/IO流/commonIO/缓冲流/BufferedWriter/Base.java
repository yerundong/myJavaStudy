package IO流.commonIO.缓冲流.BufferedWriter;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Base {
    /**
     * @ 构造器，创建BufferedWriter流
     */
    @Test
    public void Constructor() throws IOException {
        // <CM> public BufferedWriter(Writer out)
        // <CM> public BufferedWriter(Writer out, int sz)
        // <返> 创建 BufferedWriter 流，并返回

        File file = new File("IOTestFile/writerTest.txt");
        FileWriter fw = new FileWriter(file, true);// 追加
        BufferedWriter bw = new BufferedWriter(fw);
        fw.close();
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
        // <改> 通过 BufferedWriter 流对文件写入字符
        File file = new File("IOTestFile/writerTest.txt");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        // bw.write('a');
        bw.write("a\nbc");
        char[] chars = {'a', 'b', 'c', 'd'};
        // bw.write(chars, 0, chars.length);
        // bw.write("hello,io", 0, 5);
        bw.close();
    }

    /**
     * @写入一个换行
     */
    @Test
    public void newLine() throws IOException {
        // <M> public void newLine() throws IOException
        // <改> 写入一个行分隔符。行分隔符字符串由系统属性 line.separator 定义，并且不一定是单个新行 ('\n') 符。
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("IOTestFile/writerTest.txt")));
        bw.write("abc");
        bw.newLine();
        bw.write("efg");
        bw.close();
    }
}
