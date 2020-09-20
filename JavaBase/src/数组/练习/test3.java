package 数组.练习;
/*
 * 题目：找到元素位置
 * */
public class test3 {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "d", "f"};
        String str = "d";
        for (int i = 0; i < arr.length; i++) {
             int index = -1;
             if (str.equals(arr[i])){
                 System.out.println(i);
                 break;
             }
        }
    }
}
