package 常用类.System;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 @System类： 代表程序所在系统，提供了对应的一些系统属性信息和系统操作。 它不能被实例化。

 @注：
    1.System无法实例化，都是静态方法和变量，是一个系统相关的工具类
    2.静态变量有：in\out\err：
        in：标准输入流（键盘输入）
        out：标准输出流（显示器）
        err：标准错误输出流（显示器）

*/
public class Base {
    /**
     * @Description 获取系统当前毫秒值
     */
    @Test
    public void currentTimeMillis(){
        // <SM> public static native long currentTimeMillis()
        // <返> 返回绝对值获取系统当前毫秒值，可用来测试程序运行时间
        //      返回当前的计算机时间，时间的表达格式为当前计算机时间和GMT时间（格林威治时间）1970 年 1 月 1 号 0 时 0 分 0 秒所差的毫秒数。
        // <注> 与new Date().getTime()相当，但currentTimeMillis效率更高，new Date().getTime()也是利用currentTimeMillis()
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d x %d = %d \t", j, i, (j * i));
            }
            System.out.println();
        }
        long end = System.currentTimeMillis();
        System.out.printf("程序运行时间为[%d]毫秒！", (end - start));
    }

    /**
     * @Description 获取系统当前纳秒值
     */
    @Test
    public void nanoTime(){
        // <SM> public static native long nanoTime();
        // <返> 返回最准确的可用系统计时器的当前值，以纳秒为单位。
        System.out.println(System.nanoTime());// 872517608865700
    }

    /**
     * @Description 获取系统当前纳秒值
     */
    @Test
    public void exit(){
        // <SM> public static void exit(int status)
        // <注> 终止当前运行的Java虚拟机，结束正在运行的Java程序
        //     参数传入一个数字即可。通常传入0记为正常状态，其它为异常状态。
        for (int i = 0; ; i++) {
            if (i>10) System.exit(0);
            System.out.println(i);
        }
    }

    /**
     * @Description 垃圾回收方法
     */
    @Test
    public void gc(){
        // <SM> public static void gc()
        // <注> 运行垃圾回收器。
        System.gc();
    }

    /**
     * @Description 获取当前的系统属性
     */
    @Test
    public void getProperty_getProperties(){
        // <SM> public static String getProperty(String key)
        // <返> 获取当前的系统特定属性。
        // <注> 全部key值对应表请查阅api
        // <SM> public static String getProperty(String key, String def)
        // <返> 获取当前的系统特定属性，如果没有带有此键的属性，则返回默认值def。

        // <SM> public static Properties getProperties()
        // <返> 获取当前的系统所有属性。
        System.out.println(System.getProperty("user.name"));// YECL
        System.out.println(System.getProperty("java.version"));// 14.0.1
        System.out.println(System.getProperty("java.specification.vendor"));// Oracle Corporation
        System.out.println(System.getProperty("os.arch", "abc"));// Oracle Corporation
        System.out.println(System.getProperties());
    }
    /**
     * @Description 获取当前的系统属性
     */
    @Test
    public void arraycopy(){
        // <SM> public static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length)
        // <改> 用来实现将材料数组部分元素复制替换到目标数组的指定位置，修改目标数组，材料数组不变
        // <参>
        //     Object src：拿来复制的材料数组；
        //     Int srcPos：数组源的起始索引；
        //     Object dest：复制后的目标数组；
        //     int destPos：目标数组起始索引；
        //     int length，指定复制的长度；

        int[] src = {1, 22, 333, 4444, 5555, 666666, 7777777};
        int[] dest = {10, 20, 30};
        System.out.println("复制前：" + Arrays.toString(dest));
        System.arraycopy(src, 2, dest, 1, 2);
        System.out.println("复制后：" + Arrays.toString(dest));
        System.out.println("原数组不变：" + Arrays.toString(src));
    }
}
