package 数组.练习;

import java.lang.reflect.Array;
import java.util.Random;

/*
* 题目：随机生成一个int数组，元素是1-10之间的随机不重复的整数
* */
public class test1 {
    public static void main(String[] args) {
        int[] arr = createArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    static int[] createArray(){
        Random rd = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int num = rd.nextInt(10) + 1;
            boolean isHas = isHas(arr, num);
            if(!isHas){
                Array.set(arr, i, num);
            }else{
                i--;
                continue;
            }
        }
        return arr;
    }
    static boolean isHas(int[] arr, int num){
        boolean ish = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                break;
            }
            if(arr[i] == num){
                ish = true;
                break;
            }
        }
        return ish;
    }
}
