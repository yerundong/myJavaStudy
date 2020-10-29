package 类和对象.This关键字;

/**
@this关键字作用：
    1.充当当前实例对象，用于访问实例的成员变量\方法，用法：this.field/this.method()
      注：当与成员变量或形参不重名的情况下，this可以省略

    2.充当本类的构造函数，用法：this()\this(...)
      注：
        1.只允许在构造器的第一行代码执行
        2.一个构造器中只允许执行一个其他构造方法
        3.只允许调用其他构造器
        4.构造器不允许循环调用

@注意： 静态方法、静态代码块中不能使用this，因为实例对象还没生成
*/
public class Main {
    public static void main(String[] args) {
        new TestThis();
    }
}
