package 多线程.Thread的常规操作方法;

import org.junit.jupiter.api.Test;

public class Base {
    static {
        Thread.currentThread().setName("主线程");
    }

    MyThread myThread1 = new MyThread("-分线程1");
    MyThread myThread2 = new MyThread("--分线程2");
    MyThread_join myThread3 = new MyThread_join("--分线程3");
    MyThread_join myThread4 = new MyThread_join("--分线程4");


    @Test
    public void test_start() {
        myThread1.start();
        // myThread1.start();// 重复执行报错：IllegalThreadStateException
    }

    @Test
    public void test_join() {
        myThread1.start();

        // join （主线程）需等待当前线程执行完，才能执行其他线程，主线程进入等待状态（WAITING）
        try {
            myThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(myThread1.getState());// TERMINATED

        // 线程2
        myThread2.start();

        // 主线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }

    @Test
    public void test_join2() {
        myThread3.start();

        // 主线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }

    @Test
    public void test_isAlive() {
        myThread1.start();

        System.out.println(myThread1.isAlive());

        try {
            Thread.sleep(1000);
            System.out.println(myThread1.isAlive());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_sleep() {
        myThread1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 主线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }

    @Test
    public void test_yield() {
        myThread4.start();
        System.out.println(myThread4.getState());

        // 主线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }

        System.out.println(myThread4.getState());// WAITING
    }

    @Test
    public void test_getState() {
        Thread.State blocked = Thread.State.BLOCKED;
        System.out.println(blocked);
        System.out.println(myThread4.getState());
    }
}
