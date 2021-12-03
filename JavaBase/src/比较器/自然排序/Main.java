package 比较器.自然排序;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Main {
    @Test
    public void compareTo() {
        Goods g1 = new Goods("华为", 2999);
        Goods g2 = new Goods("小米", 1899);
        System.out.println(g1.compareTo(g2));
    }

    /**
     * @对数组里的对象进行排序
     */
    @Test
    public void Arrays_sort() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("华为", 2999);
        arr[1] = new Goods("小米", 1899);
        arr[2] = new Goods("苹果", 8900);
        arr[3] = new Goods("一加", 4200);
        arr[4] = new Goods("三星", 4200);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
