package 数组;

/*
一、空指针异常
所有的引用类型变量，都可以赋值为一个null值。但是代表其中什么都没有。
数组必须进行new初始化才能使用其中的元素。
如果只是赋值了一个null，没有进行new创建，
那么将会发生：空指针异常 NullPointerException

原因：忘了new
解决：补上new

二、越界异常
数组的索引编号从0开始，一直到“数组的长度-1”为止。
如果访问数组元素的时候，索引编号并不存在，那么将会发生
数组索引越界异常
ArrayIndexOutOfBoundsException

原因：索引编号写错了。
解决：修改成为存在的正确索引编号。
 */
public class 数组异常 {
    public static void main(String[] args) {
        // 空指针异常
        int[] arr1 = null;
        System.out.println(arr1);// null
//        System.out.println(arr1[0]);// NullPointerException:空指针异常
        arr1 = new int[3];
        System.out.println(arr1);// [I@10f87f48
        System.out.println(arr1[0]);// 0

        // 越界异常
        int[] arr2 = new int[5];
        System.out.println(arr2[5]);//ArrayIndexOutOfBoundsException: 越界异常
    }
}
