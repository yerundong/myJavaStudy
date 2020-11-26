package 多线程.创建线程.实现Callable式;

import java.util.concurrent.Callable;

public class MThread implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {

            Thread.sleep(10);

            System.out.println(Thread.currentThread().getName() + "---" + i);
            sum+=i;
        }
        return sum;
    }
}
