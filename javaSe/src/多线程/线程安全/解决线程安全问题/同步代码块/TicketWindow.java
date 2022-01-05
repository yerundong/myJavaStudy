package 多线程.线程安全.解决线程安全问题.同步代码块;

public class TicketWindow implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            // 锁只要是唯一对象即可
            // synchronized (this) {
            // synchronized (getClass()) {
            // synchronized (Window.class) {
            synchronized (TicketWindow.class) {
                // 此处阻塞让重票概率更高
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (ticket > 0) {
                    // 此处阻塞让错号票概率更高
                    // try {
                    //     Thread.sleep(100);
                    // } catch (InterruptedException e) {
                    //     e.printStackTrace();
                    // }

                    System.out.println(Thread.currentThread().getName() + "余票：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
