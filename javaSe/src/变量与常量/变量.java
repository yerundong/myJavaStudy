package 变量与常量;

public class 变量 {
    public static void main(String[] args) {
        System.out.println("=========整数==========");

        // 创建一个变量
        int num1;

        // 赋值
        num1 = 123;
        System.out.println(num1);// 123

        // 改变变量的值
        num1 = 10;
        System.out.println(num1);// 10

        // 一步到位：创建+赋值
        int num2 = 20;
        byte num3 = 30;

        // byte num4 = 128;// 数值超出，编译报错
        long num5 = 3000000000L;// 一定要带l或L
        System.out.println(num5);

        short num6 = 32000;
        System.out.println(num6);

        System.out.println("=========浮点数==========");
        float num7 = 2.5F;// 一定要带f或F
        System.out.println(num7);
        double num8 = 2.5;
        System.out.println(num8);

        System.out.println("=========字符==========");
        char zifu1 = 'a';
        zifu1 = '中';
        System.out.println(zifu1);

        System.out.println("=========布尔==========");
        boolean bool1 = false;
        boolean bool2 = true;
        bool1 = bool2;
        System.out.println(bool1);
        {
            boolean bool3 = true;
        }
        // System.out.println(bool3);// 报错

        // 一次创建多个变量
        int a, b = 10, c = 30;
        a = 5;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
