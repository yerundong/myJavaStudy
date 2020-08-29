package 字符串;
/*
@ 字符串：String是类，引用类型，文件位置：java.lang.String

@ 实例对象说明：
    API当中说：Java 程序中的所有字符串字面值（如 "abc" ）都作为此类的实例实现。
    即：程序当中所有的双引号字符串，都是String类的实例对象（没有new也是）。

@ 字符串的特性：
    1. 字符串的内容永不可变。【重点】
    2. 正是因为字符串不可改变，所以字符串是可以共享使用的。
    3. 字符串效果上相当于是char[]字符数组，但是底层原理是byte[]字节数组。

@ 创建字符串的常见两种方式：
    1.构造函数创建（x3）：
        public String()：创建一个空白字符串，不含有任何内容。
        public String(char[] array)：根据字符数组的内容，来创建对应的字符串。
        public String(byte[] array)：根据字节数组的内容，来创建对应的字符串。
    2.直接创建，直接写上双引号，就是字符串对象：
        String str = "Hello"; // 右边直接用双引号

@ 区别：构造函数创建的存放在堆内存当中，直接创建的存放在常量池当中


 */
public class Base {
    public static void main(String[] args) {
        // <1>
        String str1 = new String();
        System.out.println("第1个字符串是：" + str1);

        // <2>
        String str2 = new String("abc");
        System.out.println("第2个字符串是：" + str2);

        // <3>
        char[] charArray = {'e', 'd', 'f'};
        String str3 = new String(charArray);
        System.out.println("第3个字符串是：" + str3);

        // <4>
        char[] byteArray = {101, 102, 103};
        String str4 = new String(byteArray);
        System.out.println("第4个字符串是：" + str4);

        // <5>
        String str5 = "hello";
        System.out.println("第5个字符串是：" + str5);
        System.out.println( System.identityHashCode(str5));

        // 字符串的内容永不可变
        // 下面操作并没有改变字符串，而是又新增了一个字符串"java"，而原先的"hello"依然存在
        // 赋值是将str5的存的地址值改变了，而堆中的原字符串数值并未变化
        str5 = "java";
        System.out.println(System.identityHashCode(str5));
    }
}
