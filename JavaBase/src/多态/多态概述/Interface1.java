package 多态.多态概述;

public interface Interface1 {
    String TIP = "Interface1 TIP";

    default void says() {
        System.out.println("我是 Interface1 的 says()");
    }

    default void look() {
        System.out.println("我是 Interface1 特有的 look()");
    }
}
