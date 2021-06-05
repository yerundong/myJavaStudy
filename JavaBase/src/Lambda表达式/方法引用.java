package Lambda表达式;

import Lambda表达式.Lib.Interface1;
import Lambda表达式.Lib.TestClass;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/*
@方法引用：当使用Lambda表达式时，lambda体已存在方法，可以直接拿来使用，可简写成更简洁的Lambda表达式-方法引用格式。其本质还是Lambda表达式。
@格式： 类（或对象）::方法名
@要求：引用的方法必须和接口中的抽象方法具有相同的形参、返参

@构造器引用：当使用Lambda表达式时，lambda体是一个调用构造器、实例化的表达式，而后返回一个实例，可简写成构造器引用的格式
@格式： 类::new
@要求：引用的构造器方法必须和接口中的抽象方法具有相同的形参，而抽象方法返回这个类的实例

@有四种情况：
    1.对象::非静态方法
    2.类::静态方法
    3.类::非静态方法（最特殊）
    4.类::new（构造器引用）
 */

public class 方法引用 {
    /**
     * @情况1：无参无返
     */
    @Test
    public void test1() {
        TestClass tc = new TestClass("Tom", 13);
        Interface1 inst1 = () -> tc.look();
        // 等同写法
        Interface1 inst2 = tc::look;

        inst1.say();
        inst2.say();
    }

    /**
     * @情况1：单参无返
     */
    @Test
    public void test2() {
        TestClass tc = new TestClass("Tom", 13);
        Consumer<String> inst1 = str -> tc.see(str);

        // 等同写法
        Consumer<String> inst2 = tc::see;

        inst1.accept("say1");
        inst2.accept("say2");
    }

    /**
     * @情况1：无参有返
     */
    @Test
    public void test3() {
        TestClass tc = new TestClass("Tom", 13);
        Supplier<String> inst1 = () -> tc.check();
        // 等同写法
        Supplier<String> inst2 = tc::check;

        System.out.println(inst1.get());
        System.out.println(inst2.get());
    }

    /**
     * @情况1：单参有返
     */
    @Test
    public void test4() {
        TestClass tc = new TestClass("Tom", 13);
        Function<String, String> inst1 = str -> tc.watch(str);
        // 等同写法
        Function<String, String> inst2 = tc::watch;

        System.out.println(inst1.apply("say1"));
        System.out.println(inst2.apply("say2"));
    }

    /**
     * @情况1：多参有返
     */
    @Test
    public void test5() {
        TestClass tc = new TestClass("Tom", 13);
        BiFunction<String, Integer, String> inst1 = (s, i) -> tc.view(s, i);
        // 等同写法
        BiFunction<String, Integer, String> inst2 = tc::view;

        System.out.println(inst1.apply("say", 1));
        System.out.println(inst1.apply("say", 2));
    }

    /**
     * @情况2：静态的方法引用
     */
    @Test
    public void test6() {
        BiFunction<Integer, Integer, Integer> fun1 = (i1, i2) -> Integer.compare(i1, i2);
        // 等同写法
        BiFunction<Integer, Integer, Integer> fun2 = Integer::compare;

        System.out.println(fun1.apply(1, 2));
        System.out.println(fun2.apply(2, 1));
    }

    /**
     * @情况3：类调用实例方法（费解） 第一个参数s1, 是方法调用的主体，第二个参数s2是方法调用的入参，或者只有一个参数o，方法无参
     */
    @Test
    public void test7() {
        Comparator<String> cp1 = (s1, s2) -> s1.compareTo(s2);
        // 等同写法
        Comparator<String> cp2 = String::compareTo;

        BiFunction<String, String, Boolean> fun1 = (s1, s2) -> s1.equals(s2);
        // 等同写法
        BiFunction<String, String, Boolean> fun2 = String::equals;

        TestClass tc = new TestClass("Tom", 13);
        Function<TestClass, String> fn1 = o -> o.getName();
        // 等同写法
        Function<TestClass, String> fn2 = TestClass::getName;

        System.out.println(cp1.compare("a", "b"));
        System.out.println(cp2.compare("b", "a"));

        System.out.println(fun1.apply("a", "a"));
        System.out.println(fun2.apply("b", "a"));

        System.out.println(fn1.apply(tc));
        System.out.println(fn2.apply(tc));
    }

    /**
     * @情况4：构造器引用
     */
    @Test
    public void test8() {
        // 无参数
        Supplier<TestClass> sl1 = () -> new TestClass();
        // 等同写法
        Supplier<TestClass> sl2 = TestClass::new;

        // 有参数
        BiFunction<String, Integer, TestClass> bf1 = (s, i) -> new TestClass(s, i);
        // 等同写法
        BiFunction<String, Integer, TestClass> bf2 = TestClass::new;

        // 数组类型的构造器引用，属于特殊的构造器引用
        Function<Integer, String[]> fc1 = i -> new String[i];
        // 等同写法
        Function<Integer, String[]> fc2 = String[]::new;
    }
}
