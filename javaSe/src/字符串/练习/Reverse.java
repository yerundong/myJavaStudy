package 字符串.练习;

import org.junit.jupiter.api.Test;

/**
 * @Description 字符串反转方法
 */
public class Reverse {
    @Test
    public void test(){
        String str = "abcdefg";
        String str1 = reverse(str);
        String str2 = reverse(str, 0, 3);
        String str3 = reverse(str, 3, 6);
        String str4 = reverse(str, 4);
        String str5 = reverse(null, 4);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
    }

    public String reverse(String str){
        if (str == null)
            return null;
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String rstr = sb.toString();
        return rstr;
    }

    public String reverse(String str, int offset){
        if (str == null)
            return null;
        String str1 = str.substring(0, offset);
        String str2 = str.substring(offset);
        StringBuilder sb2 = new StringBuilder(str2);
        sb2.reverse();
        String rstr = str1 + sb2;
        return rstr;
    }

    public String reverse(String str, int startIndex, int endIndex){
        if (str == null)
            return null;
        String str1 = str.substring(0, startIndex);
        String str2 = str.substring(startIndex, endIndex);
        String str3 = str.substring(endIndex);
        StringBuilder sb2 = new StringBuilder(str2);
        sb2.reverse();
        String rstr = str1 + sb2 + str3;
        return rstr;
    }
}
