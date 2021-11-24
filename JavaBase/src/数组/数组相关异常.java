package 数组;

import org.junit.jupiter.api.Test;

public class 数组相关异常 {
    /**
     * @Description 空指针异常
     */
    @Test
    public void NullPointerException() {
        int[] arr = null;
        System.out.println(arr);// null
        System.out.println(arr[0]);// NullPointerException
    }

    /**
     * @Description 数组索引越界异常
     */
    @Test
    public void ArrayIndexOutOfBoundsException() {
        int[] arr = {1, 2, 3};
        System.out.println(arr[10]);// ArrayIndexOutOfBoundsException
    }
}
