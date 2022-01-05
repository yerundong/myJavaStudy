package 多线程.线程安全.解决线程安全问题.同步方法;


public class Main {
    public static void main(String[] args) {
        // test1();
        test2();
    }

    /**
     * @Description 实现式
     */
    public static void test1() {
        TicketWindow1 tw = new TicketWindow1();
        Thread rw1 = new Thread(tw, "窗口一");
        Thread rw2 = new Thread(tw, "窗口二");
        Thread rw3 = new Thread(tw, "窗口三");

        rw1.start();
        rw2.start();
        rw3.start();
    }

    /**
     * @Description 继承式
     */
    public static void test2() {
        Thread rw1 = new TicketWindow2("窗口一");
        Thread rw2 = new TicketWindow2("窗口二");
        Thread rw3 = new TicketWindow2("窗口三");

        rw1.start();
        rw2.start();
        rw3.start();
    }
}
