package 字符串;

import java.io.UnsupportedEncodingException;

/*
@字符串： String是一个final类，引用类型，代表不可变字符序列

@实例对象说明：
    API当中说：Java 程序中的所有字符串字面值（如 "abc" ）都作为此类的实例实现。
    即：程序当中所有的双引号字符串，都是String类的实例对象（没有new也是）。

 @字符串的特性：
    1. String声明为一个final类，表示不可继承
    2. String实现Serializable接口，表示支持序列化；
    3. String实现Comparable接口，表示可比较大小；
    4. String内部定义 final byte[] value 属性，用于储存字符串内容；
        @注： 字符串效果上相当于是char[]字符数组，但是底层原理是byte[]字节数组。
    5. 不可变性：即一旦一个String对象被创建以后，包含在这个对象中的字符序列是不可改变的，直至这个对象被销毁。这是与其他引用类型对象区别之一。
        @注：
            1.不可变指的是【字符串内容】不可变，而非指【变量名和内容之间的绑定】不可变
            2.不管什么方式创建的字符串都不可变
 6. 正是因为字符串不可改变，所以字符串是可以共享使用的。

 @创建字符串的有两种方式：
    1.构造函数创建（new的方式，存在堆当中）：
        public String()：创建一个空白字符串，不含有任何内容。
        public String(char[] array)：根据字符数组的内容，来创建对应的字符串。
        public String(byte[] array)：根据字节数组的内容，来创建对应的字符串。
    2.字面量创建（直接写上双引号，就是字符串对象，存在常量池中）：
        String str = "Hello"; // 右边直接用双引号

 @构造函数创建和字面量创建的区别： 构造函数创建的字符串存放在堆内存当中，字面量创建的字符串存放在常量池当中

 @Java9的改进：
   Java9改进了字符串（包括String、StringBuffer、StringBuilder）的实现。
    在Java9以前字符串采用char[]数组来保存字符，因此字符串的每个字符占2字节；
    而Java9的字符串采用byte[]数组再加一个encoding-flag字段来保存字符，因此字符串的每个字符只占1字节。
    所以Java9的字符串更加节省空间，字符串的功能方法也没有受到影响。

 @字符串拼接的区别：
    1.常量与常量（包括final常量）拼接是用字面量方式创建（如："abc"+"d"），因为常量确定，可以在编译期优化：先连接，后储存
    2.若有变量参与拼接是用构造函数方式创建（如：s1+"abc"），因为变量不确定，无法在编译期优化

 @字符串与各类数据转换：
    char[] -> String：new String(charArray)
    String ->  char[]：toCharArray()

    byte[] -> String：new String(byteArray)
    String ->  byte[]：getBytes()

 */
public class Base {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // @常见的创建方式
        String str1 = new String();
        String str2 = new String("abc");
        char[] charArray = {'e', 'd', 'f'};
        String str3 = new String(charArray);
        byte[] byteArray = {-42, -48, -71, -6};
        // 解码
        String str4 = new String(byteArray, "gbk");// 中国
        String str5 = "hello";

        // @字符串的内容永不可变
        // 下面操作并没有改变字符串，而是又新增了一个字符串"java"，而原先的"hello"内容依然存在
        // 赋值是将str5的存的地址值改变了，而堆中的原字符串数值并未变化
        System.out.println(System.identityHashCode(str5));// 地址1
        String str6 = str5;
        str5 = "java";// 字符串虽然是引用类型，但str5的改变了指向，并不影响str6的内容，即可不变性
        System.out.println(str6);// "hello"
        System.out.println(System.identityHashCode(str6));// 地址1
        System.out.println(System.identityHashCode(str5));// 新的地址

        // @字符串连接
        String ss1 = "abc";
        String ss2 = "def";
        final String ss22 = "def";
        String ss3 = "abcdef";
        String ss4 = "abc" + "def";
        String ss5 = ss1 + "def";
        String ss6 = "abc" + ss2;
        String ss7 = ss1 + ss2;
        String ss9 = "abc" + ss22;

        System.out.println(ss3 == ss4);// true
        System.out.println(ss3 == ss5);// false
        System.out.println(ss5 == ss6);// false
        System.out.println(ss3 == ss7);// false
        System.out.println(ss3 == ss7);// false
        System.out.println(ss3 == ss9);// true
        System.out.println(ss1.intern() + "def" == ss3);// false
        System.out.println((ss1 + "def").intern() == ss3);// true，
    }
}
