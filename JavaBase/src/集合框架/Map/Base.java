package 集合框架.Map;

import org.junit.jupiter.api.Test;
import 示例.Person;
import 示例.Pet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Base {

    /**
     * @Description 添加
     */
    @Test
    public void put() {
        // <M> public V put(K key, V value)
        // <改> 添加一个entry
        // <返> 若把原先旧的value覆盖，则返回旧的value，若只是新增，返回null
        Map hashMap = new HashMap();
        Object a = hashMap.put("a", 111);// null
        System.out.println(a);

        Object b = hashMap.put("a", 222);// 111
        System.out.println(b);

        hashMap.put(true, 'a');
        hashMap.put(null, null);
        hashMap.put(new Person("Tom"), new Pet("Jerry"));
        System.out.println(hashMap);
    }

    /**
     * @Description 长度
     */
    @Test
    public void size() {
        // <M> int size();
        // <返> 返回entry个数
        Map hashMap = new HashMap();
        hashMap.put("a", 111);
        hashMap.put("a", 222);
        hashMap.put(true, 'a');
        hashMap.put(666, null);
        System.out.println(hashMap);
    }

    /**
     * @Description 删除
     */
    @Test
    public void remove() {
        // <M> V remove(Object key)
        // <改> 删除key对应的entry
        // <返> 返回key对应的value，若没有对应的key，则返回null
        Map hashMap = new HashMap();
        hashMap.put("a", 111);
        hashMap.put("a", 222);
        hashMap.put(true, 'a');
        hashMap.put(666, null);
        Object a = hashMap.remove("a");// 222
        Object b = hashMap.remove("ccc");// null
        System.out.println(a);
        System.out.println(b);
        System.out.println(hashMap);
    }

    /**
     * @Description 清空
     */
    @Test
    public void clear() {
        // <M> void clear();
        // <改> 清空所有entry
        Map hashMap = new HashMap();
        hashMap.put("a", 111);
        hashMap.put("a", 222);
        hashMap.put(true, 'a');
        hashMap.put(666, null);
        hashMap.clear();
        System.out.println(hashMap);
        System.out.println(hashMap.size());// 0
    }

    /**
     * @Description 获取value
     */
    @Test
    public void get() {
        // <M> V get(Object key);
        // <返> key所对应的value，未找到返回null
        Map hashMap = new HashMap();
        hashMap.put("a", 111);
        hashMap.put("a", 222);
        hashMap.put(true, 'a');
        hashMap.put(666, null);
        System.out.println(hashMap.get("a"));// 222
        System.out.println(hashMap.get("ccc"));// null
        System.out.println(hashMap.get(666));// null
    }

    /**
     * @Description 是否包含指定的key
     */
    @Test
    public void containsKey() {
        // <M> boolean containsKey(Object key);
        // <返> 是否包含指定的key
        Map hashMap = new HashMap();
        hashMap.put("a", 111);
        hashMap.put("a", 222);
        hashMap.put(true, 'a');
        hashMap.put(666, null);
        System.out.println(hashMap.containsKey("a"));// true
        System.out.println(hashMap.containsKey("ccc"));// false
        System.out.println(hashMap.containsKey(666));// true
    }

    /**
     * @Description 是否包含指定的value
     */
    @Test
    public void containsValue() {
        // <M> boolean containsValue(Object value);
        // <返> 是否包含指定的value
        Map hashMap = new HashMap();
        hashMap.put("a", 111);
        hashMap.put("a", 222);
        hashMap.put(true, 'a');
        hashMap.put(666, null);
        System.out.println(hashMap.containsValue('a'));// true
        System.out.println(hashMap.containsValue(null));// true
        System.out.println(hashMap.containsValue(333));// false
    }

    /**
     * @Description 是否为空Map
     */
    @Test
    public void isEmpty() {
        // <M> boolean isEmpty();
        // <返> 是否为空Map
        Map hashMap = new HashMap();
        System.out.println(hashMap.isEmpty());// true
        hashMap.put("a", 111);
        System.out.println(hashMap.isEmpty());// false
    }

    /**
     * @Description 是否相等
     */
    @Test
    public void equals() {
        // <M> boolean equals(Object o);
        // <返> 是否相等
        Map map1 = new HashMap();
        Map map2 = new HashMap();
        map1.put("a", 111);
        map2.put("a", 111);
        System.out.println(map1.equals(map2));// true

        map1.put("a", new Person("Tom"));
        map2.put("a", new Person("Tom"));
        System.out.println(map1.equals(map2));// true

        map1.put("b", 111);
        map1.put("b", 222);
        System.out.println(map1.equals(map2));// false
    }

    /**
     * @Description key集
     */
    @Test
    public void keySet() {
        // <M> Set<K> keySet()
        // <返> 返回key组成的Set
        Map hashMap = new HashMap();
        hashMap.put("a", 111);
        hashMap.put(true, 'a');
        hashMap.put(666, null);
        Set keySet = hashMap.keySet();
        System.out.println(keySet);

        // 获得key集，可以用来遍历map
        for (Object o : keySet) {
            System.out.println(hashMap.get(o));
        }
    }

    /**
     * @Description value集
     */
    @Test
    public void values() {
        // <M> Collection<V> values();
        // <返> 返回value组成的Collection
        Map hashMap = new HashMap();
        hashMap.put("a", 111);
        hashMap.put(true, 'a');
        hashMap.put(666, null);
        Collection values = hashMap.values();
        System.out.println(values);

        for (Object value : values) {
            System.out.println(value);
        }
    }

    /**
     * @Description entry集
     */
    @Test
    public void entrySet() {
        // <M> Set<Map.Entry<K, V>> entrySet();
        // <返> 返回Entry组成的Set
        Map hashMap = new HashMap();
        hashMap.put("a", 111);
        hashMap.put(true, 'a');
        hashMap.put(666, null);
        Set<Map.Entry> entrySet = hashMap.entrySet();
        System.out.println(entrySet);
        System.out.println("----------------------");

        for (Map.Entry es : entrySet) {
            // System.out.println(es);
            System.out.println(es.getKey());
            System.out.println(es.getValue());
        }
    }
}
