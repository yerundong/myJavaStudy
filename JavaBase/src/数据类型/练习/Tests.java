package 数据类型.练习;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Vector;

public class Tests {
    /**
     * @问题 请编写handle方法，让输出a=100，b=200
     */
    @Test
    public void test1(){
        int a = 10, b = 20;
        handle1(a, b);
        // handle2(a, b);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }
    // handle方法1
    public static void handle1(int a, int b){
        a = a * 10;
        b = b * 10;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.exit(0);
    }
    // handle方法2
    public static void handle2(int a, int b){
        PrintStream printStream = new PrintStream(System.out){
            @Override
            public void println(String x){
                // 。。。。
            }
        };
    }

    @Test
    public void test2(){
        new Vector();
    }
}
