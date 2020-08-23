package 类.Static修饰符;

/*
@ static修饰符：用于修饰类的成员变量和方法，以及内部类，是被修饰的成为静态变量\方法\类

@ 访问格式：类.静态变量\方法\类

@ 注意事项:
    1.static修饰的目标对象将属于所在的类，非属于实例对象
    2.同一类的实例对象可以共享该类的静态变量\方法\类
    3.静态变量\方法\类不需要new创建就可使用，直接通过类访问
    4.普通类是不允许声明为静态的，只有内部类才可以
    5.静态方法中不可用this关键字，因为静态先于实例对象
    6.静态方法不能访问实例变量，但可以访问类变量
    7.静态方法可以被继承，可以被重载，可以被隐藏，但不能被重写（隐藏其实相当于重新声明）

*/
public class Main {
    public static void main(String[] args) {
        System.out.println("main函数执行！！！");

        // 静态代码块
        new StaticBlock();
        new StaticBlock();

        StaticModifier sm = new StaticModifier("郭靖");

        // 静态属性
        System.out.println(sm.country);// 正确，不推荐，这种写法在编译之后也会被javac翻译成为“类名称.静态变量名”
        System.out.println(StaticModifier.country); // 正确，推荐

        // 静态方法
        sm.run();// 正确，不推荐 这种写法在编译之后也会被javac翻译成为“类名称.静态方法名”
        StaticModifier.run(); // 正确，推荐
        StaticModifier.setCountry("宋");

        // 静态内部类
        new StaticModifier.StaticInsideClass();
    }
}

