package 集合框架.Collections;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.text.CollationKey;
import java.text.Collator;
import java.util.*;

/**
 @Collections： 操作Collection、Map的工具类
 */
public class Base {

    /**
     * @Description 反转
     */
    @Test
    public void reverse(){
        // <SM> public static void reverse(List<?> list)
        // <改> 反转指定列表中元素的顺序，并改变集合
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Collections.reverse(arrayList);
        System.out.println(arrayList);
    }

    /**
     * @Description 随机
     */
    @Test
    public void shuffle(){
        // <SM> public static void shuffle(List<?> list)
        // <改> 使用默认的随机源随机排列指定的列表。 所有排列都以大致相等的可能性发生。
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Collections.shuffle(arrayList);
        System.out.println(arrayList);
    }

    /**
     * @Description 排序
     */
    @Test
    public void sort(){
        // <SM> public static <T extends Comparable<? super T>> void sort(List<T> list)
        // <改> 对集合元素自然排序
        // <SM> public static <T> void sort(List<T> list, Comparator<? super T> c)
        // <改> 对集合元素定制排序
        ArrayList arrayList = new ArrayList();
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        Collections.sort(arrayList);
        System.out.println(arrayList);
        Collections.sort(arrayList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Integer && o2 instanceof  Integer){
                    Integer i1 = (Integer)o1;
                    Integer i2 = (Integer)o2;
                    return Integer.compare(i2, i1);
                }
                return 0;
            }
        });
        System.out.println(arrayList);
    }

    /**
     * @Description 交换
     */
    @Test
    public void swap(){
        // <SM>  public static void swap(List<?> list, int i, int j)
        // <改> 交换指定列表中指定位置的元素。
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Collections.swap(arrayList, 1, 2);
        System.out.println(arrayList);
    }

    /**
     * @Description 最大值
     */
    @Test
    public void max(){
        // <SM> public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll)
        // <返> 根据元素的自然排序，返回最大值。
        // <SM> public static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp)
        // <返> 根据元素的定制排序，返回最大值。
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(-10);
        Comparable max1 = Collections.max(arrayList);
        // 定制排序：绝对值最大
        Object max2 = Collections.max(arrayList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o1 instanceof Integer) {
                    int n1 = Math.abs((Integer) o1);
                    int n2 = Math.abs((Integer) o2);
                    return Integer.compare(n1, n2);
                }
                return 0;
            }
        });
        System.out.println(max1);// 3
        System.out.println(max2);// -10
    }

    /**
     * @Description 最小值
     */
    @Test
    public void min(){
        // <SM> public static <T extends Object & Comparable<? super T>> T min(Collection<? extends T> coll)
        // <返> 根据元素的自然排序，返回最小值
        // <SM> public static <T> T min(Collection<? extends T> coll, Comparator<? super T> comp)
        // <返> 根据元素的定制排序，返回最小值
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(-10);
        Comparable min1 = Collections.min(arrayList);
        // 定制排序：绝对值最小
        Object min2 = Collections.min(arrayList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o1 instanceof Integer) {
                    int n1 = Math.abs((Integer) o1);
                    int n2 = Math.abs((Integer) o2);
                    return Integer.compare(n1, n2);
                }
                return 0;
            }
        });
        System.out.println(min1);// -10
        System.out.println(min2);// 1
    }

    /**
     * @Description 元素出现次数
     */
    @Test
    public void frequency(){
        // <SM> public static int frequency(Collection<?> c, Object o)
        // <返> 返回集合中特定元素出现的次数
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(1);
        int frequency = Collections.frequency(arrayList, 1);
        System.out.println(frequency);
    }

    /**
     * @Description 复制
     */
    @Test
    public void copy(){
        // <SM> public static <T> void copy(List<? super T> dest, List<? extends T> src)
        // <改> 将 list src 复制到 list dest 中，从头开始替换dest中的元素
        // <注> dest 的 size 必须 <= dest 的 size
        List srcList = Arrays.asList('a', 'b', 'c', 'd');
        // List destList = Arrays.asList();// 长度不够，IndexOutOfBoundsException：Source does not fit in dest
        List destList = Arrays.asList(new Object[srcList.size()]);
        System.out.println(destList);// [null, null, null, null]

        Collections.copy(destList, srcList);
        System.out.println(destList);
    }

    /**
     * @Description 替换全部
     */
    @Test
    public void replaceAll(){
        // <SM> public static <T> boolean replaceAll(List<T> list, T oldVal, T newVal)
        // <改> 以 newVal 替换 list 中全部 的 oldVal
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(1);
        Collections.replaceAll(arrayList, 1, 'a');
        System.out.println(arrayList);
    }

    /**
     * @Description 同步列表
     */
    @Test
    public void synchronizedXxx(){
        // <SM> public static <T> List<T> synchronizedList(List<T> list)
        // <返> 返回由指定列表支持的同步（线程安全）列表。
        // <注> 将传入的集合进行同步，解决线程同步问题。为了保证串行访问，通过返回的列表完成对后台列表的所有访问，
        //      这种方式相当于对集合进行了二次包装，在内部加了一把锁。

        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        List list = Collections.synchronizedList(arrayList);
        list.add(4);// 这 add() 是调用 Collections 内部类 SynchronizedList 的 add()，是一个同步操作
        System.out.println(list);
        System.out.println(arrayList);

        Collection collection = Collections.synchronizedCollection(arrayList);
        collection.remove(4);
        System.out.println(arrayList);
    }
}
