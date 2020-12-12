package 常用类.Math;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 @Math: java.util.Math类是数学相关的工具类，里面提供了大量的静态方法，完成与数学运算相关的操作。
 
 @注： Math类操作的是数字类型数据，包括int\long\float\double
 
 */
public class Base {
    /**
     * @绝对值
     */
    @Test 
    public void abs(){
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
    public void ceil(){
        // <SM> public static double ceil(double num)
        // <返> 返回向上取整值 天花板
        System.out.println(Math.ceil(3.1466));
    }

    /**
     * @向下取整
     */
    @Test
    public void floor(){
        // <SM> public static double floor(double num)
        // <返>  返回向下取整值 地板
        System.out.println(Math.floor(3.1466));
    }

    /**
     * @四舍五入
     */
    @Test
    public void round(){
        // <SM> public static long round(double num)
        // <返>  返回四舍五入值
        System.out.println(Math.round(3.444));
        System.out.println(Math.round(3.544));
    }

    /**
     * @π
     */
    @Test
    public void PI(){
        // <SA> public static final double PI
        // <注> 圆周率常量
        System.out.println(Math.PI);// 3.141592653589793
    }

    /**
     * @取大取小
     */
    @Test
    public void max_min(){
        // <SM> public static int max(int/long/float/double a, int/long/float/double b)
        // <返> 取大 取小
        Integer a = 10, b = 20;
        System.out.println(Math.max(10, 12));// 12
        System.out.println(Math.min(10, 12));// 10

        // Integer等包装类中也内置此方法
        System.out.println(Integer.max(10, 12));// 12
        System.out.println(Integer.min(10, 12));// 10
    }
}
