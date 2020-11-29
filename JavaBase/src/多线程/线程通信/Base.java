package 多线程.线程通信;

/**

 @线程通信： 当我们需要多个线程共同完成一个任务时，总希望它们互相协作，有规律的运行，而不是独立随机的运行。这时，就需要线程通信机制，
           通信机制即等待唤醒机制，主要包含等待和唤醒两种方式。

 @线程通信的前提条件： 多线程共同操作同一份数据，即需要同步机制

 @wait: 等待，释放cpu执行权，进入阻塞状态（waiting），不在执行wait后面的代码，让其他线程先执行
    @注： 释放对象锁（区别于sleep、yield）
    @重载用法：
        wait(): 无限等待，只有notify了才能唤醒
        wait(long m): 限时等待，超过时长m没被notify唤醒，自动醒来

 @notify： 唤醒，唤醒另外一个被wait的线程，重新进入就绪状态，抢夺执行权，抢到之后继续执行wait后面的代码
 @notifyAll： 唤醒所有被wait的线程

 @注意事项：
    1.wait/notify(notifyAll)是成对出现的。
    2.wait/notify(notifyAll)必须写在synchronized代码块中或synchronized方法中（lock不行）代码块中，否则会报 IllegalMonitorStateException 异常。
        @注： lock有自己的通讯方式？？？？？？
    3.wait/notify(notifyAll)的调用者必须是同步监视器对象，且必须由同一个锁调用
    4.wait/notify(notifyAll)定义在Object类中

 @wait与sleep的对比：
    相同点：都能造成当前线程阻塞
    不同点：
        1.wait方法是Object类的实例方法，sleep是Thread类的静态方法
        2.wait只能在synchronized代码块中或synchronized方法中，sleep在任何地方都可以
        3.wait释放对象锁，sleep不释放

 */
public class Base {
    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber();
        Thread a = new Thread(printNumber, "A");
        Thread b = new Thread(printNumber, "BBB");
        a.start();
        b.start();
    }
}
