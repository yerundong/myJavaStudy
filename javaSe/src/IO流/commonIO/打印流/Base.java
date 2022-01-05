package IO流.commonIO.打印流;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;


public class Base {
    /**
     * @构造器
     */
    @Test
    public void Constructor() throws IOException {
        PrintStream ps = new PrintStream("JavaSe/src/lib/IOTestFile/writerTest.txt");
        PrintWriter pw = new PrintWriter("JavaSe/src/lib/IOTestFile/writerTest.txt");
        ps.close();
        pw.close();
    }

    /**
     * @PrintStream
     */
    @Test
    public void PrintStream() throws IOException {
        PrintStream ps = new PrintStream("JavaSe/src/lib/IOTestFile/writerTest.txt");
        ps.print(1.233333);
        ps.append("ccc");
        ps.println();
        ps.println('a');
        System.setOut(ps);// 重定向，将流向从控制台定位到ps对象
        System.out.println("我是重定向打印");//
        ps.close();

        System.out.println("println test");
    }

    /**
     * @PrintWriter
     */
    @Test
    public void PrintWriter() throws IOException {
        PrintWriter pw = new PrintWriter("JavaSe/src/lib/IOTestFile/writerTest.txt");
        pw.print(1.233333);
        pw.append("ccc");
        pw.println();
        pw.print('a');
        pw.close();
    }
}
