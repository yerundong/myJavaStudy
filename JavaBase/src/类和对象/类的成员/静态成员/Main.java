package 类和对象.类的成员.静态成员;

/**
 @静态成员： static修饰符可用于修饰类的成员（变量和方法，以及内部类），被修饰的统称为为静态成员

 @什么时候使用静态的：
    1.不会随着对象改变而变的成员
    2.操作静态属性的方法
    3.工具类的方法，习惯用静态的（比较省事，不用创建对象，如Math、Arrays）
    4.常量（final）习惯用静态的

 @注： 静态内部类参考：src\类和对象\类和对象.内部类\成员内部类

 @访问格式： 类.静态变量\方法\类

 @静态成员内存位置： 位于静态域（方法区）

 @特点：
    1.节省内存空间
    2.共享性

 @注意事项:
    1.静态成员属于所在的类，非属于实例对象
    2.静态成员被同一类的实例对象可以共享
    3.静态成员可直接通过类访问，不需要创建实例就可使用
    4.静态先于实例对象存在，所以静态方法中不可用实例变量、实例方法、this、super关键字，但可以访问其他静态成员
    5.实例方法可以访问静态成员
    6.实例成员和静态成员的名称不允许重复
    7.静态方法可以被继承，可以被重载，可以被隐藏（隐藏其实相当于重新声明），但不能被重写

*/
public class Main {
    public static void main(String[] args) {
        System.out.println("main函数执行！！！");

        StaticMember sm = new StaticMember("郭靖");

        // 静态属性
        System.out.println(sm.country);// 正确，不推荐，这种写法在编译之后也会被javac翻译成为“类名称.静态变量名”
        System.out.println(StaticMember.country); // 正确，推荐

        // 静态方法
        sm.run();// 正确，不推荐 这种写法在编译之后也会被javac翻译成为“类名称.静态方法名”
        StaticMember.run(); // 正确，推荐
        StaticMember.setCountry("宋");

        // 静态内部类
        new StaticMember.StaticInsideClass();
    }
}

