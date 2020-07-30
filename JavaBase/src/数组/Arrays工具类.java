package 数组;

import java.util.Arrays;

/*
java.util.Arrays是一个与数组相关的工具类，里面提供了大量静态方法，用来实现数组常见的操作。

public static void sort(数组)：按照默认升序（从小到大）对数组的元素进行排序。

备注：
1. 如果是数值，sort默认按照升序从小到大
2. 如果是字符串，sort默认按照字母升序
3. 如果是自定义的类型，那么这个自定义的类需要有Comparable或者Comparator接口的支持。（今后学习）
 */
public class Arrays工具类 {
    public static void main(String[] args) {
        String[] arr1 = {"A", "B", "C"};
        // <SM> public static String toString(array)
        // <返回> 将参数数组变成字符串（按照默认格式：[元素1, 元素2, 元素3...]）
        String arr1_str = Arrays.toString(arr1);
        System.out.println(arr1_str);

        // <SM> public static void sort(array)
        // <改> 按照默认升序（从小到大）对数组的元素进行排序，修改原数组。
        // <PS>
        // 1. 如果是数值，sort默认按照升序从小到大
        // 2. 如果是字符串，sort默认按照字母升序
        // 3. 如果是自定义的类型，那么这个自定义的类需要有Comparable或者Comparator接口的支持。（待了解）
        int[] arr2 = {3, 2, 10, 7, 6};
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));// [2, 3, 6, 7, 10]

        String[] arr3 = {"abb", "a", "bac", "abc"};
        Arrays.sort(arr3);
        System.out.println(Arrays.toString(arr3));// [a, abb, abc, bac]
    }
}
