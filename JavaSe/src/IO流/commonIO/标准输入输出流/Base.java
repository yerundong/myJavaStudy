package IO流.commonIO.标准输入输出流;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;


public class Base {
    @Test
    public void seeClass() {
        InputStream in = System.in;
        PrintStream out = System.out;
        PrintStream err = System.err;

        // true，说明是单例模式
        System.out.println(System.in == in);// true
        System.out.println(System.out == out);// true
        System.out.println(System.err == err);// true
    }

    @Test
    public void SystemIn() throws IOException {
        // 当 read() 执行的时候，才可输入，键盘光标出现，输入时是阻塞的，按enter才返回输入的数据，继续执行
        InputStream is = System.in;
        int rint;
        while ((rint = is.read()) != -1) {
            System.out.print((char) rint);
        }
        is.close();
    }

    @Test
    public void SystemOUt() {
        System.out.println("xxx");
        System.out.close();// 关闭后就无法打印
        System.out.println("ccc");
    }

    @Test
    public void SystemErr() {
        System.err.println("xxx");
        System.err.close();// 关闭后就无法打印
        System.err.println("ccc");
    }
}
