package 多线程.创建线程.继承Thread式;

import org.junit.jupiter.api.Test;

public class Base {
    @Test
    public void test1() {
        // 更改、获取当前线程名
        Thread.currentThread().setName("主线程");
        // System.out.println(Thread.currentThread().getName());

        MyThread myThread = new MyThread("@分线程");
        myThread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }

    @Test
    public void test2() {
        // @如果线程类只用一次，可使用匿名子类
        new Thread("@分线程2") {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(currentThread().getName() + "---" + i);
                }
            }
        }.start();

    }
}
