package 接口.多重实现;

public class TestClass implements TestInterface1, TestInterface2 {
    // 常量重复，重声明隐藏接口常量
    // public static final String NAME = "TestClass name";

    // 默认方法重复，必须重写
    @Override
    public void def(){
        System.out.println("我是 TestClass 的 def 方法");
    }

    //　多个接口有重复抽象方法，只用重写一次
    @Override
    public void says() {
        // System.out.println(TestClass.NAME);
    }
}
