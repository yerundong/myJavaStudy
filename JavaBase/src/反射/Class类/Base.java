package 反射.Class类;

import org.junit.jupiter.api.Test;
import 示例.Person;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Base {
    /**
     * @获取Class类实例
     */
    @Test
    public void getInstance() throws Exception {
        // 1.class属性：若已知具体的类，通过类的class属性获取，该方法最为安全可靠，程序性能最高
        Class<Person> clazz1 = Person.class;

        // 2.getClass方法：已知某个类的实例，调用该实例的getClass()方法获取Class对象
        Person p2 = new Person("方舟子", 54, (byte) 1);
        Class<? extends Person> clazz2 = p2.getClass();
        Class clazz2_ = this.getClass();

        // 3.forName方法：已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法forName()获取，可能抛出ClassNotFoundException
        Class<?> clazz3 = Class.forName("示例.Person");

        // 4.ClassLoader
        ClassLoader cl = this.getClass().getClassLoader();
        Class<?> clazz4 = cl.loadClass("示例.Person");

        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);
        System.out.println(clazz4);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        System.out.println(clazz1 == clazz4);

    }

    /**
     * @各种类的Class类实例对比
     */
    @Test
    public void getInstance2() throws Exception {

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

    /**
     * @获取类加载器
     */
    @Test
    public void getClassLoader() throws Exception {
        // <M> public ClassLoader getClassLoader()
        // <返> 返回该类的类加载器。如果该类由引导类加载器加载，则此方法在这类实现中将返回 null。
        Class clazz = this.getClass();
        ClassLoader classLoader = clazz.getClassLoader();
    }

    /**
     * @创建运行时对象
     */
    @Test
    public void newInstance() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // <M> public T newInstance()
        // <返> 创建此 Class 对象所表示的类的一个新实例。
        // <注>
        // 1.newInstance只能调用无参构造器，所以运行时类必须提供空参构造器
        // 2.空参构造器访问权限必须能够满足访问
        // 3.该方法在jdk9以后不建议使用了
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        System.out.println(person);
    }

    /**
     * @创建运行时对象
     */
    @Test
    public void getDeclaredConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // <M> public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
        Class<Person> clazz = Person.class;
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class, int.class, byte.class);
        Person person = constructor.newInstance("张三", 15, (byte) 1);
        System.out.println(person);// Person{name='张三', age=15, sex=1}
    }
}
