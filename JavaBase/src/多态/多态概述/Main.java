package 多态.多态概述;
/**
 @定义：
    多态是继封装、继承之后，面向对象的第三大特性。多态（Polymorphism）是指同一操作，作用于不同的对象，可以有不同的解释，产生不同的执行结果。
    现实事物经常会体现出多种形态，如学生，学生是人的一种，则一个具体的同学张三既是学生也是人，即出现两种形态。比如跑的行为，小猫、小狗和大象，跑起来是不一样的。
    Java中，多态就是同一个接口，使用不同的实例而执行不同操作。

 @含义：
    父类的引用指向子类对象，或子类对象赋给父类引用。
    多态本身就是向上转型过的过程，是小范围到大范围的转变。
    把子类单做父类使用，只能使用继承自父类的成员，不能使用子类特有的成员。
    例如：把猫当作动物来看待，可以使用动物有的属性，但不能使用猫特有的属性。

 @多态的使用： 虚拟方法的调用

 @多态的转型： 多态的转型分为向上转型和向下转型两种

 @多态存在的三个必要条件：
    1.继承或者实现【二选一】
    2.方法的重写【意义体现：不重写，无意义】
    3.父类引用指向子类对象【格式体现】

 @多态的优点：
    1. 消除类型之间的耦合关系
    2. 可替换性
    3. 可扩充性
    4. 接口性
    5. 灵活性
    6. 简化性

 @多态体现的格式：
    父类名称 对象名 = new 子类名称();
    或者：
    接口名称 对象名 = new 实现类名称();

 @口诀： 编译看左边，运行看右边

 @使用多态成员看两个方面：
    1.有没有：看类\接口是否有这个成员（继承来的也算）
    2.从哪找：从哪个类开始往上查找
    @解释： 先看有没有，没有则报错，有则再看从哪找

 @多态成员变量和多态成员方法调用规则不一样：
    1.使用多态成员方法：有没有看左边，从哪找看右边
    2.使用多态成员变量：有没有、从哪找都看左边（因为属性不存在多态性）
    @注： 通过get方法间接访问成员变量，跟成员方法的规则一致

 @虚拟方法 （虚方法\virtual method）：在多态的情况下，将父类的方法称为虚拟方法，父类根据赋给他不同的
    子类对象，动态地调用子类的该方法，这些方法在编译期是无法确定的，只有运行时才能确定。

 @注意事项：
    1.多态对象堆内存中仍然有子类特有的成员，但是因为类型是父类的，所以无法调用，需要向下转型才能调
    2.多态是动态绑定（运行时），重载是静态绑定（编译时）
    3.多态性体现在成员方法上，不体现在属性上
*/
public class Main {
    public static void main(String[] args) {
        Class1 obj1 = new Class1();
        Class2 obj2 = new Class1();

        Class1 obj3_ = new Class1();
        Class3 obj3 = obj3_;
        System.out.println(obj3 == obj3_);// 地址值相同，但通过obj3和obj3调用方法却有不同的规则_

        Interface1 obj4 = new Class1();

        System.out.println("================ part 1 =================");

        System.out.println(obj1.name);// 我是 Class1 的 name
        System.out.println(obj1.name1);// 我是 Class1 特有的
        System.out.println(obj1.name2);// 我是 Class2 特有的
        System.out.println(obj1.name3);// 我是 Class2 特有的

        System.out.println("================= part 2 =================");

        System.out.println(obj2.name);// 我是 Class2 的 name
        // System.out.println(obj2.name1);// 报错，obj2里没有name1
        System.out.println(obj2.name2);// 我是 Class2 特有的
        System.out.println(obj2.name3);// 我是 Class3 特有的
        // System.out.println(obj2.TIP);// 报错，obj2没有实现Interface1
        System.out.println(obj1.TIP);// Interface1 TIP
        System.out.println(obj4.TIP);// Interface1 TIP

        System.out.println("================ part 3 ==================");

        obj1.getName();// 我是 Class1 的 name
        obj2.getName();// 我是 Class1 的 name
        obj3.getName();// 我是 Class1 的 name

        obj1.says();// 我是 Class1 的 says()
        obj2.says();// 我是 Class1 的 says()
        // obj3.says();// 报错，obj3里没有says()
        obj4.says();// 我是 Class1 的 says()
        obj4.look();// 我是 Interface1 特有的 look()
    }
}
