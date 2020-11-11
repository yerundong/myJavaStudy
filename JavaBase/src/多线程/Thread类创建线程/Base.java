package 多线程.Thread类创建线程;

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

    @yield()： 暂停当前正在执行的线程对象，并执行其他线程。

 @Thread静态方法：
    @currentThread(): 返回对当前正在执行的线程对象的引用。

*/
public class Base {
    public static void main(String[] args) {
        Thread.currentThread().setName("主线程");

        SubThread subThread1 = new SubThread("subThread1");
        SubThread subThread2 = new SubThread("subThread2");

        // 线程1
        // start()：1.启动当前线程 2.start里调用当前线程的run方法
        subThread1.start();
        // subThread1.start();// 报错：IllegalThreadStateException

        // 线程2
        subThread2.start();

        // 主线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }

        // 如果线程类只用一次，可使用匿名子类

        new Thread("SubThread3"){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("---------------我是SubThread3----------------");
                }
            }
        }.start();

    }
}
