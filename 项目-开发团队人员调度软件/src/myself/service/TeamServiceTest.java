package myself.service;

import myself.domain.Employee;
import org.junit.jupiter.api.Test;

class TeamServiceTest {

    NameListService nameListService = new NameListService();
    TeamService teamService = new TeamService();

    @Test
    void addMember() {

        try {
            Employee employee = nameListService.getEmployeeById(2);
            teamService.addMember(employee);
            teamService.addMember(nameListService.getEmployeeById(3));
            teamService.addMember(nameListService.getEmployeeById(4));
            teamService.addMember(nameListService.getEmployeeById(5));
            teamService.addMember(nameListService.getEmployeeById(6));
            System.out.println(teamService);

        } catch (TeamException e) {
            e.printStackTrace();
        }



    }

    @Test
    void removeMember() {
    }

    @Test
    void getTeam() {
    }

    @Test
    void testToString() {
    }

    @Test
    void getTotal() {
    }

    @Test
    void getMAX_MEMBER() {
    }
}