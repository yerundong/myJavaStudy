package 多态;
/*
@ 定义：
    多态（Polymorphism）是指同一个行为，具有多个不同表现形式或形态的能力。
    比如跑的行为，小猫、小狗和大象，跑起来是不一样的。再比如飞的行为，昆虫、鸟类和飞机，飞起来也是不一样的。

@ 多态存在的三个必要条件：
    1.继承或者实现【二选一】
    2.方法的重写【意义体现：不重写，无意义】
    3.父类引用指向子类对象【格式体现】

@ 多态的优点：
    1. 消除类型之间的耦合关系
    2. 可替换性
    3. 可扩充性
    4. 接口性
    5. 灵活性
    6. 简化性

@ 多态体现的格式：
    父类名称 对象名 = new 子类名称();
    或者：
    接口名称 对象名 = new 实现类名称();

@ 口诀：编译看左边，运行看右边。

@ 使用多态调用成员方法时：
    1.直接访问成员变量，看左边，没有则向上查找
    2.通过方法间接访问成员变量，看方法属于谁，没有则向上查找

@ 使用多态访问成员变量时：
    1.直接访问成员变量，看左边，没有则向上查找
    2.通过方法间接访问成员变量，看方法属于谁，没有则向上查找

*/
public class Main {
    public static void main(String[] args) {
        SubClass obj1 = new SubClass();
        SuperClass obj2 = new SubClass();

        System.out.println(obj1.name);// SubClass name
        System.out.println(obj1.tip);// SubClass tip

        // 多态：直接访问成员变量看左边，没有则向上查找
        System.out.println(obj2.name);// SuperClass name
        System.out.println(obj2.tip);// GrandPaClass tip

        obj2.getName();

        obj1.abs();// SubClass abs
        obj2.abs();// SubClass abs
    }
}
