package 数组;

import java.util.Arrays;

/*
@ Arrays：Arrays是一个与数组相关的工具类，里面提供了大量静态方法，用来实现数组常见的操作。
 */
public class Arrays类 {
    public static void main(String[] args) {

        // <SM> public static String toString(T[])
        // <返> 将参数数组变成字符串（按照默认格式：[元素1, 元素2, 元素3...]）
        // <注> 引用类型的元素打印哈希地址
        String[] arr1 = {"A", "B", "C"};
        String[] arr1_[] = {{"A", "B", "C"}};
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr1_));

        // <SM> public static String deepToString(Object[])
        // <返> toString的加强版，返回指定数组“深层内容”的字符串表示形式。
        // <注> 参数为Object类型的数组，基本类型报错
        System.out.println(Arrays.deepToString(arr1));
        System.out.println(Arrays.deepToString(arr1_));

        // <SM> public static void sort(T[])
        // <改> 按照默认升序（从小到大）对数组的元素进行排序，修改原数组。
        // <注>
        // 1. 如果是数值，sort默认按照升序从小到大
        // 2. 如果是字符串，sort默认按照字母升序
        // 3. 如果是自定义的类型，那么这个自定义的类需要有Comparable或者Comparator接口的支持。（待了解）
        int[] arr2 = {3, 2, 10, 7, 6};
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));// [2, 3, 6, 7, 10]

        String[] arr3 = {"abb", "a", "bac", "abc"};
        Arrays.sort(arr3);
        System.out.println(Arrays.toString(arr3));// [a, abb, abc, bac]

        // <SM> public static int hashCode(T[])
        // <返> 返回哈希码
        // <注> 对于任何两个满足 Arrays.equals(arr1, arr2) 的数组 arr1 和 arr2，也可用说 Arrays.hashCode(arr1) == Arrays.hashCode(arr2)。
        System.out.println(arr3);
        System.out.println(Arrays.hashCode(arr2));
        System.out.println(Arrays.hashCode(new int[]{3, 2, 10, 7, 6}));

        // <SM> public static int deepHashCode(Object[])
        // <返> hashCode的加强版，将计算其基于深层内容的哈希码的数组
        // <略>


        // <SM> public static boolean equals(T[], T[])
        // <返> 判断数组内容是否相同
        // <注> 只是一层内容比较；如果是多维数组，则判断的是内侧元素的引用地址
        int[] arr4 = {1, 2, 3};
        int[] arr4_ = new int[]{1,2,3};
        System.out.println(Arrays.equals(arr4, arr4_));// true
        int[] arr5[] = {{1}, {1,2,3}};
        int[] arr5_[] = {{1}, {1,2,3}};
        System.out.println(Arrays.equals(arr5, arr5_));// false

        // <SM> public static boolean deepEquals(Object[], Object[]))
        // <返> equals的加强版，可判断多维数组的内容是否相同
        // <注> 参数不可为基本类型元素的数组，必须Object[]数组

        // System.out.println(Arrays.deepEquals(arr4, arr4_));// 参数不对
        System.out.println(Arrays.deepEquals(new String[]{"abb", "a", "bac", "abc"}, new String[]{"abb", "a", "bac", "abc"}));// true
        System.out.println(Arrays.deepEquals(new int[][][]{{{1}}}, new int[][][]{{{1}}}));// true
        System.out.println(Arrays.deepEquals(arr5, arr5_));// true


        // <SM> public static T[] copyOf(T[], newLength))
        // <返> 返回复制后的新数组，从0开始复制指定长度，长度超出的用默认值填充
        // <注> 只是一层内容复制；如果是多维数组，则复制的是内侧元素的引用地址

        int[] arr6 = {1, 2, 3, 4};
        int[] arr6_ = Arrays.copyOf(arr6, arr6.length);
        System.out.println(Arrays.toString(arr6_));
        System.out.println(Arrays.toString(Arrays.copyOf(arr6, 10)));

        int[] arr7[] = {{1}, {1,2,3}};
        int[] arr7_[] = Arrays.copyOf(arr7, arr7.length);
        System.out.println(Arrays.toString(arr7));
        System.out.println(Arrays.toString(arr7_));

        // <SM> public static T[] copyOfRange(T[], int fromIndex, int toIndex)
        // <返> 类似copyOf，返回复制后的新数组，从fromIndex到toIndex复制，长度超出的用默认值填充
        // <注> 只是一层内容复制；如果是多维数组，则复制的是内侧元素的引用地址

        int[] _arr7_[] = Arrays.copyOfRange(arr7, 0, arr7.length);
        System.out.println(Arrays.toString(_arr7_));

        // <SM> public static T binarySearch(T[],  int fromIndex, int toIndex, T key)
        // <返> 使用二分搜索法查找数组元素的出现的索引值（并非第一次出现索引）
        // <注> ①必须在进行此调用之前对数组进行排序（通过 sort(short[]) 方法）。如果没有对数组进行排序，则结果是不确定的。
        // ②如果数组包含多个带有指定值的元素，则无法保证找到的是哪一个。③fromIndex和toIndex左闭右开，范围必须小于等于数组自身长度，否则报错
        // ④找不到元素返回负数，

        String[] arr8 = {"a" , "bc", "a", "66", "a", "jj", "a"};
        Arrays.sort(arr8);
        System.out.println(Arrays.toString(arr8));
        System.out.println(Arrays.binarySearch(arr6, 0, arr6.length, 2));// 1
        System.out.println(Arrays.binarySearch(arr6, 0, arr6.length, 3));// 1
        System.out.println(Arrays.binarySearch(arr8, 0, arr8.length, "asd"));// -6

        // <SM> public static void fill(T[],  int fromIndex, int toIndex, T key)
        // <改> 替换数组元素
        int[] arr9 = {1,2,3};
        Arrays.fill(arr9, 0, 2, 33);
        System.out.println(Arrays.toString(arr9));// [33, 33, 3]
        // 替换所有：public static void fill(int[] a, int val)
        Arrays.fill(arr9,999);
        System.out.println(Arrays.toString(arr9));//
    }
}
