package 权限修饰符.Default修饰符;

import lib.Student;

public class Main {
    public static void main(String[] args) {
        // 来自同一个包中的default类
        TestDefault td = new TestDefault();

        // 来自非同一个包中的default类，无法访问
        // Guys guys = new Guys();// 报错

        // 来自非同一个包中的public类中的default成员变量，无法访问
        Student stu = new Student();
        // System.out.println(stu.tip);// 报错
    }
}
