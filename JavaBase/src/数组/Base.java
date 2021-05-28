package 数组;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/*
 * @数组： 数组是一种类，一种特殊的类。数组也是一种容器，可以同时存放多个数据值。数组本身不提供任何操作方法，其他全部继承自 Object，如果需要操作数组建议使用 Arrays 工具类。
 * @特殊性： 数组没有一个class文件（例如Array.class）来储存数组类的相关属性和方法，所以实创实例过程与常规类不同。具体原因参考以下链接：
 * 链接1：https://blog.csdn.net/iteye_3313/article/details/81800350?utm_medium=distribute.pc_relevant_bbs_down.none-task-blog-baidujs-2.nonecase&depth_1-utm_source=distribute.pc_relevant_bbs_down.none-task-blog-baidujs-2.nonecase
 * 链接2：https://bbs.csdn.net/topics/390943750
 * @特点： 1. 数组是一种引用数据类型
 * 2. 数组只能储存同一种类型数据
 * 3. 数组的长度在程序运行期间不可改变
 * 4. 未重写 equals、toString 方法
 * @两种常见的初始化方式： 1. 动态初始化（指定长度）：在创建数组的时候，直接指定数组当中的数据元素个数。
 * 2. 静态初始化（指定内容）：在创建数组的时候，不直接指定数据个数多少，而是直接将具体的数据内容进行指定。
 * @动态初始化数组的格式： 数据类型[] 数组名称 = new 数据类型[数组长度];
 * @静态初始化格式： 1.标准格式：
 * 数据类型[] 数组名称 = new 数据类型[] { 元素1, 元素2, ... };
 * 2.省略格式：
 * 数据类型[] 数组名称 = { 元素1, 元素2, ... };
 * @注意事项： 1. 静态初始化没有直接指定长度，但是仍然会自动推算得到长度。
 * 2. 初始化格式可以拆分成为两个步骤。
 * 3. 静态初始化一旦使用省略格式，就不能拆分成为两个步骤了。
 * @使用建议： 如果不确定数组当中的具体内容，用动态初始化；否则，已经确定了具体的内容，用静态初始化。
 * @数组的长度： 数组的成员个数，是int类型的整数
 * @访问格式： array.length
 * @注意事项： length是 final 类型，数组一旦创建，程序运行期间，length不可改变
 */
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

