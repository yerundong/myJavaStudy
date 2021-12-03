package 比较器.定制排序;

import 比较器.自然排序.Goods;

import java.util.Comparator;

/**
 * Goods：按名称从a-z，价格从高到低排序
 */
public class GoodsComparator implements Comparator<Goods> {
    @Override
    public int compare(Goods g1, Goods g2) {
        int nameCompare = g2.getName().compareTo(g1.getName());
        if (nameCompare == 0) {
            return Double.compare(g2.getPrice(), g1.getPrice());
        }

        return nameCompare;
    }
}
