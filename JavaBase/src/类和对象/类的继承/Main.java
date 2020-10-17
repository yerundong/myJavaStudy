package 类和对象.类的继承;
/*
@ extends（拓展、继承）：继承就是子类继承父类的特征和行为，使得子类对象（实例）具有父类的实例域和方法，或子类从父类继承方法，使得子类具有父类相同的行为。

@ 作用：共性抽取

@ 特性:
    1.子类拥有父类所有的属性和方法。
    2.子类可以在父类的基础上进行修改和扩展，方式是重写、重载、隐藏
    3.父类的private属性和方法也是可以被继承的，只是子类拥有但无法访问（封装性）
    4.Java 的继承是【单继承】，但是可以【多重继承】。单继承是一个子类只能继承一个父类（只能有一个父亲），多重继承就是子类也可以当父类（传代），例如 A 类 -> B 类 -> C 类
    5.继承提高了类之间的耦合性（继承的缺点，耦合度高就会造成代码之间的联系越紧密，代码独立性越差）。
    6.继承是多态的前提
    7.所有类继承的最顶级对象是java.lang.Object，Object是祖先类，Object在 java.lang 包中，所以不需要 import

注意： A 类 -> B 类 -> C 类，B为C的直接父类，A为C的间接父类

@ super关键字：我们可以通过super关键字来实现对父类成员的访问，相当于父类的this。
@ 作用：
    1.super可以指向父类的this，现对父类成员的访问，用来访问父类的成员变量和方法
    2.可以充当父类的构造函数

@ super作为父类的构造函数使用注意事项：
    1.只能在子类构造函数中执行
    2.只能作为第一个语句执行
    3.一个构造函数只能执行一次super
    4.无参会默认执行父类的构造（隐式的super()），有参必须显示的调用super(...)

@ 访问注意事项：
    1.当访问实例对象的成员变量或方法时，则优先寻找本类当中是否存在，若有则用，无则向上（父类）寻找，不会向下（子类）寻找
    2.若需访问父类与子类的重名成员变量时，可通过方法获得访问

@ 重载与重写：
    重载（Overload）：方法的名称一样，参数列表【不一样】。
    重写（Override）（覆盖、覆写）：方法的名称一样，参数列表【也一样】；子类覆盖父类方法。
*/
public class Main {
    public static void main(String[] args) {
        TestSub car1 = new TestSub("小汽车", "1.5t");

        // 子类继承父类成员变量
        // 父类tip已经被隐藏，所以父类的set不影响
        System.out.println(car1.tip);
        System.out.println(car1.age);
        car1.setTip("hello tip");
        car1.setAge(26);
        System.out.println(car1.tip);
        System.out.println(car1.age);

        // private属性可以通过方法间接访问
        car1.setName("变形金刚");
        System.out.println(car1.getName());

        //
        car1.pop();

        // 子类对父类的方法的重写
        car1.says();

        // 子类对父类的方法的重载
        car1.run();
        car1.run("我是子类的run方法，对父类的run进行了重载！");

        // 静态方法的重载和重新声明
        TestSub.look(1);// 子类look
        TestSub.look();// 父类look
    }
}
