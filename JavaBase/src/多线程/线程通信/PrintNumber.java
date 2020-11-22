package 多线程.线程通信;

/**
 * @Description TODO
 */
public class PrintNumber implements Runnable {
    private int num = 1;

    @Override
    public void run() {
        while (true){
            synchronized(this){
                notify();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":" + num);
                if (num >= 100){
                    break;
                }
                num++;

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
