package 异常.异常处理;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class 使用try_catch_finally {
    @Test
    public void test1() {
        int[] arr = new int[1];
        String str = "abc";

        try {
            // 运行时异常
            // System.out.println(arr[1]);// Exception--ArrayIndexOutOfBoundsException
            // System.out.println(str.charAt(3));// Exception
            // int[] ints = new int[1024 * 1024 * 1024];// Error--OutOfMemoryError

            // 编译时异常
            File file = new File("text.txt");
            FileInputStream fis = new FileInputStream(file);// FileNotFoundException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("出现异常--数组索引越界");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("出现异常--FileNotFoundException");
            e.printStackTrace();
        } catch (OutOfMemoryError e) {
            System.out.println("出现错误--OutOfMemoryError");
            e.printStackTrace();

            System.out.println(str.charAt(3));// 这里报错没有被捕捉到
        } catch (Exception e) {
            System.out.println("e：" + e);
            System.out.println("toString()：" + e.toString());
            System.out.println("getMessage()：" + e.getMessage());
            System.out.println("getStackTrace()：" + e.getStackTrace());
            System.out.println("getLocalizedMessage()：" + e.getLocalizedMessage());
            System.out.println("出现异常--Exception");
            e.printStackTrace();
        } catch (Error e) {
            System.out.println("出现错误--Error");
            e.printStackTrace();
        } finally {
            System.out.println("--finally--");
        }

    }


    /**
     * @ 测试return
     */
    @Test
    public void test2() {
        System.out.println(test2_());
    }

    @Test
    public int test2_() {
        int[] arr1 = {1, 2, 3};

        try {
            System.out.println("*** try ***");
            int i = arr1[10];
            return 1;
        } catch (Exception e) {
            // int i = arr1[10];
            System.out.println("*** catch ***");
            return 2;
        } finally {
            System.out.println("*** finally ***");
            return 3;
        }
    }
}
