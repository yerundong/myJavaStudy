package myself.service;

import myself.domain.Architect;
import myself.domain.Designer;
import myself.domain.Employee;
import myself.domain.Programmer;

/**
 * @Description 开发团队
 */
public class TeamList {

    private static int counter = 1;// 自增主键 给teamId赋值
    private final int MAX_MEMBER = 5;// 最大开发团队人数
    private Programmer[] team = new Programmer[MAX_MEMBER];// 开发团队数组
    private static int total;// 开发团队人数

    public void addMember(Employee em) throws TeamException {
        if (total >= MAX_MEMBER) {
            throw new TeamException("开发团队人员已满！");
        }

        if (!(em instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员！");
        }

        Programmer pg = (Programmer) em;
        String statusName = pg.getStatus().getNAME();

        if (statusName.equals("BUSY")) {
            throw new TeamException("该员工已是BUSY状态！");
        }

        if (statusName.equals("VOCATION")) {
            throw new TeamException("该员正在休假，无法添加！");
        }

        // 计算各角色已有人数
        int archNum = 0, dsgnNum = 0, prgNum = 0;
        for (int i = 0; i < team.length; i++) {
            if (team[i] == null) {
                break;
            }

            if (em.getId() == team[i].getId()) {
                throw new TeamException("该成员已在开发团队中！");
            }

            if (team[i] instanceof Architect) {
                archNum++;
            } else if (team[i] instanceof Designer) {
                dsgnNum++;
            } else if (team[i] instanceof Programmer) {
                prgNum++;
            }
        }

        if (em instanceof Architect) {
            if (archNum >= 1)
                throw new TeamException("团队中最多只能有一个架构师！");
        } else if (em instanceof Designer) {
            if (dsgnNum >= 2)
                throw new TeamException("团队中最多只能有两个设计师！");
        } else if (em instanceof Programmer) {
            if (prgNum >= 3)
                throw new TeamException("团队中最多只能有三个程序员！");
        }

        pg.setTeamId(counter++);
        team[total++] = pg;
        pg.setStatus(Status.BUSY);

    }

    /**
     * @Description 删除成员
     * @Param [teamId]
     */
    public void removeMember(int teamId) throws TeamException {

        boolean isFound = false;// 是否找到目标成员

        for (int i = 0; i < total; i++) {

            if (team[i] == null)// 遍历到空，退出
                break;

            if (isFound) {// 已找到

                team[i-1] = team[i];
                team[i] = null;

            } else {// 未找到

                if (team[i].getTeamId() == teamId) {// 匹配到目标成员
                    team[i].setStatus(Status.FREE);
                    team[i] = null;
                    isFound = true;
                }

            }
        }

        if (!isFound)
            throw new TeamException("找不到指定 teamId 的员工，删除失败");

        total--;

    }

    /**
     * @Description 返回 team 中所有程序员构成的数组
     * @Param
     */
    public Programmer[] getTeam() {
        Programmer[] pg = new Programmer[total];
        for (int i = 0; i < total; i++) {
            if (team[i] == null) {
                break;
            } else {
                pg[i] = team[i];
            }
        }
        return pg;
    }

    @Override
    public String toString() {
        Programmer[] t = getTeam();
        String str = "------------------------------ 开发团队成员列表 ----------------------------------\n";
        str += "TID\\ID \t名字   \t年龄\t工资   \t岗位   \t状态  \t奖金   \t股票  \t设备\n";

        if(t.length == 0){
            str += "\n暂无开发人员!\n\n";
        }
        for (int i = 0; i < t.length; i++) {
            str += team[i].getTeamId() + " \\ " + team[i].toString()  + "\n";
        }
        str += "-------------------------------------------------------------------------------\n";
        return str;
    }

    public static int getTotal() {
        return total;
    }

    public int getMAX_MEMBER() {
        return MAX_MEMBER;
    }
}
