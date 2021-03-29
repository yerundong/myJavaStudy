package 集合框架.Collection;

import org.junit.jupiter.api.Test;
import 示例.Pet;
import 示例.Species;

import java.util.*;

/**
 @Collection接口: Collection 是最基本的集合接口，存储一个元素集合，集合框架中最顶级的接口。其子接口和实现类都必须满足它重新设定的规则。

 @特性：
    1.继承了 Iterator 接口
    2.由于Set是无序的，所以Collection不提供索引相关的特性，所以也没有类似get和set方法用于取值设值

 @注意事项：
    1.要求Collection接口的实现类（不管是有序的List还是无序的Set）的对象添加数据obj时，要求obj所在类需要重写equals方法，因为集合的许多方法（如：contains、remove、equals...）
      都会调用到元素的equals方法。

 */
public class Base {
    /**
     * @Description 添加
     */
    @Test
    public void add() {
        // <M> boolean add(E e)
        // <改> 向集合中添加一个元素，并改变这个集合
        // <返> 添加成功返回true，添加失败返回false。
        // <添加失败的情况>
        // 1.如果该集合不允许重复并且已经包含指定的元素；
        // 2.部分子类的add方法可能会限制添加到集合中的元素类型，或者不会将NULL添加到集合中。
        Collection clt = new ArrayList();
        clt.add('a');
        clt.add('b');
        clt.add(123);
        clt.add('b');
        clt.add(null);
        System.out.println(clt);
    }

    /**
     * @Description 添加全部
     */
    @Test
    public void addAll() {
        // <M> boolean addAll(Collection<? extends E> c);
        // <改> 向集合中添加另一个集合的所有元素，并改变这个集合
        // <返> 添加成功返回true，添加失败返回false。
        Collection clt1 = new ArrayList();
        Collection clt2 = new ArrayList();
        clt1.add('b');
        clt1.add('c');
        clt2.add('a');
        clt2.addAll(clt1);
        System.out.println(clt2);
    }

    /**
     * @Description 移除
     */
    @Test
    public void remove() {
        // <M> boolean remove(Object o);
        // <改> 移除元素 o，通过equals判定是否存在，注意调用一次只能移除一个
        // <返> 移除成功，则返回true。
        // <异常>
        // ClassCastException - 如果指定元素的类型与此集合不兼容（ optional ）
        // NullPointerException - 如果指定的元素为空，并且此集合不允许空元素（ optional ）
        // UnsupportedOperationException - 如果此 集合不支持remove操作
        Collection clt = new ArrayList();
        clt.add('a');
        clt.add('b');
        clt.add('a');
        clt.add(null);
        clt.remove('a');
        clt.remove(null);
        System.out.println(clt);// [b, a]
    }

    /**
     * @Description 移除全部
     */
    @Test
    public void removeAll() {
        // <M> boolean removeAll(Collection<?> c);
        // <改> 移除全部c中的所有元素，通过equals判定是否存在
        // <返> 移除成功，则返回true。
        Collection clt1 = new ArrayList();
        clt1.add('a');
        clt1.add('b');
        clt1.add('a');
        clt1.add('c');
        clt1.removeAll(Arrays.asList('a', 'b'));
        System.out.println(clt1);// [c]
    }

    /**
     * @Description 个数，长度
     */
    @Test
    public void size() {
        // <M> int size();
        // <返> 返回集合个数；如果此 collection 包含的元素大于 Integer.MAX_VALUE，则返回 Integer.MAX_VALUE。
        Collection clt = new ArrayList();
        clt.add('a');
        clt.add('b');
        clt.add(123);
        System.out.println(clt.size());
    }

    /**
     * @Description 判空
     */
    @Test
    public void isEmpty() {
        // <M> boolean isEmpty();
        // <返> 判断集合是否为空，没有任何元素，即size==0
        Collection clt1 = new ArrayList();
        Collection clt2 = new ArrayList();
        clt1.add(null);
        System.out.println(clt1.isEmpty());// false
        System.out.println(clt2.isEmpty());// true
    }

    /**
     * @Description 清空
     */
    @Test
    public void clear() {
        // <M> boolean isEmpty();
        // <改> 清空集合的所有元素，使得size==0
        Collection clt = new ArrayList();
        clt.add('a');
        clt.add('b');
        clt.add(null);
        System.out.println(clt);
        clt.clear();
        System.out.println(clt);
    }

    /**
     * @Description 包含
     */
    @Test
    public void contains() {
        // <M> boolean contains(Object o);
        // <返> 如果此集合包含指定的元素，则返回true
        // <注> 底层是调用o的equals()方法进行判定是否包含
        Collection clt = new ArrayList();
        clt.add("a");
        clt.add(new String("b"));
        System.out.println(clt.contains("a"));
        System.out.println(clt.contains(new String("b")));// true 调用了String的equals()
    }

    /**
     * @Description 包含所有
     */
    @Test
    public void containsAll() {
        // <M> boolean containsAll(Collection<?> c)
        // <返> 如果此集合包含指定集合c中的所有元素，则返回true。
        Collection clt1 = new ArrayList();
        clt1.add("a");
        clt1.add("b");
        clt1.add("c");

        Collection clt2 = Arrays.asList("a", "c");
        System.out.println(clt1.containsAll(clt2));
    }

    /**
     * @Description 保留
     */
    @Test
    public void retainAll() {
        // <M> boolean retainAll(Collection<?> c);
        // <改> 保留此集合包含指定c集合中的所有元素，其余删除；注意：如果集合c包含该集合中所有的元素，因为无意义，所以会操作失败
        // <返> 操作成功，则返回true，操作失败返回false。
        Collection clt1 = new ArrayList();
        Collection clt2 = new ArrayList();
        Collection clt3 = Arrays.asList("a", "c");
        clt1.add("a");
        clt1.add("b");
        clt1.add("c");
        clt1.add("d");

        clt2.add("a");
        clt2.add("c");

        clt1.retainAll(clt2);// true
        System.out.println(clt1);// [a, c]

        System.out.println(clt1.retainAll(clt3));// false
        System.out.println(clt1);// [a, c]
    }

    /**
     * @Description 判等
     */
    @Test
    public void equals() {
        // <M> boolean equals(Object o);
        // <返> 判定两个集合是否相等（必包括元素的内容，排序是否影响取决于具体集合实现类是有序还是无序的），元素若是引用类型，判等结果取决于引用类型元素的equals
        Collection clt1 = Arrays.asList("a", "b");
        Collection clt2 = Arrays.asList("a", "b");
        Collection clt3 = Arrays.asList("b", "a");
        Collection clt11 = Arrays.asList("a", "b", new Pet("棒子", Species.PIG));
        Collection clt22 = Arrays.asList("a", "b", new Pet("棒子", Species.PIG));
        System.out.println(clt1.equals(clt2));// true
        System.out.println(clt1.equals(clt3));// false
        System.out.println(clt11.equals(clt22));// false
    }

    /**
     * @Description 哈希值
     */
    @Test
    public void hashCode_() {
        // <M> int hashCode();
        // <返> 返回集合的哈希值
        Collection clt = Arrays.asList("a", "b");
        System.out.println(clt.hashCode());// 4066
    }

    /**
     * @Description 集合转数组
     */
    @Test
    public void toArray() {
        // <M> Object[] toArray();
        // <M> <T> T[] toArray(T[] a);???
        // <返> 集合转数组，返回数组
        Collection clt = Arrays.asList("a", "b");
        Object[] arr = clt.toArray();
        System.out.println(Arrays.toString(arr));// [a, b]
    }

    /**
     * @Description 集合遍历、迭代器
     */
    @Test
    public void iterator() {
        // <M> Object[] toArray();
        // <返> 集合转数组，返回数组
        Collection clt = Arrays.asList("a", "b");
        Iterator iterator = clt.iterator();
        System.out.println(iterator);// [a, b]
    }
}
