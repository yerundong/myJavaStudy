package 访问修饰符.Default修饰符;

import 类.Student;

/*
@ default：default不是关键字，不加任何访问修饰符即是default，通常称为“默认访问模式“。该模式下，只允许在同一个包中进行访问。

@ 特点：default修饰类的成员变量\方法\类，只允许在同一个包中进行访问

@ 注意事项：
    1.可以修饰普通类和内部类
*/
public class Main {
    public static void main(String[] args) {
        // 来自同一个包中的default类
        TestDefault td = new TestDefault();

        // 来自非同一个包中的default类，无法访问
        // Guys guys = new Guys();// 报错

        // 来自非同一个包中的public类中的default成员变量，，无法访问
        Student stu = new Student();
        // System.out.println(stu.tip);// 报错
    }
}
