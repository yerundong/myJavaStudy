package 变量与常量;

import common.Util;

public class 常量 {
    public static void main(String[] args) {
        Integer a = 111;
        String b = "111";

        System.out.println("************整数常量************");
        // 整数常量
        System.out.println(Util.getType(111));// 默认为int类型
        System.out.println(Util.getType((int) 111));// int类型
        System.out.println(Util.getType((byte) 222));
        System.out.println(Util.getType((short) 333));
        System.out.println(Util.getType(444L));
        System.out.println(Util.getType((long) 444));
        System.out.println(1l + 2);
        System.out.println(Util.getType(1 + (byte) 2));

        System.out.println("************浮点数常量************");
        System.out.println(Util.getType(1.5));// 默认为double类型
        System.out.println(Util.getType(0.0));
        System.out.println(Util.getType(3.3F));
        System.out.println(Util.getType((float) 3.3));

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
