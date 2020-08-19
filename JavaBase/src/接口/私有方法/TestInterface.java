package 接口.私有方法;

public interface TestInterface {
    // 默认方法：
    // 可调用普通私有方法和静态私有方法
    public default void says2(){
        says3();
        says4();
    }

    // 静态方法：
    // 这里只能调用私有静态方法
    public static void says1(){
        says4();
    }

    // 普通私有方法：
    private void says3(){
        System.out.println("i am TestInterface static says1");
    }

    // 静态私有方法：
    private static void says4(){
        System.out.println("i am TestInterface static says2");
    }
}
