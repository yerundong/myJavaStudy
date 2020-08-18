package 权限修饰符.Protected修饰符.pack2;

import 权限修饰符.Protected修饰符.pack1.TestSuper;

public class TestSub extends TestSuper {
    private int age = 15;

    protected void says(){
        System.out.println(this.name);
    }

    public void says2(){
        // 父类继承而来的protected成员
        System.out.println(this.name);

        // 父类继承而来的protected静态成员
        super.open();

        // 不可访问不同包父类实例的protected成员
        // System.out.println(new TestSuper().name);// 报错

        // 本包的protected成员
        System.out.println(new TestBrother().hobby);
    }
}
