package 集合框架.Map;

import lib.Person;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeMap;

/*
 @TreeMap: Map实现类的一种，会按照添加对象的指定属性，进行排序。

 @特点： 1.TreeMap是非线程安全的。

 @添加数据时要求：
     1.要求key必须是由同一个类创建的对象
     2.要求key提供两种排序方式之一：自然排序（实现 Comparable 接口）和定制排序（Comparator），而不要求equals或hashCode方法；
     3.排序时既做了排序也做了判重，如果排序方法对所添加元素与原有元素比较返回0，说明重复，则添加失败，remove、contains等操作也是通过排序方法判等，而不是equals
 */
public class TreeMap类 {
    @Test
    public void TreeMap() {
        TreeMap treeMap = new TreeMap();
        treeMap.put('b', 69846);
        treeMap.put('a', 123);
        treeMap.put('c', 69846);
        // treeMap.put("d", 69846);// 报错，key必须是由同一个类创建的对象
        System.out.println(treeMap);
    }

    /**
     * @Description 自然排序
     */
    @Test
    public void Comparable() {
        TreeMap treeMap = new TreeMap();
        treeMap.put(new Person("a", 2), 2);
        treeMap.put(new Person("a", 3), 2);
        treeMap.put(new Person("a", 1), 2);
        System.out.println(treeMap);
    }

    /**
     * @Description 定制排序
     */
    @Test
    public void Comparator() {
        Comparator comparator = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return p1.getName().compareTo(p2.getName());
                }
                return 0;
            }
        };
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.put(new Person("c", 2), 2);
        treeMap.put(new Person("a", 3), 2);
        treeMap.put(new Person("d", 1), 2);
        System.out.println(treeMap);
    }
}
