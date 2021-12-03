package 比较器.定制排序;

import org.junit.jupiter.api.Test;
import 比较器.自然排序.Goods;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class Main {
    @Test
    public void compare() {
        Goods g1 = new Goods("华为", 2999);
        Goods g2 = new Goods("小米", 1899);
        Goods g3 = new Goods("小米", 2899);
        GoodsComparator gc = new GoodsComparator();
        System.out.println(gc.compare(g1, g2));
        System.out.println(gc.compare(g2, g3));
    }

    @Test
    public void Arrays_sort() {
        Goods[] arr = new Goods[6];
        arr[0] = new Goods("华为", 2999);
        arr[1] = new Goods("小米", 1899);
        arr[2] = new Goods("苹果", 8900);
        arr[3] = new Goods("一加", 4200);
        arr[4] = new Goods("三星", 5200);
        arr[5] = new Goods("三星", 6200);
        Arrays.sort(arr, new GoodsComparator());
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void 匿名写法() {
        Goods[] arr = new Goods[6];
        arr[0] = new Goods("华为", 2999);
        arr[1] = new Goods("小米", 1899);
        arr[2] = new Goods("苹果", 8900);
        arr[3] = new Goods("一加", 4200);
        arr[4] = new Goods("三星", 5200);
        arr[5] = new Goods("三星", 6200);
        Arrays.sort(arr, new Comparator<Goods>() {
            @Override
            public int compare(Goods g1, Goods g2) {
                int nameCompare = g2.getName().compareTo(g1.getName());
                if (nameCompare == 0) {
                    return Double.compare(g2.getPrice(), g1.getPrice());
                }

                return nameCompare;
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void Lambda写法() {
        Goods[] arr = new Goods[6];
        arr[0] = new Goods("华为", 2999);
        arr[1] = new Goods("小米", 1899);
        arr[2] = new Goods("苹果", 8900);
        arr[3] = new Goods("一加", 4200);
        arr[4] = new Goods("三星", 5200);
        arr[5] = new Goods("三星", 6200);
        Arrays.sort(arr, (g1, g2) -> {
            int nameCompare = g2.getName().compareTo(g1.getName());
            if (nameCompare == 0) {
                return Double.compare(g2.getPrice(), g1.getPrice());
            }

            return nameCompare;
        });
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @???
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
