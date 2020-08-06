package 修饰符;
import 类.Student;
// import 类.Guys;// 报错，非一个包

/*
default：即不加任何访问修饰符，通常称为“默认访问模式“。该模式下，只允许在同一个包中进行访问。

1.default修饰类的属性和方法:
    1.同一个包访问

2.default修饰类:
    1.同一个包访问
    2.可以修饰普通类和内部类

*/
public class Default修饰符 {
    public static void main(String[] args) {
        // 来自同一个包中的default类
        Kit kit = new Kit();
        Hero hero = new Hero();

        // 来自非同一个包中的default类，无法访问
        // Guys guys = new Guys();// 报错

        // 来自非同一个包中的public类中的default属性，，无法访问
        Student stu = new Student();
        // System.out.println(stu.tip);// 报错
    }
}

class Kit{
    String str1 = "kit";
}
