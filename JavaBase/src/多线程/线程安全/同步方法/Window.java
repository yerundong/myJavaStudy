package 多线程.线程安全.同步方法;

public class Window extends Thread {
    private static int ticket = 1000;

    public Window() {
    }

    public Window(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            if(handleTicket()){
                break;
            }
        }
    }

    // 同步方法
    // 同步监视器是：class
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
