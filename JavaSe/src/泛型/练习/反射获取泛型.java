package 泛型.练习;

import org.junit.jupiter.api.Test;
import 泛型.练习.lib.Son;

public class 反射获取泛型 {
    @Test
    public void test() {
        Son son = new Son("哈哈", 25);
        Class<String> clazz = son.getClazz();
    }
}
