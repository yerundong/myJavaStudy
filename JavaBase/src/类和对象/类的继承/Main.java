package 类和对象.类的继承;

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

        // private属性可以通过方法间接访问，但不能直接访问
        car1.setName("变形金刚");
        // System.out.println(car1.name);
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

        // 匿名子类
        new TestSuper() {
            // 子类结构
        };
    }
}
