package 接口.默认方法;

public class TestClass implements TestInterface {

    @Override
    public void says1() {
        System.out.println("i am TestClass says1");
    }

    // 默认方法不是必需重写，因为他不是抽象的
    // @Override
    // public void says2() {
    //
    // }
}
