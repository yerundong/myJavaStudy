package 接口.多重继承;

public interface SubInterface extends SuperInterface1, SuperInterface2 {
    // 常量隐藏
    public static final String MY_CONST = "SubInterface MY_CONST";

    // 默认方法重写
    @Override
    public default void def() {
        System.out.println("SubInterface def");
    }
}
