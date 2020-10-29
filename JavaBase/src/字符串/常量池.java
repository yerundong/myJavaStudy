package 字符串;

/*
常量池，在方法区当中，实际上分为两种形态：静态常量池和运行时常量池。

参见：https://www.cnblogs.com/syp172654682/p/8082625.html

字符串常量池：直接写上的双引号定义的字符串，就在字符串常量池中。

@ 常量池的好处：
    常量池是为了避免频繁的创建和销毁对象而影响系统性能，其实现了对象的共享。
    例如字符串常量池，在编译阶段就把所有的字符串文字放到一个常量池中。
    （1）节省内存空间：常量池中所有相同的字符串常量被【合并】，只占用一个空间。
    （2）节省运行时间：比较字符串时，== 比 equals() 快。对于两个引用变量，只用==判断引用是否相等，也就可以判断实际值是否相等。
 */
public class 常量池 {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";

        char[] charArray = {'a', 'b', 'c'};
        String str3 = new String(charArray);

        System.out.println(str1 == str2); // true
        System.out.println(str1 == str3); // false
        System.out.println(str2 == str3); // false
    }

}

