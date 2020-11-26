package 多线程.创建线程.实现Callable式;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**

 @Callable：

 @步骤：
    1.创建一个 Callable 接口的实现类：MThread
    2.在 MThread 中重写 Callable 的 call 方法
    3.创建MThread的实例对象：mThread
    4.将 mThread 作为构造参数传入，创建 FutureTask 类对象：futureTask
    5.将 futureTask 作为构造参数传入，创建 Thread 类对象：thread
    6.调用 thread.start()，启动线程

 futureTask.get() 返回call方法的返回值


 */
public class Base {
    public static void main(String[] args) {
        MThread mThread = new MThread();

        FutureTask futureTask1 = new FutureTask<>(mThread);
        FutureTask futureTask2 = new FutureTask<>(mThread);

        Thread thread1 = new Thread(futureTask1);
        Thread thread2 = new Thread(futureTask2);

        thread1.start();
        thread2.start();

        try {
            int sum1 = (Integer) futureTask1.get();
            int sum2 = (Integer) futureTask1.get();
            System.out.println("返回值1：" + sum1);
            System.out.println("返回值2：" + sum1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
