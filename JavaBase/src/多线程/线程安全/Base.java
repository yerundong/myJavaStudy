package 多线程.线程安全;

/**
 @什么时候需要处理线程安全问题：
 （1）存在多线程运行的代码，单线程不会出现线程安全问题
 （2）多个线程有共享数据，并对其进行操作
 （3）多线程运行代码中存在操作共享数据

 @不安全问题： 当某个线程在操作共享数据时，且尚未完成，其他线程也参与进来操作共享数据

 @解决方向： 同步机制。当a线程在操作共享数据时，禁止其他线程同时操作，直到a线程操作完成。即在同一时间，只能有一个线程在操作共享数据

 @同步机制缺点： 实现同步是要很大的系统开销作为代价的，甚至可能造成死锁，所以尽量避免无谓的同步控制。

 @解决方案：
    1.synchronized关键字：
        1.同步代码块
        2.同步方法
    2.lock锁

 @推荐顺序： lock锁 - 同步代码块 - 同步方法

 */
public class Base {

}
