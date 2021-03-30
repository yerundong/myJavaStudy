# 集合框架 

[参考](https://blog.csdn.net/feiyanaffection/article/details/81394745)

### 定义
集合框架是一个用来代表和操纵集合的统一架构。Java 集合框架提供了一套性能优良，使用方便的接口和类，java集合框架位于java.util包中，
所以当使用集合框架的时候需要进行导包。

### java容器
集合和数组都属于java容器，对多个数据进行储存操作的结构。  
注：这里的储存是内存层面的储存，非持久化储存

### 所有的集合框架都包含如下内容
* 接口：是代表集合的抽象数据类型。例如 Collection、List、Set、Map 等。之所以定义多个接口，是为了以不同的方式操作集合对象
* 实现（类）：是集合接口的具体实现。从本质上讲，它们是可重复使用的数据结构，例如：ArrayList、LinkedList、HashSet、HashMap。
* 算法：是实现集合接口的对象里的方法执行的一些有用的计算，例如：搜索和排序。这些算法被称为多态，那是因为相同的方法可以在相似的接口上有着不同的实现。

### Java集合框架关系：
> 结构
```
├── 集合框架
    ├── Collection(I)
        ├── List(I)
            ├──ArrayList（C）   
            ├──LinkedList（C）    
            └──Vector（C）       
        ├── Set(I)
            ├──HashSet（C）     
                └──LinkedHashSet（C）   
            └──TreeSet（C）   
        └── Queue(I)
    └── Map(I)
        ├── HashMap（C）
            ├──LinkedHashMap（C）   
        ├── treeMap（C）    
        └── Hashtable（C）
            └── Properties（C）
```
> 说明
    
    Java集合框架有两大家族，一个Collection（集合），另一个是Map（图），Collection和Map分别是2大体系中的顶层接口。Collection下有三大子接口：List(列表)、Set(集)、Queue(队列)，
    这些下面是一些抽象类，最后是具体实现类，常用的有 ArrayList、LinkedList、HashSet、LinkedHashSet、HashMap、LinkedHashMap 等等。
    
* Collection：接口；单列集合，存储一个一个对象
* Map：接口；双列集合，存储键/值对（key-value）映射；允许一对一、多对一，不允许一对多
* List：接口；储存有序的、可重复的数据；容量不固定，随着容量的增加而动态扩容（阈值基本不会达到），习惯称之为“动态数组”
* Queue：接口；储存有序的、可重复的数据；
* Set：接口；储存无序的、不可重复的数据；习惯称之为“集合”
* ArrayList：类；数组队列，Java集合框架中被使用最多的，线程不安全，效率高
* LinkedList：类；双向链表
* HashSet：类；HashSet 基于 HashMap 来实现的；

### 集合和数组的对比：
1. 数组只能放同一类型的数据，集合可以储存不同类型
2. 数组可以存放基本类型和引用类型数据，集合只能存放引用类型数据
3. 数组长度不可变，集合长度可变
4. 数组提供操作数据的放放松非常有限，对于删除、增加、插入等操作非常不便，同时效率不高；
   集合提供丰富的操作方法，十分便利
5. 获取数组中的元素个数，数组没有提供有效的属性或方法使用
6. 数组储存数据的特点：有序，可重复，对于无序，不可重复的数据无法满足