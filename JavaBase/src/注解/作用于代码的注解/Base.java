package 注解.作用于代码的注解;

import 示例.Person;

import java.util.ArrayList;

public class Base extends Person {
    // @Override：重写，可写可不写，建议写，可校验是否重写
    @Override
    public void walk() {
        super.walk();
    }

    // @Deprecated：过时、已弃用，意味将来很可能被删除，使用时会被划线，但仍可正常使用
    @Deprecated
    public void deprecated() {
        System.out.println("我是deprecated");
    }

    // @SuppressWarnings：抑制编译器警告
    // 放这里可以作用整个方法
    // @SuppressWarnings({"unused", "rawtypes"})
    public void suppressWarnings() {

        @SuppressWarnings("unused")
        // 只会作用第一个
                int num1 = 10;
        int num2 = 10;

        @SuppressWarnings({"unused", "rawtypes"})
        ArrayList arrayList = new ArrayList();
    }

    // @SafeVarargs
    // 在JDK 7中引入，主要目的是处理可变长参数中的泛型，此注解告诉编译器：在可变长参数中的泛型是类型安全的。可变长参数是使用数组存储的，
    // 而数组和泛型不能很好的混合使用
    @SafeVarargs
    public final void safeVarargs(int a, String[]... args) {
        System.out.println("我是SafeVarargs");
    }

    // @FunctionalInterface
    // Java 8 开始支持，标识一个匿名函数或函数式接口。


    // @Repeatable
    // Java 8 开始支持，标识某注解可以在同一个声明上使用多次。
}
