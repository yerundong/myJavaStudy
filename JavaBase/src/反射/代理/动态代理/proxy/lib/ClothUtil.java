package 反射.代理.动态代理.proxy.lib;

public class ClothUtil {
    public static void productBefore() {
        System.out.println("处理生产衣服之前的一些准备工作-通用方法");
    }

    public static void productAfter() {
        System.out.println("处理生产衣服之后的一些后续工作-通用方法");
    }
}
