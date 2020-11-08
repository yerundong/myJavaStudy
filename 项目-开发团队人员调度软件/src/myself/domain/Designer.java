package myself.domain;

/**
 * @Description 设计师
 */
public class Designer extends Programmer {

    private double bonus;// 奖金

    public Designer() {

    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getBaseInfo() + "\t设计师\t" + getStatus() + "\t"+ getBonus() +"\t    \t" + getEquipment();
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

}
