package 接口;
/*
@ InterfaceForAbstractMethod：接口中的抽象方法
@ 注意事项：
    1.接口是隐式抽象的，当声明一个接口的时候，不必使用abstract关键字（写不写都一样）。
    2.接口中每一个方法也是隐式抽象的，声明时同样不需要abstract关键字（写不写都一样）。
    3.接口中的方法都是公有的，声明时同样不需要public关键字（写不写都一样）。

@ 注：idea中关键字置灰表示可省写
*/
public abstract interface InterfaceForAbstractMethod {
    public abstract void says1();
    // 等同于：
    //void says1();

    void says2();
}
