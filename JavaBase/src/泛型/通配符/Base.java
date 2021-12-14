package 泛型.通配符;

import lib.Person;
import lib.Student;
import org.junit.jupiter.api.Test;
import 泛型.泛型类.GenericClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @通配符: ?表示不确定的 java 类型
 * @用处： 通常用于变量声明、泛型方法的调用代码和形参，不能用于定义泛型类、方法、接口。
 * 1.变量接收
 * 2.方法形参
 */
public class Base {

    /**
     * @Description 无边界通配符
     */
    @Test
    public void test() {
        // 表示 list1 可以指向任何泛型的 List 的引用
        // 1.变量接收
        List<?> list1 = new ArrayList<>();
        ArrayList<Person> list2 = new ArrayList<>();
        list1 = list2;

        // 2.方法形参
        ArrayList<?> look = look(new ArrayList<String>());

        // 读取
        GenericClass<?, ?> genericClass = new GenericClass<>();
        Object name = genericClass.getName();// 只能使用 Object 接收，因为不确定?代表哪个类型
        // ? name = genericClass.getName();// 错误写法

        // 写入
        // genericClass.setName(456);// 编译报错
        genericClass.setName(null);// 只有null允许，因为不确定?代表哪个类型
    }

    public ArrayList<?> look(ArrayList<?> l) {
        return l;
    }

    /**
     * @Description 上边界限定通配符
     */
    @Test
    public void test2() {
        // 表示 list1 可以指向任何泛型是 Person 或 Person 子类的 List 的引用
        // 表示 ? <= Person
        List<? extends Person> list1 = new ArrayList<>();
        ArrayList<Student> list2 = new ArrayList<>();
        list1 = list2;

        // list1.add(new Person());// 编译报错，因为不确定?代表哪个类型
        // list1.add(new Student());// 编译报错，因为不确定?代表哪个类型
    }

    /**
     * @Description 下边界限定通配符
     */
    @Test
    public void test3() {
        // 表示 list1 可以指向任何泛型是 Student 或 Student 父类的 List 的引用
        // 表示 ? >= Student
        ArrayList<? super Student> list1 = new ArrayList<>();
        ArrayList<Person> list2 = new ArrayList<>();
        list1 = list2;

        list1.add(new Student());// 允许，因为不管?代表哪个类型，都 >= Student，
        // list1.add(new Person());// 编译报错，不一定 >= Student
    }

}
