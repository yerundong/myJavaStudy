package 集合框架.Map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 循环遍历Map的4中方法
 */
public class 遍历 {
    private Map<String, Integer> map = new HashMap<>();
    {
        map.put("a", 1);
    }

    /**
     * 1. entrySet遍历，在键和值都需要时使用（最常用）
     */
    @Test
    public void test1(){
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
    }

    /**
     * 2. 通过keySet或values来实现遍历,性能略低于第一种方式
     */
    @Test
    public void test2(){
        // 遍历map中的键
        for (String key : map.keySet()) {
            System.out.println("key = " + key);
        }
        // 遍历map中的值
        for (Integer value : map.values()) {
            System.out.println("value = " + value);
        }
    }

    /**
     * 3. 使用Iterator遍历
     */
    @Test
    public void test3(){
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
    }

    /**
     * 4. java8+ Lambda
     */
    @Test
    public void test4(){
        // java8提供了Lambda表达式支持，语法看起来更简洁，可以同时拿到key和value，
        // 不过，经测试，性能低于entrySet,所以更推荐用entrySet的方式
        map.forEach((key, value) -> {
            System.out.println(key + "=" + value);
        });
    }
}
