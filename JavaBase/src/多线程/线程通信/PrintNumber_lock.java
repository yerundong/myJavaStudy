package 多线程.线程通信;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 让各线程交替打印数字
 */
public class PrintNumber_lock implements Runnable {
    private int num = 1;
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();

    @Override

    public void run() {
        while (true) {
            try {
                reentrantLock.lock();
                condition.signal();

                if (num > 100) {
                    break;
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":" + num);

                num++;

                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
