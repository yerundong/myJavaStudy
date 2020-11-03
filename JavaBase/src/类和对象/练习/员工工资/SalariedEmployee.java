package 类和对象.练习.员工工资;
/**
 * @Description 拿月薪的员工
 */
public class SalariedEmployee extends Employee {

    private double monthlySalary;// 月薪

    public SalariedEmployee(String name, int number, MyDate birthday, double monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double earnings() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee" + "{ "+ super.toString() + ", monthlySalary=" + monthlySalary + " }";
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}
