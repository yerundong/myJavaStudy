package 反射.运行时类;

import lib.Person;
import lib.Tool;
import org.junit.jupiter.api.Test;
import 反射.lib.Son;

import java.lang.reflect.Constructor;

public class 获取运行时类的对象 {
    /**
     * @方式一：获取运行时类的构造器，然后使用构造器创建运行时类的对象
     */
    @Test
    public void getInstance() throws Exception {
        Class<Son> clazz = Son.class;
        Constructor<Son> constructor1 = clazz.getConstructor(String.class);
        Constructor<Son> constructor2 = clazz.getDeclaredConstructor(String.class, int.class, Tool.class);
        Son p1 = constructor1.newInstance("张三");
        Son p2 = constructor2.newInstance("李四", 18, new Tool("biu"));
        System.out.println(p1);
        System.out.println(p2);
    }

    /**
     * @方式二：newInstance()创建运行时类的对象（已废弃）
     */
    @Test
    public void getInstance2() throws Exception {
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
}
