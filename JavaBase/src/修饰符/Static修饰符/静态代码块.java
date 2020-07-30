package 修饰符.Static修饰符;
/*
静态代码块的格式是：

public class 类名称 {
    static {
        // 静态代码块的内容
    }
}

特点：
1.当第一次用到本类时，静态代码块执行唯一的一次。
2.静态内容总是优先于非静态，所以静态代码块比构造方法先执行。

静态代码块的典型用途：
用来一次性地对静态成员变量进行赋值。
 */
public class 静态代码块 {
    public static void main(String[] args) {
        System.out.println("main函数执行！！！");
        StaticBlock sb = new StaticBlock();
        StaticBlock sb2 = new StaticBlock();
    }
}
class StaticBlock{
    static {
        System.out.println("静态代码块执行！！！");
    }

    public StaticBlock() {
        System.out.println("构造函数执行！！！");
    }
}

