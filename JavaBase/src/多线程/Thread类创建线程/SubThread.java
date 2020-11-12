package 多线程.Thread类创建线程;

public class SubThread extends Thread {

    public SubThread() {
    }
    public SubThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
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

                // @sleep
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
