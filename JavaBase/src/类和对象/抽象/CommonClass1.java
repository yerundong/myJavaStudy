package 类和对象.抽象;

public class CommonClass1 extends AbsctClass {

    public CommonClass1() {
    }

    public CommonClass1(int num) {
        super(num);
    }

    @Override
    public void says() {
        System.out.println("i am CommonClass1 says");
    }

    @Override
    public void run() {
        System.out.println("i am CommonClass1 run");
    }
}
