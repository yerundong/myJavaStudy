package 类.练习.发红包;

import java.util.ArrayList;
import java.util.Random;

// 群员（收红包）
public class CommonMember extends User {
    public CommonMember() {
    }

    public CommonMember(String name, int money) {
        super(name, money);
    }

    // 收红包
    public void receive(ArrayList<Integer> redBagList ){
        int leftMoney = super.getMoney();
        int size = redBagList.size();
        Random rd = new Random();
        int rdIdnex = rd.nextInt(size);
        int pickBagMoney = redBagList.remove(rdIdnex);
        // System.out.println(pickBagMoney);
        super.setMoney(leftMoney + pickBagMoney);
    }

}
