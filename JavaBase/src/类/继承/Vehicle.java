package 类.继承;

public class Vehicle {
    public String tip = "Vehicle tip";
    private String name;
    private boolean isCarry = true;

    public Vehicle() {
    }

    public Vehicle(String name) {
        this.name = name;
    }

    Object says (){
        System.out.println("我叫：" + name +"，是一种交通工具" );
        return null;
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
