package 多线程.线程通信;

public class Base {
    public static void main(String[] args) {
        // test1();
        test2();
    }

    /**
     * @Description synchronized同步的线程之间通讯
     */
    public static void test1() {
        PrintNumber_synchronized printNumber = new PrintNumber_synchronized();
        Thread a = new Thread(printNumber, "A");
        Thread b = new Thread(printNumber, "B");
        a.start();
        b.start();
    }

    /**
     * @Description lock同步的线程之间通讯
     */
    public static void test2() {
        PrintNumber_lock printNumber = new PrintNumber_lock();
        Thread a = new Thread(printNumber, "A");
        Thread b = new Thread(printNumber, "B");
        a.start();
        b.start();
    }
}
