package 方法;

import lib.Student;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 参数 {

    @Test
    public void 不同类型的参数() {
        int num = 10;
        String str = "一十";// 字符串不可变性
        Student student = new Student();

        says(num, str, student);

        System.out.println("输出4：" + num);
        System.out.println("输出5：" + str);
        System.out.println("输出6：" + student.getName());
    }

    @Test
    public void 可变形参() {
        look("abc", 1, 2, 3, 4);
        // 直接传数组也可接收
        look("abc", new int[]{7, 8, 9});
    }

    // 不同类型的参数
    public static void says(int num, String str, Student student) {
        num = 20;
        str = "二十";
        student.setName("张三");

        System.out.println("输出1：" + num);
        System.out.println("输出2：" + str);
        System.out.println("输出3：" + student.getName());
    }

    // 可变形参
    public static void look(String str, int... intArr) {
        System.out.println(str);
        System.out.println(Arrays.toString(intArr));
    }

    // 报错，与上面look不构成重载，因为可变参数即是数组
    // public static void look(String str, int[] intArr){}
}
