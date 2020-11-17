package 多线程.线程安全.死锁;

/**
 @死锁原因： 不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源，就形成了线程的死锁

 @注： 出现死锁后，不会出现异常，不会出现提示，只是所有的线程都处于阻塞状态，无法继续。所以需要避免死锁的出现。

 @解决方法：
     1.专门的算法、原则
     2.尽量减少同步资源的定义
     3.尽量避免嵌套同步
 */
public class Base {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        new Thread(){
            @Override
            public void run() {
                synchronized (s1){
                    s1.append('a');

                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2){
                        s1.append('b');
                    }

                    System.out.println(s1);
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                synchronized (s2){
                    s1.append('c');

                    synchronized (s1){
                        s1.append('d');
                    }

                    System.out.println(s1);
                }
            }
        }.start();
    }
}
