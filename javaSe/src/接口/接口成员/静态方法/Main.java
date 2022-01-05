package 接口.接口成员.静态方法;

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
