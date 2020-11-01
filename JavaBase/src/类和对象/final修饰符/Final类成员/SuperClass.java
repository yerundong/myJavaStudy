package 类和对象.final修饰符.Final类成员;

public class SuperClass {
    // 成员变量：必须直接赋值，或者所有的构造函数进行赋值，二者选其一
    public final String name = "SuperClass name";
    public final int age;
    public SuperClass() {
        this.age = 0;
    }
    public SuperClass(int age) {
        this.age = age;
    }

    // 静态成员变量：允许被子类隐藏
    public final static String tip = "SuperClass tip";

    // 成员方法
    public final void says(){
        System.out.println("SuperClass says");
    }

    // 静态成员方法
    public static final void look(){
        System.out.println("SuperClass look");
    }

    // 报错：abstract 和 final互相矛盾
    // public abstract final void hello();
}
