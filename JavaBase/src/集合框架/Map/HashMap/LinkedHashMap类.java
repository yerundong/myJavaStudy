package 集合框架.Map.HashMap;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class LinkedHashMap类 {

    /**
     * @遍历
     */
    @Test
    public void test() {
        LinkedHashMap<String, Object> lhh = new LinkedHashMap<>();
        lhh.put("yellow", 111);
        lhh.put("red", 222);
        lhh.put("black", 333);

        for (String s : lhh.keySet()) {
            System.out.println(s);
        }
    }

}
