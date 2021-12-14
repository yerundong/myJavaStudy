package 反射.类加载器;

import lib.Person;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Base {
    /**
     * @获取某类的加载器（引导加载器取不到，返值为null）
     */
    @Test
    public void getClassLoader() {
        // 自定义类
        ClassLoader classLoader = Person.class.getClassLoader();
        System.out.println(classLoader);// 自定义类加载器：系统加载器

        // 核心类
        ClassLoader classLoader2 = String.class.getClassLoader();
        System.out.println(classLoader2);// null
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
     * @获取拓展、引导加载器
     */
    @Test
    public void getParent() {
        // <M> public final ClassLoader getParent()
        ClassLoader classloader = this.getClass().getClassLoader();
        System.out.println(classloader);

        ClassLoader classloader1 = classloader.getParent();
        System.out.println(classloader1);

        ClassLoader classloader2 = classloader1.getParent();
        System.out.println(classloader2);// null
    }

    /**
     * @使用指定的二进制名称来加载类。
     */
    @Test
    public void loadClass() throws ClassNotFoundException {
        // <M> public Class<?> loadClass(String name) throws ClassNotFoundException
        // <注> name是二进制名称
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class clazz = classLoader.loadClass("lib.Person");
    }

    /**
     * @通过类加载器获取输入流
     */
    @Test
    public void getResourceAsStream() throws IOException {
        // <M> public InputStream getResourceAsStream(String name)
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream is = classLoader.getResourceAsStream("反射/lib/test.properties");// 注意：这里是相对于当前模块包的src下的路径
        Properties properties = new Properties();
        properties.load(is);
        System.out.println(properties.get("user"));
    }
}
