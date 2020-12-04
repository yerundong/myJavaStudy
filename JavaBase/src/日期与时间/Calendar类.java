package 日期与时间;

import common.Util;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
@Calendar类：
    Calendar类是一个[ 抽象类 ]，它为特定瞬间与一组诸如 YEAR、MONTH、DAY_OF_MONTH、HOUR 等 日历字段之间的转换提供了一些方法，
    并为操作日历字段（例如获得下星期的日期）提供了一些方法。

@唯一子类： GregorianCalendar

 @快速记忆： 抽象类，单例，获取和设置各个日历字段，转时间戳，转Date，比较，克隆
*/
public class Calendar类 {
    /**
     * @Description 获得实例
     */
    @Test
    public void getInstance() {
        // <SM> public static Calendar getInstance()
        // <返> GregorianCalendar 获得一个日历对象。返回的 Calendar 基于[当前时间]，使用了默认时区和默认语言环境。
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar instanceof GregorianCalendar);// true
        System.out.println(calendar);
        System.out.println(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DATE)
                + " " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.MILLISECOND));
    }

    /**
     * @Description 日历字段（静态变量）
     */
    @Test
    public void field() {
        // @日期
        // <SA> YEAR：年份
        // <SA> MONTH：当前年中的月数（0-11）（几月）
        // <SA> DATE：当前月中的天数（几号）
        // <SA> DAY_OF_MONTH：当前月中的天数（与DATE同，推荐）（几号）
        // <SA> DAY_OF_WEEK：当前周中的天数（周几）（星期日-星期六 对应：1-7）
        // <SA> WEEK_OF_YEAR：当前年中的星期数
        // <SA> WEEK_OF_MONTH：当前月中的星期数
        // <SA> DAY_OF_YEAR：当前年中的天数
        // <SA> DAY_OF_WEEK_IN_MONTH：指示当前月中的第几个星期。与 DAY_OF_WEEK 字段一起使用时，就可以唯一地指定某月中的某一天？？？。
        // @时间
        // <SA> HOUR：小时，12小时制 (0 - 11)。
        // <SA> HOUR_OF_DAY：小时，24小时制
        // <SA> MINUTE：分钟
        // <SA> SECOND：秒
        // <SA> MILLISECOND：毫秒

        System.out.println(Calendar.YEAR);
        System.out.println(Calendar.MONTH);
        System.out.println(Calendar.HOUR);
    }

    /**
     * @Description 获得日历字段对应的值
     */
    @Test
    public void get() {
        // <M> public int get(int field)
        // <返> 返回给定日历字段对应的值。field：日历字段
        Calendar calendar = Calendar.getInstance();
        System.out.println("YEAR = " + calendar.get(Calendar.YEAR));
        System.out.println("MONTH = " + calendar.get(Calendar.MONTH)+1);
        System.out.println("DATE = " + calendar.get(Calendar.DATE));
        System.out.println("DAY_OF_MONTH = " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("DAY_OF_WEEK = " + calendar.get(Calendar.DAY_OF_WEEK));

        System.out.println("HOUR = " + calendar.get(Calendar.HOUR));
        System.out.println("HOUR_OF_DAY = " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("MINUTE = " + calendar.get(Calendar.MINUTE));
        System.out.println("SECOND = " + calendar.get(Calendar.SECOND));
        System.out.println("MILLISECOND = " + calendar.get(Calendar.MILLISECOND));
    }

    /**
     * @Description 设置日历字段对应的值
     */
    @Test
    public void set() {
        // <M> public void set(int field, int value)
        // <改> 将给定的日历字段设置为给定值。不管处于何种宽松性模式下，该值都不由此方法进行解释。
        // <M> public final void set(int year, int month, int date)
        // <改> 设置日历字段 YEAR、MONTH 和 DAY_OF_MONTH 的值。保留其他日历字段以前的值。如果不需要这样做，则先调用 clear()。
        // <M> public final void set(int year, int month, int date, int hourOfDay, int minute)
        // <改> 设置日历字段 YEAR、MONTH、DAY_OF_MONTH、HOUR_OF_DAY 和 MINUTE 的值。保留其他字段以前的值。如果不需要这样做，则先调用 clear()。
        // <M> set(int year, int month, int date, int hourOfDay, int minute, int second)
        // <改> 设置字段 YEAR、MONTH、DAY_OF_MONTH、HOUR、MINUTE 和 SECOND 的值。保留其他字段以前的值。如果不需要这样做，则先调用 clear()。

        Calendar calendar = Calendar.getInstance();
        // @set(int field, int value)
        calendar.set(Calendar.YEAR, 2088);
        calendar.set(Calendar.MONTH, 5);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));

        // @set(int year,int month,int date)
        calendar.set(2088, 6, 12);
        System.out.println(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DATE));

        // @set(int year, int month, int date, int hourOfDay, int minute)
        calendar.set(2081, 8, 1, 14, 12);
        System.out.println(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DATE)
                + " " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));

        // @set(int year, int month, int date, int hourOfDay, int minute, int second)
        calendar.set(2082, 11, 1, 23, 12, 30);
        System.out.println(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DATE)
                + " " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
    }

    @Test
    public void clear() {
        // <M> public final void clear()
        // <改> 清除，将此 Calendar 的所日历字段值和时间值（从历元至现在的毫秒偏移量）设置成初始值：1970-1-1 0:0:0。
        // <M> public final void clear(int field)
        // <改> 清除对应的日历字段
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        System.out.println(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" + calendar.get(Calendar.DATE)
                + " " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE)
                + ":" + calendar.get(Calendar.SECOND));// 1970-1-1 0:0:0

        calendar.clear(Calendar.MILLISECOND);
        System.out.println(calendar.get(Calendar.MILLISECOND));// 0

    }

    @Test
    public void toString_() {
        // <M> public String toString()
        // <返> 返回此日历的字符串表示形式。此方法仅在进行调试的时候使用，不同实现之间所返回的字符串格式可能有所不同。返回的字符串可能为空，但不可能为 null。
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.toString());
    }

    @Test
    public void clone_() {
        // <M> public Object clone()
        // <返> 拷贝日历对象，并返回
        Calendar calendar = Calendar.getInstance();
        Object calendar2 = calendar.clone();
        System.out.println(calendar == calendar2);
        System.out.println(calendar.equals(calendar2));
    }

    @Test
    public void add_roll() {
        // @add
        // <M> public abstract void add(int field, int amount)
        // <改> 增减日历字段对应的时间量 amount；amount可以为负，表示减量；整体时间联动

        // @roll
        // <M> public void roll(int field, int amount)
        // <改> 增减日历字段对应的时间量 amount；amount可以为负，表示减量；整体时间不联动，只在该日历字段内滚动；
        // <M> roll(int field, boolean up)
        // <改> 增减日历字段对应的时间量一个单位，up为true，则增一，up为false，则减一

        // <注> add 和 roll 方法的区别：
        // 1.roll方法只是对相应时间属性的域内做变化，如对月份使用roll方法，它会在1-12的范围内变化，不会影响的年，对于跨年问题，最好用add方法。
        // 2.add方法会产生其他相关时间字段的连动变化（推荐）

        Calendar calendar = Calendar.getInstance();
        calendar.clear();

        // @add
        calendar.add(Calendar.YEAR, 10);
        System.out.println(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1));// 1980-1
        calendar.add(Calendar.MONTH, -2);// 月份不够减，年份减！！！
        System.out.println(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1));// 1979-11

        // @roll
        calendar.clear();
        calendar.roll(Calendar.YEAR, 10);
        System.out.println(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1));// 1980-1
        calendar.roll(Calendar.MONTH, -2);// 月份不够减，也不会减年份！！！
        System.out.println(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1));// 1980-11

        calendar.roll(Calendar.YEAR, true);
        System.out.println(calendar.get(Calendar.YEAR));// 1981
        calendar.roll(Calendar.MONTH, false);
        System.out.println(calendar.get(Calendar.MONTH) + 1);// 10
    }

    /**
     * @Description Calendar和时间戳互转
     */
    @Test
    public void getTimeInMillis_setTimeInMillis() {
        // <M> public long getTimeInMillis()
        // <返> 日历转时间戳
        // public void setTimeInMillis(long millis)
        // <改> 时间戳转日历，或用时间戳设置日历
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTimeInMillis());// 1607069169713
        calendar.setTimeInMillis(344448002000L);
    }

    /**
     * @Description Calendar和Date互转
     */
    @Test
    public void getTime_setTime() {
        // <M> public final Date getTime()
        // <返> Calendar 转 Date
        // public final void setTime(Date date)
        // <改> Date 转 Calendar，或用Date设置Calendar
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        calendar.setTime(date);
        System.out.println(date);
    }

    @Test
    public void equals() {
        // <M> public boolean equals(Object obj)
        // <返> 比较两个日历值（内容）
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTimeInMillis(344448001233L);
        calendar2.setTimeInMillis(344448001233L);
        System.out.println(calendar.equals(calendar2));// true
    }

    @Test
    public void after_before_compareTo() {
        // <M> public boolean after(Object when)
        // <返> 是否晚于日历 when
        // <M> public boolean before(Object when)
        // <返> 是否早于日历 when
        // <M> public int compareTo(Calendar anotherCalendar)
        // <返> 比较两个日期的先后顺序，早于 anotherCalendar 返-1，晚于 anotherCalendar 返1，相等返0
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTimeInMillis(344448001233L);
        calendar2.setTimeInMillis(344448001234L);
        System.out.println(calendar.after(calendar2));// false
        System.out.println(calendar.before(calendar2));// true
        System.out.println(calendar.compareTo(calendar2));// -1
    }
}
