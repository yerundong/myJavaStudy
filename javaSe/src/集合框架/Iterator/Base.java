package 集合框架.Iterator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Base {
    /**
     * @Description 获取迭代器
     */
    @Test
    public void iterator() {
        // <M> Iterator<E> iterator()
        // <返> Collection接口继承了 Iterator，Iterator提供 iterator 返回迭代器实例
        Collection clt = Arrays.asList("a", "b");
        Iterator it = clt.iterator();
        System.out.println(it);

        // <注> iterator每次执行都会重置迭代器的指针位置
        System.out.println(it.next());// a
        it = clt.iterator();// 重置
        System.out.println(it.next());// a
        System.out.println(it.next());// b
    }

    /**
     * @Description 迭代
     */
    @Test
    public void next() {
        // <M> E next() 会返回迭代器的下一个元素，并且更新迭代器的状态。
        Collection clt = Arrays.asList("abc", 123, 'd');
        Iterator it = clt.iterator();
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        // System.out.println(it.next());// 报错，NoSuchElementException，找不到元素
    }

    /**
     * @Description 检测是否还有元素
     */
    @Test
    public void hasNext() {
        // <M> boolean hasNext() 检测集合中是否还有元素，避免出现 NoSuchElementException 这样的异常
        Collection clt = Arrays.asList("abc", 123, 'd');
        Iterator it = clt.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    @Test
    public void 遍历集合() {
        Collection clt = Arrays.asList("abc", 123, '；');
        Iterator it = clt.iterator();

        // while
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // 也可以用 for 循环
        for (Object o : clt) {
            System.out.println(o);
        }

        // 还可以这样写
        for (Iterator it2 = clt.iterator(); it.hasNext(); ) {
            System.out.println(it2.next());
        }
    }

    /**
     * @Description 删除
     */
    @Test
    public void remove() {
        // <M> default void remove()
        // <改> 将指针所在位置的集合元素删除，改变原集合
        // <注>
        // 1.指针不能在初始位，因为初始位指针不指向任何元素，无法锁定移除目标，此时会报 IllegalStateException，故remove之前必先执行 next()
        // 2.同一个指针处只能执行一次 remove()，否则会报 IllegalStateException
        // 3.迭代器的 remove() 不同于 集合的 remove()？？？？？？？？？
        Collection clt = new ArrayList();
        clt.add('a');
        clt.add(1);
        clt.add("螟蛉");
        Iterator it = clt.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if ("螟蛉".equals(next)) {
                it.remove();
            }
        }

        System.out.println(clt);// [a, 1]
    }

}
