package 多线程.线程的常规操作;

/**
 @Thread类： 线程类，代表程序中的执行线程，是 Runnable 接口的实现类

 @Runnable接口： Runnable 接口应该由那些打算通过某一线程执行其实例的类来实现。内部仅有一个抽象方法：run

 @Thread实例方法：

     @start()： 辟新的栈空间，启动线程，执行 run 方法，进入就绪状态（ready）。
         注：一个线程只能启动一次，即个线程的start()只能执行一次，否则报错：IllegalThreadStateException

     @run()： 通常需要重写，将当前线程需要执行的操作写在此方法里
        注：直接只调用 run 方法（不调start）不会创建线程，而是在主线程里执行 run 方法

     @getName()\setName()： 获取\设置线程名字

     @join()： 首尾连接，让【当前线程】连到【目标线程】尾部，等待【目标线程】执行完，达到死亡状态时，【当前线程】才能重新执行
        @注：
            1.join方法一般写在【目标线程】外部，效果如上
            2.若写在【目标线程】内部，等于在内部等待自己死亡，释放执行权，进入永远阻塞

     @isAlive()： 测试此线程是否仍然存活

 @Thread静态方法：

     @currentThread(): 返回对当前正在执行的线程对象的引用。

     @yield()： 让步，释放cpu执行权，回到就绪状态，重新争抢执行权
         @注：
            1.不释放对象锁，如果有synchronized同步块，其他线程仍然不能访问共享数据
            2.只能【相同或高于】它的优先级的线程有争抢执行权的机会。

     @sleep(long): 休眠，释放cpu执行权，进入阻塞状态，让其他线程先执行，休眠结束再争抢执行权，继续执行
        @注：
            1.不释放对象锁，如果有synchronized同步块，其他线程仍然不能访问共享数据
            2.需要处理异常
            3.此操作受到系统计时器和调度程序精度和准确性的影响
            4.所有优先级的线程都有争抢执行权的机会（区别于yield）。


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

        // @配合内部join，查看subThread1状态，确定为：阻塞
        // try {
        //     Thread.sleep(2000);
        //     System.out.println(subThread1.isAlive());
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        // @线程2
        // subThread2.start();

        // @join
        // try {
        //     subThread2.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        // @isAlive()
        // System.out.println(subThread1.isAlive());

        // @主线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }

    }
}
