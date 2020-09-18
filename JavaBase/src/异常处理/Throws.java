package 异常处理;

import java.io.IOException;

/*
@ throws：针对方法内部的异常处理，将方法内部的异常抛出，由调用处接受，一层层向上抛出，直到虚拟机

@ 优点：抛出外部，统一处理异常

@ 格式：method() throws ExceptionType1, ExceptionType2...{
    方法体
}

@ 注意：
    1.throws的类型与顺序无关
    2.方法内部出现异常将终止后续代码执行

 *
* */
public class Throws {
    public static void main(String[] args) {
        try {
            look();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException");
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
    public static void look() throws ArrayIndexOutOfBoundsException, StringIndexOutOfBoundsException {
        says();
    }
    public static void says() throws ArrayIndexOutOfBoundsException, StringIndexOutOfBoundsException {
        int[] arr1 = new int[1];
        String str1 = "abc";
        System.out.println(arr1[1]);
        System.out.println("says end");
    }
}
