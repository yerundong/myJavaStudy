package 接口.函数式接口;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class 内置函数式接口 {
    /**
     * @内置函数式接口：Consumer
     */
    @Test
    public void testConsumer() {
        Consumer<Integer> obj = t -> System.out.println(t);
        obj.accept(567);
    }

    /**
     * @内置函数式接口：Supplier
     */
    @Test
    public void testSupplier() {
        Supplier<Integer> obj = () -> 567;
        Integer res = obj.get();
        System.out.println(res);
    }

    /**
     * @内置函数式接口：Function
     */
    @Test
    public void testFunction() {
        Function<Integer, String> obj = t -> t + 123 + "";
        String apply = obj.apply(567);
        System.out.println(apply);
    }

    /**
     * @内置函数式接口：Predicate
     */
    @Test
    public void testPredicate() {
        Predicate<Integer> obj = t -> t > 0;
        boolean test = obj.test(-567);
        System.out.println(test);
    }
}
