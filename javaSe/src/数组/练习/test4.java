package src.数组.练习;

import java.util.Arrays;
import java.util.Random;

public class test4 {
    /**
     * 程序主入口：创建并填充一个包含6个不重复随机数的数组
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建长度为6的整型数组
        int[] arr = new int[6];
        // 循环填充每个位置，确保每个位置都是不重复的随机数
        for (int i = 0; i < arr.length; i++) {
            genElement(arr, i);
        }
        // 输出最终的数组内容
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 生成不重复的随机数并赋值到数组的指定位置
     * <p>使用递归方式确保生成的随机数在数组中不重复</p>
     *
     * @param arr 目标数组
     * @param i   要填充的位置索引
     */
    static void genElement(int[] arr, int i) {
        Random rand = new Random();
        // 生成 0-29 之间的随机数
        int num = rand.nextInt(30);
        // 如果数组中不存在该随机数，则赋值到指定位置
        if (!alreadyExists(arr, num)) {
            arr[i] = num;
        } else {
            // 如果已存在，递归重新生成
            genElement(arr, i);
        }
    }

    /**
     * 判断数组中是否已存在指定的数字
     *
     * @param arr 要检查的数组
     * @param num 要查找的数字
     * @return 如果数组中存在该数字返回 true，否则返回 false
     */
    static boolean alreadyExists(int[] arr, int num) {
        // 遍历数组中的每个元素
        for (int i = 0; i < arr.length; i++) {
            // 如果找到相同的数字，立即返回 true
            if (arr[i] == num) {
                return true;
            }
        }
        // 遍历完整个数组都没找到，返回 false
        return false;
    }
}