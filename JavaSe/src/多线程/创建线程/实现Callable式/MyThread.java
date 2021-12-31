package 多线程.创建线程.实现Callable式;

import java.util.concurrent.Callable;

public class MyThread implements Callable<Integer> {

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "---" + i);
            sum += i;
        }
        return sum;
    }
}
