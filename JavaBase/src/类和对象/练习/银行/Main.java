package 类和对象.练习.银行;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer customer = new Customer("Jack", "Sparrow");
        Account account = new Account(100, 2000, 0.0123);
        customer.says();
        customer.setAccount(account);
        customer.says();
        // 取钱
        account.withdraw(250);
        customer.says();
        // 存钱
        account.deposit(1000);
        customer.says();

        bank.addCustomer(customer);
        bank.says();

        bank.addCustomer("hello", "kitty");
        bank.says();
        bank.printAll();

        try{
            bank.getCustomer(3).says();
        }catch (Exception exception){

        }
    }

}
