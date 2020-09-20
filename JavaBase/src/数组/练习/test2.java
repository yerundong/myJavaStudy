package 数组.练习;
/*
* 题目：数组反转
* */
public class test2 {
    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'd', 'f'};

        char[] arr1 = get1(arr);

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]);
        }

        System.out.println();
        get2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
    static char[] get1(char[] arr){
        char[] arr_ = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr_[i] = arr[arr.length-1-i];
        }
        return arr_;
    }

    static void get2(char[] arr){
        for (int i = 0; i < arr.length / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }
}
