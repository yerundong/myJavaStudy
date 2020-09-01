package 日期与时间.Calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/*
@ Calendar类：
    Calendar类是一个[ 抽象类 ]，它为特定瞬间与一组诸如 YEAR、MONTH、DAY_OF_MONTH、HOUR 等 日历字段之间的转换提供了一些方法，
    并为操作日历字段（例如获得下星期的日期）提供了一些方法。

@ 它的子类：GregorianCalendar

@ 构造方法：
    @ Calendar()：构造一个带有默认时区和语言环境的 Calendar。
    @ Calendar(TimeZone zone, Locale aLocale)：构造一个带有指定时区和语言环境的 Calendar。

@ 成员方法：
    @ get(int field)：返回给定日历字段的值。

    @ set(int field, int value)：将给定的日历字段设置为给定值。不管处于何种宽松性模式下，该值都不由此方法进行解释。
    @ set(int year,int month,int date)：设置日历字段 YEAR、MONTH 和 DAY_OF_MONTH 的值。保留其他日历字段以前的值。如果不需要这样做，则先调用 clear()。
    @ set(int year, int month, int date, int hourOfDay, int minute)：设置日历字段 YEAR、MONTH、DAY_OF_MONTH、HOUR_OF_DAY 和 MINUTE 的值。保留其他字段以前的值。如果不需要这样做，则先调用 clear()。
    @ set(int year, int month, int date, int hourOfDay, int minute, int second)设置字段 YEAR、MONTH、DAY_OF_MONTH、HOUR、MINUTE 和 SECOND 的值。保留其他字段以前的值。如果不需要这样做，则先调用 clear()。

    @ clear()：将此 Calendar 的所日历字段值和时间值（从历元至现在的毫秒偏移量）设置成未定义。
    @ clear(int field)：此 Calendar 的给定日历字段值和时间值（从历元至现在的毫秒偏移量）设置成未定义。

    @ toString()：返回此日历的字符串表示形式。此方法仅在进行调试的时候使用，不同实现之间所返回的字符串格式可能有所不同。返回的字符串可能为空，但不可能为 null。
    @ add(int field, int amount)：据日历的规则，为给定的日历字段添加或减去指定的时间量。

    @ roll(int field, boolean up) 在给定的时间字段上添加或减去（上/下）单个时间单元,如果向上滚动，则使用 true，向下使用 false。
    @ roll(int field, int amount) 向指定日历字段添加指定（有符号的）时间量，不更改更大的字段。负的时间量意味着向下滚动。

    @ 注：add 和 roll 方法的区别：
        1.roll方法只是对相应时间属性的域内做变化，如对月份使用roll方法，它会在1-12的范围内变化，不会影响的年，对于跨年问题，最好别用roll方法。
        2.add方法会产生其他相关时间属性的连动变化（推荐使用）

    @ setTime(Date date)：Date 转 Calendar
    @ getTime()：Calendar 转 Date

    @ getTimeInMillis() 日历转时间戳
    @ setTimeInMillis(long millis) 时间戳设置日历

    @ equals 比较两个日历值（内容）


@ 静态方法：
    @ getInstance()：获得一个日历对象。返回的 Calendar 基于当前时间，使用了默认时区和默认语言环境。

@ 静态的日历字段：
    @ YEAR：年份
    @ MONTH：当前年中的月数（0-11）（几月）
    @ DATE：当前月中的天数，与DAY_OF_MONTH同（几号）
    @ DAY_OF_MONTH：当前月中的天数（几号）
    @ DAY_OF_WEEK：当前周中的天数（周几）（星期日-星期六 对应：1-7）
    @ WEEK_OF_YEAR：当前年中的星期数
    @ WEEK_OF_MONTH：当前月中的星期数
    @ DAY_OF_YEAR：当前年中的天数
    @ DAY_OF_WEEK_IN_MONTH：指示当前月中的第几个星期。与 DAY_OF_WEEK 字段一起使用时，就可以唯一地指定某月中的某一天？？？。
    // 时间
    @ HOUR：小时，12小时制 (0 - 11)。
    @ HOUR_OF_DAY：小时，24小时制
    @ MINUTE：分钟
    @ SECOND：秒
    @ MILLISECOND：毫秒


*/
public class Calendar类 {
    public static void main(String[] args) {
        // @ public static Calendar getInstance()
        Calendar calendar = Calendar.getInstance();
        // System.out.println(calendar);

        // @ public int get(int field)
        // System.out.println(calendar.get(Calendar.YEAR));
        // System.out.println(calendar.get(Calendar.MONTH)+1);
        // System.out.println(calendar.get(Calendar.DATE));
        // System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        // System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

        // System.out.println(calendar.get(Calendar.HOUR));
        // System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        // System.out.println(calendar.get(Calendar.MINUTE));
        // System.out.println(calendar.get(Calendar.SECOND));
        // System.out.println(calendar.get(Calendar.MILLISECOND));

        // @ public void set(int field, int value)
        calendar.set(Calendar.YEAR, 2088);
        calendar.set(Calendar.MONTH, 5);
        // System.out.println(calendar.get(Calendar.YEAR));
        // System.out.println(calendar.get(Calendar.MONTH));

        // @ public final void set(int year,int month,int date)
        calendar.set(2088, 6, 12);
        // System.out.println(calendar.get(Calendar.YEAR));
        // System.out.println(calendar.get(Calendar.MONTH));
        // System.out.println(calendar.get(Calendar.DATE));

        // @ public final void set(int year, int month, int date, int hourOfDay, int minute)
        calendar.set(2021, 8, 1, 14, 12);

        // @ public final void set(int year, int month, int date, int hourOfDay, int minute, int second)
        calendar.set(2021, 8, 1, 14, 12, 30);

        // @ public final void clear(int field)
        calendar.clear(Calendar.MILLISECOND);
        // System.out.println(calendar.get(Calendar.MILLISECOND));// 0

        // @ public final void clear()
        calendar.clear();
        // System.out.println(calendar.get(Calendar.YEAR));// 1970

        // @ public String toString()
        // System.out.println(calendar.toString());

        // @ public abstract void add(int field, int amount)
        calendar.add(Calendar.YEAR, 10);
        calendar.add(Calendar.MONTH, -12);
        // System.out.println(calendar.get(Calendar.YEAR));// 1979
        // System.out.println(calendar.get(Calendar.MONTH));// 0

        // @ public abstract void roll(int field, boolean up)
        // @ public void roll(int field, int amount)
        calendar.roll(Calendar.YEAR, true);
        // System.out.println(calendar.get(Calendar.YEAR));// 1980
        calendar.roll(Calendar.MONTH, false);
        // System.out.println(calendar.get(Calendar.YEAR));// 1980
        // System.out.println(calendar.get(Calendar.MONTH));// 11
        calendar.roll(Calendar.MONTH, 12);
        // System.out.println(calendar.get(Calendar.YEAR));// 1980
        // System.out.println(calendar.get(Calendar.MONTH));// 11

        // @ getTimeInMillis() 日历转时间戳
        // @ setTimeInMillis(long millis) 时间戳设置日历
        // System.out.println(calendar.getTimeInMillis());// 344448000000
        calendar.setTimeInMillis(344448002000L);
        // System.out.println(calendar.getTimeInMillis());// 344448002000

        // @ public final void setTime(Date date)：Date 转 Calendar
        // @ public final Date getTime()：Calendar 转 Date
        // System.out.println(calendar.getTime());// Mon Dec 01 00:00:02 CST 1980
        calendar.setTime(new Date(348448002000L));
        // System.out.println(calendar.getTime());

        // @ equals 比较两个日历值（内容）
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTimeInMillis(344448001233L);
        calendar2.setTimeInMillis(344448001233L);
        System.out.println(calendar.equals(calendar2));// true
    }
}
