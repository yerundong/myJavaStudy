package 接口.继承和实现组合;

public interface TestInterface {
    public static final String MY_CONST = "TestInterface MY_CONST";

    public abstract void says();

    public default void look(){
        System.out.println("TestInterface look()");
    };

    public static void see(){
        System.out.println("TestInterface see()");
    };
}
