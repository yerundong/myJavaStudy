package 接口.函数式接口;

import org.junit.jupiter.api.Test;
import 接口.函数式接口.lib.FuncInterface;

public class Base {
    @Test
    public void test1() {
        // 普通写法
        FuncInterface fi1 = new FuncInterface() {
            @Override
            public void look() {
                System.out.println("look");
            }
        };

        // Lambda写法
        FuncInterface fi2 = () -> System.out.println("look");

        fi1.look();
        fi2.look();
    }
}
