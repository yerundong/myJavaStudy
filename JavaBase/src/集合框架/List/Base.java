package 集合框架.List;

import org.junit.jupiter.api.Test;
import 示例.Person;
import 示例.Pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 @List接口: 储存有序的、可重复的数据；容量不固定，随着容量的增加而动态扩容（阈值基本不会达到），习惯称之为“动态数组”。List下面有三个实现类：ArrayList、
    linkedList、Vector。

 ├── Collection(I)
    ├── List(I)
         ├──ArrayList：主要实现类，使用最多；线程不安全，效率高；底层使用 Object[] elementData 储存数据
         ├──linkedList：底层使用双向链表储存；对于频繁的插入、删除操作，使用此类效率比 ArrayList 高，但查询效率不如ArrayList；
         └──Vector：出现比较早（1.0，比List还早），基本被ArrayList替代；线程安全，效率低；底层使用 Object[] elementData 储存数据
 */
public class Base {
    /**
     * @Description 添加
     */
    @Test
    public void add(){
        // <M> public boolean add(E e)
        // <改> 向 List 末尾添加一个元素，并改变这个集合
        // <M> public void add(int index, E element)
        // <改> 向 List 中特定索引位置添加一个元素，并改变这个集合；如果索引已有元素，则被往后挤。

        ArrayList al = new ArrayList();
        al.add(1);
        al.add(0,'a');
        al.add(2,'b');
        System.out.println(al);// [a, 1, b]
    }

    /**
     * @Description 添加全部
     */
    @Test
    public void addAll(){
        // <M> public boolean addAll(Collection<? extends E> c)
        // <改> 向 List 中添加一个集合元素，并改变这个集合
        // <M> public boolean addAll(int index, Collection<? extends E> c)
        // <改> 向 List 中特定索引位置添加一个集合元素，并改变这个集合；如果索引已有元素，则被往后挤。

        ArrayList al = new ArrayList();
        List lis1 = Arrays.asList(1,2,6);
        List lis2 = Arrays.asList(3,4,5);
        al.addAll(lis1);
        System.out.println(al);// [1, 2, 6]
        al.addAll(2, lis2);
        System.out.println(al);// [1, 2, 3, 4, 5, 6]
    }

    /**
     * @Description 检索
     */
    @Test
    public void indexOf(){
        // <M> int indexOf(Object o)
        // <改> 返回集合中首次出现的索引值，找不到返回-1
        // <注> 底层使用 equals 比对是否存在，所以引用类型的元素需要重写 equals 方法
        List lis1 = Arrays.asList(1, 2, 3, new Pet("棒子"), new Person("米国"));
        System.out.println(lis1.indexOf(3));
        System.out.println(lis1.indexOf(new Pet("棒子")));// -1，Pet没有重写 equals 方法
        System.out.println(lis1.indexOf(new Person("米国")));
    }

    /**
     * @Description 检索
     */
    @Test
    public void lastIndexOf(){
        // <M> int indexOf(Object o)
        // <改> 返回集合中末次出现的索引值，找不到返回-1
        // <注> 底层使用 equals 比对是否存在，所以引用类型的元素需要重写 equals 方法
        List lis1 = Arrays.asList(1, 2, 3, 2);
        System.out.println(lis1.lastIndexOf(2));
    }

    /**
     * @Description 删除
     */
    @Test
    public void remove(){
        // <M> E remove(int index)
        // <改> 删除集合索引位置的元素，找不到报 IndexOutOfBoundsException
        // <返> 返回被删除的元素
        // <注> Collection中的 remove 是 boolean remove(Object o)，这是重载方法
        List al = new ArrayList();
        al.add(1);
        al.add(2);
        Object remove = al.remove(1);
        System.out.println(remove);
        System.out.println(al);
        // al.remove(2);// IndexOutOfBoundsException
    }

    /**
     * @Description 设置
     */
    @Test
    public void get(){
        // <M> E get(int index)
        // <返> 获取集合索引位置的元素，找不到报 IndexOutOfBoundsException
        List al = new ArrayList();
        System.out.println(al.get(1));
    }

    /**
     * @Description 设置
     */
    @Test
    public void set(){
        // <M> E set(int index, E element)
        // <改> 设置集合索引位置的元素，找不到报 IndexOutOfBoundsException
        // <返> 返回被替换的元素
        List al = new ArrayList();
        al.add(1);
        Object a = al.set(0, 'a');
        System.out.println(a);
        System.out.println(al);
    }

    /**
     * @Description 截取
     */
    @Test
    public void subList(){
        // <M> List<E> subList(int fromIndex, int toIndex)
        // <返> 返回截取的部分的list
        List al = new ArrayList();
        al.add(1);
        al.add(2);
        al.add(3);
        List list2 = al.subList(1, 2);
        System.out.println(al);
        System.out.println(list2);
    }
}
