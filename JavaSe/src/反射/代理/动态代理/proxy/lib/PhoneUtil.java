package 反射.代理.动态代理.proxy.lib;

public class PhoneUtil {
    public static void productBefore() {
        System.out.println("~~~ hello mifans ~~~");
        System.out.println("~~~ are you ok ~~~");
    }

    public static void productAfter() {
        System.out.println("~~~ thank you ~~~");
    }
}
