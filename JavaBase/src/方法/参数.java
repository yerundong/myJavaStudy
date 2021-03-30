package 方法;

import org.junit.jupiter.api.Test;
import 示例.Student;

import java.util.Arrays;

/**
@方法的参数： 是方法内部的局部变量，但它们是最先声明的，只不过是由调用时由外部传值\传址来赋值

@方法的参数分为两种：
    1.形参：形参代表方法定义上的，用于接收实际参数的参数，如void method(int a, int b)中的ab
    2.实参：实参代表实际参与运算的参数，如method(1, 2)中的12

@传递参数有两种类型：
    1.基本类型，值传递（传值），形参的改变不影响实参
    2.引用类型，引用地址传递（传址），形参的改变直接影响实参

@修饰符：
    1.形参不可使用访问修饰符
    2.可以使用final修饰符

@可变的形参个数： JDK 1.5 开始，Java支持传递同类型的可变参数给一个方法，以数组类型接受。
   用来接受不可预期个数的参数。

@格式： (Type... name)

@注意事项：
    1.一个方法中只能指定一个可变参数
    2.可变参数必须是最后一个参数
    3.与(Type[] name)是相同的形参列表，可构成重写条件，不构成重载条件
    4.可变参数会被转成数组类型接收，直接传数组也可接收

*/
public class 参数 {

    @Test
    public void 可变参数(){
        look("abc", 1,2,3,4);
        // 直接传数组也可接收
        look("abc", new int[]{7, 8, 9});
    }

    @Test
    public void 不同类型的参数(){
        int num = 10;
        String str = "一十";// 字符串不可变性
        Student student = new Student();

        says(num, str, student);

        System.out.println("输出4：" + num);
        System.out.println("输出5：" + str);
        System.out.println("输出6：" + student.getName());
    }

    // 不同类型的参数
    public static void says(int num, String str, Student student){
        num = 20;
        str = "二十";
        student.setName("张三");

        System.out.println("输出1：" + num);
        System.out.println("输出2：" + str);
        System.out.println("输出3：" + student.getName());
    }

    // 可变参数方法
    public static void look(String str, int... intArr){
        System.out.println(str);
        System.out.println(Arrays.toString(intArr));
    }

    // 与上面look不构成重载，报错，因为可变参数即是数组
    // public static void look(String str, int[] intArr){}
}
