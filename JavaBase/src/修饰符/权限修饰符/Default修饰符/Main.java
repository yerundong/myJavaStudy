package 修饰符.权限修饰符.Default修饰符;

import 类和对象.Student;

/**
@default： default不是关键字，不加任何访问修饰符即是default，通常称为“默认访问模式“。该模式下，只允许在同一个包中进行访问。

@可见性： 同一个包中的同级类

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
