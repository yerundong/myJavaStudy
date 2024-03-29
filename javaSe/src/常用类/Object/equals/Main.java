package 常用类.Object.equals;

import lib.Student;

public class Main {
    public static void main(String[] args) {
        // @基本类型
        // 比较内容
        Byte byte1 = 1;
        Byte byte2 = 1;
        Short short1 = 1;
        Short short2 = 1;
        Integer int1 = 1;
        Integer int2 = 1;
        Long long1 = 1L;
        Long long2 = 1L;
        Float float1 = 1.1F;
        Float float2 = 1.1F;
        Double double1 = 1.1;
        Double double2 = 1.1;
        Character char1 = 'a';
        Character char2 = 'a';
        Boolean bool1 = false;
        boolean bool2 = false;
        System.out.println(byte1.equals(byte2));// true
        System.out.println(short1.equals(short2));// true
        System.out.println(int1.equals(int2));// true
        System.out.println(long1.equals(long2));// true
        System.out.println(float1.equals(float2));// true
        System.out.println(double1.equals(double2));// true
        System.out.println(char1.equals(char2));// true
        System.out.println(bool1.equals(bool2));// true

        System.out.println("================ part 2 ===================");

        // @字符串
        // 比较内容
        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
        String str4 = new String("abc");
        String str5 = str4;

        System.out.println(str1.equals(str2));// true
        System.out.println(str3.equals(str4));// true
        System.out.println(str2.equals(str3));// true
        System.out.println(str4.equals(str5));// true
        System.out.println("abc".equals(str1));// true

        System.out.println("================ part 3 ===================");

        // @其他引用类型
        // 没有重写equals，继承Object类的equals，是比较地址
        Student stu1 = new Student("张三");
        Student stu2 = new Student("张三");
        char[] arr1 = {'a'};
        char[] arr2 = {'a'};
        System.out.println(stu1.equals(stu2));

        // @重写类中的 equals 方法
        OverrideEquals oe1 = new OverrideEquals("张三", 15);
        OverrideEquals oe2 = new OverrideEquals("张三", 15);

        System.out.println(oe1.equals(oe2));// true


    }
}

