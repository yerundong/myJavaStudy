package 异常处理;

import java.io.File;
import java.util.Date;

/**
@异常： 在java语言中，将程序执行中发生不正常的情况称为“异常”
    @注： 语法错误和逻辑错误不称为异常

@常见类型异常： 参考 https://blog.csdn.net/Return_head/article/details/90243070

@抓抛模型: java的异常处理是「抓抛模型」，「抓」是「捕获继而处理」的意思，「抛」是「抛出异常」的意思

@Throwable类: 是 Java 语言中所有错误或异常的超类（广义上的异常）。

@Throwable有两个子类：
    1.Error：java虚拟机无法解决的严重错误，无法捕获，只能改代码，它们在Java程序处理的范畴之外。例如，JVM 内存溢出
    2.Exception：编程错误或偶然性的外在因素导致的一般性问题，可以用针对性的代码处理（一般说的狭义上的异常）

@Exception异常分为两类：
    1.编译时异常，也叫受检异常（checked），如IOException、ClassNotFoundException、CloneNotSupportedException等
    2.运行时异常，也叫非受检异常（unchecked），RuntimeException极其子类异常
    @注： Error也不可检测（unchecked），在运行时才抛出

@异常对象的生成：
    1.虚拟机检测到异常，如果当前程序没有对异常进行处理，则会在后台自动创建一个异常对象抛出--自动抛出
    2.手动创建一个异常对象抛出，如果只创建不抛出，不会对程序运行有影响

@异常处理的两种方式：
    1.try-catch-finally
    2.throws + 异常类型
*/
public class Base {
    public static void main(String[] args) {

        // @Error
        // main(new String[]{"1000"});// StackOverflowError

        // @运行时异常
        // @ArrayIndexOutOfBoundsException
        int[] arr1 = new int[3];
        // System.out.println(arr1[3]);

        // @StringIndexOutOfBoundsException
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

        // @编译时异常
        // @IOException
        File file = new File("text.txt");
        // FileInputStream fis = new FileInputStream(file);
    }
}
