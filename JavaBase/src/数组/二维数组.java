package 数组;

public class 二维数组 {
    public static void main(String[] args) {
        // @ 一、动态初始化
        int[][] arr1 = new int[1][1];
        arr1[0][0] = 1;
        // arr1[0][1] = 2;// 报错
        arr1[0] = new int[2];// 元素数组地址重新new了
        arr1[0][1] = 2;

        // 遍历多维数组
        for (int i = 0; i < arr1.length ; i++) {
            int[] item1 = arr1[i];
            for (int j = 0; j < item1.length; j++) {
                int item2 = item1[j];
                System.out.println(item2);
            }
        }

        // @ 二、静态初始化
        int[][] arr2 = new int[][]{ { 1,2 }, { 1 } };

        // @ 三、静态初始化省略写法
        int[][] arr3 = { { 1,2 }, { 1 } };

        // @ 长度
        // System.out.println(arr3[0].length);
    }
}
