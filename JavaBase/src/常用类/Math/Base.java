package 常用类.Math;

import org.junit.jupiter.api.Test;

public class Base {
    /**
     * @绝对值
     */
    @Test
    public void abs() {
        // <SM> public static double abs(num)
        // <注> 获取绝对值；有多种重载
        // <返>返回绝对值 absolute value
        System.out.println(Math.abs(-3.1415));
        System.out.println(Math.abs(-4.68F));
        System.out.println(Math.abs(0));
    }

    /**
     * @向上取整
     */
    @Test
    public void ceil() {
        // <SM> public static double ceil(double num)
        // <返> 返回向上取整值 天花板
        System.out.println(Math.ceil(3.1466));
    }

    /**
     * @向下取整
     */
    @Test
    public void floor() {
        // <SM> public static double floor(double num)
        // <返>  返回向下取整值 地板
        System.out.println(Math.floor(3.1466));
    }

    /**
     * @四舍五入
     */
    @Test
    public void round() {
        // <SM> public static long round(double num)
        // <返> 返回四舍五入值，保留整数
        // <注> 更多舍入模式请用BigDecimal
        System.out.println(Math.round(3.444));
        System.out.println(Math.round(3.544));
        System.out.println(Math.round(-1.5));// -1
        System.out.println(Math.round(-1.45));// -1
    }

    /**
     * @π
     */
    @Test
    public void PI() {
        // <SA> public static final double PI
        // <注> 圆周率常量
        System.out.println(Math.PI);// 3.141592653589793
    }

    /**
     * @取大取小
     */
    @Test
    public void max_min() {
        // <SM> public static int max(int/long/float/double a, int/long/float/double b)
        // <返> 取大 取小
        Integer a = 10, b = 20;
        System.out.println(Math.max(10, 12));// 12
        System.out.println(Math.min(10, 12));// 10

        // Integer等包装类中也内置此方法
        System.out.println(Integer.max(10, 12));// 12
        System.out.println(Integer.min(10, 12));// 10
    }

    /**
     * @随机数
     */
    @Test
    public void random() {
        // <SM> public static double random()
        // <返> 返回的数值是[0.0,1.0）的double型数值
        for (int i = 0; i < 3; i++) {
            System.out.println(Math.random());
        }

        System.out.println("----------------------");

        // 取[1,10]随机数
        for (int i = 0; i < 10; i++) {
            System.out.println((int) (Math.random() * 10 + 1));
        }

    }
}
