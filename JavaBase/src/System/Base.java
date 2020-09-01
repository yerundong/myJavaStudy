package System;

import java.util.Arrays;
import java.util.Date;

/*
@ System类：代表程序所在系统，提供了对应的一些系统属性信息和系统操作。 它不能被实例化。
*/
public class Base {
    public static void main(String[] args) {
        // @ currentTimeMillis() 获取系统当前毫秒值，可用来测试程序运行时间
        // 注：与new Date().getTime()相当，但currentTimeMillis效率更高，new Date().getTime()也是利用currentTimeMillis()
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                // System.out.printf("%d x %d = %d \t", j, i, (j * i));
            }
            System.out.println();
        }
        long end = System.currentTimeMillis();
        // System.out.printf("程序运行时间为[%d]毫秒！", (end - start));

        // @ public staitc void exit(int status)：终止当前运行的Java虚拟机，结束正在运行的Java程序
        // 参数传入一个数字即可。通常传入0记为正常状态，其它为异常状态。
        for (int i = 0; i < 100; i++) {
            // if (i>50) System.exit(1);
            // System.out.println(i);
        }

        // @ public static void gc() 运行垃圾回收器。
        // System.gc();

        // @ public static Properties getProperties()
        // System.out.println(System.getProperties());

        // @ public static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length)
        // 用来实现将源数组部分元素复制替换到目标数组的指定位置
        // Object src：要复制的原数组；
        // Int srcPos：数组源的起始索引；
        // Object dest：复制后的目标数组；
        // int destPos：目标数组起始索引；
        // int length，指定复制的长度；

        int[] src = {1, 22, 333, 4444, 5555, 666666, 7777777};
        int[] dest = {10, 20, 30};
        System.out.println("复制前：" + Arrays.toString(dest));
        System.arraycopy(src, 2, dest, 1, 2);
        System.out.println("复制后：" + Arrays.toString(dest));
        System.out.println("原数组不变：" + Arrays.toString(src));
    }
}
