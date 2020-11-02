package 类和对象.抽象;
/**


 一、抽象类

 @抽象类： 如果一个类没必要实例化，仅提供一些结构供子类去实例化，其中没有包含具体的信息来描绘一个具体的对象，这样的类就是抽象类。

 @解释： 类的继承当中，结构会越来越具体，而上层的父类往往需要更通用，且没必要实例化，因此便有了抽象类

 @声明格式：
    abstract class {
        ...
    }

 @注意：
    1.抽象类不能直接实例化，必须被继承，才能够使用
    2.没有任何抽象方法的抽象类有特殊作用（待学。。。）

 二、抽象方法

 @抽象方法: 该方法的具体实现由它的子类确定，那么你可以在父类中声明该方法为抽象方法

 @声明格式：
    abstract returnType method (Type param);

 @注意：
    1.抽象方法只能声明在抽象类中
    2.有抽象方法的类必定是抽象类，抽象类中不一定包含抽象方法
    3.子类必须覆盖重写抽象父类当中所有的抽象方法，除非该子类也是抽象类，否则报错。
    4.构造方法，静态方法（static）不能声明为抽象方法
    5.一个抽象类若要被普通类继承，必须保证没有任何抽象方法未被重写
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
