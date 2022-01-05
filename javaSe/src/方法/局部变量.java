package 方法;

public class 局部变量 {
    public static void main(String[] args) {
        says(1);
    }

    public static void says(int num1) {
        // 形参
        System.out.println(num1);

        // 普通局部变量
        int num2;
        // System.out.println(num2);// 报错
        num2 = 2;
        System.out.println(num2);

        // 代码块局部变量
        {
            int num3 = 3;
            System.out.println(num3);
        }

        // System.out.println(num3);// 报错
    }
}
