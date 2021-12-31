package 多线程.Thread的常规操作方法;

public class MyThread_join extends Thread {

    public MyThread_join() {
    }

    public MyThread_join(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(currentThread().getName() + "---" + i);

            if (i == 5) {
                // join：在内部执行，导致永远阻塞
                try {
                    join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
