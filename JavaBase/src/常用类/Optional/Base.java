package 常用类.Optional;

import lib.Person;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class Base {
    /**
     * @
     */
    @Test
    public void test() {
        Person person = new Person("李四");
        this.say(person);
        this.say(null);
    }

    public void say(Person p) {
        Optional<Person> p1 = Optional.ofNullable(p);
        Person person = p1.orElse(new Person("默认名"));

        String name = person.getName();
        System.out.println(name);
    }
}
