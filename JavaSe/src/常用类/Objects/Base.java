package 常用类.Objects;

import lib.Student;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class Base {
    @Test
    public void equals() {
        // <SM> public static boolean equals(Object a, Object b)
        Student stu1 = new Student("张三");
        Student stu2 = new Student("张三");
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

    @Test
    public void deepEquals() {
        // <SM> public static boolean deepEquals(Object a, Object b)
    }
}
