package 接口.函数式接口.lib;

// 函数式接口注解，可省略
@FunctionalInterface
public interface FuncInterface {
    int COUNT = 1;

    void look();

    default void see() {
    }

    static void watch() {
    }
}
