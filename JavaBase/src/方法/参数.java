package 方法;

import 类和对象.Student;

/*
@ 方法的参数：是方法内部的局部变量，但它们是最先声明的，只不过是由调用时由外部传值\传址来赋值

@ 方法的参数分为两种：
    1.形参：形参代表方法定义上的，用于接收实际参数的参数，如void method(int a, int b)中的ab
    2.实参：实参代表实际参与运算的参数，如method(1, 2)中的12

@ 传递参数有两种类型：
    1.基本类型，值传递（传值），形参的改变不影响实参
    2.引用类型，引用地址传递（传址），形参的改变直接影响实参

@ 修饰符：
    1.形参不可使用访问修饰符
    2.可以使用final修饰符

@@ 可变的形参个数：DK 1.5 开始，Java支持传递同类型的可变参数给一个方法，以数组类型接受。

@ 格式：(type... name)

@ 注意事项：
    1.一个方法中只能指定一个可变参数
    2.可变参数必须是最后一个参数

*/
public class 参数 {
    public static void main(String[] args) {
        int num = 10;
        String str = "一十";
        Student student = new Student();

        says(num, str, student);

        System.out.println("输出4：" + num);
        System.out.println("输出5：" + str);
        System.out.println("输出6：" + student.getName());

        System.out.println("================ 分割线1 =================");
        look("abc", 1,2,3,4);
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

    // 可变参数
    public static void look(String str, int... nums){
        System.out.println(str);
        System.out.println(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
