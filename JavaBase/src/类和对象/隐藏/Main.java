package 类和对象.隐藏;

/*
@ 隐藏：隐藏是对于成员变量（包括实例变量和静态变量）和静态方法而言的
*/
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
