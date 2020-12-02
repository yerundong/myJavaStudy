package 字符串;

/**
 @==： 详见 \src\运算符\双等号

 @equals： 详见 \src\常用类.Object类\equals

 @equalsIgnoreCase：
    public boolean equalsIgnoreCase(String str)：忽略大小写，进行内容比较。

 @注： 不推荐使用 == 判断字符串相等

 @快速记忆： 双等号，判地址，equals，判内容；常量池搞兼并，内容同则地址同。
 */
public class 判断相等 {

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        String str3 = new String(charArray);

        // 一、==
        System.out.println("==：" + (str1 == str2));// true
        System.out.println("==：" + (str1 == str3));// false

        // 二、equals
        System.out.println(str1.equals(str2)); // true
        System.out.println(str2.equals(str3)); // true
        System.out.println(str3.equals("Hello")); // true
        System.out.println("Hello".equals(str1)); // true

        String str4 = "hello";
        System.out.println(str1.equals(str4)); // false
        System.out.println("=================");

        String str5 = null;
        System.out.println("abc".equals(str5)); // 推荐：false
        // System.out.println(str5.equals("abc")); // 不推荐：报错，空指针异常NullPointerException
        System.out.println("=================");

        // 三、equalsIgnoreCase
        String strA = "Java";
        String strB = "java";
        System.out.println(strA.equals(strB)); // false，严格区分大小写
        System.out.println(strA.equalsIgnoreCase(strB)); // true，忽略大小写

        // 注意，只有英文字母区分大小写，其他都不区分大小写
        System.out.println("abc一123".equalsIgnoreCase("abc壹123")); // false
    }

}

