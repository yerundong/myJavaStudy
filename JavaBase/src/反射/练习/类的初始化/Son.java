package 反射.练习.类的初始化;

public class Son extends Father {
    static int a = 2;
    static final int A = 2;

    public static void steady() {

    }

    static {
        System.out.println("已初始化Son类");
    }
}
