package 类和对象.练习.高级版发红包;

public class Main {
    public static void main(String[] args) {
        MyRed myred = new MyRed("我发红包啦");
        myred.setOwnerName("王思聪");

        // 普通红包
        NomalMode nomalMode = new NomalMode();
        // myred.setOpenWay(nomalMode);

        // 手气红包
        RandomMode randomMode = new RandomMode();
        myred.setOpenWay(randomMode);
    }
}
