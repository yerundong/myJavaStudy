package 类;
/*
构造方法是专门用来创建对象的方法，当我们通过关键字new来创建对象时，其实就是在调用构造方法。
格式：
public 类名称(参数类型 参数名称) {
    方法体
}

注意事项：
1. 构造方法的名称必须和所在的类名称完全一样，就连大小写也要一样
2. 构造方法不要写返回值类型，连void都不写
3. 构造方法不能return
4. 如果没有编写任何构造方法，那么编译器将会默认创建一个空的构造方法（没有参数、方法体什么事情都不做：public Student() {}）。
5. 一旦编写了至少一个构造方法，那么编译器将不再默认创建。
6. 构造方法也是可以进行重载的。（重载：方法名称相同，参数列表不同）
 */
public class 构造方法 {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.say();
        System.out.println("=========================");
        Car car2 = new Car("本田", "思域", 2019, "以人为本,共创未来");
        car2.say();
    }
}

class Car{
    String brand;
    String model;
    int year;
    String slogan;

    public Car(){
        System.out.println("构造方法1执行啦！");
    }

    public Car(String brand, String model, int year, String slogan){
        System.out.println("构造方法2执行啦！");
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.slogan = slogan;
    }
    public void say(){
        System.out.println("brand: " + this.brand + ", model: " + this.model + ", year: " + this.year + ", slogan: " + this.slogan);
    }
}
