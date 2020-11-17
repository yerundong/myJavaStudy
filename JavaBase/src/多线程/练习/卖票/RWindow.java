package 多线程.练习.卖票;

import static java.lang.Thread.sleep;

public class RWindow implements Runnable{
    private int ticket = 100;
    Object lock = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (lock) {
                if (ticket > 0) {
                    try {
                        sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "余票：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
