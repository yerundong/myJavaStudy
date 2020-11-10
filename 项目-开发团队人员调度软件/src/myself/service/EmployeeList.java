package myself.service;

import myself.domain.*;

import static myself.service.Data.*;

/**
 * @Description 全部员工列表
 */
public class EmployeeList {

    private Employee[] employees;// 员工数组

    public EmployeeList() {

        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < EMPLOYEES.length; i++) {
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
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    eq = createEquipment(eqDataItem);
                    employees[i] = new Programmer(id, name, age, salary, eq);
                    break;
                case DESIGNER:
                    eq = createEquipment(eqDataItem);
                    bonus = Double.parseDouble(empDataItem[5]);
                    employees[i] = new Designer(id, name, age, salary, eq, bonus);
                    break;
                case ARCHITECT:
                    eq = createEquipment(eqDataItem);
                    bonus = Double.parseDouble(empDataItem[5]);
                    stock = Integer.parseInt(empDataItem[6]);
                    employees[i] = new Architect(id, name, age, salary, eq, bonus, stock);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * @Description 根据Data条目创建设备
     * @Param eqDataItem Data条目
     * @return Equipment 设备实例
     */
    public Equipment createEquipment(String[] eqDataItem){

        final int code = Integer.parseInt(eqDataItem[0]);

        Equipment eq;

        switch (code){
            case PC:
                {
                    final String mode = eqDataItem[1];
                    final String display = eqDataItem[2];
                    eq = new PC(mode, display);
                }
                break;
            case PRINTER:
                {
                    final String name = eqDataItem[1];
                    final String type = eqDataItem[2];
                    eq = new Printer(name, type);
                }
                break;
            case NOTEBOOK:
                {
                    final String mode = eqDataItem[1];
                    final double price = Double.parseDouble(eqDataItem[2]);
                    eq = new NoteBook(mode, price);
                }
                break;
            default:
                eq = null;
                break;

        }

        return eq;
    }

    @Override
    public String toString() {
        String str = "------------------------------ 开发团队调度软件 ----------------------------------\n";
        str += "ID \t名字   \t年龄\t工资   \t岗位   \t状态  \t奖金   \t股票  \t设备\n";
        for (int i = 0; i < employees.length-1; i++) {
            str += employees[i].toString()+"\n";
        }
        str += employees[employees.length-1].toString()+"\n";
        str += "-------------------------------------------------------------------------------\n";
        return str;
    }

    // public Employee[] getAllEmployees() {
    //
    //     for (int i = 0; i < employees.length; i++) {
    //
    //     }
    //
    //     return employees;
    // }

    public Employee getEmployeeById(int id) throws TeamException{
        for (int i = 0; i < employees.length; i++) {
            if(employees[i].getId() == id){
                return employees[i];
            }
        }
        throw new TeamException("未找到id对应的员工！");
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }
}
