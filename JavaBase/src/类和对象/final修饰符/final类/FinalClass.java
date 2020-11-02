package 类和对象.final修饰符.final类;

/**

 @final类： 使这个类不可被继承（太监类），成为最终类，被继承会报错

 @注意事项：
     1.final类没有子类，但有父类（任何类都有父类，除了Object）
     2.既然没有继承，也就没有所谓的子类对父类的成员覆盖、重载
     3.final类一样可以对它的父类成员进行重写、重载
     4.abstract 和 final 互相矛盾（abstract 类一定要被继承，final 类不可被继承），不能同时使用

 */
public final class FinalClass {
}
