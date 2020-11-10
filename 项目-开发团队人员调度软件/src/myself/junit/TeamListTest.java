package myself.junit;

import myself.domain.Employee;
import myself.service.EmployeeList;
import myself.service.TeamException;
import myself.service.TeamList;
import org.junit.jupiter.api.Test;

class TeamListTest {

    EmployeeList employeeList = new EmployeeList();
    TeamList teamList = new TeamList();

    @Test
    void addMember() {

        try {
            Employee employee2 = employeeList.getEmployeeById(2);
            // ((Programmer)employee2).setStatus(Status.VOCATION);

            teamList.addMember(employee2);
            teamList.addMember(employeeList.getEmployeeById(3));
            teamList.addMember(employeeList.getEmployeeById(4));
            teamList.addMember(employeeList.getEmployeeById(6));
            teamList.addMember(employeeList.getEmployeeById(7));

            System.out.println(teamList);
            // System.out.println(Arrays.toString(teamService.getTeam()));

            try{
                teamList.removeMember(5);
            }catch (TeamException e){
                e.printStackTrace();
            }


            System.out.println(teamList);

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