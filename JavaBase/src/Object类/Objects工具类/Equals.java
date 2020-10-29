package Object类.Objects工具类;

import 类和对象.Student;

import java.util.Objects;

/**
    Objects.equals() 与 equals区别在于可以容忍空指针异常（null），判断基本类型时不用包装类，其他一致
*/

public class Equals {
    public static void main(String[] args) {
        Student stu1 = new Student("张三", 15);
        Student stu2 = new Student("张三", 15);
        char[] arr1 = {'a'};
        char[] arr2 = {'a'};

        int int1 = 1;
        int int2 = 1;

        String str1 = "a";
        String str2 = "a";
        String str3 = new String("a");
        String str4 = new String("a");

        System.out.println(Objects.equals(stu1, stu2));// false
        System.out.println(Objects.equals(null, stu2));// false
        System.out.println(Objects.equals(null, null));// true

        System.out.println(Objects.equals(int1, int2));// true

        System.out.println(Objects.equals(str1, str2));// true
        System.out.println(Objects.equals(str3, str4));// true
        System.out.println(Objects.equals(str2, str3));// true
    }
}
