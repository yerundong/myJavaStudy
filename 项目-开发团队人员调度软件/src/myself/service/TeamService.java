package myself.service;

import jdk.swing.interop.SwingInterOpUtils;
import myself.domain.Architect;
import myself.domain.Designer;
import myself.domain.Employee;
import myself.domain.Programmer;

import java.util.Arrays;

import static myself.service.Data.*;

/**
 * @Description 关于开发团队成员的管理：添加、删除等。
 */
public class TeamService {

    private static int counter = 1;// 自增主键 给memberId赋值
    private final int MAX_MEMBER = 5;// 最大开发团队人数
    private Programmer[] team = new Programmer[MAX_MEMBER];// 开发团队数组
    private static int total;// 开发团队人数

    public void addMember(Employee em) throws TeamException{
        if(total >= MAX_MEMBER){
            throw new TeamException("开发团队人员已满！");
        }

        if(!(em instanceof Programmer)){
            throw new TeamException("该成员不是开发人员！");
        }

        Programmer pg = (Programmer)em;

        int archNum = 0, dsgnNum = 0, prgNum = 0;
        for (int i = 0; i < team.length; i++) {
            if(team[i] == null){
                continue;
            }
            if (em.getId() == team[i].getId()){
                throw new TeamException("该成员已在开发团队中！");
            }


            System.out.println(team[i] instanceof Programmer);
            if(team[i] instanceof Architect){
                archNum++;
            }else if(team[i] instanceof Designer){
                dsgnNum++;
            }else if(team[i] instanceof Programmer){
                prgNum++;
            }
        }
        // System.out.println();

        if(archNum > 0 && em.getId() == ARCHITECT){
            throw new TeamException("团队中最多只能有一个架构师！");
        }else if(dsgnNum > 1 && em.getId() == DESIGNER){
            throw new TeamException("团队中最多只能有两个设计师！");
        }else if(prgNum > 2 && em.getId() == PROGRAMMER){
            throw new TeamException("团队中最多只能有3️三个程序员！");
        }



        pg.setMemberId(counter++);
        team[total++] = pg;


    }

    public void removeMember(int memberId){

    }

    /**
     * @Description 返回team中所有程序员构成的数组
     * @Param
     */
    public Programmer[] getTeam() {
        // Programmer[] programmers = new Programmer[total];
        // int index = 0;
        // for (int i = 0; i < team.length; i++) {
        //     if(team[i] != null){
        //         programmers[index++] = team[i];
        //     }
        // }
        return team;
    }

    @Override
    public String toString() {
        String str = "";
        str += "TID\\ID \t名字   \t年龄\t工资   \t岗位   \t状态  \t奖金   \t股票  \t设备\n";
        for (int i = 0; i < team.length; i++) {
            if(team[i] == null){
                str += "null\n";
            }else{
                str += team[i].toString()+ "\t tid=" + team[i].getMemberId() + "\n";
            }
        }
        return str;
    }

    public static int getTotal() {
        return total;
    }

    public int getMAX_MEMBER() {
        return MAX_MEMBER;
    }
}
