package 接口.继承和实现组合;

public class TestClass extends MySuperClass implements MyInterface {
    // public static final String MY_CONST = "TestClass MY_CONST";

    // 抽象方法重复：子类只需重写一次
    @Override
    public void says() {
        System.out.println("TestClass says()");
    }

    // cook抽象方法，在父类中有定义，子类继承了父类cook，实现对接口抽象方法的重写（虽然父类和接口没有关系）
    // @Override
    // public void cook(){
    //     System.out.println("MySuperClass cook()");
    // };
}
