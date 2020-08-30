package 日期与时间;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
@ SimpleDateFormat类：
    是一个以与语言环境有关的方式来格式化和解析日期的具体类。
    它允许进行格式化（日期 -> 文本）、解析（文本 -> 日期）和规范化。

@ 构造方法：
    1. SimpleDateFormat()：用默认的模式和默认语言环境的日期格式符号构造
    1. SimpleDateFormat(String pattern)：

@ 成员方法：
    @ public StringBuffer format(Date date)
*/
public class SimpleDateFormat类 {
    public static void main(String[] args) {
        SimpleDateFormat sdf1 = new SimpleDateFormat();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");

        System.out.println(sdf1);

        // public StringBuffer format(Date date)
        System.out.println(sdf1.format(new Date()));// 2020/8/30 下午11:24
        System.out.println(sdf2.format(new Date()));// 2020-08-30 11:59:56
    }
}
