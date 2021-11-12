package 数据类型;

import common.Util;
import org.junit.jupiter.api.Test;

public class 基本数据类型之间的自动转换 {

    @Test
    public void 赋值运算时的自动类型提升() {
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
    }

    @Test
    public void 数学运算时的自动类型提升() {
        // byte/short/char这三种类型在运算的时候，都会被先提升成为int类型，然后计算
        System.out.println('国' + 0);// 22269
        System.out.println('国' * 1);// 22269
        System.out.println('国' * 1);// 22269

        // char提升为int，又提升为float
        System.out.println('国' + 1.0f);// 22270.0

        // char提升为int
        System.out.println('国' + (byte) 1);// 22270

        // boolean 不能类型转换所以也不能计算
        // System.out.println(false + 1);// 编译报错
    }

    @Test
    public void 关系运算时的自动类型提升() {
        // char提升为int
        System.out.println('a' == 97);// true

        // char提升为double
        System.out.println('a' == 97.0);// true

        // int -> long
        System.out.println("关系运算：" + (97 == 97l));// true

        // boolean 不能类型转换所以也不能计算
        boolean bool = false;
        // System.out.println(false == 123);// 编译报错
    }

    @Test
    public void 三元运算时的自动类型提升() {
        // 三元运算符要求两个结果的类型相同，所以也存在自动类型提升
        Object o1 = true ? 1 : 2.0;
        System.out.println(o1);// 1.0
        System.out.println(Util.getType(o1));// Double
    }

    @Test
    public void 传参时的自动类型提升() {
        // 当形参与实参类型不一，且满足自动提升要求时，会发生自动类型提升
        autoChange('a');// 97
    }

    public void autoChange(int n) {
        System.out.println(n);
    }
}
