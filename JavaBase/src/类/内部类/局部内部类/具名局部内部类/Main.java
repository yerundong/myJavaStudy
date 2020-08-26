package 类.内部类.局部内部类.具名局部内部类;

/*
@ 局部内部类：定义在方法内的类

@ 注意事项：
    1.局部内部类只能在该方法内访问，方法外无法访问
    2.局部内部类不允许使用权限修饰符（public，default...），因为没有意义，它只能在方法内访问
    3.局部内部类只能通过所在的方法去使用

@ 局部内部类访问该方法内的局部变量的情况：
    1.该变量必须是【final】的，原因：因为局部变量是跟方法走的，而局部内部类是new出来的，是在堆中的，两者声明周期不同，所以局部变量必须不变
    2.从Java 8+开始，只要局部变量事实不变，那么final关键字可以省略
*/
public class Main {
    public static void main(String[] args) {
        OuterClass outCla = new OuterClass();
        outCla.says();
    }
}
