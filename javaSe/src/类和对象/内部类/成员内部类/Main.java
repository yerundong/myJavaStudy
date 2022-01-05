package 类和对象.内部类.成员内部类;

public class Main {
    public static void main(String[] args) {
        OuterClass cla = new OuterClass();

        // 通过成员方法，间接访问
        cla.cook();

        // 创建非静态成员内部类
        OuterClass.InnerClass innerCla = new OuterClass().new InnerClass();
        // innerCla.says();

        // 创建静态成员内部类
        OuterClass.StaticInnerClass staticInnerCla = new OuterClass.StaticInnerClass();
        // staticInnerCla.see();
    }
}
