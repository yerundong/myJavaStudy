package 集合框架;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
@集合框架： 集合框架是一个用来代表和操纵集合的统一架构。Java 集合框架提供了一套性能优良，使用方便的接口和类，java集合框架位于java.util包中， 所以当使用集合框架的时候需要进行导包。

@参考： https://blog.csdn.net/feiyanaffection/article/details/81394745

@所有的集合框架都包含如下内容：
    接口：是代表集合的抽象数据类型。例如 Collection、List、Set、Map 等。之所以定义多个接口，是为了以不同的方式操作集合对象
    实现（类）：是集合接口的具体实现。从本质上讲，它们是可重复使用的数据结构，例如：ArrayList、LinkedList、HashSet、HashMap。
    算法：是实现集合接口的对象里的方法执行的一些有用的计算，例如：搜索和排序。这些算法被称为多态，那是因为相同的方法可以在相似的接口上有着不同的实现。

@Java集合框架主要包括两种类型的容器： 一种是集合（Collection），存储一个元素集合，另一种是图（Map），存储键/值对映射。
Collection 接口又有 3 种子接口：List、Set 和 Queue，再下面是一些抽象类，最后是具体实现类，
常用的有 ArrayList、LinkedList、HashSet、LinkedHashSet、HashMap、LinkedHashMap 等等。

@集合和数组的对比：
    1.集合和数组都是对多个数据进行储存的数据结构，简称java容器
    2.数组只能放同一类型的数据，集合可以储存不同类型
    3.数组可以存放基本类型和引用类型数据，集合只能存放引用类型数据
    4.数组长度不可变，集合长度可变
*/
public class Base {
    public static void main(String[] args) {

    }
}
