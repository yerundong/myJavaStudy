package 权限修饰符.Protected修饰符;

import 权限修饰符.Protected修饰符.pack2.TestSub;

public class Main {
    public static void main(String[] args) {
        TestSub sub = new TestSub();

        // 不可见
        // System.out.println(sub.name);
        // sub.says();
        // sub.open();

        sub.says2();
    }
}
