package 数组;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Base {
    @Test
    public void 动态初始化() {
        // <格式> Type[] arrayName = new Type[length];
        // <注> ①动态初始化必须写长度 ②态初始化会根据元素类型，给定默认值

        int[] arr1 = new int[3];
        // int[] arr1 = new int[];// 错误写法
        System.out.println(Arrays.toString(arr1));

        // <元素重新赋值>
        arr1[0] = 1;
        System.out.println(Arrays.toString(arr1));

        // <声明、初始化分步走>
        char[] arr2;
        // System.out.println(arr2);// 报错，未初始化
        arr2 = new char[7];
        System.out.println(arr2);
    }

    @Test
    public void 静态初始化() {
        // <格式> Type[] arrayName = new Type[]{element1, element2, element3...};
        // <注> 静态初始化时不能在[]中写长度
        int[] arr1 = new int[]{1, 2, 3};
        // int[] arr1 = new int[3]{1, 2, 3};// 错误写法
        System.out.println(Arrays.toString(arr1));

        // <声明、初始化分步走>
        char[] arr2;
        // System.out.println(arr2);// 报错，未初始化
        arr2 = new char[]{'a'};
        System.out.println(Arrays.toString(arr2));
    }

    @Test
    public void 静态初始化省略写法() {
        // <格式> Type[] arrayName = {element1, element2, element3...};
        // 省略写法实际是类型推断的一种表现。
        // <注>
        // ①方法形参不能使用省略写法初始化数组，如 method({1, 2, 3})，必须在先用变量接收再作为形参
        // ②省略写法时，声明、初始化不可分步写
        int[] arr1 = {1, 2, 3};

        // 错误写法，不可分步写，因为无法类型推断
        // int[] arr2;
        // arr2 = {1};

        // says({1, 2, 3});// 错误写法，不可分步写，因为无法类型推断
        int[] arr2 = {1, 2, 3};// 先用变量接收
        testMethod(arr1);
        testMethod(arr2);
    }

    @Test
    public void 声明初始化分步写() {
        // <注> ①方法形参不能使用省略写法初始化数组，如 method({1, 2, 3})，必须在先用变量接收再作为形参
        char[] arr1;
        // System.out.println(arr2);// 报错，未初始化前不能调用
        arr1 = new char[1];// 初始化
        System.out.println(Arrays.toString(arr1));
        arr1 = new char[]{'a'};// 赋值
        System.out.println(Arrays.toString(arr1));
        // arr1 = {'b'};// 报错，省略写法不可用于单纯的赋值
    }

    @Test
    public void 内存哈希值() {
        // <注> ①方法形参不能使用省略写法初始化数组，如 method({1, 2, 3})，必须在先用变量接收再作为形参
        int[] arr1 = {0, 1, 2};
        char[] arr2 = {'0', '1', '2'};
        String[] arr3 = {"0", "1", "2"};
        System.out.println(arr1);// 3
        System.out.println(arr2);// 3
        System.out.println(arr3);// 3
    }

    @Test
    public void length() {
        int[] arr1 = {0, 1, 2};
        System.out.println(arr1.length);// 3
        // arr1.length = 400;// 错误写法，长度不可改变
    }

    /**
     * @Description []的位置
     */
    @Test
    public void brackets() {
        // <注> []可以放在类型后面（java源代码写法，推荐），也可以放在变量后面（c语言写法）
        int[] arr1 = new int[1];
        int arr2[] = new int[1];
        // 多维数组
        float[][] arr3 = new float[1][2];
        float[] arr4[] = new float[1][2];
        float arr5[][] = new float[1][2];
    }

    /**
     * @Description 取值设值
     */
    @Test
    public void getAndSet() {
        int[] arr1 = new int[3];
        arr1[0] = 1;
        System.out.println(Arrays.toString(arr1));
        System.out.println(arr1[0]);
    }

    /**
     * @Description 多维数组
     */
    @Test
    public void multidimensionalArray() {
        // 动态初始化
        int[][] arr1 = new int[3][3];
        System.out.println(Arrays.deepToString(arr1));

        // 静态初始化
        int[][] arr2 = new int[][]{{1}, {1, 2}, {1, 2, 3}};
        System.out.println(Arrays.deepToString(arr2));

        // 静态初始化省略写法
        int[][][] arr3 = {{{1}, {1, 2}}, {{1}, {1, 2, 3}}, {{1}, {1, 2}}};
        System.out.println(Arrays.deepToString(arr3));

        arr1[0] = new int[]{1};
        System.out.println(Arrays.deepToString(arr1));
        System.out.println(arr1[0].length);
    }

    static void testMethod(int[] arr) {
    }
}

