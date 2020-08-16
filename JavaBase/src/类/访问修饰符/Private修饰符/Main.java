package 类.访问修饰符.Private修饰符;

/*
@ private：访问权限限制的最窄的修饰符，一般称之为“私有的”。被其修饰的类、属性以及方法只能被该类的对象访问，其子类不能访问，更不能允许跨包访问。

@ 作用：有一些变量和方法只作用在本类中，不必被外部访问或子类继承，则可以使用private修饰符

@ 1.private修饰类的属性和方法：
    1.用private修饰的类变量，方法，只能类的内部使用(读写)，对于类外部（包括它的子类和父类）来说是隐藏不可见的
    2.需要访问private成员变量，可通过Getter/Setter方法

@ 2.private修饰类，只能修饰内部类

@ Getter/Setter：
    规范：setXxx、getXxx的命名规则；对于基本类型当中的boolean值，Getter方法要写成isXxx的形式，而setXxx规则不变
    注意：
        1.对于Getter来说，不能有参数，返回值类型和成员变量对应；
        2.对于Setter来说，不能有返回值，参数类型和成员变量对应。
*/
public class Main {
    public static void main(String[] args) {
        TestPrivate hero = new TestPrivate();
        hero.age = 20;
        hero.frient = "钢铁侠";

        // private属性不能在类外访问
        // hero.name = "钢铁侠";// 错误

        // 通过setter、getter访问private属性
        hero.setName("蜘蛛侠");
        String getname = hero.getName();

        hero.say();

        // private方法不能在类外调用
        // hero.axiba();// 错误
        hero.executeAxiba();

        hero.setMale(true);
        System.out.println("是爷们们儿吗："+hero.isMale());
    }
}