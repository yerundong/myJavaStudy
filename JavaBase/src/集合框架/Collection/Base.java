package 集合框架.Collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 @Collection接口: 统一定义了一套单列集合的接口，它规定它的子接口及其实现类都必须满足它重新设定的规则。是List和Set的父接口。

 @注意事项：
        1.要求Collection接口的实现类的对象添加数据obj时，要求obj所在类需要重写equals方法。
 */
public class Base {
    /**
     * @Description 添加
     */
    @Test
    public void add(){
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
     * @Description 添加
     */
    @Test
    public void addAll(){
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
     * @Description 个数，长度
     */
    @Test
    public void size(){
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
    public void isEmpty(){
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
    public void clear(){
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
    public void contains(){
        // <M> boolean contains(Object o);
        // <返> 如果此集合包含指定的元素，则返回true
        // <注> 底层是调用o的equals()方法进行判定是否包含
        Collection clt = new ArrayList();
        clt.add('a');
        clt.add(new String("b"));
        System.out.println(clt.contains('a'));
        System.out.println(clt.contains(new String("b")));// true 调用了String的equals()
    }
}
