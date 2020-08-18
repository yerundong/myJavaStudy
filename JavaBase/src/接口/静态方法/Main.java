package 接口.静态方法;
/*
@ 从Java 8开始，接口里允许定义静态方法。

格式：
public static 返回值类型 方法名称(参数列表) {
    方法体
}

@ 注意事项：
    1.静态方法非抽象方法，必带有方法体
    2.静态方法不会被实现类继承，它与类无关，只存在接口自身中，当然也不必重写
    3.静态方法只能通过接口自身调用，格式：接口.静态方法()

*/
public class Main {
    public static void main(String[] args) {
        TestClass obj = new TestClass();
        obj.says();
        TestInterface.says();
    }
}
