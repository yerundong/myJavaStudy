package 接口.抽象方法;

public class TestClass implements TestInterface {
    @Override
    public void says1() {
        System.out.println("i am TestClass says1");
    }

    @Override
    public void says2() {
        System.out.println("i am TestClass says2");
    }
}
