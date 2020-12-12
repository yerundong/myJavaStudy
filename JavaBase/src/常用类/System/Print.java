package 常用类.System;

/**
 @print/printf/println： 打印
 */
public class Print {
    public static void main(String[] args) {
        // <M> public void println(Object x)
        // <M> public void println(char[] x)
        // <注> 打印引用类型，println方法只对String和char[]做了特殊处理，其他引用类型都打印toString返回内容，没toString打印地址值

        int[] intArr = new int[]{1,2,3};
        char[] charArr = new char[]{'a','b','c'};
        byte[] byteArr = new byte[]{1,2,3};
        short[] shortArr = new short[]{1,2,3};
        double[] doubleArr = new double[]{1,2,3};
        boolean[] booleanArr = new boolean[]{true, false};

        System.out.println(intArr);// 地址值
        // System.out.printf();// 地址值
        System.out.println(byteArr);// 地址值
        System.out.println(shortArr);// 地址值
        System.out.println(doubleArr);// 地址值
        System.out.println(booleanArr);// 地址值
        System.out.println(charArr);// abc(特别)

    }
}
