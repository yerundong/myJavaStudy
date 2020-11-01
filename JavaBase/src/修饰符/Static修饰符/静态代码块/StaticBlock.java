package 修饰符.Static修饰符.静态代码块;

public class StaticBlock {

    static {
        // System.out.println(this);// this还没生成
        System.out.println("StaticBlock的静态代码块执行！！！");
    }

    public StaticBlock() {
        System.out.println("StaticBlock的构造函数执行！！！");
    }
}

