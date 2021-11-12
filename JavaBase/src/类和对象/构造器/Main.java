package 类和对象.构造器;

public class Main {
    public static void main(String[] args) {
        TestConstructor car1 = new TestConstructor();
        car1.say();

        TestConstructor car2 = new TestConstructor("本田", "思域", 2019, "以人为本,共创未来");
        car2.say();
    }
}


