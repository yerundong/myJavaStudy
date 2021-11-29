package 异常;

import org.junit.jupiter.api.Test;
import 异常.自定义异常类.NumberSmallerThanZeroException;

public class 手动抛出异常 {
    @Test
    public void test() {
        try {
            see(-10);
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println(e);
        }
    }

    public void see(int num) {
        if (num < 0) {
            throw new NumberSmallerThanZeroException("num不能小于0");
        }
    }

}
