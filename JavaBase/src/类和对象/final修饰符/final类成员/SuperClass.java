package 类和对象.final修饰符.final类成员;

public class SuperClass {

    // final成员变量：必须赋值（显式赋值、代码块赋值、【所有】的构造函数赋值，反正最终就是要赋值），且不可再变
    public final String NAME = "SuperClass NAME";
    public final int AGE;
    public final int COUNT;

    {
        COUNT = 123;
    }

    public SuperClass() {
        this.AGE = 111;
    }

    public SuperClass(int AGE) {
        this.AGE = AGE;
    }

    // final静态变量：必须赋值，（显式赋值、代码块赋值，反正最终就是要赋值），且不可再变
    public final static String tip = "SuperClass tip";
    public final static String log;

    static {
        log = "wuwuwu";
    }

    // final成员方法
    public final void says(){
        System.out.println("SuperClass says");
    }

    // final静态方法
    public static final void look(){
        System.out.println("SuperClass look");
    }

    // 报错：abstract 和 final互相矛盾
    // public abstract final void hello();

}
