package 多线程.Thread的常规操作方法;

public class MyThread extends Thread {

    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // @sleep
            // try {
            //     sleep(1000);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }

            System.out.println(currentThread().getName() + "---" + i);

            // if (i == 5) {
            //     // @yield
            //     // this.yield();
            //
            //     // @join：在内部等待自己死亡才执行，导致永远阻塞
            //     try {
            //         join();
            //     } catch (InterruptedException e) {
            //         e.printStackTrace();
            //     }
            // }
        }
    }
}
