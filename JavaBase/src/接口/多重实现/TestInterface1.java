package 接口.多重实现;

public interface TestInterface1 {
    public static final String NAME = "TestInterface1 name";

    // 抽象方法重复
    public void says();

    // 默认方法重复
    public default void def(){
        System.out.println("我是 TestInterface1 的 def 方法");
    }

    public default void def1(){
        System.out.println("我是 TestInterface1 的 def1 方法");
    }
}
