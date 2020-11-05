package 类和对象.内部类.成员内部类;
/**
 @成员内部类： 内部类作为一个外部类的成员存在。

 @用途： 但一个事物（人）需要一个完整的结构（大脑）去描述，而这个结构只需要对这个事物提供服务，那么这个结构最好使用内部类

 @成员内部类可分为两种：
    1.非静态成员内部类
    2.静态成员内部类

 @访问成员内部类的两种方式：
    1.通过成员方法，间接访问
    2.直接创建访问

 @实例化成员内部类格式： 外部类名称.内部类名称 对象名 = new 外部类名称().new 内部类名称();
 @实例化静态内部类格式： 外部类名称.内部类名称 对象名 = new 外部类名称.内部类名称();

 @注意事项：
    1.内部类的 this 指向内部类实例，若要在内部类中使用外部类 this，则用：【外部类.this】

*/
public class Main {
    public static void main(String[] args) {
        OuterClass cla = new OuterClass();

        // 通过成员方法，间接访问
        cla.cook();

        // 创建非静态成员内部类
        OuterClass.InnerClass innerCla =  new OuterClass().new InnerClass();
        // innerCla.says();

        // 创建静态成员内部类
        OuterClass.StaticInnerClass staticInnerCla = new OuterClass.StaticInnerClass();
        // staticInnerCla.see();
    }
}
