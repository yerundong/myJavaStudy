package 集合框架.Map;

import org.junit.jupiter.api.Test;
import 示例.Person;
import 示例.Pet;

import java.util.*;

/**
 @Map接口: 双列集合，存储键/值对（key-value）映射；允许一对一、多对一，不允许一对多;

 @结构：
    ├── Map(I)：双列数据，存储key-value对的数据
        ├── HashMap（C）：作为Map的主要实现类；线程不安全的，效率高；允许存储null的key和value；
            ├──LinkedHashMap（C）：保证在遍历map元素时，可以按照添加的顺序实现遍历。
                原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。对于频繁的遍历操作，此类执行效率高于HashMap。
        ├── treeMap（C）：保证按照特定规则对添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序，底层使用红黑树
        └── Hashtable（C）：作为古老的实现类；线程安全的，效率低；不能存储null的key和value
            └── Properties（C）：常用来处理配置文件。key和value都是String类型

        HashMap的底层：数组+链表  （jdk7及之前）
                    数组+链表+红黑树 （jdk 8）

 @Map结构的理解：
   Map中的key:无序的、不可重复的，使用Set存储所有的key  ---> key所在的类要重写equals()和hashCode() （以HashMap为例）
   Map中的value:无序的、可重复的，使用Collection存储所有的value --->value所在的类要重写equals()
   一个键值对：key-value构成了一个Entry对象。
   Map中的entry:无序的、不可重复的，使用Set存储所有的entry。

 @HashMap的底层实现原理？以jdk7为例说明：
    HashMap map = new HashMap():
    在实例化以后，底层创建了长度是16的一维数组Entry[] table。
    ...可能已经执行过多次put...
    map.put(key1,value1):
    首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法计算以后，得到在Entry数组中的存放位置。
    如果此位置上的数据为空，此时的key1-value1添加成功。 ----情况1
    如果此位置上的数据不为空，(意味着此位置上存在一个或多个数据(以链表形式存在)),比较key1和已经存在的一个或多个数据
    的哈希值：
            如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功。----情况2
            如果key1的哈希值和已经存在的某一个数据(key2-value2)的哈希值相同，继续比较：调用key1所在类的equals(key2)方法，比较：
                    如果equals()返回false:此时key1-value1添加成功。----情况3
                    如果equals()返回true:使用value1替换value2。

    补充：关于情况2和情况3：此时key1-value1和原来的数据以链表的方式存储。

    在不断的添加过程中，会涉及到扩容问题，当超出临界值(且要存放的位置非空)时，扩容。默认的扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来。

    jdk8 相较于jdk7在底层实现方面的不同：
        1. new HashMap():底层没有创建一个长度为16的数组
        2. jdk 8底层的数组是：Node[],而非Entry[]
        3. 首次调用put()方法时，底层创建长度为16的数组
        4. jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树。
          4.1 形成链表时，七上八下（jdk7:新的元素指向旧的元素。jdk8：旧的元素指向新的元素）
          4.2 当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64时，此时此索引位置上的所数据改为使用红黑树存储。

    字段说明：
        DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
        DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
        threshold：扩容的临界值，=容量*填充因子：16 * 0.75 => 12
        TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树:8
        MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量:64

 @LinkedHashMap的底层实现原理（了解）
     static class Entry<K,V> extends HashMap.Node<K,V> {
         Entry<K,V> before, after;//能够记录添加的元素的先后顺序
         Entry(int hash, K key, V value, Node<K,V> next) {
            super(hash, key, value, next);
         }
     }
 */
public class Base {

    /**
     * @Description 添加
     */
    @Test
    public void put(){
        // <M> public V put(K key, V value)
        // <改> 添加一个entry
        // <反> 若把原先旧的value覆盖，则返回旧的value，若只是新增，返回null
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
    public void size(){
        // <M> int size();
        // <返> 返回entry个数
        Map hashMap = new HashMap();
        hashMap.put("a", 111);
        hashMap.put("a", 222);
        hashMap.put(true, 'a');
        hashMap.put(666, null);
        System.out.println(hashMap.size());
    }

    /**
     * @Description 删除
     */
    @Test
    public void remove(){
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
    public void clear(){
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
    public void get(){
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
    public void containsKey(){
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
    public void containsValue(){
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
    public void isEmpty(){
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
    public void equals(){
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
    public void keySet(){
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
    public void values(){
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
    public void entrySet(){
        // <M> Set<Map.Entry<K, V>> entrySet();
        // <返> 返回Entry组成的Set
        Map hashMap = new HashMap();
        hashMap.put("a", 111);
        hashMap.put(true, 'a');
        hashMap.put(666, null);
        Set entrySet = hashMap.entrySet();
        System.out.println(entrySet);

        for (Object value : entrySet) {
            Map.Entry value_ = (Map.Entry) value;
            // System.out.println(value);
            System.out.println(value_);
            System.out.println(value_.getKey());
            System.out.println(value_.getValue());
            System.out.println("----------------------");
        }
    }
}
