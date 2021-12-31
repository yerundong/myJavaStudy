package 多态.基础;

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
