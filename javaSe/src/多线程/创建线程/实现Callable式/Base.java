package 多线程.创建线程.实现Callable式;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Base {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        FutureTask<Integer> futureTask1 = new FutureTask(myThread);
        FutureTask<Integer> futureTask2 = new FutureTask(myThread);

        Thread thread1 = new Thread(futureTask1, "@子线程1");
        Thread thread2 = new Thread(futureTask2, "@子线程2");

        thread1.start();
        thread2.start();

        try {
            int sum1 = futureTask1.get();
            int sum2 = futureTask1.get();
            System.out.println("返回值1：" + sum1);
            System.out.println("返回值2：" + sum1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
