package 异常处理;

public class TryCatch {
    public static void main(String[] args) {
        int[] arr1 = new int[1];
        try {
            System.out.println(arr1[1]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("出现数组索引越界异常");
        }
    }
}
