package 数据类型;

/***
@强制类型的转换： 向下转换，将数据是从范围大到小的转换

@格式： 类型 变量 = （类型）数据

@注意事项：
	1.不推荐使用，有可能发生精度损失、数据溢出
	2.byte/short/char三种类型：如果【常量数据】强制转换为此三种类型，且常量数据【不超过此三种类型范围】，可以省略强制格式——"(类型)"
	  javac编译器将会自动隐含地补上一个(byte)(short)(char)

	3.只有数字类型和char类型（char类型底层也是储存数字）的数据，也就是与 Number 类相关的数据类型，才可以发生转换（包括自动和强制），
	  boolean 类型与数字不相关，不能发生数据类型转换，强制和自动都不行

*/
public class 基本数据类型之间的强制转换 {
    public static void main(String[] args){

        // @ =时的强制类型的转换
        // int num1 = 100L;// 报错: 既不能自动提升，又没声明强制转换，类型不兼容

        // 左边是int，右边是long，左比右小，需要强制转换。
        int num1 = (int)100L;

        // long类型强制转换成int类型，int类型装不下，数据溢出
        int num2 = (int)6000000000L;
        System.out.println(num2);

        // double --> int，强类型转换，浮点型精度丢失
        int num3 = (int)3.5;
        System.out.println(num3);// 3

        // @ byte/short/char三种类型隐含的强制转换
        int num4 = 4;
        int num5 = 5;
        // byte byte1 = num4 + num5;// 编译报错：不是常量，不能省略
        byte byte1 = (byte)(num4 + num5);

        // byte byte2 = 666;// 编译报错：超过范围
        // byte byte2 = 123 + 6;// 编译报错：超过范围
        byte byte2 = 4 + 6;

        // int 强转成 char
        char char1 = 65;
        System.out.println(char1);// A
    }
}
