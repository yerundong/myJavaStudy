package 数组;
/*
@ 数组的长度：数组的成员个数，是int类型的整数

@ 访问格式：array.length

@ 注意事项：length是final类型，数组一旦创建，程序运行期间，length不可改变
 */
public class 数组长度 {
    public static void main(String[] args) {
        byte[] arr1 = new byte[]{1,2,3};
        System.out.println(arr1.length);// 3

        // arr1.length = 4;// 错误写法，长度不可改变

        arr1 =  new byte[]{1,2,3,4,5,6};
        System.out.println(arr1.length);// 3
    }
}
