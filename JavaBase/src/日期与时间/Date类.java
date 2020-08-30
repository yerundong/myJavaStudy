package 日期与时间;
import java.util.Date;
/*
@ Date类：表示特定的瞬间，精确到毫秒。

@ 构造方法：
    1. Date()：获取当前时间对象
    1. Date(long ms)：获取指定时间对象，ms：毫秒，long类型

@ 成员方法：
    @ public long getTime()：获取Date 对象的毫秒数
    @ public String toString() ：把Date 对象转换为以下形式的 String：dow mon dd hh:mm:ss zzz yyyy
    @ public boolean after(Date date)：测试此日期是否在指定日期之后。
    @ public boolean before(Date date)：测试此日期是否在指定日期之前。
    @ public Object clone()：返回此对象的副本。
    @ public int compareTo(Date anotherDate)：比较两个日期的顺序。
    @ public boolean equals(Object obj)：比较两个日期（值）的相等性。重写了 Object 的 equals 方法，比较值
*/
public class Date类 {
    public static void main(String[] args) {
        // 构造方法
        Date date = new Date();
        Date date2 = new Date(1598891904923L);
        System.out.println(date);// Sun Aug 30 20:54:51 CST 2020
        System.out.println(date2);// Tue Sep 01 00:38:24 CST 2020

        // public long getTime()
        System.out.println(date.getTime());

        // public String toString()
        System.out.println(date.toString());// Sun Aug 30 20:54:51 CST 2020

        // boolean after(Date date)
        System.out.println(new Date(1598891904921L).after(new Date(1598891904920L)));// true

        // boolean before(Date date)
        System.out.println(new Date(1598891904921L).before(new Date(1598891904922L)));// true

        // public Object clone()
        System.out.println(date2.clone());// Tue Sep 01 00:38:24 CST 2020

        // public int compareTo(Date anotherDate)
        System.out.println(date.compareTo(date));// 0
        System.out.println(new Date(3898891904921L).compareTo(new Date(1598891904921L)));// 1
        System.out.println(new Date(1598891904921L).compareTo(new Date(3898891904921L)));// -1

        // public boolean equals(Object obj)
        System.out.println(date.equals(date));// true
        System.out.println(new Date(3898891904921L).equals(new Date(3898891904921L)));// true
    }
}
