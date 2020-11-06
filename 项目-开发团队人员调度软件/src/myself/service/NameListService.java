package myself.service;

import myself.domain.*;
import org.junit.jupiter.api.Test;

import static myself.service.Data.*;

public class NameListService {

    private Employee[] employees;// 员工数组

    public NameListService() {

        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < EMPLOYEES.length; i++) {
            Employee employeeItem = employees[i];// 员工项
            final String[] empDataItem = EMPLOYEES[i];// 员工数据项
            final String[] eqDataItem = EQUIPMENTS[i];// 设备数据项

            // 员工参数
            final int code = Integer.parseInt(empDataItem[0]);
            final int id = Integer.parseInt(empDataItem[1]);
            final String name = empDataItem[2];
            final int age = Integer.parseInt(empDataItem[3]);
            final double salary = Double.parseDouble(empDataItem[4]);

            Equipment eq;
            double bonus;
            int stock;

            switch (code){
                case EMPLOYEE:
                    employeeItem = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    eq = createEquipment(eqDataItem);
                    employeeItem = new Programmer(id, name, age, salary, eq);
                    break;
                case DESIGNER:
                    eq = createEquipment(eqDataItem);
                    bonus = Double.parseDouble(empDataItem[5]);
                    employeeItem = new Designer(id, name, age, salary, eq, bonus);
                    break;
                case ARCHITECT:
                    eq = createEquipment(eqDataItem);
                    bonus = Double.parseDouble(empDataItem[5]);
                    stock = Integer.parseInt(empDataItem[6]);
                    employeeItem = new Architect(id, name, age, salary, eq, bonus, stock);
                    break;
                default:
                    break;
            }
        }
    }

    public Equipment createEquipment(String[] eqDataItem){
        final int code = Integer.parseInt(eqDataItem[0]);

        Equipment eq;

        switch (code){
            case PC:
                final String mode = eqDataItem[1];
                final String display = eqDataItem[2];
                eq = new PC(mode, display);
                break;
            case NOTEBOOK:

                // eq = new PC(mode, display);
                break;
            default:
                break;

        }
        return null;
    }

    public Employee[] getAllEmployees() {

        for (int i = 0; i < employees.length; i++) {

        }

        return employees;
    }

    public Employee getEmployeeById(int id){
        return null;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }
}
