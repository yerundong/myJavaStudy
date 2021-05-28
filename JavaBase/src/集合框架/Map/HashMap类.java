package 集合框架.Map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class HashMap类 {
    /**
     * @使用泛型
     */
    @Test
    public void generic() {
        HashMap<String, Integer> hh = new HashMap<>();
        hh.put("one", 1);
        hh.put("two", 2);
        System.out.println(hh);
        System.out.println(hh.get("one"));
    }
}
