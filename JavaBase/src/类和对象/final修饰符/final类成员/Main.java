package 类和对象.final修饰符.final类成员;
/**

 @final变量（成员常量）：
     1.成员常量，不可用默认值，所以必须赋值一次（初始化），且不可再变
        @注： 赋值的位置有：显式赋值，构造器赋值，代码块赋值。（方法中赋值不可行，太晚了）
     2.子类可以隐藏final变量

    @全局常量： 用 static final 修饰的成员变量

 @final方法： final方法不可被重写、隐藏，但可以被重载

    @注意： abstract 和 final 互相矛盾（abstract 方法一定要被重写，final 方法不可被重写），不能同时使用

 @内部类（？）

*/
public class Main {
    public static void main(String[] args) {
        SubClass subclass = new SubClass();

        SuperClass.look();
        SubClass.look();
    }
}
