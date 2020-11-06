package myself.domain;

/**
 * @Description 架构师
 */
public class Architect extends Designer {

    private int stock;// 公司奖励的股票数量

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Architect{" +
                "stock=" + stock +
                "} " + super.toString();
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
