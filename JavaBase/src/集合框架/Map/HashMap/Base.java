package 集合框架.Map.HashMap;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Base {
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

        Set<Map.Entry<String, Integer>> entries = hh.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey());
        }
    }
}
