package 类和对象.main方法;

/**
 @main方法: 在Java中，main方法是Java应用程序的【入口方法】，因为JAVA是在C++的基础上开发的语言，main也是c++的程序入口。
     也就是说，程序在运行的时候，第一个执行的方法就是main()方法，
     这个方法和其他的方法有很大的不同，比如方法的名字必须是main，方法必须是public static void 类型的，方法必须接收一个字符串数组的参数等等。

 @要求：
    1.方法的名字必须是：main
    2.修饰符和返回类型也是固定的：public static void
    3.参数只能一个，且是字符串数组类型的：String[] args

 @解释：
    为什么是main：规定，JVM只能识别叫做main的函数作为程序运行的起点
    为什么是public的：为了保证JVM在任何情况下都可以访问到main方法，就用public修饰。
    为什么是static的：静态可以让JVM调用main方法的时候更加方便，不需要通过对象调用。
    为什么没有返回值（void）：没有返回值是因为不需要，Java不需要main方法向操作系统返回退出信息。如果main方法正常退出，那么Java应用层序的退出代码为0，表示成功的运行了程序。
    为什么参数是String[] args：也是规定

 */
public class Base {
    public static int num = 777;

    public static void main(String[] args) {
        // new Base();
        System.out.println(Base.num);

    }

    static {
        System.out.println(123);
    }

    {
        System.out.println(456);
    }
}
