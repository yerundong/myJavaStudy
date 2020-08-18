package 接口.一个类实现多个接口;

public interface TestInterface2 {
    public String name = "TestInterface2 name";

    public void says();

    public default void def(){
        System.out.println("我是 TestInterface2 的 def 方法");
    }

    public default void def2(){
        System.out.println("我是 TestInterface2 的 def2 方法");
    }
}
