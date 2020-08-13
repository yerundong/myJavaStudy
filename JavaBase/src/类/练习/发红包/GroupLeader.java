package 类.练习.发红包;

import java.util.ArrayList;

// 群主（发红包）
public class GroupLeader extends User {
    public GroupLeader() {
    }

    public GroupLeader(String name, int money) {
        super(name, money);
    }

    // 发红包
    public ArrayList<Integer> give(int giveTotalMoney, int copies){
        ArrayList<Integer> reList = new ArrayList<Integer>();
        int leftMoney = super.getMoney();
        if(leftMoney < giveTotalMoney){
            System.out.println("余额不足！");
            return reList;
        }

        super.setMoney(leftMoney - giveTotalMoney);
        int avg = giveTotalMoney / copies;
        int mod = giveTotalMoney % copies;
        for (int i = 0; i < copies; i++) {
            if(i == copies-1){
                reList.add(avg + mod);
            }else{
                reList.add(avg);
            }
        }
        return reList;
    }
}
