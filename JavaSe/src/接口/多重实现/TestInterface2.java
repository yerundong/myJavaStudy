package 接口.多重实现;

public interface TestInterface2 {
    public static final String NAME = "TestInterface2 name";

    // 抽象方法重复
    public void says();

    // 默认方法重复
    public default void def(){
        System.out.println("我是 TestInterface2 的 def 方法");
    }

    public default void def2(){
        System.out.println("我是 TestInterface2 的 def2 方法");
    }
}
