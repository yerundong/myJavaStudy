package 泛型.类型擦除机制;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Base<T> {
    /**
     * @new泛型参数
     */
    @Test
    public void test1() {
        // T t = new T();// 错误写法
        // T[] ts = new T[10];// 错误写法
        T t = (T) new Object();// 允许
    }

    /**
     * @instanceof
     */
    @Test
    public void test2() {
        int a = 1;

        // 错误写法
        // if (a instanceof T) {
        // }

        // 错误写法
        // if (a instanceof List<String>) {
        // }
    }


    /**
     * @泛型数组
     */
    @Test
    public void test3() {
        // ArrayList<String>[] list = new ArrayList<String>[2];// 错误写法
        // ArrayList<T>[] list = new ArrayList<T>[2];// 错误写法
        // ArrayList<?>[] list = new ArrayList<? extends T>[2];// 错误写法
        ArrayList<?>[] list = new ArrayList<?>[2];
    }

    /**
     * @不变性（invariant）-不同泛型参数的类（接口）赋值
     */
    @Test
    public void test4() {
        List<Object> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        // list1 = list2;// 编译报错


        // 通配泛型可以接收
        List<?> list3 = new ArrayList<>();
        // list1 = list3;// 编译报错
        list3 = list1;
        list3 = list2;
    }

    /**
     * @不变性（invariant）-不同泛型参数的类（接口）传参
     */
    @Test
    public void test5() {
        ArrayList<String> ls = new ArrayList<>();

        // 在编译之后，List<Object>和List<String>都被擦除变成List，Object和String类型信息对于JVM来说是不可见的。JVM
        // 在编译阶段，编译器发现它们不一致，因此给出了一个编译错误。

        see(ls);// 允许

        // look(ls);// 不允许

        // ArrayList<String> pick1 = pick(ls);// 不允许使用ArrayList<String>接收

        ArrayList<?> pick = pick(ls);// 允许

        // ArrayList<String> seal = seal(ls);// 不允许使用ArrayList<String>接收
        ArrayList<?> seal = seal(ls);
    }

    public void see(ArrayList<String> ls) {

        // list[0] = new ArrayList<String>();
    }

    public void look(ArrayList<Object> ls) {
    }

    // 使用通配符可以解决这个问题
    public ArrayList<?> pick(ArrayList<?> ls) {
        return ls;
    }

    // 使用通配符可以解决这个问题
    public ArrayList<? extends Object> seal(ArrayList<? extends Object> ls) {
        return ls;
    }
}
