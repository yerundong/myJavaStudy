package 类和对象.重载;

public class 重载 {
    public static void main(String[] args) {
        sum(10, 20);
        sum(10, 20, 30);
        sum(10, 20, 30, 40);
        sum(3.14F, 20);
        sum(20, 3.14F);
    }

    public static void sum(int a, int b) {
        System.out.println(a + b);
    }

    public static void sum(int a, int b, int c) {
        System.out.println(a + b + c);
    }

    public static void sum(int a, int b, int c, int d) {
        System.out.println(a + b + c + d);
    }

    public static int sum(float a, int b) {
        System.out.println(a + b);
        return (int) (a + b);
    }

    public static int sum(int b, float a) {
        System.out.println("bingo:" + a + b);
        return (int) (a + b);
    }

//    与方法的返回值无关
//    public static void sum(float a, int b){
//        System.out.println(a + b);
//    }

//    与参数的名称无关
//    public static void sum(float x, int y){
//        System.out.println(a + b);
//    }
}
