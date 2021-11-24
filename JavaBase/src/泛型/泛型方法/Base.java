package 泛型.泛型方法;

import org.junit.jupiter.api.Test;
import 泛型.泛型类.GenericClass;

public class Base {
    @Test
    public void test() {
        // 通过实参确定
        GenericClass gc = look('a', 15);
        System.out.println(gc.getName());
        System.out.println(gc.getAge());

        // 通过变量接收类型确定
        String watch = watch(21);
        System.out.println(watch);

        see('J', 16);

        run(new GenericClass<String, Integer>("Tom", 99), 66);
    }

    public <T, E> GenericClass<T, E> look(T p1, E p2) {
        return new GenericClass<>(p1, p2);
    }

    public <T> T watch(int num) {
        T o = (T) String.valueOf(num);
        return o;
    }

    public static <T, E> void see(E name, T num) {
    }

    // 泛型方法与泛型类组合使用
    public <T> void run(GenericClass<String, T> g, T t) {
        System.out.println(t);
    }

    // 只有方法上定义了泛型才算泛型方法，以下不算泛型方法
    public void check(GenericClass<String, Integer> g) {
    }

}
