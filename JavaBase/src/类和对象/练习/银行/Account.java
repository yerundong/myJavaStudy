package 类和对象.练习.银行;

public class Account {
    private int id;// 账户id
    private double balance;// 余额
    private double annualInterestRate;// 年利率

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    // 存钱
    public void deposit(double amount) {
        if (amount > 0) {
            this.setBalance(balance + amount);
        }
    }

    // 取钱
    public boolean withdraw(double amount) {
        if (balance < amount) {
            return false;
        } else {
            this.setBalance(balance - amount);
            return true;
        }
    }
}
