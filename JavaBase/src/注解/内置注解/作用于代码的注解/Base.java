package 注解.内置注解.作用于代码的注解;

import lib.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Base extends Person {
    @Override
    public void walk() {
        super.walk();
    }

    @Deprecated(since = "8")
    public void deprecated() {
        System.out.println("我是deprecated");
    }

    @Test
    public void test_deprecated() {
        deprecated();
    }

    // 放这里可以作用整个方法
    // @SuppressWarnings({"unused", "rawtypes"})
    public void suppressWarnings() {

        // 只会作用第一个
        @SuppressWarnings("unused")
        int num1 = 10;
        int num2 = 10;

        @SuppressWarnings({"unused", "rawtypes"})
        ArrayList arrayList = new ArrayList();
    }

    @Test
    public void test_suppressWarnings() {
        suppressWarnings();
    }


    // @SafeVarargs
    @SafeVarargs
    public final void safeVarargs(int a, String[]... args) {
        System.out.println("我是SafeVarargs");
    }

    @Test
    public void test_safeVarargs() {
        safeVarargs(1, new String[]{"a"});
    }

    @Test
    public void test_functionalInterface() {
        TestFunctionalInterface testFunctionalInterface = () -> System.out.println("look");
        testFunctionalInterface.look();
    }
}
