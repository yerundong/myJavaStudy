package 变量与常量;

import common.Util;

/*
常量：在程序运行期间，固定不变的量。

常量的分类：
1. 整数常量：分为byte、short、int、long，默认为int类型。如果
2. 字符串常量：凡是用双引号引起来的部分，叫做字符串常量。例如："abc"、"Hello"、"123"
3. 浮点数常量：直接写上的数字，有小数点，默认为double类型。例如：2.5、-3.14、0.0
4. 字符常量：凡是用单引号引起来的单个字符，就做字符常量。例如：'A'、'b'、'9'、'中'
5. 布尔常量：只有量中取值。true、false。
6. 空常量：null。代表没有任何数据。
*/
public class 常量{
    public static void main(String[] args){
        Integer a = 111;
        String b = "111";
        Util util = new Util();

        System.out.println("************整数常量************");
        // 整数常量
        System.out.println(util.getType(111));// 默认为int类型
        System.out.println(util.getType((int)111));// int类型
        System.out.println(util.getType((byte)222));
        System.out.println(util.getType((short)333));
        System.out.println(util.getType(444L));
        System.out.println(util.getType((long)444));
        System.out.println(1l + 2);
        System.out.println(util.getType(1 + (byte)2));

        System.out.println("************浮点数常量************");
        System.out.println(util.getType(1.5));// 默认为double类型
        System.out.println(util.getType(0.0));
        System.out.println(util.getType(3.3F));
        System.out.println(util.getType((float)3.3));

        System.out.println("************字符串常量************");
        System.out.println(util.getType("ppp"));
        System.out.println(util.getType(""));
        System.out.println(util.getType("123"));

        System.out.println("************字符常量************");
        System.out.println(util.getType('a'));
        System.out.println(util.getType('9'));
        System.out.println(util.getType(' '));
        System.out.println('中');
        // System.out.println('');// 报错
        // System.out.println('-5');// 报错
        // System.out.println('ab');// 报错

        System.out.println("************布尔常量************");
        System.out.println(util.getType(true));
        System.out.println(true);
        System.out.println(false);

        // 空常量
        // 无法打印输出
        // System.out.println(null);// 报错
        System.out.println(util.getType(null));
    }
}
