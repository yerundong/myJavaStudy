package 类.练习;

import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) {
        // System.in代表从键盘进行输入
        Scanner sc = new Scanner(System.in);

        // @ sc.nextInt()获取键盘输入的int数字
        // int num = sc.nextInt();
        // System.out.println("我输入了一个数字："+num);

        // @ sc.next()获取键盘输入的String字符串
        // String str = sc.next();
        // System.out.println("我输入了一个字符串："+str);

        // 练习：输入两个数字，求它们的和
        inputForSum();

    }
    public static void inputForSum(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        int num1 = sc.nextInt();
        System.out.println("请输入第二个数字：");
        int num2 = sc.nextInt();
        System.out.println("它们的和是：" + (num1 + num2));
    }
}
