package 日期与时间.java.time;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;

/**
 @LocalDateTime: JDK8新特性里提供了3个时间类：LocalDate、LocalTime、LocalDateTime。时间表示为纳秒精度。

 @注：

 */
public class LocalDateTime类 {

    /**
     * @返回当前日期时间实例
     */
    @Test
    public void now() {
        // <SM> public static LocalDateTime now()
        // <返> 返回当前日期时间的 LocalDateTime 对象
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime：" + localDateTime);
    }

    /**
     * @返回特定时间日期实例
     */
    @Test
    public void of() {
        // <SM> public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, ...)
        // <返> 返回特定时间日期的 localDateTime 对象
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 6, 12, 15, 28);
        LocalDateTime localDateTime2 = LocalDateTime.of(2020, 6, 12, 15, 28, 33);
        LocalDateTime localDateTime3 = LocalDateTime.of(2020, 6, 12, 15, 28, 33, 105);
    }

    /**
     * @获取日期字段
     */
    @Test
    public void getXxx() {
        // <M> public int getYear()
        // <M> public int getMonthValue()
        // <M> public int getDayOfMonth()
        // <M> public int getHour()
        // <M> public int getMinute()
        // <M> public int getSecond()
        // <M> public DayOfWeek getDayOfWeek()
        LocalDateTime localDateTime = LocalDateTime.now();
        int year = localDateTime.getYear();
        int month = localDateTime.getMonthValue();
        int dayOfMonth = localDateTime.getDayOfMonth();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        System.out.println(year + "-" + month + "-" + dayOfMonth + " " + hour + ":" + minute + ":" + second);
        System.out.println(dayOfWeek.getValue());// 3
        System.out.println(dayOfWeek.toString());// WEDNESDAY

    }

    /**
     * @格式化
     */
    @Test
    public void format() {
        // <SM> public String format(DateTimeFormatter formatter)
        // <返> 使用ISO 8601的格式，将字符串解析为 LocalDateTime
        LocalDateTime localDateTime1 = LocalDateTime.now();
        DateTimeFormatter dtft = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String format1 = localDateTime1.format(dtft);
        System.out.println(format1);// 2020年12月09日 16:19:23
    }

    /**
     * @解析
     */
    @Test
    public void parse() {
        // <SM> public static LocalDateTime parse(CharSequence text)
        // <返> 使用ISO 8601的格式，将字符串解析为 LocalDateTime
        // <注> ISO 8601的格式：yyyy-MM-ddTHH:mm:ss
        // <SM> public static LocalDateTime parse(CharSequence text, DateTimeFormatter formatter)
        // <返> 使用特定的 formatter 格式，将字符串解析为 LocalDateTime
        LocalDateTime localDateTime1 = LocalDateTime.parse("2020-06-12T18:06:30");
        System.out.println(localDateTime1);

        DateTimeFormatter dtft = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime localDateTime2 = LocalDateTime.parse("2020年06月12日 18:06:30", dtft);
        System.out.println(localDateTime2);
    }

    /**
     * @增加
     */
    @Test
    public void plus_plusXxxs(){
        // <M> public LocalDateTime plusXxxs(long amount)
        // <M> public LocalDateTime plus(long amountToAdd, TemporalUnit unit)
        // <返> 增加对应字段的时间量，amount可以为负，整体时间联动
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = localDateTime1.plusYears(1);
        LocalDateTime localDateTime3 = localDateTime1.plusDays(1);
        LocalDateTime localDateTime4 = localDateTime1.plusWeeks(1);
        LocalDateTime localDateTime5 = localDateTime1.plusYears(-1);
        LocalDateTime localDateTime6 = localDateTime1.plus(1, ChronoUnit.DAYS);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);
        System.out.println(localDateTime4);
        System.out.println(localDateTime5);
        System.out.println(localDateTime6);

        LocalDateTime localDateTime7 = localDateTime1.plusDays(24);
        System.out.println(localDateTime7);

    }

    /**
     * @减少
     */
    @Test
    public void minus_minusXxxs(){
        // <M> public LocalDateTime minusXxxs(long amount)
        // <M> public LocalDateTime minus(long amountToAdd, TemporalUnit unit)
        // <返> 减少对应字段的时间量，amount可以为负，整体时间联动
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = localDateTime1.minusYears(1);
        LocalDateTime localDateTime3 = localDateTime1.minusMonths(-2);
        LocalDateTime localDateTime4 = localDateTime1.minus(1, ChronoUnit.DAYS);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);
        System.out.println(localDateTime4);
    }

    /**
     * @设置
     */
    @Test
    public void with_withXxxs(){
        // <M> public LocalDateTime with_withXxxs(int newValue)
        // <M> public LocalDateTime with(TemporalField field, long newValue)
        // <M> public LocalDateTime with(TemporalAdjuster adjuster)
        // <返> 设置对应字段的时间量
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = localDateTime1.withYear(2007);
        LocalDateTime localDateTime3 = localDateTime1.withMonth(06);
        LocalDateTime localDateTime4 = localDateTime1.with(ChronoField.YEAR, 2022);
        LocalDateTime localDateTime5 = localDateTime1.with(TemporalAdjusters.firstDayOfYear());
        LocalDateTime localDateTime6 = localDateTime1.with(TemporalAdjusters.lastDayOfYear());
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);
        System.out.println(localDateTime4);
        System.out.println(localDateTime5);
        System.out.println(localDateTime6);
    }
}
