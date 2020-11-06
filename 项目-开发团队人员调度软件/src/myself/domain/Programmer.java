package myself.domain;

import myself.service.Status;

/**
 * @Description 程序员
 */
public class Programmer extends Employee{

    private int memberId;// TID 开发团队中的Id
    private Status status = Status.FREE;// 状态
    private Equipment equipment;// 设备

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "memberId=" + memberId +
                ", status=" + status +
                ", equipment=" + equipment +
                '}';
    }
}
