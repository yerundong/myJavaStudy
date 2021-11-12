package 数据类型;

import org.junit.jupiter.api.Test;

public class 基本数据类型之间的强制转换 {
    @Test
    public void 常规强制转换() {
        // int num1 = 100L;// 报错: 既不能自动提升，又没声明强制转换，类型不兼容

        // 左边是int，右边是long，左比右小，需要强制转换。
        int num1 = (int) 100L;

        // long类型强制转换成int类型，int类型装不下，数据溢出
        int num2 = (int) 6000000000L;
        System.out.println(num2);

        // double --> int，强类型转换，浮点型精度丢失
        int num3 = (int) 3.5;
        System.out.println(num3);// 3
    }

    /**
     * @Description byte/short/char强制转换省略情况
     */
    @Test
    public void 特殊的强制转换() {
        // 常量数据强转为byte/short/char时可省略"(类型)"
        byte num1 = 5;// 5默认是int类型，此处强转为byte，省略了"(类型)"
        // byte num1 = (byte)5;

        int num4 = 4;
        int num5 = 5;
        // byte byte1 = num4 + num5;// 编译报错：不是常量，不能省略
        byte byte1 = (byte) (num4 + num5);

        // byte byte2 = 666;// 编译报错：超过范围
        // byte byte2 = 123 + 6;// 编译报错：超过范围
        byte byte2 = 4 + 6;

        // int 强转成 char
        int num6 = 65;
        char char1 = 65;
        System.out.println(char1);// A

        // char char2 = num6;// 编译报错：必须常量
        char char2 = (char) num6;
        System.out.println(char2);

        // stay(65, 13);// 编译报错：传参时都不能省略
        stay((char) 65, (byte) 13);
    }

    public void stay(char c, byte b) {
    }
}
