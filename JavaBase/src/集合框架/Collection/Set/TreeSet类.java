package 集合框架.Collection.Set;

import org.junit.jupiter.api.Test;
import 示例.Person;
import 示例.Tool;

import java.util.Comparator;
import java.util.TreeSet;

/*
 @TreeSet: Set实现类的一种，会按照添加对象的指定属性，进行排序。

 @特点：
    1.TreeSet实际上是TreeMap实现的。
    2.TreeSet是非线程安全的。
    3.TreeSet实现java.io.Serializable的方式。当写入到输出流时，依次写入“比较器、容量、全部元素”；当读出输入流时，再依次读取。

 @添加数据时要求：
     1.向TreeSet中添加的数据，要求是相同类的对象；
     2.要求提供两种排序方式之一：自然排序（实现 Comparable 接口）和定制排序（Comparator），而不要求equals或hashCode方法；
     3.排序时既做了排序也做了判重，如果排序方法对所添加元素与原有元素比较返回0，说明重复，则添加失败，remove、contains等操作也是通过排序方法判等，而不是equals
 */
public class TreeSet类 {
    @Test
    public void TreeSet() {
        // 使用Integer默认排序：升序
        TreeSet treeSet = new TreeSet();
        treeSet.add(123);
        treeSet.add(123);
        treeSet.add(-66);
        treeSet.add(45);
        treeSet.add(1100);
        // treeSet.add("abc");// ClassCastException,cannot be cast to class

        for (Object o : treeSet) {
            System.out.println(o);
        }
    }

    /**
     * @Description 排序1
     */
    @Test
    public void Comparable() {
        TreeSet treeSet = new TreeSet();
        // treeSet.add(new Pet());// 报错，Pet没有排序方法
        treeSet.add(new Person("Tom", 12, (byte) 1));
        treeSet.add(new Person("Simon", 10, (byte) 1));
        treeSet.add(new Person("Jacky", 8, (byte) 1));
        treeSet.add(new Person("Jack", 8, (byte) 1));
        treeSet.add(new Person("Lucy", 7, (byte) 0));

        for (Object o : treeSet) {
            System.out.println(o);
        }
    }

    /**
     * @Description 排序2
     */
    @Test
    public void comparator() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                System.out.println("执行了compare");
                if (o1 instanceof Tool && o2 instanceof Tool) {
                    Tool t1 = (Tool) o1;
                    Tool t2 = (Tool) o2;
                    if (t1.getName().equals(t2.getName())) {
                        return Integer.compare(t1.getYear(), t2.getYear());
                    } else {
                        return t1.getName().compareTo(t2.getName());
                    }
                }
                throw new RuntimeException("请传入Tool对象");
            }
        };

        TreeSet treeSet = new TreeSet(comparator);
        treeSet.add(new Tool("c"));
        treeSet.add(new Tool("b"));
        treeSet.add(new Tool("a"));
        treeSet.add(new Tool("b", 2000));
        for (Object o : treeSet) {
            System.out.println(o);
        }

        treeSet.remove(new Tool("b", 2000));// 利用compare判等

    }

}
