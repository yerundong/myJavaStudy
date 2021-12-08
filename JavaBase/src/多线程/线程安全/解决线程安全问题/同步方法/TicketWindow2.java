package 多线程.线程安全.解决线程安全问题.同步方法;

/**
 * @Description 继承式
 */
public class TicketWindow2 extends Thread {
    private static int ticket = 100;

    public TicketWindow2() {
    }

    public TicketWindow2(String name) {
        super(name);
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
    // 同步监视器是：Class对象
    private synchronized static boolean handleTicket() {

        // sleep让重票概率更高
        try {
            sleep(10);
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
