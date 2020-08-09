package 方法;
/*
对于功能类似的方法来说，因为参数列表不一样，却需要记住那么多不同的方法名称，太麻烦。

方法的重载（Overload）：多个方法的名称一样，但是参数列表不一样（只要参数有一点不同即可重载）。
好处：只需要记住唯一一个方法名称，就可以实现类似的多个功能。

重载与重写：
    重载（Overload）：方法的名称一样，参数列表【不一样】。
    重写（Override）（覆盖、覆写）：方法的名称一样，参数列表【也一样】；子类覆盖父类方法。


方法重载与下列因素相关：
1. 参数个数不同
2. 参数类型不同
3. 参数的多类型顺序不同

方法重载与下列因素无关：
1. 与参数的名称无关
2. 与方法的返回值类型无关
3. 与方法的修饰符无关
 */
public class 方法的重载 {
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
