package 日期与时间.java.time;

import org.junit.jupiter.api.Test;

import java.time.*;

/**
 * @ZonedDateTime：
 */
public class ZonedDateTime类 {
    @Test
    public void now() {
        // <SM> public static ZonedDateTime now()
        // <返> 返回当前时区的当前日期时间的 ZonedDateTime 对象
        // <SM> public static ZonedDateTime now(ZoneId zone)
        // <返> 返回特定时区的、当前日期时间的 ZonedDateTime 对象
        ZonedDateTime zdt1 = ZonedDateTime.now(); // 默认时区
        ZonedDateTime zdt2 = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(zdt1);
        System.out.println(zdt2);
    }

    /**
     * @特定时区的、特定日期时间的ZonedDateTime对象
     * @LocalDate、LocalTime、LocalDateTime转ZonedDateTime
     */
    @Test
    public void of() {
        // <SM> public static ZonedDateTime of(LocalDateTime localDateTime, ZoneId zone)
        // <SM> public static ZonedDateTime of(LocalDate date, LocalTime time, ZoneId zone)
        // <SM> public static ZonedDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond, ZoneId zone)
        // <返> 返回特定时区的、特定日期时间的 ZonedDateTime 对象
        ZoneId zoneId = ZoneId.of("UTC+1");
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        ZonedDateTime zdt1 = ZonedDateTime.of(localDateTime, zoneId);
        ZonedDateTime zdt2 = ZonedDateTime.of(localDate, localTime, zoneId);
        ZonedDateTime zdt3 = ZonedDateTime.of(2015, 11, 30, 23, 45, 59, 1234, zoneId);
        System.out.println(zdt1);
        System.out.println(zdt2);
        System.out.println(zdt3);
    }

    /**
     * @ZonedDateTime转LocalDate、LocalTime、LocalDateTime
     */
    @Test
    public void toLocal() {
        ZonedDateTime zdt1 = ZonedDateTime.now(ZoneId.of("America/New_York"));
        LocalDateTime localDateTime = zdt1.toLocalDateTime();
        LocalDate localDate = zdt1.toLocalDate();
        LocalTime localTime = zdt1.toLocalTime();
        System.out.println(localDateTime);
        System.out.println(localDate);
        System.out.println(localTime);
    }

    /**
     * @ZonedDateTime转Instance
     */
    @Test
    public void toInstant() {
        ZonedDateTime zdt1 = ZonedDateTime.now();
        Instant instant = zdt1.toInstant();
        System.out.println(instant);
    }

    /**
     * @设置
     */
    @Test
    public void with_withXxxs() {
        // <SM> public ZonedDateTime withZoneSameInstant(ZoneId zone)
        // <返> 改变 ZonedDateTime 对象的时区，并返回
        // <注> 其他与LocalDateTime类似，这里只举这一例
        ZonedDateTime zdt1 = ZonedDateTime.now(); // 默认时区
        ZonedDateTime zdt2 = zdt1.withZoneSameInstant(ZoneId.of("America/New_York"));// 将北京时间转换为纽约时间
        System.out.println(zdt1);
        System.out.println(zdt2);
    }


}
