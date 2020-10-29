package 数据类型;

import common.Util;

public class 不同类型的数据转换 {
    public static void main(String[] args) {
        Util util = new Util();

        // @ 8种基本类型 --> String类型
        byte byte1 = 1;
        short sht1 = 2;
        int int1 = 3;
        long lng1 = 4;
        float flt1 = 5.5F;
        double dbe1 = 6.6;
        char char1 = 'a';
        boolean boo1 = true;

        // valueOf方法
        String str1 = String.valueOf(byte1);
        String str2 = String.valueOf(sht1);
        String str3 = String.valueOf(int1);
        String str4 = String.valueOf(lng1);
        String str5 = String.valueOf(flt1);
        String str6 = String.valueOf(dbe1);
        String str7 = String.valueOf(char1);
        String str8 = String.valueOf(boo1);

        // 字符串拼接方式
        String str9 = lng1 + "";
        String str10 = char1 + "";
        String str11 = boo1 + "";
        System.out.println(str9);
        System.out.println(str10);
        System.out.println(str11);

        System.out.println("=================================");

        // @ String --> 8种基本类型

        // Xxx.parseXxx(s) （不适用于char）
        // s 必须是符合转换类型规则的字符串
        byte byte2 = Byte.parseByte("1");
        short sht2 = Short.parseShort("2");
        int int2 = Integer.parseInt("3");
        long lng2 = Long.parseLong("4");
        float flt2 = Float.parseFloat("6.0");
        double dbe2 = Double.parseDouble("7.0");
        // char char2 = Character.parseChar("A");// 报错，没有该方法
        boolean boo2 = Boolean.parseBoolean("false");// s推荐是布尔值字符串（忽略大小写），布尔值字符串返回对应布尔值，其他都返回false

        System.out.println(byte2);
        System.out.println(sht2);
        System.out.println(int2);
        System.out.println(lng2);
        // System.out.println(util.getType(lng2));// Long
        System.out.println(flt2);
        System.out.println(dbe2);
        System.out.println(boo2);

        // String --> char
        // charAt()
        char char2 = "A".charAt(0);
        char char3 = (char)Integer.parseInt("65");
        System.out.println(char2);// A
        System.out.println(char3);// A

        System.out.println("=================================");

        // @ 基本类型互转
        // 可以用自动和强制类型转换

        // char --> int
        int int4 = 'a';
        System.out.println(int4);// 97
        System.out.println((int)'a');// 97
        System.out.println('a' + 0);// 97
    }
}
