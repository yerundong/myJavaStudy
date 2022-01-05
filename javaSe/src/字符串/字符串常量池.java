package 字符串;

import org.junit.jupiter.api.Test;

public class 字符串常量池 {

    @Test
    public void test1() {
        String str1 = "abc";
        String str2 = "abc";

        char[] charArray = {'a', 'b', 'c'};
        String str3 = new String(charArray);
        String str4 = new String("abc");

        System.out.println(str1 == str2); // true
        System.out.println(str1 == str3); // false
        System.out.println(str1 == str4); // false
    }

    @Test
    public void test2() {
        String str1 = "a";
        final String str1_ = "a";
        String str2 = "b";
        final String str2_ = "b";

        String $str1 = new String("ab");
        String $str2 = "ab";
        String $str3 = "a" + "b";
        String $str4 = "a" + str2;
        String $str5 = "a" + str2_;
        String $str6 = str1_ + str2_;

        System.out.println($str1 == $str2);// false
        System.out.println($str2 == $str3);// true
        System.out.println($str2 == $str4);// false
        System.out.println($str2 == $str5);// true
        System.out.println($str2 == $str6);// true
    }

}

