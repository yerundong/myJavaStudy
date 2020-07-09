package 数据类型;

/*
	当数据类型不一样时，将发生数据类型转换。

	自动类型转换（隐式）
		1.特点：代码不需要进行特殊处理，自动完成。
		2.规则：数据范围从小到大（与字节数无关）。

	强制类型转换（显式）
*/
public class 数据类型的自动转换{
    public static void main(String[] args){
        System.out.println(1024); // 整数，默认int
        System.out.println(3.14); // 浮点数，默认double

        // 左边long类型，右边是默认int，左右不一样，发生自动类型转换。
        // 一个等号代表赋值，将右侧的int类型交给左侧的long变量进行储存。
        // int --> long，符合从小到大的规则。
        long num1 = 100;
        System.out.println(num1);

        // float --> double，符合从小到大的规则。
        double num2 = 2.5F;
        System.out.println(num2);

        // 注意：float、double类型比long类型范围大
        // long --> float，符合从小到大的规则。
        float num3 = 30L;
        System.out.println(num3);

        char zifu1 = 'A';// 底层保存的是ascii码表对应的十进制数字：65
        // char --> int 发生了自动类型转换
        int num4 = zifu1;
        System.out.println(num4);// 65

        char zifu2 = '国';
        System.out.println(zifu2 + 0);// 22269
    }
}
