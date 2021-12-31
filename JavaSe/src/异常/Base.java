package 异常;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Date;

public class Base {

    /**
     * @Error异常
     */
    @Test
    public void test1() {
        test1();// StackOverflowError：堆栈溢出错误
    }

    /**
     * @运行时异常
     */
    @Test
    public void test2() {
        // ArrayIndexOutOfBoundsException
        int[] arr1 = new int[3];
        System.out.println(arr1[3]);

        // StringIndexOutOfBoundsException
        String str1 = "abc";
        // System.out.println(str1.charAt(3));

        // @NullPointerException
        String str2 = null;
        // System.out.println(str2.charAt(0));

        // @ClassCastException 类强制转换异常
        Object date = new Date();
        // String str3 = (String)date;

        // @NumberFormatException
        // int int1 = Integer.parseInt("abc");

        // @ArithmeticException 算术异常
        int int2 = 0;
        // System.out.println(10 / int2);
    }

    /**
     * @编译时异常
     */
    @Test

    public void test3() {
        // @编译时异常
        // @IOException
        File file = new File("text.txt");
        // FileInputStream fis = new FileInputStream(file);
    }
}
