package 多线程.线程安全.解决线程安全问题.同步代码块;

public class Main {
    public static void main(String[] args) {
        TicketWindow ticketWindow = new TicketWindow();
        Thread rw1 = new Thread(ticketWindow, "窗口一");
        Thread rw2 = new Thread(ticketWindow, "窗口二");
        Thread rw3 = new Thread(ticketWindow, "窗口三");

        rw1.start();
        rw2.start();
        rw3.start();
    }
}
