package 日期与时间.Java8之前的日期与时间;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class Date类 {
    /**
     * @Description 构造器
     */
    @Test
    public void constructor() {
        // <CM> Date()：获取当前日期对象
        // <CM> Date(long ms)：获取指定日期对象，ms：毫秒，long类型
        // <注> 底层是用 System.currentTimeMillis() 获取系统时间并储存
        Date date = new Date();
        Date date2 = new Date(1598891904923L);
        System.out.println(date);// Sun Aug 30 20:54:51 CST 2020
        System.out.println(date2);// Tue Sep 01 00:38:24 CST 2020

    }

    @Test
    public void toString_() {
        // <M> public String toString()
        // <返> 把 Date 对象转换为以下形式的 String：dow mon dd hh:mm:ss zzz yyyy
        Date date = new Date();
        System.out.println(date.toString());// Thu Dec 03 17:34:27 CST 2020
    }

    @Test
    public void clone_() {
        // <M> public Object clone()
        // <返> 拷贝日期对象，并返回
        Date date = new Date();
        Object date1 = date.clone();
        System.out.println(date);// Thu Dec 03 17:40:51 CST 2020
        System.out.println(date1);// Thu Dec 03 17:40:51 CST 2020
        System.out.println(date == date1);// false
        System.out.println(date.equals(date1));// true
    }

    @Test
    public void getTime_setTime() {
        // <M> public long getTime()
        // <返> 获取 Date 对象的毫秒数，即时间戳
        // <M> public void setTime(long time)
        // <改> 设置 Date 对象的毫秒数
        Date date = new Date();
        System.out.println(date.getTime());

        date.setTime(1598891904921L);
        System.out.println(date.getTime());// 1598891904921
    }

    @Test
    public void before_after_compareTo() {
        // <M> public boolean before(Date when)
        // <返> 时间是否早于 when
        // <M> public boolean after(Date when)
        // <返> 时间是否晚于 when
        // <M> public int compareTo(Date anotherDate)
        // <返> 比较两个日期的先后顺序，早于 anotherDate 返-1，晚于 anotherDate 返1，相等返0
        Date date = new Date();

        System.out.println(new Date(1598891904921L).before(new Date(1598891904922L)));// true
        System.out.println(new Date(1598891904921L).after(new Date(1598891904920L)));// true

        System.out.println(date.compareTo(date));// 0
        System.out.println(new Date(3898891904920L).compareTo(new Date(3898891904929L)));// -1
        System.out.println(new Date(1598891904929L).compareTo(new Date(1598891904920L)));// 1
    }

    @Test
    public void equals() {
        // <M> public boolean equals(Object obj)
        // <返> 比较日期的时间值是否相等，比较内容
        Date date = new Date();
        System.out.println(date.equals(date));// true
        System.out.println(new Date(3898891904921L).equals(new Date(3898891904921L)));// true
        System.out.println(new Date(3898891904921L) == (new Date(3898891904921L)));// false
    }
}
