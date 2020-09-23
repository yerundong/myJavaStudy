package 类和对象.练习.发红包;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GroupLeader leader = new GroupLeader("王富贵", 1000);
        CommonMember member1 = new CommonMember("狗子", 10);
        CommonMember member2 = new CommonMember("柱子", 10);
        CommonMember member3 = new CommonMember("狗剩", 10);
        leader.show();
        member1.show();
        member2.show();
        member3.show();

        ArrayList<Integer> redBagList = leader.give(500, 3);
        System.out.println(redBagList);

        member1.receive(redBagList);
        member2.receive(redBagList);
        member3.receive(redBagList);

        leader.show();
        member1.show();
        member2.show();
        member3.show();
    }
}
