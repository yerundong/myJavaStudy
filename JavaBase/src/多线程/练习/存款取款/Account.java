package 多线程.练习.存款取款;

import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private int accountId;// 账号id
    private double balance;// 账号余额
    private static int counter = 10000;

    private ReentrantLock lock = new ReentrantLock();

    public Account() {
        accountId = counter++;
    }

    public Account(double balance) {
        this();
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // 存钱
    public synchronized boolean deposit(double m) {
        if (m <= 0) {
            return false;
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        balance += m;
        System.out.println("存钱成功！" + Thread.currentThread().getName() + "，余额：" + this.getBalance());
        return true;
    }

    // 取钱
    public boolean withdraw(double m) {

        try {
            lock.lock();
            if (balance < m) {
                System.out.println("余额不足！" + Thread.currentThread().getName() + "：" + this.getBalance());
                return false;
            } else {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                balance -= m;
                System.out.println("取钱成功！" + Thread.currentThread().getName() + "：" + this.getBalance());
                return true;
            }
        } finally {
            lock.unlock();
        }

    }
}
