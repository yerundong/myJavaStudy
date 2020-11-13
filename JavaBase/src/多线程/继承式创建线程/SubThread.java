package 多线程.继承式创建线程;

public class SubThread extends Thread {

    public SubThread() {
    }
    public SubThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // @sleep
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(currentThread().getName() + "---" + i);
            if ( i == 5){
                // @yield
                // this.yield();

                // @join 阻塞，无法达到【dead】状态
                // try {
                //     join();
                // } catch (InterruptedException e) {
                //     e.printStackTrace();
                // }
            }
        }
    }
}
