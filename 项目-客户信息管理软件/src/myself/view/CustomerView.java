package myself.view;

import myself.bean.Customer;
import myself.service.CustomerList;
import myself.util.CMUtility;

import java.util.Scanner;

/**
 * @Description CustomerView为主模块，负责菜单的显示和处理用户操作
 * @Author 叶润东
 * @Date 2020/10/13
 * @Version 1.0
 */
public class CustomerView {
    private CustomerList customerList;

    public static void main(String[] args) {
        CustomerView cv = new CustomerView();
        cv.enterMainMenu();
    }

    public CustomerView() {
        customerList = new CustomerList(10);
        Customer cust = new Customer("叶润东", '男', 26, "13454782955", "414868970@qq.com");
        customerList.addCustomer(cust);
    }

    /**
     * @Description 用途：显示主菜单，响应用户输入，根据用户操作分别调用其他相应的成员方法（如addNewCustomer），以完成客户信息处理。
     * @Param 
     * @Author 叶润东
     * @Date  
     * @return 
     */
    public void enterMainMenu(){
        boolean loopFlag = true;
        do {
            System.out.println("-----------------客户信息管理软件-----------------");
            System.out.println("                 1 添 加 客 户");
            System.out.println("                 2 修 改 客 户");
            System.out.println("                 3 删 除 客 户");
            System.out.println("                 4 客 户 列 表");
            System.out.println("                 5 退      出");
            System.out.print("                 请选择(1-5)：");
            char key = CMUtility.readMenuSelection();
            // System.out.println(key);
            System.out.println();
            switch (key) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("确认是否退出(Y/N)：");
                    char yn = CMUtility.readConfirmSelection();
                    if (yn == 'Y')
                        loopFlag = false;
                    break;
            }
        } while (loopFlag);
    }

    /**
     * @Description 添加用户
     * @Param
     * @Author 叶润东
     * @Date
     * @return
     */
    private void addNewCustomer(){ System.out.println("---------------------添加客户---------------------");
        System.out.print("                 请输入姓名：");
        String name = CMUtility.readString(4);
        System.out.print("                 请输入性别：");
        char gender  = CMUtility.readChar('男');
        System.out.print("                 请输入年龄：");
        int age  = CMUtility.readInt(0);
        System.out.print("                 请输入电话：");
        String phone  = CMUtility.readString(11);
        System.out.print("                 请输入邮箱：");
        String email  = CMUtility.readString(30);

    }

    /**
     * @Description 修改用户
     * @Param
     * @Author 叶润东
     * @Date
     * @return
     */
    private void modifyCustomer(){

    }

    /**
     * @Description 删除用户
     * @Param
     * @Author 叶润东
     * @Date
     * @return
     */
    private void deleteCustomer(){

    }

    /**
     * @Description 客户列表
     * @Param
     * @Author 叶润东
     * @Date
     * @return
     */
    private void listAllCustomers(){
        Customer[] custs = customerList.getAllCustomers();
        // System.out.println(custs.length);
        System.out.println("  姓名      性别      年龄      电话      邮箱");
        for (int i = 0; i < custs.length; i++) {
            Customer cust = custs[i];
            System.out.println("  "+cust.getName()+"      "+cust.getGender()+"      "+cust.getAge()+"      "+cust.getPhone()+"      "+cust.getEmail()+"");
        }
    }


}
