package 数组.练习;

import java.util.Arrays;

/*
题目：
请使用Arrays相关的API，将一个随机字符串中的所有字符升序排列，并倒序打印。
*/
public class 随机字符串排序 {
    public static void main(String[] args) {
        String str = "kfjghigahfgrq3645wemniklmrn.+ gtlxcuyts";
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        System.out.println(charArr);
        for (int i = charArr.length-1; i >= 0; i--) {
            System.out.println(charArr[i]);
        }
    }
}
