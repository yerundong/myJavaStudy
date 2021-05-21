package 反射.练习.类的初始化;

public class Base {
    public static void main(String[] args) throws Exception {
        // 1.初始化Father类、Son类
        // new Son();

        // 2.初始化Father类、Son类
        // System.out.println(Son.a);
        // Son.steady();

        // 3.只初始化Father类
        // System.out.println(Father.a);

        // 4.不初始化Father类、Son类
        // System.out.println(Son.A);

        // 5.初始化Father类、Son类
        // Class.forName("类和对象.练习.类的初始化.Son");

        // 6.不初始化Father类、Son类
        // Son[] sons = new Son[1];
    }

    static {
        System.out.println("已初始化main所在的类");
    }
}
