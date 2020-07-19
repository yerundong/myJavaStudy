package 字符串;

public class 常用方法 {
    public static void main(String[] args) {
        String str1 = "Hello Java";

        // <M> length()
        System.out.println("输出1：" + str1.length());

        // <M> concat(String str)
        // <返回> 拼接创建一个新的 String 对象返回
        String str2 = ", I am studying.";
        String str3 = str1.concat(str2);
        System.out.println("输出2：" + str3);

        // <M> concat(int index)
        // <返回> 返回指定索引处的 char 值。
        char char1 = str1.charAt(1);
        System.out.println("输出3：" + char1);

        // <M> indexOf(String str/char char)
        // <返回> 返回指定子字符串在此字符串/字符中第一次出现处的索引,未找到返回-1
        // <M> indexOf(String str/char char, int fromIndex)
        // <返回> 返回指定子字符串在此字符串/字符中第一次出现处的索引，从指定的索引(包含该索引)开始,未找到返回-1
        System.out.println("输出4：" + str1.indexOf("l"));
        System.out.println("输出5：" + str1.indexOf('l'));
        System.out.println("输出6：" + str1.indexOf("Java"));
        System.out.println("输出7：" + str1.indexOf("l", 3));

        // <M> substring(int beginIndex)
        // <返回> 返回一个新的字符串，该字符串从指定索引处的字符开始，直到此字符串末尾。
        // <M> substring(int beginIndex, int endIndex)
        // <返回> 返回一个新的字符串，该字符串从指定索引处的字符开始，直到索引 endIndex - 1 处的字符。
        // <ps> 左闭右开[)，beginIndex - 起始索引（包括）,endIndex - 结束索引（不包括）。
        String str4 = str1.substring(6);
        String str5 = str1.substring(6, 7);
        System.out.println("输出8：" + str4);
        System.out.println("输出9：" + str5);

        // <M> toCharArray()
        // <返回> 将此字符串转换为一个新的字符数组并返回。
        char[] charArr1 = str1.toCharArray();
        System.out.println("输出10：" + charArr1[0]);

        // <M> getBytes()
        // <返回> 将此字符串转换为一个新的字节数组并返回。
        byte[] byteArr1 = str1.getBytes();
        System.out.println("输出11：" + byteArr1[0]);

        // <M> replace(CharSequence target, CharSequence replacement)
        // <返回> 匹配所有target字符串，替换成replacement字符串，并生成一个新字符串返回
        String str6 = str1.replace("ll", "*");
        System.out.println("输出12：" + str6);

    }
}
