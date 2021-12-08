package IO流.各种流的使用.打印流;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/*
 @打印流：打印流是java中用来输出数据的流类，分为PrintStream和PrintWriter，分别继承自OutputStream和OutputWriter。
    也是处理流的一种，实现将基本数据类型的数据格式转化为字符串输出

 @注意：
    1.System.out.println()是系统类的打印方法，直接打印在控制台上，System.out其实就是PrintStream的一个对象，用来方便平时控制台打印。
        System.out.println()是系统类控制了流向在控制台上，可以使用重定向定位到其他位置，使用打印流

    2.PrintStream 打印的所有字符都使用平台的默认字符编码转换为字节。在需要写入字符而不是写入字节的情况下，应该使用PrintWriter 类。
 */

public class Base {
    /**
     * @构造器
     */
    @Test
    public void Constructor() throws IOException {
        PrintStream ps = new PrintStream("IOTestFile/writerTest.txt");
        PrintWriter pw = new PrintWriter("IOTestFile/writerTest.txt");
        ps.close();
        pw.close();
    }

    /**
     * @PrintStream
     */
    @Test
    public void PrintStream() throws IOException {
        PrintStream ps = new PrintStream("IOTestFile/writerTest.txt");
        ps.print(1.233333);
        ps.append("ccc");
        ps.println();
        ps.println('a');
        System.setOut(ps);// 重定向，将流向从控制台定位到ps对象
        System.out.println("我是重定向打印");//
        ps.flush();// 不会自动刷新，手动刷新下
        ps.close();

        System.out.println("println test");
    }

    /**
     * @PrintWriter
     */
    @Test
    public void PrintWriter() throws IOException {
        PrintWriter pw = new PrintWriter("IOTestFile/writerTest.txt");
        pw.print(1.233333);
        pw.append("ccc");
        pw.println();
        pw.print('a');
        pw.close();
    }
}
