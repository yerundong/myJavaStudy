package 多线程.继承式创建线程;

/**
 @Thread类： 线程类，代表程序中的执行线程，是 Runnable 接口的实现类

 @创建线程方式： 创建 Thread 子类：SubThread，SubThread实例化几次，就创建几个线程

 @具体步骤：
     1.创建 Thread 子类：SubThread（注：如果子类只用一次，可使用匿名子类）
     2.重写 run 方法
     3.创建 SubThread 实例
     4.实例调用 start 方法

 @Thread实例方法：
    @start()： 做了两件事：1.启动线程。2.调用该线程的 run 方法。
        注：
            1.一个线程只能启动一次，start()不能执行两次，否则报错：IllegalThreadStateException
            2.直接调用 run 方法不会创建线程，而是在主线程里执行

    @run()： 通常需要重写，将当前线程需要执行的操作写在此方法里（注：这个方法继承自Runnable）

    @getName()\setName()： 获取\设置线程名字

    @join()：
        1.写在线程外部：（主线程）进入等待状态（waiting），等待当前分线程执行完，才重新执行
        2.写在线程内部：（当前线程）进入等待状态（waiting），先执行其他线程

 @Thread静态方法：
    @currentThread(): 返回对当前正在执行的线程对象的引用。

    @yield()： 向调度程序提示当前线程愿意让步，释放当前cpu执行权，重新分配，但也有可能还是分配到当前线程

    @sleep(long millis): 线程休眠（暂停执行），此操作受到系统计时器和调度程序精度和准确性的影响。

*/
public class Base {
    public static void main(String[] args) {
        Thread.currentThread().setName("主线程");

        SubThread subThread1 = new SubThread("-分线程1");
        SubThread subThread2 = new SubThread("--分线程2");

        // @线程1
        subThread1.start();
        // subThread1.start();// 报错：IllegalThreadStateException

        // @join （主线程）需等待当前线程执行完，才能执行其他线程
        // try {
        //     subThread1.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        // @线程2
        // subThread2.start();

        // try {
        //     subThread2.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        System.out.println(subThread1.isAlive());

        // @主线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }

        // @如果线程类只用一次，可使用匿名子类
        new Thread("SubThread3"){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    // System.out.println("---------------我是SubThread3----------------");
                }
            }
        }.start();

    }
}
