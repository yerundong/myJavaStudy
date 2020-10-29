package 字符串.StringBuilder和StringBuffer;
/**
@定义： StringBuilder代表一个字符序列可变的字符串类，可以调用它的toString()方法将其转换为一个String对象。

@StringBuilder与StringBuffer对比：
    1.StringBuffer 和 StringBuilder类都代表可变字符串对象，基本相似
    2.此类提供一个与 StringBuffer 兼容的 API，两个类的构造器和方法也基本相同，但不保证同步。
    2.该类被设计用作 StringBuffer 的一个简易替换，用在字符串缓冲区被单个线程使用的时候（这种情况很普遍）。
    3.不同的是：StringBuffer是线程安全的，而StringBuilder则没有实现线程安全功能，所以性能略高。
    4.StringBuffer类中的方法都添加了synchronized关键字，也就是给这个方法添加了一个锁，用来保证线程安全。
    5.如果可能，建议优先采用该类，因为在大多数实现中，它比 StringBuffer 要快。

@构造方法：
    StringBuilder(); 构造一个其中不带字符的字符串缓冲区，其初始容量为 16 个字符。
    StringBuilder(int capacity); 构造一个不带字符，但具有指定初始容量的字符串缓冲区。
    StringBuilder(String str); 构造一个字符串缓冲区，并将其内容初始化为指定的字符串内容。
    StringBuilder(CharSequence seq) 构造一个字符串缓冲区，它包含与指定的 CharSequence 相同的字符（？？？？？？？？）

@成员方法：
    public StringBuffer append(someType some)
        append(String str\StringBuffer sb\char c\int i\boolean b\char[] charArr\CharSequence s\Object obj)
        将参数的字符串表示形式追加到序列
        append(char[] str, int offset, int len) 将 char 数组参数的子数组的字符串表示形式追加到此序列
        append(CharSequence s, int start, int end) 将指定 CharSequence 的子序列追加到此序列。
    public char charAt(int index) 返回此序列中指定索引处的 char 值。
    public StringBuilder delete(int start, int end) 移除此序列[s,e)的字符。
    public StringBuilder insert(int offset, someType some) 插入
    public int length()

*/
public class Base {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("efg");
        StringBuilder sb3 = new StringBuilder(3);

        sb1.append("a").append('b').append(sb2).append(true).append(new char[]{'k'}).append(1).append(0.1).append(0.2F)
                .append(10L).append((byte)10).append((short)10);
        sb1.append(new char[]{'零', '一', '二', '三', '四', '五', '六', '七'}, 2, 4);
        System.out.println(sb1);

        System.out.println(sb1.charAt(2));
        System.out.println(sb1.delete(2, 3));
        System.out.println(sb1.deleteCharAt(2));
        System.out.println(sb1.insert(2, "FALSE"));
        System.out.println(sb1.capacity());
        System.out.println(sb1.length());

    }
}
