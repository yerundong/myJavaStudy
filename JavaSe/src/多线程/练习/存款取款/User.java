package 多线程.练习.存款取款;

public class User implements Runnable {
    private String name;
    private Account account;

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
            // account.withdraw(1000);
        }

    }

    public User(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
