package 字符串;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

/**
@定义： String是不可变的字符序列，StringBuffer/StringBuilder 代表可变的字符序列，StringBuffer是JDK1.0就存在，StringBuilder是JDK1.5才新增的。

@StringBuffer与StringBuilder相同：
    1.两个类都代表可变字符串对象
    2.两个类的构造器和方法也基本相同（但不保证同步）。
    3.两个类底层都是byte[]储存数据
    4.两个类都会自动对底层数组进行扩容

 @StringBuilder与StringBuffer不同：
    1.StringBuffer 是线程安全的（方法都添加了synchronized），效率更低
    2.StringBuilder 是线程不安全的，效率更高（优先采用）

 @效率都比： StringBuilder > StringBuffer > String

 @关键点： 大部分方法改变原字符序列，左闭右开

 @注： 以下为 StringBuffer 的归纳，StringBuilder与此类似，不再赘述

*/
public class StringBuilder和StringBuffer {
    /**
     * @Description 构造器
     */
    @Test
    public void constructor() {
        // <CM> StringBuffer() 构造一个其中不带字符的字符串缓冲区，其初始容量为 16 个字符（new byte[16]）。
        // <CM> StringBuffer(String str) 构造一个初始化为指定字符串内容的字符串缓冲区，容量为16加上字符串参数的长度。
        // <CM> StringBuffer(CharSequence seq) 构造一个字符串缓冲区，它包含与指定的 CharSequence 相同的字符
        // <CM> StringBuffer(int capacity) 构造一个不带字符，但具有指定初始容量的字符串缓冲区。（尽量构造够用的容量，避免再次扩容）
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer("efg");
        StringBuffer sb3 = new StringBuffer(sb2);
        StringBuffer sb4 = new StringBuffer(3);

    }

    @Test
    public void toString_() {
        // <M> public synchronized int length()
        // <返> 返回字符串【有值长度】，而容量 capacity
        StringBuffer sb = new StringBuffer("abc");
        String s = sb.toString();
        System.out.println(s);
    }

    @Test
    public void length() {
        // <M> public synchronized int length()
        // <返> 返回字符串【有值长度】，而容量 capacity
        StringBuffer sb = new StringBuffer("abc");
        System.out.println(sb.length());
    }

    @Test
    public void capacity() {
        // <M> public synchronized int capacity()
        // <返> 返回当前容量
        // <注> 容量会在不同操作时，根据相关计算规则进行扩容
        StringBuffer sb1 = new StringBuffer("abc");// 16
        StringBuffer sb2 = new StringBuffer("abc");// 3 + 16
        System.out.println(sb1.capacity());// 16
        System.out.println(sb2.capacity());// 19
        sb2.append("012345678901234567890123456789");
        System.out.println(sb2.length());// 33
        System.out.println(sb2.capacity());// 40
    }

    @Test
    public void charAt() {
        // <M> public synchronized char charAt(int index)
        // <返> 返回此序列中指定索引处的 char 值
        StringBuffer sb = new StringBuffer("abc");
        System.out.println(sb.charAt(1));// b
    }

    @Test
    public void append() {
        // <M> public synchronized StringBuffer append(String str\char c\int i\boolean b\char[] charArr\CharSequence s\Object obj\StringBuffer sb)
        // <返、改> 追加指定类型的数据到这个序列最后，修改这个序列，并返回自身
        // <M> public synchronized StringBuffer append(CharSequence s, int start, int end)
        // <返、改> 将 s 从 start 至 end 的部分追加到序列最后，修改这个序列，并返回自身
        // <M> append(char[] str, int offset, int len)
        // <返、改> 将 str 从 offset 开始取 len 个，追加到序列最后，修改这个序列，并返回自身
        StringBuffer sb = new StringBuffer("a");
        sb.append("bc");
        System.out.println(sb);// abc
        System.out.println(sb.length());// 3
        System.out.println(sb.append('d').append(1).append((byte)2).append(true).append(new char[]{'e','f'}).append(new int[]{1,2}));
        System.out.println(sb == sb.append("***"));// true

        StringBuffer sb2 = new StringBuffer("ab");
        sb2.append("123", 1, 2);
        System.out.println(sb2);// ab2

        char[] chars = new char[]{'x','y','z'};
        sb2.append(chars, 1, 2);
        System.out.println(sb2);// ab2yz
        System.out.println(Arrays.toString(chars));// [x, y, z]

    }

    @Test
    public void insert() {
        // <M> public synchronized StringBuffer insert(int offset, String/基本类型/char[]/Object/CharSequence str)
        // <返、改> 将 str 插入序列的索引 offset 位置，修改这个序列，并返回自身
        // <M> public synchronized StringBuffer insert(int offset, char[]/CharSequence str, int start, int end)
        // <返、改> 将 str 的 start -> end 部分插入序列的索引 offset 位置，修改这个序列，并返回自身
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.insert(0, "***");
        System.out.println(sb1);// ***abc
        sb1.insert(4, "123", 1,2);
        System.out.println(sb1);// ***a2bc
    }

    @Test
    public void delete() {
        // <M> public synchronized StringBuffer delete(int start, int end)
        // <返、改> 删除从 start 至 end 的部分的字符，修改这个序列，并返回自身
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.delete(1, 2);
        System.out.println(sb1);// ac
    }

    @Test
    public void replace() {
        // <M> public synchronized StringBuffer replace(int start, int end, String str)
        // <返、改> 从 start 至 end 的部分的字符被替换为 str，修改这个序列，并返回自身
        StringBuffer sb1 = new StringBuffer("abcdef");
        sb1.replace(2, 4, "*");
        System.out.println(sb1);// ab*ef
    }

    @Test
    public void setCharAt() {
        // <M> public void setCharAt(int index, char ch)
        // <改> 指定索引处的字符设置为 ch
        StringBuffer sb = new StringBuffer("azc");
        sb.setCharAt(1, 'b');
        System.out.println(sb);// abc
    }

    @Test
    public void substring() {
        // <M> public synchronized String substring(int start)
        // <返> 截取从 start 至 结尾的部分的字符，创建新的String对象并返回
        // <M> public synchronized String substring(int start, int end)
        // <返> 截取从 start 至 end 的部分的字符，创建新的String对象并返回
        StringBuffer sb1 = new StringBuffer("abcdef");
        String str1 = sb1.substring(2);
        System.out.println(str1);// cdef

        String str2 = sb1.substring(2, 3);
        System.out.println(str2);// c
    }

    @Test
    public void subSequence() {
        // <M> public synchronized CharSequence subSequence(int start, int end)
        // <返> 截取从 start 至 结尾的部分的字符，创建新的String对象并返回
        // <M> public synchronized String substring(int start, int end)
        // <返> 截取从 start 至 end 的部分的字符，创建新的String对象并返回
        StringBuffer sb1 = new StringBuffer("abcdef");
        CharSequence charSequence = sb1.subSequence(2, 3);
        System.out.println(charSequence);// c
    }

    @Test
    public void indexOf() {
        // <M> public int indexOf(String str)
        // <返> 返回指定字符串在此字符串中第一次出现处的索引,未找到返回-1
        // <M> public synchronized int indexOf(String str, int fromIndex)
        // <返> 返回指定字符串在此字符串中第一次出现处的索引,从指定的索引 fromIndex (包含)开始,未找到返回-1
        StringBuffer sb1 = new StringBuffer("abcdef");
        System.out.println(sb1.indexOf("d"));// 3
        System.out.println(sb1.indexOf("d", 4));// -1
    }

    @Test
    public void reverse() {
        // <M> public synchronized StringBuffer reverse()
        // <返、改> 将原字符序列按相反的顺序排列，修改这个序列，并返回自身
        StringBuffer sb1 = new StringBuffer("abcdef");
        sb1.reverse();
        System.out.println(sb1);// fedcba
    }

}
