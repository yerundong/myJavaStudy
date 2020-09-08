package 数组;

import java.lang.reflect.Array;

/*

*/
public class 常用方法 {
    public static void main(String[] args) {
        int[] arr1 = {0,1,2,3,4,5,6};
        // @ public static Object get(Object array, int index)
        System.out.println(Array.get(arr1, 1));

        System.out.println(arr1.length);
        System.out.println(arr1[1]);
    }
}
