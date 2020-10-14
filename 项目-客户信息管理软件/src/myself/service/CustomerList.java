package myself.service;

import myself.bean.Customer;

/**
 * @Description CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象，
 * 并提供相应的添加、修改、删除和遍历方法，供CustomerView调用
 * @Author 叶润东
 * @Date 2020/10/13
 * @Version 1.0
 */
public class CustomerList {
    private Customer[] customers; // 用来保存客户对象的数组
    private int total = 0; // 记录已保存客户对象的数量

    public CustomerList(int totalCustomer){
        this.customers = new Customer[totalCustomer];
    }

    /**
     * @Description 添加客户
     * @Param [customer]
     * @Author 叶润东
     * @Date 17:47 2020/10/13
     * @return boolean
     */
    public boolean addCustomer(Customer customer){
        if(total < customers.length){
            customers[total++] = customer;
            return true;
        }
        return false;
    }

    /**
     * @Description 替换数组中由index指定的对象
     * @Param [index, cust]
     * @Author 叶润东
     * @Date 17:50 2020/10/13
     * @return boolean
     */
    public boolean replaceCustomer(int index, Customer cust){
        try{
            customers[index] = cust;
            return true;
        }catch (RuntimeException exception){
            return false;
        }
    }

    /**
     * @Description 删除数组中由index指定的对象
     * @Param [index]
     * @Author 叶润东
     * @Date 17:50 2020/10/13
     * @return boolean
     */
    public boolean deleteCustomer(int index){
        try{
            customers[index] = null;
            total--;
            return true;
        }catch (RuntimeException exception){
            return false;
        }
    }

    /**
     * @Description 返回数组中记录的所有客户对象
     * @Param []
     * @Author 叶润东
     * @Date 17:57 2020/10/13
     * @return Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同。
     */
    public Customer[] getAllCustomers(){
        Customer[] custs = new Customer[total];
        if(total == 0){
            return custs;
        }

        int num = 0;
        for (int i = 0; i < customers.length; i++) {
            if(customers[i] != null){
                custs[num++] = customers[i];
            }
        }
        return custs;
    }

    /**
     * @Description 返回参数index指定索引位置的客户对象记录
     * @Param [index]
     * @Author 叶润东
     * @Date 17:59 2020/10/13
     * @return myself.bean.Customer
     */
    public Customer getCustomer(int index){
        try{
            return customers[index];
        }catch (RuntimeException exception){
            return null;
        }
    }

    public int getTotal(){
        return total;
    }
}
