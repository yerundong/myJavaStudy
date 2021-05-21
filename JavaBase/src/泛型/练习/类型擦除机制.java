package 泛型.练习;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class 类型擦除机制 {

    /**
     * @Description 类型擦除机制
     */
    @Test
    public void test() {
        ArrayList<String> stringList = new ArrayList<>();

        // 编译报错，原因在于类型擦除。记住：Java的泛型机制是在编译级别实现的。编译器生成的字节码在运行期间并不包含泛型的类型信息。
        // 在编译之后，List<Object>和List<String>都被擦除变成List，Object和String类型信息对于JVM来说是不可见的。在编译阶段，编译器发现它们不一致，因此给出了一个编译错误。
        // look(stringList);

        // 使用通配符可以解决这个问题
        // ArrayList<String> pick = pick(stringList);// 报错，
        ArrayList<?> pick = pick(stringList);

        seal(stringList);
    }

    public void look(ArrayList<Object> l) {
    }

    public ArrayList<?> pick(ArrayList<?> l) {
        return l;
    }

    public void seal(ArrayList<? extends Object> l) {
    }
}
