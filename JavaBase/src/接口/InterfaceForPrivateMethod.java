package 接口;
/*
@ InterfaceForPrivateMethod：接口中的私有方法

从Java 9开始，接口里允许定义私有方法

@ 注意事项：
    1.私有方法非抽象方法，必带有方法体


格式：
private static 返回值类型 方法名称(参数列表) {
    方法体
}

*/
public interface InterfaceForPrivateMethod {
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
        System.out.println("i am InterfaceForPrivateMethod static says1");
    }

    // 静态私有方法：
    private static void says4(){
        System.out.println("i am InterfaceForPrivateMethod static says2");
    }
}
