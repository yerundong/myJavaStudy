package 比较器.自然排序;

/**
 @定制排序： Comparable 接口强行对实现它的每个类的对象进行整体排序。这种排序被称为类的自然排序

 @步骤：
    1.需要排序的类要实现 Comparable 接口，并重写 compareTo 方法；
    2.在 compareTo 接口里，比较该类的两个实例的属性，按特定的规则比较一个或若干个属性，返回1\-1\0三个值；
    3.1代表往后排，-1往前排，0不变

 @实现Comparable的类（默认都是从小到大排列的）：
    1.包装类
    2.String
    3.Date、Time
 
 @注： 实现 Comparable 接口的对象列表（和数组）可以通过 Collections.sort 或 Arrays.sort 进行自动排序。

 */
public class Goods implements Comparable {
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
     * @Description 比较器：按价格从低到高
     */
    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods){
            Goods g = (Goods)o;
            // 方式一：
            if(this.price > g.price){
                return 1;
            }else if (this.price < g.price){
                return -1;
            }else{
                // 若不比较名称：
                // return 0;
                // 若价格相等还需比较名称：
                return g.name.compareTo(this.name);
            }

            // 方式二：
            // return Double.compare(this.price, g.price);
        }
        throw new RuntimeException("传入的参数非Goods对象");
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
