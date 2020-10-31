package 修饰符.Static修饰符;

/**
@修饰对象:
    1.类成员 参考：\src\类和对象\类的成员
    2.接口成员 参考：\src\接口\静态方法&常量
    3.代码块

@静态内存： 位于静态区（方法区）


*/
public class Main {
    public static void main(String[] args) {
        System.out.println("main函数执行！！！");

        // 静态代码块
        new StaticBlock();
        new StaticBlock();

    }
}

