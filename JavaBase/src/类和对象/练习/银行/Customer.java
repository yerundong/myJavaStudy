package 类和对象.练习.银行;

public class Customer {
    private String firstName;
    private String lastName;
    private Account account;// 账户

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void says(){
        if(account == null){
            System.out.println("我叫"+ firstName + '.'+lastName + "，暂无账户");
            return;
        }
        System.out.println("我叫"+ firstName + '.'+lastName + "，我的账户余额：" + account.getBalance());
    }
}
