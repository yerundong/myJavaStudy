package 多线程.练习.银行;

public class Account {
    private int accountId;// 账号id
    private double balance;// 账号余额
    private static int counter = 10000;//

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
    public boolean deposit(double m) {
        if(m <= 0){
            return false;
        }

        balance += m;
        return true;
    }

    // 取钱
    public boolean withdraw (double m) {
        if(m <= 0){
            return false;
        }

        if(balance < m){
            System.out.println("余额不足！");
            return false;
        }else{
            balance -= m;
            System.out.println("取钱成功！");
            return true;
        }
    }
}
