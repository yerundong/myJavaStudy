package 权限修饰符.Public修饰符;

public class Main {
    public static void main(String[] args) {
        TestPublic tom = new TestPublic();
        System.out.println(tom.plnum);

        // 不能修饰变量
        // public int num = 321;// 报错
    }
}
