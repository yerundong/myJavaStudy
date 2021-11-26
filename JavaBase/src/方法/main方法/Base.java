package 方法.main方法;

public class Base {
    public static int num = 777;

    public static void main(String[] args) {
        // new Base();
        System.out.println(Base.num);

    }

    static {
        System.out.println(123);
    }

    {
        System.out.println(456);
    }
}
