package 泛型.泛型接口;

import org.junit.jupiter.api.Test;

public class Base implements GenericInterface<String> {

    @Test
    public void test() {
        look("a");
        see("a");
        GenericInterface.run(555);
    }

    @Override
    public String see(String s) {
        return null;
    }
}
