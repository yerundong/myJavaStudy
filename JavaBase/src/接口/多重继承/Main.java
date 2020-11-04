package 接口.多重继承;
/**
@多重继承： 一个接口可以同时继承多个父接口

@注意事项：
    1.父接口抽象方法重复：子接口不必重写，但实现类中必须重写
    2.父接口默认方法重复：子接口必须重写，实现类不必重写
    3.父接口静态方法重复：静态方法只通过接口自身调用，所以不用管重复（接口的静态方法不会被继承）
    4.父接口常量（静态变量）重复，只能通过父接口调用；或者子接口中重声明隐藏接口常量，才可以在子接口、类、实例调用
*/
public class Main {
    public static void main(String[] args) {
        ImplClass obj = new ImplClass();
        // 常量
        System.out.println(ImplClass.MY_CONST);

        // 抽象方法
        obj.abs();
        obj.abs1();
        obj.abs2();

        // 默认方法
        obj.def();
        obj.def1();
        obj.def2();

        // 静态方法
        SuperInterface1.stac();
        SuperInterface1.stac1();
        SuperInterface2.stac();
        SuperInterface2.stac2();
    }
}
