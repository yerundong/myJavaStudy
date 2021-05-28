package 接口.函数式接口;

import org.junit.jupiter.api.Test;
import 接口.函数式接口.lib.FuncInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Base {
    /**
     * @自定义函数式接口
     */
    @Test
    public void testCustom() {
        FuncInterface fi = () -> System.out.println(FuncInterface.COUNT);

        fi.look();
    }

    /**
     * @内置函数式接口：Consumer
     */
    @Test
    public void testConsumer() {
        // <M> void accept(T t);
        // <注> 拿到一个参数，执行一系列操作
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
        Function<Integer, String> obj = t -> t + "";
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

    /**
     * @
     */
    @Test
    public void test() {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(integers);
    }

}
