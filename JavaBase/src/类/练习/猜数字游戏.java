package 类.练习;

import java.util.Random;
import java.util.Scanner;

public class 猜数字游戏 {
    public static void main(String[] args) {
        Random rd = new Random();
        int num = rd.nextInt(100);
        // System.out.println(num);

        System.out.println("你猜：");
        while (true){
            Scanner sc = new Scanner(System.in);
            int prenum = sc.nextInt();
            if(prenum > num){
                System.out.println("太大了！请再猜：");
            }else if(prenum < num){
                System.out.println("太小了！请再猜：");
            }else{
                System.out.println("恭喜你猜对了！游戏结束，没有奖励！");
                break;
            }
        }
    }
}
