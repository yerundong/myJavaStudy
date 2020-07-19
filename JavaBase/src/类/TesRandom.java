package 类;

import java.util.Random;
/*
Random类用来生成随机数字。使用起来也是三个步骤：

1. 导包
import java.util.Random;

2. 创建
Random r = new Random(); // 小括号当中留空即可

3. 使用
获取一个随机的int数字（范围是int所有范围，有正负两种）：int num = r.nextInt()
获取一个随机的int数字（参数代表了范围，左闭右开区间）：int num = r.nextInt(3)
实际上代表的含义是：[0,3)，也就是0~2
 */
public class TesRandom {
    public static void main(String[] args) {
        Random rd = new Random();
        int num1 = rd.nextInt();
        System.out.println("随机int数是："+num1);

        int num2 = rd.nextInt(10);
        System.out.println("0~9随机int数是："+num2);

        int num3 = rd.nextInt(10) + 1;
        System.out.println("1~10随机int数是："+num3);
    }
}
