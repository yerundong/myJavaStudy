package myself.service;

import myself.domain.Employee;
import org.junit.jupiter.api.Test;

/**
 * @Description 测试 NameListService
 */
public class NameListServiceTest {
    NameListService service = new NameListService();

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