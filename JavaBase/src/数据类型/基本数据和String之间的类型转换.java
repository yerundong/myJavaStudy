package 数据类型;

import org.junit.jupiter.api.Test;

/**

 @快速记忆： 基本转String用valueOf，toString，拼接符号黑科技；String转基本用parse，只有char搞特殊。

 */
public class 基本数据和String之间的类型转换 {

/*************** 8种基本类型（byte\short\int\long\float\double\char\boolean） --> String类型 ***************/

    /**
     * @Description 一、String.valueOf
     */
    @Test
    public void valueOf(){
        // <SM> public static String valueOf(BasicTypes val)
        String str1 = String.valueOf((byte)1);
        String str2 = String.valueOf((short)2);
        String str3 = String.valueOf(3);
        String str4 = String.valueOf(4L);
        String str5 = String.valueOf(5.1F);
        String str6 = String.valueOf(6.2);
        String str7 = String.valueOf('a');
        String str8 = String.valueOf(true);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
        System.out.println(str6);
        System.out.println(str7);
        System.out.println(str8);
    }

    /**
     * @Description 二、包装类的toString方法
     */
    @Test
    public void toString_(){
        // <SM> public static String toString(BasicTypes val)

        String str1 = Byte.toString((byte)1);
        String str2 = Short.toString((short)2);
        String str3 = Integer.toString((short)3);
        String str4 = Long.toString(4L);
        String str5 = Float.toString(5.1F);
        String str6 = Double.toString(6.2);
        String str7 = Character.toString('a');
        String str8 = Boolean.toString(true);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
        System.out.println(str6);
        System.out.println(str7);
        System.out.println(str8);
    }

    /**
     * @Description 三、字符串拼接方式
     */
    @Test
    public void connected(){
        String str1 = (byte)1 + "";
        String str2 = (short)2 + "";
        String str3 = 3 + "";
        String str4 = 4L + "";
        String str5 = 5.1F + "";
        String str6 = 6.2 + "";
        String str7 = 'a' + "";
        String str8 = true + "";

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
        System.out.println(str6);
        System.out.println(str7);
        System.out.println(str8);
    }

/**************** String类型 --> 8种基本类型（byte\short\int\long\float\double\char\boolean） ***************/

    /**
     * @Description 一、包装类的parseXxx(s)方法（不适用于char）
     */
    @Test
    public void parseXxx(){
        // <SM> public static byte parseByte(String s)
        // <注> s 必须是符合转换类型规则的字符串
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
        System.out.println(flt2);
        System.out.println(dbe2);
        System.out.println(boo2);
    }

    /**
     * @Description 二、String --> char
     */
    @Test
    public void stringTochar(){
        // 方式一
        char char1 = "A".charAt(0);
        // 方式二
        char char2 = (char)Integer.parseInt("65");
        System.out.println(char1);// A
        System.out.println(char2);// A
    }
}
