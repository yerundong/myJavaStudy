package 常用类.Math类;
/**
java.util.Math类是数学相关的工具类，里面提供了大量的静态方法，完成与数学运算相关的操作。
 */
public class Base {
    public static void main(String[] args) {
        // <SM> public static double abs(double num)
        // <PS> 获取绝对值；有多种重载
        // <返回>返回绝对值
        System.out.println("输出1.1：" + Math.abs(-3.1415));
        System.out.println("输出1.2：" + Math.abs(-4.68F));
        System.out.println("输出1.3：" + Math.abs(0));

        // <SM> public static double ceil(double num)
        // <PS> 向上取整
        // <返回> 返回向下取整值
        System.out.println("输出2.1：" + Math.ceil(3.1466));

        // <SM> public static double floor(double num)
        // <PS> 向下取整
        // <返回>  返回向下取整值
        System.out.println("输出3.1：" + Math.ceil(3.1466));

        // <SM> public static long round(double num)
        // <PS> 四舍五入
        // <返回>  返回四舍五入值
        System.out.println("输出4.1：" + Math.round(3.444));
        System.out.println("输出4.2：" + Math.round(3.544));

        // <SA> public static final double PI
        // <PS> 圆周率常量
        System.out.println("输出PI：" + Math.PI);

    }
}
