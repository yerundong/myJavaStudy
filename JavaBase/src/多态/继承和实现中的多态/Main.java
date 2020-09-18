package 多态.继承和实现中的多态;
/*
@ 定义：
    多态（Polymorphism）是指同一操作，作用于不同的对象，可以有不同的解释，产生不同的执行结果。比如跑的行为，小猫、小狗和大象，跑起来是不一样的。再比如飞的行为，昆虫、鸟类和飞机，飞起来也是不一样的。
    Java中，多态就是同一个接口，使用不同的实例而执行不同操作。

@ 含义：
    父类引用指向子类。
    多态写法实际是向上转型，是小范围到大范围的转变。
    把子类单做父类使用，只能使用父类有的成员，不能使用子类特有的成员。
    例如：把猫当作动物来看待，可以使用动物有的属性，但不能使用猫特有的属性。

@ 多态存在的三个必要条件：
    1.继承或者实现【二选一】
    2.方法的重写【意义体现：不重写，无意义】
    3.父类引用指向子类对象【格式体现】

@ 多态的优点：
    1. 消除类型之间的耦合关系
    2. 可替换性
    3. 可扩充性
    4. 接口性
    5. 灵活性
    6. 简化性

@ 多态体现的格式：
    父类名称 对象名 = new 子类名称();
    或者：
    接口名称 对象名 = new 实现类名称();

@ 口诀：编译看左，运行看右

@@ 使用多态成员成员看两个方面：
    1.有没有：看类\接口是否有这个成员（继承来的也算）
    2.从哪找：从哪个类开始往上查找

@@ 使用多态成员变量：有没有、从哪找都看左边，没有则报错
@  注意：通过方法间接访问成员变量，跟成员方法的规则一致

@ 使用多态成员方法：有没有看左边，从哪找看右边，没有则报错

*/
public class Main {
    public static void main(String[] args) {
        Class1 obj1 = new Class1();
        Class2 obj2 = new Class1();
        Class3 obj3 = new Class1();
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
