package 多线程.创建线程.实现Runnable式;

/**

 @步骤：
    1.创建一个 Runnable 接口的实现类：MThread
    2.在 MThread 中重写 Runnable 的 run 方法
    3.创建MThread的实例对象：mThread
    4.将 mThread 作为构造参数传入，创建 Thread 类对象：thread
    5.调用 thread.start()，启动线程


 */
public class Base {
    public static void main(String[] args) {
        MThread mThread = new MThread();
        Thread thread1 = new Thread(mThread);
        Thread thread2 = new Thread(mThread);

        thread1.start();
        thread2.start();
    }
}
