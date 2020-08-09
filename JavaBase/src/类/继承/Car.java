package 类.继承;

public class Car extends Vehicle {
    public String tip = "Car tip";
    private String displacement;

    public Car() {
        // 无参会隐式调用super()
    }

    public Car(String name) {
        // 有参必须显式调用super()，并且必须第一执行
        super(name);
    }

    public Car(String name, String displacement) {
        super(name);
        System.out.println(super.tip);
        this.displacement = displacement;
    }

    @Override
    public String says (){
        System.out.println("我是重写方法！" );
        return "我是重写方法！";
    }

    public void pop (){
        System.out.println("我的排量是：" + displacement + "，superTip：" + super.tip + "，subTip：" + this.tip);
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }
}
