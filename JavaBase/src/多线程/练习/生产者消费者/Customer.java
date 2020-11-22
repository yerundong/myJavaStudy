package 多线程.练习.生产者消费者;

/**
 * @Description 消费者
 */
public class Customer {

    Clerk clerk;
    private String name;
    private static int newCounter = 0;

    public Customer(Clerk clerk) {
        newCounter++;
        this.clerk = clerk;
        name = "消费者" + newCounter;
    }

    public Customer(Clerk clerk, String name) {
        newCounter++;
        this.clerk = clerk;
        this.name = name;
    }

    /**
     * @Description 买东西
     */
    public boolean buy(int n){
        boolean sale = clerk.sale(n);
        return sale;
    }
}
