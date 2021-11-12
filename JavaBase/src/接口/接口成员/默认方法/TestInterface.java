package 接口.接口成员.默认方法;

public interface TestInterface {
    // 默认方法：
    default void says() {
        System.out.println("i am TestInterface default says");
    }

    ;
}
