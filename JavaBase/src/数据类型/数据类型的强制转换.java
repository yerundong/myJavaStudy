package 数据类型;

/*
强制类型的转换
	1.应用：数据范围是从大到小的转换
	2.特点：代码需要手动的格式处理，不能自动完成。
	3.格式：类型 变量 = （类型）数据
注意事项：
	1.不推荐使用，有可能发生精度损失、数据溢出
	2.byte/short/char这三种类型都可以发生数学运算，例如加法“+”，
	3.这三种类型在运算的时候，都会被提升成为int类型，然后计算
	4.boolean类型不能发生数据类型转换

*/
public class 数据类型的强制转换 {
    public static void main(String[] args){
        // 左边是int，右边是long，类型不一样，就要转换
        // long --> int，范围是从大到小，不能自动转换
        // int num1 = 100L;// 报错: 不兼容的类型: 从long转换到int可能会有损失
        int num1 = (int)100L;
        System.out.println(num1);
        // long类型强制转换成int类型
        // 数据溢出
        int num2 = (int)60000000000L;
        System.out.println(num2);
        // double --> int，强类型转换
        // 精度丢失
        int num3 = (int)3.5;
        System.out.println(num3);// 3
        char zifu1 = 'A';
        System.out.println(zifu1 + 1);// 66
        // 计算机的底层会用一个数字（二进制）代表字符A，就是65
        // 一旦char类型进行计算，那么字符就会按照一定规则翻译成一个数字
        byte num4 = 40;
        byte num5 = 50;
        // byte + byte --> int + int = int;
        // int --> byte 范围大到小，所以报错
        // byte num6 = num4 + num5;// 报错
        // byte num6 = (byte)(num4 + num5);
        int num6 = num4 + num5;
        System.out.println(num6);
        short num7 = 60;
        // int --> short，强制转换
        short num8 = (short)(num7 + num5);
        System.out.println(num8);
    }
}
