package 多线程.练习.生产者消费者;

/*
 生产者 Productor 将产品交给店员 ( Clerk)，而消费者 ( 从店员处
 取走产品，店员一次只能持有固定数量的产品 比如 :20 ），如果生产者试图
 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 果店中有产品了再通知消费者来取走产品。

 这里可能出现两个问题：
     生产者比消费者快时，消费者会漏掉一些数据没有取到。
     消费者比生产者快时，消费者会取相同的数据。
 */
public class Main {
    public static void main(String[] args) {

        ProductThread productThread = new ProductThread();
        ClerkThread clerkThread = new ClerkThread();

        productThread.start();
        clerkThread.start();
        //
        // try {
        //     Thread.sleep(5000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // clerk.purchase(10);

        // System.out.println(productor.getProductCounter());
    }
}
