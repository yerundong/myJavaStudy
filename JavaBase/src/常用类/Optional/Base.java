package 常用类.Optional;

import org.junit.jupiter.api.Test;
import 示例.Person;

import java.util.Optional;

public class Base {
    /**
     * @
     */
    @Test
    public void test() {
        Person person = new Person("李四");
        this.say(person);
    }

    public void say(Person p) {
        Optional<Person> p1 = Optional.ofNullable(p);
        Person person = p1.orElse(new Person("默认名"));

        String name = person.getName();
        System.out.println(name);
    }
}
