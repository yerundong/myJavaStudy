package 多线程.线程安全.解决线程安全问题.同步方法;

/**
 * @Description 实现式
 */
public class TicketWindow1 implements Runnable {
    private static int ticket = 100;

    public TicketWindow1() {
    }

    @Override
    public void run() {
        while (true) {
            if (handleTicket()) {
                break;
            }
        }
    }

    // 同步方法
    // 同步监视器是：this
    private synchronized boolean handleTicket() {

        // sleep让重票概率更高
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (ticket > 0) {

            System.out.println(Thread.currentThread().getName() + "余票：" + ticket);
            ticket--;

            return false;
        } else {
            return true;
        }
    }
}
