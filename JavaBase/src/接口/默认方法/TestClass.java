package 接口.默认方法;

public class TestClass implements TestInterface {

    // 重写接口中的默认方法（但不是必须，因为他不是抽象的）
    // @Override
    // public void says() {
    //
    // }

    // 重载接口中的默认方法
    public void says(int num) {
        System.out.println("i am TestClass says");
    }
}
