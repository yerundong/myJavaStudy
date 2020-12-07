package 日期与时间;
import org.junit.jupiter.api.Test;

import java.util.Date;
/**

 @Date类： java.util.Date 表示日期对象，精确到毫秒。 java.sql.Date 表示数据库中的日期类型变量。java.sql.Date 是 java.util.Date 的子类。

 @注：
    Date类自jdk 1.0即存在，但是它的大多数方法已经在JDK 1.1引入Calendar类之后被弃用了。而Calendar并不比Date好多少。它们面临的问题有：
        1.可变性：像日期和时间这样的类应该是不可变的。
        2.偏移性：Date中的年份是从1900开始的，而月份都从0开始。
        3.格式化：格式化只对Date有用，Calendar则不行。
        4.此外，它们也不是线程安全的；不能处理闰秒等。
    第三次引入的API是成功的，Java 8 吸收了 Joda-Time 的精华，本地日期（LocalDate）、本地时间（LocalTime）、本地日期时间（LocalDateTime）、
    时区（ZonedDateTime）和持续时间（Duration）的类。

 @快速记忆： 方法比较少（很多弃用）：比较，克隆，时间戳，更具体地获取和设置可以用 Calendar 类
*/
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
