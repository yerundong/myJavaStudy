package 泛型.泛型类;

import org.junit.jupiter.api.Test;

import java.util.List;

public class Base {
    /**
     * @Description 实例化时的泛型传入，各种写法
     */
    @Test
    public void test1() {
        GenericClass<String, Integer> stringInteger1 = new GenericClass<String, Integer>("Tom", 13);// 完整写法
        GenericClass<String, Integer> stringInteger2 = new GenericClass<>("Tom", 13);// 类型推导 √
        GenericClass<String, Integer> stringInteger5 = new GenericClass("Tom", 13);// 类型推导 √
        String tom1 = new GenericClass<>("Tom", 13).getName();// 类型推导 √

        GenericClass stringInteger3 = new GenericClass<String, Integer>("Tom", 13);// 泛型擦除 x
        GenericClass stringInteger4 = new GenericClass<>("Tom", 13);// 泛型擦除 x
        // GenericClass<> stringInteger6 = new GenericClass<String, Integer>("Tom", 13);// 错误写法 x
        Object tom2 = new GenericClass("Tom", 13).getName();// 泛型擦除 x

    }

    /**
     * @Description 继承时的泛型确定
     */
    @Test
    public void test2() {
        // SubClass1非泛型类（完全确定）
        SubClass1 subClass1 = new SubClass1();
        String name1 = subClass1.getName();

        // SubClass2为泛型类（完全保留）
        SubClass2<Double, Float> subClass2 = new SubClass2<>();
        Double name2 = subClass2.getName();

        // SubClass3为泛型类（部分保留，部分确定）
        SubClass3<Integer> subClass3 = new SubClass3<>();
        String name3 = subClass3.getName();
        Integer age3 = subClass3.getAge();

        // SubClass4为泛型类（完全擦除）
        SubClass4<Character, List<Integer>> subClass4 = new SubClass4<>();
        Object name = subClass4.getName();
        Object age = subClass4.getAge();
    }
}
