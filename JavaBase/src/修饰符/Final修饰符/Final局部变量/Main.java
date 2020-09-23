package 修饰符.Final修饰符.Final局部变量;

import 类和对象.Student;

/*
@ final局部变量：只能赋值一次，之后不可再赋值修改，即“一次赋值，终生使用”

@ 注意事项：
    1.对于基本类型来说，不可变说的是变量当中的数据不可改变
    2.对于引用类型来说，不可变说的是变量当中的地址值不可改变
*/
public class Main {
    public static void main(String[] args) {
        final int num1 = 10;
        // num1 = 10;// 报错
        // num1 = 20;// 报错

        final int num2;
        num2 = 20;

        //　引用类型
        final Student stu = new Student();
        // 错误：
        // stu = new Student();// 每次new地址值发生变化
        // 但允许对类内容成员修改
        stu.setName("张三");
    }
}
