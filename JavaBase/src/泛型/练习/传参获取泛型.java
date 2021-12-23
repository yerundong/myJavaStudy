package 泛型.练习;

import lib.Person;
import lib.Pet;
import org.junit.jupiter.api.Test;
import 泛型.练习.lib.Boom;

public class 传参获取泛型 {
    @Test
    public void test() {
        Boom boom = new Boom(Person.class, Pet.class);
        System.out.println(boom.getClazzT());
        System.out.println(boom.getClazzV());
    }
}
