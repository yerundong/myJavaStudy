package 集合框架.Collection.Set;

import org.junit.jupiter.api.Test;
import 示例.Person;
import 示例.Tool;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Base {
    @Test
    public void HashSet() {
        Set hashSet = new HashSet();
        hashSet.add(123);
        hashSet.add(123);
        hashSet.add("abc");
        hashSet.add("abc");
        hashSet.add(new Person("Tom"));
        hashSet.add(new Person("Tom"));
        hashSet.add(new Tool("锤子"));
        hashSet.add(new Tool("锤子"));// Tool没有重写hashCode()
        Tool qz = new Tool("钳子");
        hashSet.add(qz);
        hashSet.add(qz);

        for (Object o : hashSet) {
            System.out.println(o);
        }
    }

    @Test
    public void LinkedHashSet() {
        // LinkedHashSet可以按照添加的顺序遍历，对于频繁的遍历操作，LinkedHashSet效率高于HashSet
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(123);
        linkedHashSet.add(123);
        linkedHashSet.add("abc");
        linkedHashSet.add("abc");
        linkedHashSet.add(new Person("Tom"));
        linkedHashSet.add(new Person("Tom"));
        linkedHashSet.add(new Tool("锤子"));
        linkedHashSet.add(new Tool("锤子"));// Tool没有重写hashCode()
        Tool qz = new Tool("钳子");
        linkedHashSet.add(qz);
        linkedHashSet.add(qz);

        for (Object o : linkedHashSet) {
            System.out.println(o);
        }
    }
}
