package 类和对象.隐藏;

public class Main {
    public static void main(String[] args) {
        TestSub sub = new TestSub();
        System.out.println(sub.name);

        System.out.println(TestSub.tip);
        System.out.println(TestSuper.tip);

        TestSub.says();
        TestSuper.says();
    }
}
