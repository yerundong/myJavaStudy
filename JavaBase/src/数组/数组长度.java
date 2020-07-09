package 数组;
/*
如何获取数组的长度，格式：
数组名称.length

这将会得到一个int数字，代表数组的长度。

数组一旦创建，程序运行期间，长度不可改变。
 */
public class 数组长度 {
    public static void main(String[] args) {
        byte[] arr1 = new byte[]{1,2,3};
        System.out.println(arr1.length);// 3

//        arr1.length = 4;// 错误写法

        arr1 =  new byte[]{1,2,3,4,5,6};
        System.out.println(arr1.length);// 3
    }
}
