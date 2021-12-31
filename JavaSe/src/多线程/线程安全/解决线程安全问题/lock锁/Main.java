package 多线程.线程安全.解决线程安全问题.lock锁;

public class Main {
    public static void main(String[] args) {
        TicketWindow window = new TicketWindow();
        Thread rw1 = new Thread(window, "窗口一");
        Thread rw2 = new Thread(window, "窗口二");
        Thread rw3 = new Thread(window, "窗口三");

        rw1.start();
        rw2.start();
        rw3.start();
    }
}
