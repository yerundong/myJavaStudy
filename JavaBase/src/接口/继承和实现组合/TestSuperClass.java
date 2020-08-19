package 接口.继承和实现组合;

public abstract class TestSuperClass {
    public static final String MY_CONST = "TestSuperClass MY_CONST";

    public abstract void says();

    public void look(){
        System.out.println("TestSuperClass look()");
    };

    public static void see(){
        System.out.println("TestSuperClass see()");
    };
}
