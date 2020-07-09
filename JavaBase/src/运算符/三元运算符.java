package 运算符;

public class 三元运算符{
    public static void main(String[] args){
        int num1 = 10 > 5 ? 20 : 30;
        System.out.println(num1);

        System.out.println(10 > 5 ? 25 : 30);

        // int num2 = 2 > 1 ? 100 : 200.5;// 错误
        int num2 = (int)(2 > 1 ? 100.5 : 200.5);
        System.out.println(num2);


    }
}