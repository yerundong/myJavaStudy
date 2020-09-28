package 类和对象.This关键字;

/*
@ this关键字作用：
    1.充当实例对象，用于访问实例的成员变量\方法，用法：this.field/this.method()
    2.充当本类的构造函数，用法：this()\this(...)

@ 注意：静态方法、静态代码块中不能使用this，因为实例对象还没生成，也就没有this
*/
public class Main {
    public static void main(String[] args) {
        new TestThis();
    }
}
