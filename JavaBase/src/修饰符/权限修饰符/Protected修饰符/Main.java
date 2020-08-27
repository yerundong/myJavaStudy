package 修饰符.权限修饰符.Protected修饰符;

import 修饰符.权限修饰符.Protected修饰符.pack1.TestSuper;
import 修饰符.权限修饰符.Protected修饰符.pack2.TestSub;

/*
@ protected：:被protected修饰的成员对于本包和其子类可见。

@ 可见性：
    1.若在同一个包中，protected成员是可见的
    2.若不在同一包中，非继承关系不可见；若继承，那么在子类中，子类可继承父类的protected成员，但不能访问【父类实例】的protected方法

@ 修饰限制：
    1.不能修饰接口的成员
    2.不能修饰类\接口（外部）
*/

public class Main extends TestSuper {
    public static void main(String[] args) {
        TestSub sub = new TestSub();

        // 报错
        // System.out.println(sub.name);
        // sub.says();

        sub.says2();
    }
}
