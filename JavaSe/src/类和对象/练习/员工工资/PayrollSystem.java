package 类和对象.练习.员工工资;

import java.util.Scanner;

/**
 * @Description 测试
 */
public class PayrollSystem {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.print("请输入月份：");
        int month = sn.nextInt();

        Employee[] employees = new Employee[2];

        employees[0] = new SalariedEmployee("张三", 1001, new MyDate(1994, 1, 2), 10000);
        employees[1] = new HourlyEmployee("李四", 1002, new MyDate(1992, 5, 5), 60, 240);

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
            System.out.println("月工资是：" + employees[i].earnings());
            if(month == employees[i].getBirthday().getMonth()){
                System.out.println("生日快乐！奖励100元！");
            }
            System.out.println();
        }
    }

}
