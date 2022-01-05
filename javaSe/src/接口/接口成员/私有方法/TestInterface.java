package 接口.接口成员.私有方法;

public interface TestInterface {
    // 私有方法：
    private void says1() {
        System.out.println("i am TestInterface static says1");
    }

    // 静态私有方法：
    private static void says2() {
        System.out.println("i am TestInterface static says2");
    }

}
