package 多线程.练习.存款取款;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(0);
        User u1 = new User("甲用户", account);
        User u2 = new User("乙用户", account);

        Thread t1 = new Thread(u1, "甲线程");
        Thread t2 = new Thread(u2, "乙线程");

        t1.start();
        t2.start();

        // u1.getAccount().withdraw(5000);
        // u2.getAccount().withdraw(1000);


    }
}
