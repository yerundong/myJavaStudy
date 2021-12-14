package 反射.lib;

import lib.Tool;

import java.io.IOException;

@myAnno(value = 1000, key = '中')
public class Son extends Father<String> implements People {
    public String girlFriend;
    protected int girlFriendNumber;
    String phrase;
    private Tool tool;
    public static String kelly;
    public static final String XOS = "China";

    public Son(String name) {
        super(name);
    }

    public Son(String name, int gfn, Tool t) {
        super(name);
        girlFriendNumber = gfn;
        tool = t;
    }

    private Son(String name, String phrase) {
        super(name);
        this.phrase = phrase;
    }

    @myAnno(value = 1, key = 'a')
    @Override
    public void eat() {
    }

    @Override
    public void work() {
    }

    public String fly(String s) {
        return s;
    }

    protected boolean shout() throws Exception, IOException {
        return true;
    }

    void see() {
    }

    private void kick() {
    }

    public static void jump() {
        System.out.println("I am jumping");
    }

    public void setGirlFriend(String girlFriend) {
        this.girlFriend = girlFriend;
    }

    @Override
    public String toString() {
        return "Son{" +
                "girlFriend='" + girlFriend + '\'' +
                ", girlFriendNumber=" + girlFriendNumber +
                ", phrase='" + phrase + '\'' +
                ", tool=" + tool +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                "} " + super.toString();
    }
}
