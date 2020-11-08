package 异常处理;

import java.io.IOException;

/**
@ throws：针对方法内部的异常处理，将方法内部的异常抛出，由调用处接受，一层层向上抛出，直到虚拟机

@ 作用：
    1.编译时异常，要求方法调用处必须 try-catch-finally 处理可能出现的异常，对于极有可能出现异常的代码提供了保障
        @注： 如果是继承自编译时异常的自定义异常，也硬性要求需要 try-catch-finally 处理
    2.抛出外部，统一处理异常，

@ 格式：method() throws ExceptionType1, ExceptionType2...{
    方法体
}

@ 注意：
    1.throws的类型与顺序无关
    2.方法内部出现异常将终止后续代码执行
    3.throws没有真正处理异常，而是向上“甩锅”，最终处理还需要try-catch-finally

 *
* */
public class throws关键字 {
    public static void main(String[] args) {
        try {
            look();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException");
            // e.printStackTrace();
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
