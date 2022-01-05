package 类和对象.抽象类和抽象方法;

public class Main {
    public static void main(String[] args) {

        // new AbsClass1();// 错误，无法实例化抽象类

        CommonClass1 cm1 = new CommonClass1();
        cm1.says();
        cm1.run();

        System.out.println("===============================");

        CommonClass2 cm2 = new CommonClass2();
        cm2.says();
        cm2.run();
    }
}
