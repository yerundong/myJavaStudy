package 类和对象.练习.银行;

public class Bank {
    private Customer[] customers;// 存放所有客户的数组
    private int numberOfCustomers;// 记录客户个数

    public Bank() {
        customers = new Customer[10];
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    // 添加客户
    public void addCustomer(String firstName, String lastName){
        customers[numberOfCustomers++] = new Customer(firstName, lastName);
    }

    public void addCustomer(Customer customer){
        customers[numberOfCustomers++] = customer;
    }

    // 获得客户
    public Customer getCustomer(int index){
        if (index > 0 && index < numberOfCustomers){
            return customers[index];
        }
        return null;
    }

    public void says(){
        System.out.println("客户个数："+ numberOfCustomers + "，customers.length：" +customers.length);
    }

    public void printAll(){
        String str = "[";
        for (int i = 0; i < numberOfCustomers - 1; i++) {
            Customer cus = customers[i];
            str += cus.getFirstName() + "." + cus.getLastName() + ", ";
        }
        str += customers[numberOfCustomers - 1].getFirstName() + "." + customers[numberOfCustomers - 1].getLastName() + "]";
        System.out.println(str);
    }
}
