package 方法;
/*
@ 方法重载（Overload）：
    方法重载是指在同一个类中定义多个同名的方法，要求每个方法具有不同的形参的类型\个数\顺序，
    保证每个重载的方法都必须有一个独一无二的参数列表。
@ 注：形参名不作为重载方法的条件

@ 作用：对不同的传参进行不同的处理

@ 重载与重写对比：
    重载（Overload）：方法的名称一样，形参列表【不一样】。
    重写（Override）（覆盖、覆写）：方法的名称一样，形参列表【也一样】；子类覆盖父类方法


@ 方法重载与下列因素相关：
    1. 参数个数不同
    2. 参数类型不同
    3. 参数的多类型顺序不同

@ 方法重载与下列因素无关：
    1. 与参数的名称无关
    2. 与方法的返回值类型无关
    3. 与方法的修饰符无关

@ 注意事项：
    1.重载可以对本类方法的重载，也可以是子类可以对父类的非private方法进行重载，但不能是本类对子类的重载
    2.子类对父类成员方法的重写和重载的前提是：子类继承了该方法；所以private方法无法被重载、重写
 */
public class 重载 {
    public static void main(String[] args) {
        sum(10, 20);
        sum(10, 20, 30);
        sum(10, 20, 30, 40);
        sum(3.14F, 20);
        sum(20, 3.14F);
    }
    public static void sum(int a, int b){
        System.out.println(a + b);
    }
    public static void sum(int a, int b, int c){
        System.out.println(a + b + c);
    }
    public static void sum(int a, int b, int c, int d){
        System.out.println(a + b + c + d);
    }
    public static int sum(float a, int b){
        System.out.println(a + b);
        return (int)(a + b);
    }
    public static int sum( int b, float a){
        System.out.println("bingo:" + a + b);
        return (int)(a + b);
    }

//    与方法的返回值无关
//    public static void sum(float a, int b){
//        System.out.println(a + b);
//    }

//    与参数的名称无关
//    public static void sum(float x, int y){
//        System.out.println(a + b);
//    }
}
