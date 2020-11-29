package 多线程.线程安全.同步代码块;

/**
 @同步代码块格式：
     synchronized(同步监视器){
        // 需要同步的代码
     }

 @同步监视器（锁）： 手动声明

 @常用的锁对象：
    1.this：需要保证每个线程都共享这个this，而不是各自创建一个this
    2.Window.class
    2.Window.class\getClass()

 @同步监视器（锁）： 只有拿到锁的线程才可以运行同步代码，只有当前线程执行完同步代码，才会把锁递交给下一个线程
    没有拿到锁的对象，运行到同步代码部分将进入阻塞状态等待，直到拿到锁

 @锁的要求：
     1.锁必须是对象，任何对象都可以充当锁
     2.唯一性：必须确保使用多个线程共用一把锁，这个非常重要，否则就无法保证共享资源的安全

 @释放锁的操作：
     1.当前线程的同步方法、同步代码块执行结束。
     2.当前线程在同步代码块、同步方法中遇到break、return终止了该代码块、该方法的继续执行。
     3.当前线程在同步代码块、同步方法中出现了未处理的Error或Exception，导致异常结束。
     4.当前线程在同步代码块、同步方法中执行了线程对象的wait()方法，当前线程暂停，并释放锁。

 @不会释放锁的操作：
     1.线程执行同步代码块或同步方法时，程序调用Thread.sleep()、Thread.yield()方法暂停当前线程的执行
     2.线程执行同步代码块时，其他线程调用了该线程的suspend()方法将该线程挂起，该线程不会释放锁（同步监视器）。
     @注： 应尽量避免使用suspend()和resume()来控制线程
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
