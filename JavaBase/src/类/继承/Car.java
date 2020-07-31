package 类.继承;

public class Car extends Vehicle {
    private String displacement;

    public Car() {
        // 无参会隐式调用super()
    }

    public Car(String name) {
        // 有参必须显式调用super()
        super(name);
    }

    public Car(String name, String displacement) {
        super(name);
        this.displacement = displacement;
    }

    public void pop (){
        System.out.println("我的排量是：" + displacement);
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }
}
