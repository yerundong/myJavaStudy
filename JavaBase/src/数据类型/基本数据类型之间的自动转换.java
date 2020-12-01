package 数据类型;

import common.Util;

/***
 @定义： 基本数据类型（除布尔类型外）在某些情况下将发生数据类型自动转换。这些情况包括：赋值运算，数学运算，三目运算，传参等

 @快速记忆： 数字相关才能玩，运算，传参，不带布尔玩

 @自动类型转换（提升）特点：
    1.代码不需要进行特殊处理，自动完成。
    2.数据范围从小到大自动转变（与字节数无关），所以也叫提升。
    3.byte/short/char这三种类型在运算的时候，都默认被先提升成为int类型，然后计算
    4.只有数字类型（byte/short/int/long/float/double）和char类型（char类型底层也是储存数字）的数据，也就是与 Number 类相关的数据类型，
      才可以发生转换（包括自动和强制），而 boolean 类型与数字不相关，不能发生数据类型转换（强制和自动都不行）

*/
public class 基本数据类型之间的自动转换 {
    public static void main(String[] args){
        // 一、赋值运算时的自动类型提升
        // 左边long类型，右边是默认int，左比右大，发生自动类型提升。
        // int --> long，符合从小到大的规则。
        long num1 = 100;

        // float --> double，左比右大，发生自动类型提升。
        double num2 = 2.5F;

        // 注意：float、double类型比long类型范围大
        // long --> float，符合从小到大的规则。
        float num3 = 30L;

        // 'A'底层保存的是ascii码表对应的十进制数字：65
        // char --> int 左比右大，发生自动类型提升
        int num4 = 'A';
        // System.out.println(num4);// 65

        // boolean 不能类型转换所以也不能计算
        // int num5 = false;// 编译报错

        // 二、数学运算
        // byte/short/char这三种类型在运算的时候，都会被先提升成为int类型，然后计算
        System.out.println("数学运算：" + ('国' + 0));// 22269
        System.out.println("数学运算：" + '国' * 1);// 22269
        System.out.println("数学运算：" + '国' * 1);// 22269

        // char提升为int，又提升为float
        System.out.println('国' + 1.0f);// 22270.0

        // char提升为int
        System.out.println('国' + (byte)1);// 22270

        // boolean 不能类型转换所以也不能计算
        // System.out.println(false + 1);// 编译报错

        // 三、关系运算
        // char提升为int
        System.out.println('a' == 97);// true

        // char提升为double
        System.out.println('a' == 97.0);// true

        // int -> long
        System.out.println("关系运算：" + (97 == 97l));// true

        // boolean 不能类型转换所以也不能计算
        boolean bool = false;
        // System.out.println(false == 123);// 编译报错

        // 四、三元运算
        // 三元运算符要求两个结果的类型相同，所以也存在自动类型提升
        Object o1 = true ? 1 : 2.0;
        System.out.println(o1);// 1.0
        System.out.println(Util.getType(o1));// Double

        // 五、传参
        autoChange('a');// 97
    }

    public static void autoChange(int n){
        System.out.println(n);
    }
}
