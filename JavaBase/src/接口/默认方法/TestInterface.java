package 接口.默认方法;

public interface TestInterface {
    // 默认方法：
    public default void says(){
        System.out.println("i am TestInterface default says");
    };
}
