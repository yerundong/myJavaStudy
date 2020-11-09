package myself.service;

import myself.domain.Employee;
import myself.domain.Programmer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TeamServiceTest {

    NameListService nameListService = new NameListService();
    TeamService teamService = new TeamService();

    @Test
    void addMember() {

        try {
            Employee employee2 = nameListService.getEmployeeById(2);
            // ((Programmer)employee2).setStatus(Status.VOCATION);

            teamService.addMember(employee2);
            teamService.addMember(nameListService.getEmployeeById(3));
            teamService.addMember(nameListService.getEmployeeById(4));
            teamService.addMember(nameListService.getEmployeeById(6));
            teamService.addMember(nameListService.getEmployeeById(7));

            System.out.println(teamService);
            // System.out.println(Arrays.toString(teamService.getTeam()));

            try{
                teamService.removeMember(5);
            }catch (TeamException e){
                e.printStackTrace();
            }


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