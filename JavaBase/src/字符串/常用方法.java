package 字符串;

import java.util.Arrays;

/**
 @注： 由于String的不可变性，String的所有方法都不会改变字符串
 */
public class 常用方法 {
    public static void main(String[] args) {
        String str1 = "Hello Java";

        // <M> public int length()
        // <返回> 返回字符串长度，实质是底层数组的长度：value.length
        System.out.println("输出1：" + str1.length());

        // <M> public String concat(String str)
        // <返回> 拼接,等价于+，创建一个新的 String 对象并返回
        String str2 = ", I am studying.";
        String str3 = str1.concat(str2);
        System.out.println("输出2：" + str3);

        // <M> public char charAt(int index)
        // <返回> 返回指定索引处的 char 值。
        char char1 = str1.charAt(1);
        System.out.println("输出3：" + char1);

        // <M> public int indexOf(String str/char char)
        // <返回> 返回指定字符（串）在此字符串中第一次出现处的索引,未找到返回-1
        // <M> indexOf(String str/char char, int fromIndex)
        // <返回> 返回指定字符（串）在此字符串中第一次出现处的索引,从指定的索引 fromIndex (包含)开始,未找到返回-1
        System.out.println("输出4：" + str1.indexOf("l"));
        System.out.println("输出5：" + str1.indexOf('l'));
        System.out.println("输出6：" + str1.indexOf("Java"));
        System.out.println("输出7：" + str1.indexOf("l", 3));

        // <M> public String substring(int beginIndex)
        // <返回> 剪切，从指定索引 beginIndex (包含)的字符开始，直到此字符串末尾，创建并返回剪切的字符串。
        // <M>  public String substring(int beginIndex, int endIndex)
        // <返回> 剪切，从指定索引 beginIndex (包含)的字符开始，直到索引 endIndex （不包含）结束，创建并返回剪切的字符串。
        // <ps> 左闭右开[)，beginIndex - 起始索引（包含）,endIndex - 结束索引（不包含）。
        String str4 = str1.substring(6);//
        String str5 = str1.substring(6, 7);
        System.out.println("输出8：" + str4);
        System.out.println("输出9：" + str5);

        // <M> public char[] toCharArray()
        // <返回> 将此字符串转换为一个新的字符数组并返回。
        char[] charArr1 = str1.toCharArray();
        System.out.println("输出10：" + charArr1[0]);

        // <M> public byte[] getBytes()
        // <返回> 将此字符串转换为一个新的字节数组并返回。
        byte[] byteArr1 = str1.getBytes();
        System.out.println("输出11：" + byteArr1[0]);

        // <M> replace(CharSequence target, CharSequence replacement)
        // <返回> 匹配所有 target 字符串，替换成 replacement 字符串，创建并返回新的字符串。
        String str6 = str1.replace("ll", "*");
        System.out.println("输出12：" + str6);

        // <M> public String[] split(String regex)
        // <M> public String[] split(String regex, int limit)
        // <参数> regex 分割标识符，limit 切割个数阈值
        // <返回> 分割，创建并返回的字符串数组。
        String str7 = "aaa,bbb,ccc,ddd";
        String[] stringArr1 = str7.split(",");// {"aaa", "bbb", "ccc", "ddd"}
        String[] stringArr2 = str7.split(",", 2);// {"aaa", "bbb,ccc,ddd"}
        System.out.println("输出13：" + Arrays.toString(stringArr1));
        System.out.println("输出14：" + Arrays.toString(stringArr2));

        // <M>  public native String intern()
        // <解释> 当调用 intern 方法时，如果常量池已存在一个等于此 String 对象的字符串（用 equals(Object) 方法确定），则返回池中的字符串。
        //       否则，将此 String 对象添加到池中，并返回此 String 对象的引用。
        // <返回> 返回内容一致的数组，不过是在放在常量池中的
        String str8 = new String("abc");
        String str9 = str8.intern();
        String str10 = "abc";
        System.out.println(str8 == str9);// false
        System.out.println(str9 == str10);// true

        // <M> public boolean isEmpty()
        // <返回> length()为0时返回true,其他返回false
        System.out.println("isEmpty1 = " + str10);// false
        System.out.println("isEmpty2 = " + "".isEmpty());// true

        // <M> public String toLowerCase()
        // <M> public String toUpperCase()
        // <返回> 转换大小写,创建并返回新的字符串。
        System.out.println("toLowerCase = " + "abcDef123".toLowerCase());
        System.out.println("toLowerCase = " + "abcDef123".toUpperCase());

        // <M> public String trim()
        // <返回> 去除首位空格,创建并返回新的字符串。
        // <应用> 用户输入账号密码可用到
        System.out.println("trim=" + " ab cd   ".trim() + ";");

        // <M> public int compareTo(String anotherString)
        // <返回> 按字典顺序比较两个字符串。 比较是基于字符串中每个字符的Unicode值。 由该String对象表示的字符序列按字典顺序与由参数字符串表示的字符序列进行比较。
        // <应用>
        // 用于字符串排序比较
        String str11 = "abc";// c99
        String str12 = "abde";// d100 e101
        String str13 = "5";
        String str14 = "10";
        System.out.println("compareTo = " + str11.compareTo(str12));
        System.out.println("compareTo = " + str13.compareTo(str14));
    }
}
