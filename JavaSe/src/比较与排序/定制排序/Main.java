package 比较与排序.定制排序;

import org.junit.jupiter.api.Test;
import 比较与排序.自然排序.Goods;

import java.util.Arrays;
import java.util.Comparator;

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
     * @comparing： 接收一个类的属性，作为排序排序关键字，返回这个类的比较器（Comparator）
     */
    @Test
    public void comparing() {
        Goods[] arr = new Goods[6];
        arr[0] = new Goods("华为", 2999);
        arr[1] = new Goods("小米", 1899);
        arr[2] = new Goods("苹果", 8900);
        arr[3] = new Goods("一加", 4200);
        arr[4] = new Goods("三星", 5200);
        arr[5] = new Goods("三星", 6200);

        Comparator<Goods> comparator = Comparator.comparing(Goods::getPrice);
        Arrays.sort(arr, comparator);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @
     */
    @Test
    public void comparingInt() {
        Integer[] arr = new Integer[]{2, 57, 1, 25, 46, 7, 22};
        Comparator<Integer> comparator = Comparator.comparingInt(t -> t);
        Arrays.sort(arr, comparator);
        System.out.println(Arrays.toString(arr));
    }
}
