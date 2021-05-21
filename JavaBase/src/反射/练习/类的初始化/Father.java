package 反射.练习.类的初始化;

public class Father {
    static int a = 1;
    static final int A = 1;

    static {
        System.out.println("已初始化Father类");
    }
}
