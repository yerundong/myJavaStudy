package 多线程.线程安全.线程安全问题模拟;

public class TicketWindow implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        while (true) {
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
                // 票卖完即止
                break;
            }
        }
    }
}
