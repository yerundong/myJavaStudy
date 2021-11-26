package 方法;

public class Base {
    public static void main(String[] args) {
        farmer();
        seller();
        cook();
        customer();
        if (false) {
            return;
        }

        // 以下报错：
        // void v = customer();
        // System.out.println(customer());

    }

    // 农民
    public static void farmer() {
        System.out.println("I am farmer!");
    }

    // 商贩
    public static void seller() {
        System.out.println("I am seller!");
    }

    // 商贩
    public static void cook() {
        System.out.println("I am cook!");
    }

    // customer
    public static void customer() {
        System.out.println("I am customer!");
    }
}
