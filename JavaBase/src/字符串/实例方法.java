package 字符串;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/*
 @CharSequence： CharSequence是char值的可读序列。
     @所有已知实现类：
        CharBuffer ， Segment ， String ， StringBuffer ， StringBuilder

 @注： 由于String的不可变性，String的所有方法都不会改变字符串

 @关键点： 左闭右开，原字符串不变，正则表达式

 */
public class 实例方法 {
    @Test
    public void length() {
        String str1 = "Hello Java";
        System.out.println(str1.length());
    }

    @Test
    public void concat() {
        String str0 = "Hello Java";
        String str1 = ", I am studying.";
        String str2 = str0.concat(str1);
        System.out.println(str2);
    }

    @Test
    public void charAt() {
        String str1 = "Hello Java";
        char char1 = str1.charAt(1);
        System.out.println(char1);
    }

    @Test
    public void indexOf() {
        String str1 = "Hello Java";
        System.out.println(str1.indexOf("l"));
        System.out.println(str1.indexOf('l'));
        System.out.println(str1.indexOf("Java"));
        System.out.println(str1.indexOf("l", 3));
    }

    @Test
    public void lastIndexOf() {
        String str = "hello2hello";
        System.out.println(str.lastIndexOf("e"));// 7
        System.out.println(str.lastIndexOf('2'));// 5
        System.out.println(str.lastIndexOf('2' + 0));// 5
        System.out.println(str.lastIndexOf("e", 2));// 1
    }

    @Test
    public void contains() {
        String str = "Gemute";
        System.out.println(str.contains("emu"));// true
        System.out.println(str.contains("emue"));// false
    }

    @Test
    public void substring() {
        String str0 = "Hello Java";
        String str1 = str0.substring(6);//
        String str2 = str0.substring(6, 7);
        System.out.println(str1);
        System.out.println(str2);
    }

    @Test
    public void toCharArray() {
        String str0 = "Hello Java";
        char[] charArr1 = str0.toCharArray();
        System.out.println(charArr1[0]);
    }

    @Test
    public void getBytes() throws UnsupportedEncodingException {
        String str = "abc123中国";
        byte[] byteArr1 = str.getBytes();
        byte[] byteArr2 = str.getBytes("UTF-16");
        byte[] byteArr3 = str.getBytes("US-ASCII");
        byte[] byteArr4 = str.getBytes("GBK");
        System.out.println(Arrays.toString(byteArr1));
        System.out.println(Arrays.toString(byteArr2));
        System.out.println(Arrays.toString(byteArr3));
        System.out.println(Arrays.toString(byteArr4));
    }

    @Test
    public void intern() {
        String str1 = new String("abc");
        String str2 = str1.intern();
        String str3 = "abc";
        String str4 = str3.intern();
        System.out.println(str1 == str2);// false
        System.out.println(str2 == str3);// true
        System.out.println(str3 == str4);// true
    }

    @Test
    public void isEmpty() {
        String str1 = "Hello Java";
        System.out.println(str1.isEmpty());// false
        System.out.println("".isEmpty());// true
    }

    @Test
    public void toLowerCase_toUpperCase() {
        System.out.println("abcDef123".toLowerCase());
        System.out.println("abcDef123".toUpperCase());
    }

    @Test
    public void trim() {
        System.out.println("trim =" + " ab cd   ".trim() + ";");
    }

    @Test
    public void compareTo() {
        String str1 = "abc";// c99
        String str2 = "abde";// d100 e101
        String str3 = "5";
        String str4 = "10";
        System.out.println(str1.compareTo(str2));
        System.out.println(str3.compareTo(str4));
    }

    @Test
    public void endsWith_startsWith() {
        String str = "Gemute";
        System.out.println("endsWith ：" + str.endsWith("te"));// true
        System.out.println("endsWith ：" + str.endsWith("AGemute"));// false
        System.out.println("startsWith ：" + str.startsWith("G"));// true
        System.out.println("startsWith ：" + str.startsWith("mut"));// false
        System.out.println("startsWith ：" + str.startsWith("mut", 2));// true
    }

    @Test
    public void replace() {
        String str1 = "北京在北边所以叫北京";
        String str2 = str1.replace("北", "东");
        String str3 = str1.replace('京', '城');
        System.out.println(str2);
        System.out.println(str3);
    }

    @Test
    public void replaceAll() {
        String str1 = "123abc四五六，123abc四五六";
        String str2 = str1.replaceAll("abc", "ABC");
        String str3 = str1.replaceAll("\\d+", "。");
        String str4 = str1.replaceAll("^123|四五六$|，", "*");
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
    }

    @Test
    public void matches() {
        String str1 = "123abc四五六，123abc四五六";
        System.out.println(str1.matches(".*abc.*"));// true
        System.out.println(str1.matches("^123[a-z]{3}.*四五六$"));// true
    }

    @Test
    public void split() {
        String str = "aaa,bbb,ccc,ddd";
        String[] stringArr1 = str.split(",");// {"aaa", "bbb", "ccc", "ddd"}
        String[] stringArr2 = str.split(",", 2);// {"aaa", "bbb,ccc,ddd"}
        System.out.println(Arrays.toString(stringArr1));
        System.out.println(Arrays.toString(stringArr2));
    }

}
