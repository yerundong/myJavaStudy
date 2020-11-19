package 多线程.练习.银行;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(3000);
        User a = new User("甲", account);
        User b = new User("乙", account);


    }
}
