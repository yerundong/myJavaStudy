package 类和对象.练习.员工工资;

/**
 * @Description 员工抽象类
 */
public abstract class Employee {

    private String name;// 姓名
    private int number;// 工号
    private MyDate birthday;// 生日

    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public abstract double earnings();

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
}
