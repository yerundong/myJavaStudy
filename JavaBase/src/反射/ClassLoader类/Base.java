package 反射.ClassLoader类;

import org.junit.jupiter.api.Test;
import 示例.Person;

import java.io.InputStream;

public class Base {
    /**
     * @获取类的加载器
     */
    @Test
    public void getClassLoader() {
        // 1.先获取Class类的实例
        Class clazz = Person.class;
        clazz = this.getClass();

        // 2.调用getClassLoader()
        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println(classLoader);
    }

    /**
     * @获取系统类加载器
     */
    @Test
    public void getSystemClassLoader() {
        // <SM> public static ClassLoader getSystemClassLoader()
        // <返> 获取系统类加载器
        ClassLoader classloader = ClassLoader.getSystemClassLoader();
        System.out.println(classloader);
    }

    /**
     * @使用指定的二进制名称来加载类。
     */
    @Test
    public void loadClass() throws ClassNotFoundException {
        // <M> public Class<?> loadClass(String name) throws ClassNotFoundException
        // <注> name是二进制名称
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class clazz = classLoader.loadClass("示例.Person");
    }

    /**
     * @返回父类加载器
     */
    @Test
    public void getParent() {
        // <M> public final ClassLoader getParent()
        ClassLoader classloader = this.getClass().getClassLoader();
        ClassLoader classloader1 = classloader.getParent();
        ClassLoader classloader2 = classloader1.getParent();
        System.out.println(classloader);
        System.out.println(classloader1);
        System.out.println(classloader2);
    }

    /**
     * @返回读取指定资源的输入流
     */
    @Test
    public void getResourceAsStream() {
        // <M> public InputStream getResourceAsStream(String name)
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream is = classLoader.getResourceAsStream("IOTestFile/hello-io.txt");

    }


}
