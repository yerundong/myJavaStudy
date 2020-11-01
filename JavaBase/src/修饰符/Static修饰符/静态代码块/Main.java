package 修饰符.Static修饰符.静态代码块;

/**
 @StaticBlock： 静态代码块

 @格式：
 public class 类名称 {
 static {
 // 静态代码块的内容
 }
 }

 @特点：
 1.当第一次用到本类时，静态代码块执行唯一的一次。
 2.静态内容总是优先于非静态，所以静态代码块比构造方法先执行。
 3.无法调用this，因为静态先于实例化执行

 @典型用途：
 用来一次性地对静态成员变量进行赋值。

 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main函数执行！！！");

        // 静态代码块
        new StaticBlock();
        new StaticBlock();
    }
}
