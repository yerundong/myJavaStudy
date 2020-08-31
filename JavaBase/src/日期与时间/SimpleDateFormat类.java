package 日期与时间;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
@ SimpleDateFormat类：
    是一个以与语言环境有关的方式来格式化和解析日期的具体类。
    它允许进行格式化（日期 -> 文本）、解析（文本 -> 日期）和规范化。

@ 构造方法：
    1. SimpleDateFormat()：用默认的模式和默认语言环境的日期格式符号构造
    1. SimpleDateFormat(String pattern)：用特定的日期时间的字母模式构造
    ...

@ 成员方法：
    @ public StringBuffer format(Date date)：将给定的 Date 格式化为日期/时间字符串，并将结果添加到给定的 StringBuffer。
    @ public Date parse(String text, ParsePosition pos)：解析字符串的文本，生成 Date。
*/
public class SimpleDateFormat类 {
    public static void main(String[] args) throws ParseException {
        // @ 构造方法
        SimpleDateFormat sdf1 = new SimpleDateFormat();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");

        System.out.println(sdf1);

        // @ 成员方法：
        // @ public StringBuffer format(Date date)
        System.out.println(sdf1.format(new Date()));// 2020/8/30 下午11:24
        System.out.println(sdf2.format(new Date()));// 2020-08-30 11:59:56:274
        System.out.println(sdf3.format(new Date()));// 2020年08月31日 03时53分57秒

        // @ public Date parse(String text, ParsePosition pos)
        System.out.println(sdf1.parse("2020/8/30 下午11:24"));
        System.out.println(sdf2.parse("2021-08-30 11:59:56:274"));


    }
}
