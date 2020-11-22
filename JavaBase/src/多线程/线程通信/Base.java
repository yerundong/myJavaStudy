package 多线程.线程通信;

/**

 @wait: 等待，释放cpu执行权，进入阻塞状态，让其他线程先执行
    @注： 释放对象锁（区别于sleep、yield）

 @notify： 唤醒，唤醒另外一个被wait的线程，重新进入就绪状态，抢夺执行权
 @notifyAll： 唤醒所有被wait的线程

 @注意事项：
    1.这三个方法是成对出现的。
    2.这三个方法必须写在synchronized代码块中或synchronized方法中（lock不行）代码块中才能使用，否则会报IllegalMonitorStateException 异常。
        @注： lock有自己的通讯方式？？？？？？
    3.这三个方法的调用者必须是同步监视器对象
    4.这三个方法定义在Object类中

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
