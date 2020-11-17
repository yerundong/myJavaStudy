package 多线程.线程安全.lock锁;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class Window implements Runnable {
    private int ticket = 100;

    // 1.创建锁
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                // 2.锁上
                lock.lock();

                // sleep让重票概率更高
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "余票：" + ticket);
                    ticket--;
                } else {
                    break;
                }

                // 报错
                // int[] arr = {};
                // System.out.println(arr[3]);
            } finally {
                // 3.解锁
                lock.unlock();
            }
        }
    }
}
