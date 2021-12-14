package 常用类.Arrays;

import lib.Person;
import lib.Pet;
import lib.Species;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Arrays： Arrays是一个与数组相关的工具类，里面提供了大量静态方法，用来实现数组常见的操作。
 * @关键点： 拷贝（一层）、排序、查找、替换、判断相等、格式化成字符串
 */
public class Base {
    /**
     * @Description toString
     */
    @Test
    public void toString_deepToString() {
        // <SM> public static String toString(T[])
        // <返> 将参数数组变成字符串（按照默认格式：[元素1, 元素2, 元素3...]）
        // <注> 只能一层格式化，若是引用类型的元素打印哈希地址
        String[] arr1 = {"A", "B", "C"};
        String[] arr2[] = {{"A", "B", "C"}};
        System.out.println("toString：" + Arrays.toString(arr1));
        System.out.println("toString：" + Arrays.toString(arr2));

        // <SM> public static String deepToString(Object[])
        // <返> toString的加强版，返回指定数组“深层内容”的字符串表示形式。
        // <注> 参数为Object类型的数组，基本类型报错
        System.out.println("deepToString：" + Arrays.deepToString(arr1));
        System.out.println("deepToString：" + Arrays.deepToString(arr2));
    }

    /**
     * @Description toString
     */
    @Test
    public void sort() {
        // <SM> public static void sort(T[])
        // <改> 按照默认升序（从小到大）对数组的元素进行排序，修改原数组。
        // <SM> public static void sort(int[] a, int fromIndex, int toIndex)
        // <改> 对区间内（[)）的元素进行排序
        // <注>
        //     1. 如果是数值，sort默认按照升序从小到大
        //     2. 如果是字符/字符串，sort默认按照字母升序
        //     3. 如果是自定义的类型，那么这个自定义的类需要有Comparable或者Comparator接口的支持（示例详见"\比较器"）。
        int[] arr1 = {3, 2, 10, 7, 6};
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));// [2, 3, 6, 7, 10]

        String[] arr2 = {"abb", "a", "bac", "abc"};
        char[] arr2_ = {'b', 'a', 'd', 'c'};
        Arrays.sort(arr2);
        Arrays.sort(arr2_);
        System.out.println(Arrays.toString(arr2));// [a, abb, abc, bac]
        System.out.println(Arrays.toString(arr2_));// [a, b, c, d]

        int[] arr3 = {3, 2, 10, 7, 6};
        Arrays.sort(arr3, 1, 5);
        System.out.println(Arrays.toString(arr3));// [3, 2, 6, 7, 10]
    }

    /**
     * @Description 获取 hashCode
     */
    @Test
    public void hashCode_() {
        // <SM> public static int hashCode(T[])
        // <返> 返回哈希码
        // <注> 对于任何两个满足 Arrays.equals(arr1, arr2) 的数组 arr1 和 arr2，也可用说 Arrays.hashCode(arr1) == Arrays.hashCode(arr2)。
        int arr1[] = {3, 2, 1};
        int arr2[] = {3, 2, 1};
        int[][] arr3 = {{1, 2, 3}};
        int[][] arr4 = {{1, 2, 3}};
        System.out.println(arr1);
        System.out.println(Arrays.hashCode(arr1));
        System.out.println(Arrays.hashCode(arr2));
        // 内容相同的多维数组 hashCode 不同，需要使用 deepHashCode
        System.out.println(Arrays.hashCode(arr3));
        System.out.println(Arrays.hashCode(arr4));
    }

    /**
     * @Description hashCode的加强版
     */
    @Test
    public void deepHashCode() {
        // <SM> public static int deepHashCode(Object[])
        // <返> hashCode的加强版，将计算其基于深层内容的哈希码的数组
        int[][] arr3 = {{1, 2, 3}};
        int[][] arr4 = {{1, 2, 3}};
        // 内容相同的多维数组 hashCode 不同，deepHashCode相同
        System.out.println(Arrays.deepHashCode(arr3));
        System.out.println(Arrays.deepHashCode(arr4));
    }

    /**
     * @Description 判等
     */
    @Test
    public void equals() {
        // <SM> public static boolean equals(T[], T[])
        // <返> 判断数组元素是否相同，判断机制是：基本类型的元素用==，引用类型的元素用该对象的equals方法判断
        // <注> 由于Array继承Object的equals，所以多维数组用equals判断的是地址值，所以多维数组请用deepEquals
        int[] arr1 = {1, 2, 3};
        int[] arr2 = new int[]{1, 2, 3};
        String[] arr3 = {"a"};
        String[] arr4 = {"a"};
        String[] arr5 = {new String("a")};
        // 自定义类
        Person[] persons1 = {new Person("张三")};
        Person[] persons2 = {new Person("张三")};
        Pet[] mimi1 = {new Pet("咪咪", Species.CAT)};
        Pet[] mimi2 = {new Pet("咪咪", Species.CAT)};
        // 多维数组
        int[] arr6[] = {{1}, {1, 2, 3}};
        int[] arr7[] = {{1}, {1, 2, 3}};

        System.out.println(Arrays.equals(arr1, arr2));// true
        System.out.println(Arrays.equals(arr3, arr4));// true
        System.out.println(Arrays.equals(arr4, arr5));// true
        System.out.println(Arrays.equals(persons1, persons2));// true，Person有自定义equals方法
        System.out.println(Arrays.equals(mimi1, mimi2));// false，Pet没有自定义equals方法
        System.out.println(Arrays.equals(arr6, arr7));// false，数组没有自定义equals方法
    }

    /**
     * @Description equals 的加强版
     */
    @Test
    public void deepEquals() {
        // <SM> public static boolean deepEquals(Object[], Object[]))
        // <返> equals的加强版，用于判断多维数组。判断机制是：基本类型的元素用==，引用类型的元素用equals
        // <注> 参数不可为第一层为基本类型元素的数组（如{1,2,3}），必须Object[]数组
        int[] arr1[] = {{1}, {1, 2, 3}};
        int[] arr2[] = {{1}, {1, 2, 3}};
        String[][] arr3 = new String[][]{{"a"}};
        String[][] arr4 = new String[][]{{"a"}};
        String[][] arr5 = new String[][]{{new String("a")}};
        Person[][] arr6 = new Person[][]{{new Person()}};
        Person[][] arr7 = new Person[][]{{new Person()}};
        Pet[][] mimi1 = {{new Pet("咪咪", Species.CAT)}};
        Pet[][] mimi2 = {{new Pet("咪咪", Species.CAT)}};

        // System.out.println("name：" + Arrays.deepEquals(new int[]{1}, new int[]{1}));// 参数不对，不可传单维数组
        System.out.println(Arrays.deepEquals(arr1, arr2));// true
        System.out.println(Arrays.deepEquals(arr3, arr4));// true
        System.out.println(Arrays.deepEquals(arr4, arr5));// true
        System.out.println(Arrays.deepEquals(arr6, arr7));// true，Person有自定义equals方法
        System.out.println(Arrays.deepEquals(mimi1, mimi2));// false，Pet没有自定义equals方法
    }

    /**
     * @Description 复制
     */
    @Test
    public void copyOf_copyOfRange() {
        // <SM> public static T[] copyOf(T[], newLength))
        // <返> 复制并创建新的数组，从索引0开始复制指定长度 newLength ，长度超出的用默认值填充
        // <注> 只是一层内容复制；如果是多维数组，则复制的是内侧元素的引用地址

        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        System.out.println("copyOf：" + Arrays.toString(arr2));
        System.out.println("copyOf：" + Arrays.toString(Arrays.copyOf(arr1, 10)));

        int[] arr3[] = {{1}, {1, 2, 3}};
        int[] arr4[] = Arrays.copyOf(arr3, arr3.length);
        System.out.println("copyOf：" + Arrays.deepToString(arr4));// [[1], [1, 2, 3]]
        System.out.println("copyOf：" + (arr3[1] == arr4[1]));// true 同一个地址

        // <SM> public static T[] copyOfRange(T[], int fromIndex, int toIndex)
        // <返> 类似copyOf，返回复制后的新数组，从 fromIndex 到 toIndex 复制，长度超出的用默认值填充
        // <注> 只是一层内容复制；如果是多维数组，则复制的是内侧元素的引用地址

        int[] arr5[] = Arrays.copyOfRange(arr3, 0, arr3.length);
        System.out.println("copyOfRange：" + Arrays.toString(arr5));
    }

    /**
     * @Description 搜索
     */
    @Test
    public void binarySearch() {
        // <SM> public static int binarySearch(int[] a, Type key)
        // <SM> public static int binarySearch(int[] a, int fromIndex, int toIndex, Type key)
        // <返> 使用二分搜索法查找数组元素的出现的索引值（并非第一次出现索引）,fromIndex 和 toIndex 指定查找范围，key是查找关键元素
        // <注> ①必须在进行此调用之前对数组进行排序（通过 sort(short[]) 方法），如果没有对数组进行排序，则结果是不确定的。
        // ②如果数组包含多个带有指定值的元素，则无法保证找到的是哪一个。③fromIndex和toIndex左闭右开，范围必须小于等于数组自身长度，否则报错
        // ④找不到元素返回负数

        int[] arr1 = {1, 2, 3, 4};
        String[] arr2 = {"a", "bc", "a", "66", "a", "jj", "a"};

        System.out.println(Arrays.binarySearch(arr1, 2));// 1
        System.out.println(Arrays.binarySearch(arr1, 0, arr1.length, 2));// 1

        Arrays.sort(arr2);//
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.binarySearch(arr2, "jj"));// 6
        System.out.println(Arrays.binarySearch(arr2, "a"));// a重复，无法保证找到的是哪一个
        System.out.println(Arrays.binarySearch(arr2, 0, arr2.length - 1, "jj"));// -7 负数代表找不到
    }

    /**
     * @Description 替换
     */
    @Test
    public void fill() {
        // <SM> public static void fill(Type[] a, Type val)
        // <改> 替换所有数组元素
        // <SM> public static void fill(Type[] a, int fromIndex, int toIndex, Type val)
        // <改> 替换数组元素，从索引 fromIndex（包含）到 toIndex（不包含）之间，用 val 替换

        int[] arr1 = {1, 2, 3};
        Arrays.fill(arr1, 999);
        System.out.println(Arrays.toString(arr1));// [999, 999, 999]
        Arrays.fill(arr1, 0, 2, 33);
        System.out.println(Arrays.toString(arr1));// [33, 33, 999]
    }

    /**
     * @Description 数组转List
     */
    @Test
    public void asList() {
        // <SM> public static <T> List<T> asList(T... a)
        // <返> 返回值是一个固定长度的 List 集合，参数可以是多个参数，也可是数组
        // <注> 参数若是数组，只有是对象型数据的数组才能被解析成多个元素，若是基本数据类型的数组，就会一整个数组被当成一个元素

        List<String> ls1 = Arrays.asList("a", "b", "c");
        System.out.println(ls1);// [a, b, c]

        String[] arr1 = {"a", "b", "c"};
        Integer[] arr2 = {1, 2, 3};
        char[] arr3 = {'a', 'b', 'c'};

        List<String> ls2 = Arrays.asList(arr1);
        List<Integer> ls3 = Arrays.asList(arr2);
        List<char[]> chars = Arrays.asList(arr3);// 基本数据类型的数组，一整个数组被当成一个元素
        System.out.println(ls2);// [a, b, c]
        System.out.println(ls3);// [1, 2, 3]
        System.out.println(chars);

        /*
        注：由于Arrays.asList() 返回的是Arrays的内部类ArrayList， 而不是java.util.ArrayList。
        Arrays的内部类ArrayList和java.util.ArrayList都是继承AbstractList，remove、add、clear等方法在
        AbstractList中是默认throw UnsupportedOperationException而且不作任何操作。
        参考：https://www.jianshu.com/p/52cdcec633bd
        */
        // ls1.add(4);// 报错 UnsupportedOperationException
        // ls1.remove(1);// 报错 UnsupportedOperationException
        ls1.set(1, "java");
        ls1.get(1);
        ls1.indexOf(1);
    }
}
