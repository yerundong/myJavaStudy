package 类.构造方法;

public class TestConstructor {
    String brand;
    String model;
    int year;
    String slogan;

    public TestConstructor(){
        System.out.println("构造方法1执行！");
    }

    public TestConstructor(String brand, String model, int year, String slogan){
        System.out.println("构造方法2执行！");
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.slogan = slogan;
    }
    public void say(){
        System.out.println("brand: " + this.brand + ", model: " + this.model + ", year: " + this.year + ", slogan: " + this.slogan);
    }
}