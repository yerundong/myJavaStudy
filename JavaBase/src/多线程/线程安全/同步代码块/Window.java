package 多线程.线程安全.同步代码块;

import static java.lang.Thread.sleep;

public class Window implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            // 锁只要是唯一对象即可
            // synchronized (getClass()) {
            // synchronized (Window.class) {
            synchronized (this) {
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
            }
        }
    }
}
