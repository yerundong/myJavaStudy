package 变量与常量;

import common.Util;

/**
@常量： 在程序运行期间，固定不变的量。

@常量的分类：
    1. 整数常量：分为byte、short、int、long，默认为int类型。如果
    2. 字符串常量：凡是用双引号引起来的部分，叫做字符串常量。例如："abc"、"Hello"、"123"
    3. 浮点数常量：直接写上的数字，有小数点，默认为double类型。例如：2.5、-3.14、0.0
    4. 字符常量：凡是用单引号引起来的单个字符，就做字符常量。例如：'A'、'b'、'9'、'中'
    5. 布尔常量：只有量中取值。true、false。
    6. 空常量：null。代表没有任何数据。

@编译器的常量优化： 在给变量进行赋值的时候，如果右侧的表达式当中全都是常量，没有任何变量，那么编译器javac将会直接将若干个常量表达式计算得到结果。
    如：short result = 5 + 8 等号右边全都是常量，没有任何变量参与运算，编译之后，得到的.class字节码文件当中优化成：short result = 13 。
    这称为“编译器的常量优化”。（注意：一旦表达式当中有变量参与，那么就不能进行这种优化了）

*/
public class 常量{
    public static void main(String[] args){
        Integer a = 111;
        String b = "111";

        System.out.println("************整数常量************");
        // 整数常量
        System.out.println(Util.getType(111));// 默认为int类型
        System.out.println(Util.getType((int)111));// int类型
        System.out.println(Util.getType((byte)222));
        System.out.println(Util.getType((short)333));
        System.out.println(Util.getType(444L));
        System.out.println(Util.getType((long)444));
        System.out.println(1l + 2);
        System.out.println(Util.getType(1 + (byte)2));

        System.out.println("************浮点数常量************");
        System.out.println(Util.getType(1.5));// 默认为double类型
        System.out.println(Util.getType(0.0));
        System.out.println(Util.getType(3.3F));
        System.out.println(Util.getType((float)3.3));

        System.out.println("************字符串常量************");
        System.out.println(Util.getType("ppp"));
        System.out.println(Util.getType(""));
        System.out.println(Util.getType("123"));

        System.out.println("************字符常量************");
        System.out.println(Util.getType('a'));
        System.out.println(Util.getType('9'));
        System.out.println(Util.getType(' '));
        System.out.println('中');
        // System.out.println('');// 报错
        // System.out.println('-5');// 报错
        // System.out.println('ab');// 报错

        System.out.println("************布尔常量************");
        System.out.println(Util.getType(true));
        System.out.println(true);
        System.out.println(false);

        // 空常量
        // 无法打印输出
        // System.out.println(null);// 报错
        System.out.println(Util.getType(null));
    }
}
