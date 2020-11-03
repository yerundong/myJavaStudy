package 类和对象.练习.员工工资;

/**
 * @Description 拿时薪的员工
 */
public class HourlyEmployee extends Employee {

    private double wage;// 时薪
    private double hour;// 小时数

    public HourlyEmployee(String name, int number, MyDate birthday, double wage, double hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    @Override
    public double earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee" + "{ " + super.toString() + ", wage=" + wage + ", hour=" + hour + " }";
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }
}
