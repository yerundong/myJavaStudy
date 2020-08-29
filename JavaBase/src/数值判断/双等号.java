package 数值判断;

public class 双等号 {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 1;

        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
        String str4 = str3;

        System.out.println(num1 == num2);// true
        System.out.println(str1 == str2);// true
        System.out.println(str1 == str3);// false
        System.out.println(str3 == str4);// true
    }
}
