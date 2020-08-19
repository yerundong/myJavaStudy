package 接口.继承和实现组合;

public class TestSubClass extends TestSuperClass implements TestInterface {
    // 隐藏父类和继承的静态变量
    // public static final String MY_CONST = "TestSubClass MY_CONST";

    @Override
    public void says() {
        System.out.println("TestSubClass says()");
    }
}
