package myself.domain;

import myself.service.Status;

/**
 * @Description 程序员
 */
public class Programmer extends Employee{

    private int teamId;// TID 开发团队Id
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
        return getBaseInfo() + "\t程序员\t" + getStatus() + "\t     \t    \t" + getEquipment();
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
