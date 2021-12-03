package 集合框架.Collection.List;

import org.junit.jupiter.api.Test;
import 示例.Person;
import 示例.Pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 以下方法都是List接口中有定义，是其实现类都继承重写的、共有的方法。
 * 因为接口不能直接创建实例，以下使用多态的方式来演示
 */
public class Base {
    /**
     * @Description 添加
     */
    @Test
    public void add() {
        // <M> public boolean add(E e)
        // <改> 向 List 末尾添加一个元素，并改变这个集合
        // <M> public void add(int index, E element)
        // <改> 向 List 中特定索引位置添加一个元素，并改变这个集合；如果索引已有元素，则被往后挤。
        List ls = new ArrayList();

        ls.add(1);
        ls.add(0, 'a');
        ls.add(2, 'b');

        System.out.println(ls);// [a, 1, b]
    }

    /**
     * @Description 添加全部
     */
    @Test
    public void addAll() {
        // <M> public boolean addAll(Collection<? extends E> c)
        // <改> 向 List 末尾添加一个集合元素，并改变这个集合
        // <M> public boolean addlsl(int index, Collection<? extends E> c)
        // <改> 向 List 中特定索引位置添加一个集合元素，并改变这个集合；如果索引已有元素，则被往后挤。

        List ls = new ArrayList();
        List ls1 = Arrays.asList(1, 2, 6);
        List ls2 = Arrays.asList(3, 4, 5);

        ls.addAll(ls1);
        System.out.println(ls);// [1, 2, 6]

        ls.addAll(2, ls2);
        System.out.println(ls);// [1, 2, 3, 4, 5, 6]
    }

    /**
     * @Description 检索
     */
    @Test
    public void indexOf() {
        // <M> int indexOf(Object o)
        // <改> 返回集合中首次出现的索引值，找不到返回-1
        // <注> 底层使用 equlss 比对是否存在，所以引用类型的元素需要重写 equlss 方法
        List ls = Arrays.asList(1, "2", '3', new Pet("棒子"), new Person("米国"));
        System.out.println(ls.indexOf('3'));
        System.out.println(ls.indexOf(new Pet("棒子")));// -1，Pet没有重写 equlss 方法
        System.out.println(ls.indexOf(new Person("米国")));// 4
    }

    /**
     * @Description 检索
     */
    @Test
    public void lastIndexOf() {
        // <M> int indexOf(Object o)
        // <改> 返回集合中末次出现的索引值，找不到返回-1
        // <注> 底层使用 equlss 比对是否存在，所以引用类型的元素需要重写 equlss 方法
        List lis1 = Arrays.asList(1, 2, 3, 2);
        System.out.println(lis1.lastIndexOf(2));
    }

    /**
     * @Description 删除
     */
    @Test
    public void remove() {
        // <M> E remove(int index)
        // <改> 删除集合索引位置的元素，找不到报 IndexOutOfBoundsException
        // <返> 返回被删除的元素
        // <注> Collection中的 remove 是 boolean remove(Object o)，这是重载方法
        List ls = new LinkedList();
        ls.add(1);
        ls.add(2);
        Object remove = ls.remove(1);
        System.out.println(remove);
        System.out.println(ls);
        // ls.remove(2);// IndexOutOfBoundsException
    }

    /**
     * @Description 获取
     */
    @Test
    public void get() {
        // <M> E get(int index)
        // <返> 获取集合索引位置的元素，找不到报 IndexOutOfBoundsException
        List ls = new ArrayList();
        System.out.println(ls.get(1));
    }

    /**
     * @Description 设置
     */
    @Test
    public void set() {
        // <M> E set(int index, E element)
        // <改> 设置集合索引位置的元素，找不到报 IndexOutOfBoundsException
        // <返> 返回被替换的元素
        List ls = new ArrayList();
        ls.add(1);
        Object a = ls.set(0, 'a');
        System.out.println(a);
        System.out.println(ls);
    }

    /**
     * @Description 截取
     */
    @Test
    public void subList() {
        // <M> List<E> subList(int fromIndex, int toIndex)
        // <返> 返回截取的部分的list
        List ls = new ArrayList();
        ls.add(1);
        ls.add(2);
        ls.add(3);

        List list2 = ls.subList(1, 3);
        System.out.println(ls);
        System.out.println(list2);

        list2.add(1, 'o');
        System.out.println(list2);
    }

    /**
     * @Description 数组转List
     * （详见JavaBase\src\常用类\Arrays）
     */
    @Test
    public void asList() {
        // <M> public static <T> List<T> asList
        List<Integer> ls = Arrays.asList(1, 2, 3);
        System.out.println(ls);
    }
}
