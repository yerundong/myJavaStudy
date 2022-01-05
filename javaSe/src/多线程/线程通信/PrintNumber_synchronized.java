package 多线程.线程通信;

/**
 * @Description 让各线程交替打印数字
 */
public class PrintNumber_synchronized implements Runnable {
    private int num = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();// 唤醒另外一个被wait的线程

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
                    wait();// 使当前线程状态变成等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
