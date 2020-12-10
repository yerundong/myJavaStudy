package 日期与时间.java.time;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 @Instant： 时刻，是格林威治标准时间（GMT）的即时时间点（类似 java.util.Date），表示全球时间轴上的特定瞬间，与时区无关，精确到纳秒的（而不是象旧版本的Date精确到毫秒）

 @时间戳： 时间戳是指格林威治时间1970年01月01日00时00分00秒(北京时间1970年01月01日08时00分00秒)起至特定时刻的总秒数或总毫秒数。

 @与LocalDateTime的不同：
    LocalDateTime表示的是不带时区的 日期及时间，替换之前的Calendar。看上去，LocalDateTime和Instant很象，但记得的是“Instant中是不带时区的即时时间点。
    可能有人说，即时的时间点 不就是日期＋时间么？看上去是这样的，但还是有所区别，比如LocalDateTime对于用户来说，可能就只是一个简单的日期和时间的概念，
    考虑如下的 例子：两个人都在2013年7月2日11点出生，第一个人是在英国出生，而第二个是在加尼福利亚，如果我们问他们是在什么时候出生的话，则他们看上去都是
    在同样的时间出生（就是LocalDateTime所表达的），但如果我们根据时间线（如格林威治时间线）去仔细考察，则会发现在出生的人会比在英国出生的人稍微晚几个小时
    （这就是Instant所表达的概念，并且要将其转换为UTC格式的时间）。

 @快速记忆： 时间戳、LocalDateTime、ZonedDateTime转换
 */

public class Instant类 {
    /**
     * @获取当前时刻
     */
    @Test
    public void now(){
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
    public void ofEpochSecond(){
        // <SM> public static Instant ofEpochSecond(long epochSecond)
        // <返> 秒数时间戳转Instant
        Instant instant = Instant.ofEpochSecond(1607503461);
        System.out.println(instant);// 2020-12-09T08:44:21Z

    }

    /**
     * @毫秒数时间戳转Instant
     */
    @Test
    public void ofEpochMilli(){
        // <SM> public static Instant ofEpochSecond(long epochSecond)
        // <返> 毫秒数时间戳转Instant
        Instant instant = Instant.ofEpochMilli(1607503451326L);
        System.out.println(instant);// 2020-12-09T08:44:11.326Z
    }


    /**
     * @获取秒数时间戳
     */
    @Test
    public void getEpochSecond(){
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
    public void toEpochMilli(){
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
    public void atZone(){
        // <M> public ZonedDateTime atZone(ZoneId zone)
        // <返> 带上时区，转ZonedDateTime
        Instant instant = Instant.now();
        ZonedDateTime zonedDateTime1 = instant.atZone(ZoneId.of("UTC"));
        ZonedDateTime zonedDateTime2 = instant.atZone(ZoneId.of("UTC+8"));
        System.out.println(instant);
        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);
        // 转LocalDateTime
        LocalDateTime localDateTime = zonedDateTime1.toLocalDateTime();
        System.out.println(localDateTime);
    }
}
