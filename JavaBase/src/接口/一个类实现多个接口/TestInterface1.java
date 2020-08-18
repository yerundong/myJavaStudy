package 接口.一个类实现多个接口;

public interface TestInterface1 {
    public String name = "TestInterface1 name";

    public void says();

    public default void def(){
        System.out.println("我是 TestInterface1 的 def 方法");
    }

    public default void def1(){
        System.out.println("我是 TestInterface1 的 def1 方法");
    }
}
