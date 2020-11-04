package 接口.静态方法;
/**
@注： 从Java 8开始，接口里允许定义静态方法。

@权限修饰符：
    1.public：默认，可以省略
    2.private

@格式：
    static 返回值类型 方法名称(参数列表) {
        方法体
    }

@注意事项：
    1.静态方法非抽象方法，必带有方法体
    2.接口的静态方法不会被继承（这里与父类不同），只存在接口自身中，当然也没有重载、重写、隐藏（重点）
    3.静态方法只能通过接口自身调用，格式：接口.静态方法()

*/
public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();

        // 接口\父类自身调用
        MyInterface.staticMethodI();
        MySupClass.staticMethodC();

        // 父类的静态方法，子类可以继承
        MyClass.staticMethodC();

        // 接口静态方法，实现类无法继承，这是区别
        // MyClass.staticMethodI();

    }
}
