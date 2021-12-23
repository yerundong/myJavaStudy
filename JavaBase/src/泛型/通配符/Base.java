package 泛型.通配符;

import lib.Person;
import lib.Sola;
import lib.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Base {
    /**
     * @Description 接收-上边界通配符
     */
    @Test
    public void test1() {
        // Student是Person子类
        List<? extends Person> ls1 = new ArrayList<>();
        List<Student> ls2 = new ArrayList<>();
        ls1 = ls2;

        // 无边界通配符，相当于<? extends Object>
        List<?> ls3 = new ArrayList<>();
        ls3 = ls1;
        ls3 = ls2;
    }

    /**
     * @Description 接收-下边界通配符
     */
    @Test
    public void test2() {
        // Student是Person子类
        List<? super Student> ls1 = new ArrayList<>();
        List<Person> ls2 = new ArrayList<>();
        List<Student> ls3 = new ArrayList<>();
        ls1 = ls2;
        ls1 = ls3;
        // ls2 = ls1;// Error
        // ls3 = ls1;// Error
    }

    /**
     * @使用处：形参、返参、变量接收处
     */
    @Test
    public void test3() {
        List<? extends Number> work = work(new ArrayList<Integer>());
    }

    public List<? extends Number> work(List<? extends Integer> ls) {
        return ls;
    }

    /**
     * @上边界通配符存、取
     */
    @Test
    public void test4() {
        List<? extends Person> ls2 = new ArrayList<>();

        // 因为?<=Person，只知?最大为Person，不知最小
        // 只能取，但取只能用Person接收
        Person person = ls2.get(0);
        // Student stu = ls2.get(0);// Error

        // 所有类型都不能存，无论传入多小，都可能比?大，所以禁止存
        // ls2.add(new Student());// Error
        // ls2.add(new Person());// Error
    }

    /**
     * @下边界通配符存、取
     */
    @Test
    public void test5() {
        List<? super Student> ls2 = new ArrayList<>();

        // 因为?>=Student，知?最小为Student，最大为Object

        // 可以取，但取只能用Object接收
        Object object = ls2.get(0);
        // Student stu = ls2.get(0);// Error

        // 可以存，但只能存Student及子类，才能确保存入的比?小
        ls2.add(new Student());
        ls2.add(new Sola());
        // ls2.add(new Person());// Error
    }
}
