package 接口.抽象方法;

/**
接口最重要的内容就是其中的：抽象方法。

@格式：
    返回值类型 方法名称(参数列表);

@注意事项：
    1.接口是隐式抽象的，当声明一个接口的时候，可以省略 abstract 关键字
    2.接口中每一个方法是隐式抽象的，声明时可以省略 abstract 关键字
    3.接口中的抽象方法必须公有的，声明时可以省略 public 关键字
    4.普通实现类必须重写接口中所有的抽象方法；
    5.抽象实现类可以【选择性地】重写接口中的抽象方法；

*/

public class Main {
    public static void main(String[] args) {
        TestClass obj = new TestClass();
        obj.says1();
        obj.says2();
    }
}
