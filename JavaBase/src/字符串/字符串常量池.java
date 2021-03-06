package 字符串;

/**
 @字符串常量池： 位于方法区，用于储存字面量创建的字符串。字符串常量池不会储存相同内容的字符串。

 @常量池位置： jdk1.6-方法区（永久代），jdk1.7堆空间，jdk1.8+方法区（元空间）

 @常量池的好处：
    常量池是为了避免频繁的创建和销毁对象而影响系统性能，其实现了[对象的共享]。
    例如字符串常量池，在编译阶段就把所有的字符串文字放到一个常量池中。
    （1）节省内存空间：常量池中所有相同的字符串常量被【合并】，只占用一个空间。
    （2）节省运行时间：比较字符串时，== 比 equals() 快。对于两个引用变量，只用==判断引用是否相等，也就可以判断实际值是否相等。

 @快速记忆： 常量池搞兼并，内容同则地址同。
 */
public class 字符串常量池 {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";

        char[] charArray = {'a', 'b', 'c'};
        String str3 = new String(charArray);
        String str4 = new String("abc");

        System.out.println(str1 == str2); // true
        System.out.println(str1 == str3); // false
        System.out.println(str1 == str4); // false
    }

}

