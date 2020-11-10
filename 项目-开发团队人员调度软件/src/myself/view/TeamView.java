package myself.view;

import myself.service.EmployeeList;
import myself.service.TeamException;
import myself.service.TeamList;
import teacher.view.TSUtility;

/**
 * @Description TODO
 */
public class TeamView {

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }

    private EmployeeList employeeList = new EmployeeList();
    private TeamList teamList = new TeamList();

    /**
     * @Description 进入主菜单
     */
    public void enterMainMenu(){

        // try {
        //     teamList.addMember(employeeList.getEmployeeById(3));
        // } catch (TeamException e) {
        //     e.printStackTrace();
        // }

        listAllEmployees();

        a:for (;;){
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");

            char key = TSUtility.readMenuSelection();

            switch (key){
                case '1':
                    listTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("已退出");
                    break a;
                default:
                    break;
            }
        }
    }

    /**
     * @Description 展示员工列表
     */
    public void listAllEmployees(){
        System.out.println(employeeList);
    }

    /**
     * @Description 展示团队成员列表
     */
    public void listTeam(){
        System.out.println(teamList);
    }

    public void addMember(){
        System.out.print("请输入要添加员工的ID：");
        int key = TSUtility.readInt();
        try {
            teamList.addMember(employeeList.getEmployeeById(key));
            System.out.println("添加成功！");
        } catch (TeamException e) {
            System.out.println("添加失败：" + e.getMessage());
        }
    }

    /**
     * @Description 删除团队员工
     */
    public void deleteMember(){
        System.out.print("请输入要删除员工的TID：");
        int key = TSUtility.readInt();
        System.out.print("确定删除该团队员工（Y/N）：");
        String c = String.valueOf(TSUtility.readConfirmSelection());
        if(c.equalsIgnoreCase("y")){
            try{
                teamList.removeMember(key);
                System.out.println("删除成功！");
            }catch (TeamException e){
                System.out.println("添加失败：" + e.getMessage());
            }
        }else{
            System.out.println("已取消删除！");
        }
    }

}
