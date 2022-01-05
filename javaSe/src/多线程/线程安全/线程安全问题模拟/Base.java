package 多线程.线程安全.线程安全问题模拟;

public class Base {
    public static void main(String[] args) {
        // test1();
        test2();
    }

    /**
     * @单个线程不会出现安全问题
     */
    public static void test1() {
        TicketWindow ticketWindow = new TicketWindow();
        Thread rw1 = new Thread(ticketWindow, "窗口一");

        rw1.start();
    }

    /**
     * @多个线程出现安全问题: 1.重票 2.错号票，如-1
     */
    public static void test2() {
        TicketWindow ticketWindow = new TicketWindow();
        Thread rw1 = new Thread(ticketWindow, "窗口一");
        Thread rw2 = new Thread(ticketWindow, "窗口二");
        Thread rw3 = new Thread(ticketWindow, "窗口三");

        rw1.start();
        rw2.start();
        rw3.start();
    }
}
