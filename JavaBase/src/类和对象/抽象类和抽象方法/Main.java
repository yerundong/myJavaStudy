package 类和对象.抽象类和抽象方法;
/*
@ 抽象类：如果一个类中没有包含足够的信息来描绘一个具体的对象，这样的类就是抽象类。
@ 声明方式：在class之前写上abstract即可。

@ 抽象方法: 该方法的具体实现由它的子类确定，那么你可以在父类中声明该方法为抽象方法
@ 声明方式：在方法返回类型之前写上abstract，且只有声明，不能有方法体。

@ 注意事项：
    1.抽象类不能直接实例化创建对象，必须被继承，才能够使用
    2.抽象类中不一定包含抽象方法，但是有抽象方法的类必定是抽象类。
    3.子类必须覆盖重写抽象父类当中所有的抽象方法，除非该子类也是抽象类，否则报错。
    4.构造方法，类方法（用 static 修饰的方法）不能声明为抽象方法。
    5.没有任何抽象方法的抽象类有特殊作用（待学。。。）
    6.一个抽象类若要被普通类继承，必须保证没有任何抽象方法未被重写



*/
public class Main {
    public static void main(String[] args) {
        // AbsctClass abcs = new AbsctClass();// 错误，无法实例化抽象类

        CommonClass1 cm1 = new CommonClass1();
        cm1.says();
        cm1.run();

        System.out.println("===============================");

        CommonClass2 cm2 = new CommonClass2();
        cm2.says();
        cm2.run();
    }
}
