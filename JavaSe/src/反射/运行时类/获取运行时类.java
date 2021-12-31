package 反射.运行时类;

import lib.Person;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;

public class 获取运行时类 {
    /**
     * @获取运行时类-Class类实例的方式
     */
    @Test
    public void getInstance() throws Exception {
        // 1.class属性
        Class<Person> clazz1 = Person.class;

        // 2.实例getClass方法
        Person p2 = new Person("方舟子", 54, (byte) 1);
        Class<? extends Person> clazz2 = p2.getClass();
        Class clazz2_ = this.getClass();

        // 3.forName方法
        Class<?> clazz3 = Class.forName("lib.Person");

        // 4.loadClass方法
        ClassLoader cl = this.getClass().getClassLoader();
        Class<?> clazz4 = cl.loadClass("lib.Person");

        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);
        System.out.println(clazz4);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        System.out.println(clazz1 == clazz4);

    }

    /**
     * @各种运行时类对比
     */
    @Test
    public void classCompare() throws Exception {

        Class<Object> clazz1 = Object.class;
        Class<Comparable> clazz2 = Comparable.class;
        Class<String> clazz3 = String.class;
        Class<String[]> clazz4 = String[].class;
        Class<int[]> clazz5 = int[].class;
        Class<? extends int[]> clazz5_ = new int[]{1, 2, 3}.getClass();
        Class<int[][]> clazz6 = int[][].class;
        Class<ElementType> clazz7 = ElementType.class;
        Class<Override> clazz8 = Override.class;
        Class<Void> clazz9 = void.class;
        Class<Class> clazz10 = Class.class;

        // 数组只要类型和维度一样，它们的Class的就是一样的
        System.out.println(clazz5 == clazz5_);// true
    }
}
