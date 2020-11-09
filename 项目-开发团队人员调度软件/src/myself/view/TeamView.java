package myself.view;

import myself.service.NameListService;
import myself.service.TeamService;
import teacher.view.TSUtility;

/**
 * @Description TODO
 */
public class TeamView {

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }

    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu(){
        listAllEmployees();

        System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");

        char key = TSUtility.readMenuSelection();
        System.out.println(key);

        switch (key){
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
        }
    }

    /**
     * @Description 展示所有成员列表
     */
    public void listAllEmployees(){
        System.out.println(listSvc);
    }

    public void getTeam(){

    }

    public void addMember(){

    }

    public void deleteMember(){

    }

}
