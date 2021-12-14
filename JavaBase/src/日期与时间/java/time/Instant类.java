package 日期与时间.java.time;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;


public class Instant类 {
    /**
     * @获取当前时刻
     */
    @Test
    public void now() {
        // <SM> public static Instant now()
        // <返> 获取当前时刻
        Instant now = Instant.now();
        // 以ISO-8601输出
        System.out.println(now);// 2020-12-10T02:28:58.056463700Z

    }

    /**
     * @秒数时间戳转Instant
     */
    @Test
    public void ofEpochSecond() {
        // <SM> public static Instant ofEpochSecond(long epochSecond)
        // <返> 秒数时间戳转Instant
        Instant instant = Instant.ofEpochSecond(1607503461);
        System.out.println(instant);// 2020-12-09T08:44:21Z

    }

    /**
     * @毫秒数时间戳转Instant
     */
    @Test
    public void ofEpochMilli() {
        // <SM> public static Instant ofEpochSecond(long epochSecond)
        // <返> 毫秒数时间戳转Instant
        Instant instant = Instant.ofEpochMilli(1607503451326L);
        System.out.println(instant);// 2020-12-09T08:44:11.326Z
    }


    /**
     * @获取秒数时间戳
     */
    @Test
    public void getEpochSecond() {
        // <M> public long getEpochSecond()
        // <返> 从1970-01-01T00：00：00Z的Java时代获取秒数。
        Instant instant = Instant.now();
        long epochSecond = instant.getEpochSecond();
        System.out.println(epochSecond);// 1607503461
    }

    /**
     * @获取毫秒数时间戳
     */
    @Test
    public void toEpochMilli() {
        // <M> public long toEpochMilli()
        // <返> 将此瞬间转换为1970-01-01T00：00：00Z的时期的毫秒数。
        Instant instant = Instant.now();
        long epochMilli = instant.toEpochMilli();
        System.out.println(epochMilli);// 1607503451326
    }

    /**
     * @Instant转ZonedDateTime、localDateTime
     */
    @Test
    public void atZone() {
        // <M> public ZonedDateTime atZone(ZoneId zone)
        // <返> 带上时区，转ZonedDateTime
        Instant instant = Instant.now();
        ZonedDateTime zonedDateTime1 = instant.atZone(ZoneId.of("UTC"));
        ZonedDateTime zonedDateTime2 = instant.atZone(ZoneId.of("UTC+8"));
        System.out.println(instant);
        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);

        // 再转LocalDateTime
        LocalDateTime localDateTime = zonedDateTime1.toLocalDateTime();
        System.out.println(localDateTime);
    }
}
