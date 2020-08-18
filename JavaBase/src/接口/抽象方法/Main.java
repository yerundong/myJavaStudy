package 接口.抽象方法;

/*

@ 格式：
    public abstract 返回值类型 方法名称(参数列表);

@ 注意事项：
    1.接口是隐式抽象的，当声明一个接口的时候，不必使用abstract关键字（写不写都一样）。
    2.接口中每一个方法也是隐式抽象的，声明时同样不需要abstract关键字（写不写都一样）。
    3.接口中的方法都是公有的，声明时同样不需要public关键字（写不写都一样）。@ 注意事项：
    4.普通实现类必须有覆盖重写接口中所有的抽象方法；
    5.抽象实现类可以选择覆盖重写接口中的抽象方法；

@ 注：idea中关键字置灰表示可省写

*/

public class Main {
    public static void main(String[] args) {
        TestClass obj = new TestClass();
        obj.says1();
        obj.says2();
    }
}
