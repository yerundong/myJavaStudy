package 多线程.Thread的常规操作方法;

public class MyThread_yield extends Thread {

    public MyThread_yield() {
    }

    public MyThread_yield(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(currentThread().getName() + "---" + i);

            if (i == 5) {
                Thread.yield();
            }
        }
    }
}
