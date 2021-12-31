package 泛型.边界符;

import lib.Student;
import lib.USB;
import org.junit.jupiter.api.Test;

public class Base<T extends String> {

    /**
     * @extends 上边界符
     */
    @Test
    public void test1() {
        // 这里值展示T型，通配型用法请查看通配符章
        look(new Student());
    }

    public <T extends Student> T look(T t) {
        return t;
    }

    /**
     * @super 下边界符
     */
    @Test
    public void test2() {
        // 下边界符super只有通配型使用，请查看通配符章
    }

    // T型不支持下边界符
    // public <T super Student> void see(T t) {}


    /**
     * @多重界符
     */
    @Test
    public void test3() {
        // slip(new ArrayList<Person>());//编译报错，必须是是 Student 和 USB 的共同子类
    }

    public <E extends Student & USB> void slip(E t) {
    }

    // 通配型不支持多重界符
    // public List<? extends Student & USB> miss(List<? super Student & USB> t) {
    // }
}
