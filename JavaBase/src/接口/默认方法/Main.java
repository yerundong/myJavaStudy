package 接口.默认方法;
/*
@ 从Java 8开始，接口里允许定义默认方法。

@ 格式：
    public default 返回值类型 方法名称(参数列表) {
        方法体
    }

@ 注意事项：
    1.默认方法非抽象方法，必带有方法体
    2.接口当中的默认方法，常用来解决接口升级的问题。
    3.若是升级时添加抽象方法，则实现类未重写而报错，而默认方法不用。
    4.
*/
public class Main {
    public static void main(String[] args) {
        TestClass obj1 = new TestClass();
        obj1.says1();
        obj1.says2();
    }
}
