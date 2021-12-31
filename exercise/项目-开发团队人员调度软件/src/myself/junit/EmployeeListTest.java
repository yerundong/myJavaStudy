package myself.junit;

import myself.domain.Employee;
import myself.service.EmployeeList;
import myself.service.TeamException;
import org.junit.jupiter.api.Test;

/**
 * @Description 测试 NameListService
 */
public class EmployeeListTest {
    EmployeeList service = new EmployeeList();

    {
        System.out.println(service);
    }

    @Test
    void createEquipment() {

    }

    @Test
    void testToString() {
    }

    @Test
    void getEmployeeById() {
        try {
            Employee employee = service.getEmployeeById(2);
            System.out.println(employee);
        } catch (TeamException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getEmployees() {
    }

    @Test
    void setEmployees() {
    }
}