package 比较与排序.自然排序;

public class Goods implements Comparable<Goods> {
    private String name;
    private double price;

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /**
     * @Description 按价格从低到高，名称从a-z排序
     */
    @Override
    public int compareTo(Goods g) {
        // 方式一：
        int priceCompare = Double.compare(this.price, g.price);
        if (priceCompare == 0) {
            return g.name.compareTo(this.name);
        }
        return priceCompare;

        // 方式二：
        // if (this.price > g.price) {
        //     return 1;
        // } else if (this.price < g.price) {
        //     return -1;
        // } else {
        //     // 若价格相等还需比较名称：
        //     return g.name.compareTo(this.name);
        // }
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
