# List接口 
 储存有序的、可重复的数据；容量不固定，随着容量的增加而动态扩容（阈值基本不会达到），习惯称之为“动态数组”。List下面有三个实现类：ArrayList、linkedList、Vector。

- List(I)：储存有序的、可重复的数据；容量不固定，随着容量的增加而动态扩容
- ArrayList：主要实现类，使用最多；线程不安全，效率高；底层使用数组 Object[] elementData 储存数据
- LinkedList：底层使用双向链表储存；对于频繁的插入、删除操作，使用此类效率比 ArrayList 高，但查询效率不如ArrayList；
- Vector：出现比较早（1.0，比List还早），基本被ArrayList替代；线程安全，效率低；底层使用 Object[] elementData 储存数据

>ArrayList和LinkedList对比区别，请移步：[博客园](https://i.cnblogs.com/links?cateId=1980880)

### 继承关系
```
├── Collection(I)
    ├── List(I)
        └──AbstractList
           ├──ArrayList
           ├──linkedList
           └──Vector
```

### ArrayList的源码分析：
```
1.jdk 7情况下
    ArrayList list = new ArrayList();//底层创建了长度是10的Object[]数组elementData
    list.add(123);//elementData[0] = new Integer(123);
    ...
    list.add(11);//如果此次的添加导致底层elementData数组容量不够，则扩容。
    默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。
    结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity)

2.jdk 8中ArrayList的变化：
    ArrayList list = new ArrayList();//底层Object[] elementData初始化为{}.并没有创建长度为10的数组
    list.add(123);//第一次调用add()时，底层才创建了长度10的数组，并将数据123添加到elementData[0]
    ...
    后续的添加和扩容操作与jdk 7 无异。
3. 小结：jdk7中的ArrayList的对象的创建类似于单例的饿汉式，而jdk8中的ArrayList的对象的创建类似于单例的懒汉式，延迟了数组的创建，节省内存。

```

### LinkedList的源码分析：
```java
  LinkedList list = new LinkedList(); 内部声明了Node类型的first和last属性，默认值为null
  list.add(123);//将123封装到Node中，创建了Node对象。

  其中，Node定义为：体现了LinkedList的双向链表的说法
      private static class Node<E> {
         E item;
         Node<E> next;
         Node<E> prev;

         Node(Node<E> prev, E element, Node<E> next) {
             this.item = element;
             this.next = next;
             this.prev = prev;
         }
      }
```
 
 ### Vector的源码分析
```java
    jdk7和jdk8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组。在扩容方面，默认扩容为原来的数组长度的2倍。
```
