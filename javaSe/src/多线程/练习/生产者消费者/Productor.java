package 多线程.练习.生产者消费者;

/**
 * @Description 供应商
 */
public class Productor{
    private int productCounter = 20;

    // 生产：每秒生产一个
    public void product(){
        while (true){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            productCounter++;
            System.out.println("productCounter：" + productCounter);
        }
    }

    /**
     * @Description 卖货
     */
    public boolean sale(int n){
        if (n <= 0){
            return false;
        }

        if(n > productCounter){
            return false;
        }

        productCounter -= n;
        return true;
    }

    public int getProductCounter() {
        return productCounter;
    }
}
