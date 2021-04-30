package 泛型.边界符;

import org.junit.jupiter.api.Test;
import 示例.*;

import java.util.ArrayList;
import java.util.List;

public class Base {

    /**
     * @Description 上边界符（<=）
     */
    @Test
    public void test1(){
        // look(new Person());//编译报错，超出边界
        look(new Student());
        look(new Sola());
    }

    /**
     * @Description 下边界符（>=）
     */
    @Test
    public void test2(){
        see(new ArrayList<Student>());
        see(new ArrayList<Person>());
        // see(new ArrayList<Sola>());//编译报错，超出边界
    }

    public <T extends Student> void look(T t) {
    }

    // 只有通配符?才能使用super
    // public <T super Student> void see(T t) {}
    public void see(List<? super Student> t) {}

    /**
     * @Description 多重界符（<=）
     * 使用 & 符号设定多重边界（Multi Bounds)，指定泛型类型 T 必须是 Student 和 USB 的共有子类型，
     * 此时变量 t 就具有了所有限定的方法和属性。对于通配符？来说，因为它不是一个确定的类型，所以不能进行多重限定。
     */
    @Test
    public void test3(){
        // slip(new ArrayList<Person>());//编译报错，必须是是 Student 和 USB 的共同子类
        // see(new ArrayList<Sola>());//编译报错，必须是是 Student 和 USB 的共同子类
    }

    public <T extends Student & USB> void slip(T t) {
    }
}
