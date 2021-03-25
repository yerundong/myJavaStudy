package 数组;

import org.junit.jupiter.api.Test;

/**
@空指针异常：
    所有的引用类型变量，都可以赋值为一个null值。但是代表其中什么都没有。
    数组必须进行new初始化才能使用其中的元素。
    如果只是赋值了一个null，没有进行new创建，
    那么将会发生：空指针异常 NullPointerException

    原因：忘了new
    解决：补上new

@越界异常
    数组的索引编号从0开始，一直到“数组的长度-1”为止。
    如果访问数组元素的时候，索引编号并不存在，那么将会发生
    数组索引越界异常
    ArrayIndexOutOfBoundsException

    原因：索引编号写错了。
    解决：修改成为存在的正确索引编号。
 */
public class 数组相关异常 {
    /**
     * @Description 空指针异常
     */
    @Test
    public void NullPointerException(){
        int[] arr = null;
        System.out.println(arr);// null
        System.out.println(arr[0]);// NullPointerException
    }

    /**
     * @Description 数组索引越界异常
     */
    @Test
    public void ArrayIndexOutOfBoundsException(){
        int[] arr = {1, 2, 3};
        System.out.println(arr[10]);// ArrayIndexOutOfBoundsException
    }
}
