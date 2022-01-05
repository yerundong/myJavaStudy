package 多线程.练习.生产者消费者;

/**
 * @Description 销售员
 */
public class Clerk implements Runnable {
    private Productor productor;// 对应的供应商
    private int stock = 0;// 库存 最多20个
    private String name;
    private static int newCounter = 0;

    @Override
    public void run() {

    }

    public Clerk(Productor productor) {
        newCounter++;
        this.productor = productor;
        name = "销售员" + newCounter;
    }

    public Clerk(Productor productor, String name) {
        newCounter++;
        this.productor = productor;
        this.name = name;
    }

    /**
     * @Description 进货
     */
    public synchronized boolean purchase(int n){
        if (n <= 0){
            return false;
        }

        if(stock + n > 20){
            return false;
        }

        boolean s = productor.sale(n);
        if(!s){
            return false;
        }

        stock += n;

        System.out.println(Thread.currentThread().getName());
        return true;
    }

    /**
     * @Description 卖货
     */
    public synchronized boolean sale(int n){
        if (n <= 0){
            return false;
        }

        if(n > stock){
            return false;
        }

        stock -= n;
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }
}
