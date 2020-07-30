package 类.继承;

public class Vehicle {
    private String name;
    private boolean isCarry = true;

    public Vehicle() {
    }

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCarry() {
        return isCarry;
    }

    public void setCarry(boolean carry) {
        isCarry = carry;
    }
}
