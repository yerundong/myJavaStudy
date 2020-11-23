package 多线程.练习.生产者消费者;

/**
 * @Description 生产线程
 */
public class ProductThread extends Thread {
    @Override
    public void run() {
        Productor productor = new Productor();
        productor.product();
    }
}
