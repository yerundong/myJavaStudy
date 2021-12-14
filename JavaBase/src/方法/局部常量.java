package 方法;

import lib.Student;

public class 局部常量 {
    public static void main(String[] args) {
        final int NUM1 = 10;
        // NUM1 = 10;// 报错
        // NUM1 = 20;// 报错

        final int NUM2;
        NUM2 = 20;

        //　引用类型
        final Student STU = new Student();

        // 错误：
        // STU = new Student();// 每次new地址值发生变化

        // 但允许对类内容成员修改
        STU.setName("张三");
    }

    // final形参
    public static void mth(final int NUM) {
        // NUM = 666;// 报错
        // NUM++;// 报错

        System.out.println(NUM);
    }
}
