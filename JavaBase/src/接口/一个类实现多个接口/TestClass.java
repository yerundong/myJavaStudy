package 接口.一个类实现多个接口;

public class TestClass implements TestInterface1, TestInterface2 {
    public String name = "TestClass name";

    public void def(){
        System.out.println("我是 TestClass 的 def 方法");
    }

    @Override
    public void says() {
        System.out.println(this.name);
    }
}
