package 接口.默认方法;

public interface TestInterface {
    // 抽象方法：
    void says1();

    // 默认方法：
    public default void says2(){
        System.out.println("i am TestInterface default says1");
    };
}
