package 多线程.线程安全.死锁问题;


/**
 * @Description 线程一持有s1锁，需要s2锁，才能执行下一步；线程二持有s2锁，需要s1锁，才能执行下一步。彼此僵持着，造成死锁。
 */
public class Base {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        new Thread() {
            @Override
            public void run() {
                synchronized (s1) {
                    s1.append('a');

                    // 阻塞增加死锁概率
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2) {
                        s1.append('b');
                    }

                    System.out.println("线程一：" + s1);
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                synchronized (s2) {
                    s1.append('c');

                    synchronized (s1) {
                        s1.append('d');
                    }

                    System.out.println("线程二：" + s1);
                }
            }
        }.start();

        // 主线程依然正常执行
        System.out.println("主线程");
    }
}
