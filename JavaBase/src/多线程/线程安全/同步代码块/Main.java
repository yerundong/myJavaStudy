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
