package 比较器.定制排序;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

/***
 @定制排序： 当元素的类型没有实现 java.lang.Comparable 接口而又不方便修改代码，或者实现了 java.lang.Comparable 接口的排序规则不适合当前的操作，那
 么可以考虑使用 Comparator的对象来排序，强行对多个对象进行整体排序的比较。

 @注： 1.可以 将 Comparator 传递给 sort 方法（如 Collections.sort 或 Arrays.sort 从而允许在排序顺序上实现精确控制 。
 2.可以使用 Comparator 来控制某些数据结构（如有序 set 或有序映射）的序，或者为那些没有自然顺序的对象 collection 提供排序 。
 */
public class Main {
    @Test
    public void sort() {
        // 对数组里的对象进行排序
        String[] arr = new String[]{"NN", "AA", "GG", "PP"};
        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        Arrays.sort(arr, comparator);

        // Lambda写法
        // Arrays.sort(arr, (o1, o2) -> o1.compareTo(o2));

        // 方法引用写法
        // Arrays.sort(arr, String::compareTo);

        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, new StringComparator());

        System.out.println(Arrays.toString(arr));
    }

    /**
     * @
     */
    @Test
    public void test() {
        Comparator<Integer> comparing = Comparator.comparing(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer i) {
                return i + 1;
            }
        });

    }
}
