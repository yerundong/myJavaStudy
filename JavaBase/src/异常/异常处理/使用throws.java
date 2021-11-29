package 异常.异常处理;

import org.junit.jupiter.api.Test;

public class 使用throws {
    @Test
    public void test() {
        try {
            look();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void look() throws ArrayIndexOutOfBoundsException, StringIndexOutOfBoundsException {
        says();
    }

    public static void says() throws ArrayIndexOutOfBoundsException, StringIndexOutOfBoundsException {
        int[] arr1 = new int[1];
        String str1 = "abc";
        System.out.println(arr1[1]);
        System.out.println("says end");
    }
}
