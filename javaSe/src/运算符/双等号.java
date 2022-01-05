package 运算符;

import lib.Student;

public class 双等号 {
    public static void main(String[] args) {
        // 基本类型
        byte byte1 = 1;
        byte byte2 = 1;
        short short1 = 1;
        short short2 = 1;
        int int1 = 1;
        int int2 = 1;
        long long1 = 1;
        long long2 = 1;
        float float1 = 1.1F;
        float float2 = 1.1F;
        double double1 = 1.1;
        double double2 = 1.1;
        char char1 = 'a';
        char char2 = 'a';
        boolean bool1 = false;
        boolean bool2 = false;
        System.out.println(int1 == int2);// true
        System.out.println(char1 == char2);// true
        System.out.println(byte1 == byte2);// true
        System.out.println(short1 == short2);// true
        System.out.println(long1 == long2);// true
        System.out.println(long1 == long2);// true
        System.out.println(float1 == float2);// true
        System.out.println(double1 == double2);// true
        System.out.println(bool1 == bool2);// true

        System.out.println("================ part 2 ===================");

        // 引用类型
        Student stu1 = new Student("张三");
        Student stu2 = new Student("张三");
        char[] arr1 = {'a'};
        char[] arr2 = {'a'};

        System.out.println(stu1 == stu2);// false
        System.out.println(arr1 == arr2);// false

        System.out.println("================ part 3 ===================");

        // 字符串（是引用类型，但有一个常量池机制）
        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
        String str4 = new String("abc");
        String str5 = str4;

        System.out.println(str1 == str2);// true
        System.out.println(str1 == str3);// false
        System.out.println(str3 == str4);// false
        System.out.println(str4 == str5);// true
    }
}
