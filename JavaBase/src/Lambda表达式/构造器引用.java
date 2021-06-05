package Lambda表达式;

import Lambda表达式.Lib.TestClass;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

public class 构造器引用 {
    /**
     * @
     */
    @Test
    public void test1() {
        Supplier<TestClass> sl1 = () -> new TestClass();

        Supplier<TestClass> sl2 = TestClass::new;
    }
}
