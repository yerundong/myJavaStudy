package 集合框架.Set;

import org.junit.jupiter.api.Test;
import 示例.Person;
import 示例.Tool;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 @Set: 储存无序的、不可重复的数据；习惯称之为“集合”

 ├── Collection(I)
     ├── Set(I)：存储无序的、不可重复的数据
         ├──AbstractSet
             ├──HashSet：作为Set接口的主要实现类；线程不安全的；可以存储null值
                ├──LinkedHashSet：作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历，对于频繁的遍历操作，LinkedHashSet效率高于HashSet.
             ├──TreeSet：可以按照添加对象的指定属性，进行排序。

 @特性：
    1.无序性：不等于随机性；存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值决定的。
    2.不可重复性：保证添加的元素按照equals()判断时，不能返回true.即：相同的元素只能添加一个。
    3.效率？？？

 @注意：
    1.Set里没有额外定义的方法，全部是继承自Collection的方法；

 @HashSet\LinkedHashSet

 @添加元素的过程(以HashSet为例)：
     我们向HashSet中添加元素a,首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
     此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置（即为：索引位置），判断
     数组此位置上是否已经有元素：
        如果此位置上没有其他元素，则元素a添加成功。 --->情况1
        如果此位置上有其他元素b(或以链表形式存在的多个元素），则比较元素a与元素b的hash值：
            如果hash值不相同，则元素a添加成功。--->情况2
            如果hash值相同，进而需要调用元素a所在类的equals()方法：
                equals()返回true,元素a添加失败
                equals()返回false,则元素a添加成功。--->情况3

     对于添加成功的情况2和情况3而言：元素a与已经存在指定索引位置上数据以链表的方式存储。
     jdk 7 :元素a放到数组中，指向原来的元素。
     jdk 8 :原来的元素在数组中，指向元素a
     总结：七上八下

 @要求：
    1. HashSet、LinkedHashSet中添加的数据，其所在的类一定要重写hashCode()和equals()，否则添加时都默认是未存在相同的，造成重复的数据
    2. 重写的hashCode()和equals()尽可能保持一致性：相等的对象必须具有相等的散列码（哈希值）
    @重写两个方法的小技巧： 对象中用作 equals() 方法比较的 Field，都应该用来计算 hashCode 值。
 */
public class Base {
    @Test
    public void HashSet(){
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
    public void LinkedHashSet(){
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
