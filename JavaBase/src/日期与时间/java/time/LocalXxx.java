package 日期与时间.java.time;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalXxx {

    /**
     * @返回当前日期时间实例
     */
    @Test
    public void now() {
        // <SM> public static LocalDateTime/LocalDate/LocalTime now()
        // <返> 返回当前日期时间的 LocalDateTime/LocalDate/LocalTime 对象
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        System.out.println(localDateTime);
        System.out.println(localDate);
        System.out.println(localTime);
    }

    /**
     * @返回特定时间日期实例
     */
    @Test
    public void of_ofXxx() {
        // <SM> public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, ...)
        // <返> 返回特定时间日期的 localDateTime 对象
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 6, 12, 15, 28);
        LocalDateTime localDateTime2 = LocalDateTime.of(2020, 6, 12, 15, 28, 33);
        LocalDateTime localDateTime3 = LocalDateTime.of(2020, 6, 12, 15, 28, 33, 105);

        LocalDateTime localDateTime4 = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDateTime localDateTime5 = LocalDateTime.ofEpochSecond(1607566596, 387272600, ZoneOffset.of("+8"));
        System.out.println(localDateTime4);
        System.out.println(localDateTime5);
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
    public void plus_plusXxxs() {
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
    public void minus_minusXxxs() {
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
    public void with_withXxxs() {
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

    /**
     * @转ZonedDateTime
     */
    @Test
    public void atZone() {
        // <M> public ZonedDateTime atZone(ZoneId zone)
        // <返> 转ZonedDateTime
        LocalDateTime localDateTime1 = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime1.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);


    }


    /**
     * @转Instant
     */
    @Test
    public void toInstant() {
        // <M> default Instant toInstant(ZoneOffset offset)
        LocalDateTime localDateTime1 = LocalDateTime.now();
        // 方式一：先转zonedDateTime，再转Instant
        ZonedDateTime zonedDateTime = localDateTime1.atZone(ZoneId.systemDefault());
        Instant instant1 = zonedDateTime.toInstant();
        // 方式二：直接转Instant
        Instant instant2 = localDateTime1.toInstant(ZoneOffset.of("+8"));

        System.out.println(instant1);// 2020-12-10T02:21:04.387272600Z
        System.out.println(instant2);// 2020-12-10T02:21:04.387272600Z
    }

    /**
     * @转OffsetDateTime
     */
    @Test
    public void atOffset() {
        // <M> public OffsetDateTime atOffset(ZoneOffset offset)
        // <返> 转OffsetDateTime
        LocalDateTime localDateTime1 = LocalDateTime.now();
        OffsetDateTime offsetDateTime = localDateTime1.atOffset(ZoneOffset.of("+8"));
        System.out.println(offsetDateTime);
    }

    /**
     * @获取秒数时间戳
     */
    @Test
    public void toEpochSecond() {
        // <M> public LocalDateTime with_withXxxs(int newValue)
        LocalDateTime localDateTime1 = LocalDateTime.now();
        long sec = localDateTime1.toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(sec);// 1607566596
    }

    /**
     * @获取毫秒数时间戳
     */
    @Test
    public void toEpochMilli() {
        // <注> 只有转为Instant才能获取时间戳
        LocalDateTime localDateTime1 = LocalDateTime.now();
        Instant instant = localDateTime1.toInstant(ZoneOffset.of("+8"));
        long msec = instant.toEpochMilli();
        System.out.println(msec);// 1607567014805


    }


}

