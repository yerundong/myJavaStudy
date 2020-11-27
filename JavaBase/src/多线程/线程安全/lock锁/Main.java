package 多线程.线程安全.lock锁;

/**
 @Lock(锁): 从JDK 5.0开始，Java提供了更强大的线程同步机制——通过显式定义同步锁对象来实现同步。同步锁使用Lock对象充当。

 @Lock接口： Lock接口是控制多个线程对共享资源进行访问的工具。锁提供了对共享资源的独占访问，每次只能有一个线程对Lock对象
    加锁，线程开始访问共享资源之前应先获得Lock对象。

 @ReentrantLock类： ReentrantLock 实现了 Lock 接口，它拥有与 synchronized 相同的并发性和内存语义，在实现线程安全的控制中，
    比较常用的是ReentrantLock，可以显式加锁、释放锁

 @创建锁： ReentrantLock lock = new ReentrantLock();

 @方法：
    lock()：获取锁，锁上。在可能出现线程安全的同步代码前调用
    unlock()：释放锁，解锁。在可能出现线程安全的同步代码后调用

 @注意事项：
    1.一定要手动关闭锁，否则将造成死锁
    2.为了避免报错执行不到解锁操作，造成死锁，建议使用 try-finally，在finally调用unlock

 */
public class Main {
    public static void main(String[] args) {
        Window window = new Window();
        Thread rw1 = new Thread(window, "窗口一");
        Thread rw2 = new Thread(window, "窗口二");
        Thread rw3 = new Thread(window, "窗口三");

        rw1.start();
        rw2.start();
        rw3.start();
    }
}
