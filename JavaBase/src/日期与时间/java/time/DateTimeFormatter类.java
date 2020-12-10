package 日期与时间.java.time;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
    对ZonedDateTime或LocalDateTime进行格式化，需要使用DateTimeFormatter类；DateTimeFormatter可以通过格式化字符串和Locale对日期和时间进行定制输出。
 */
public class DateTimeFormatter类 {

    /**
     * @获取当前时刻
     */
    @Test
    public void ofPattern(){
        // <M> public static DateTimeFormatter ofPattern(String pattern)
        // <返> 使用指定的模式创建格式化程序。
        // public static DateTimeFormatter ofPattern(String pattern, Locale locale)
        // <返> 使用指定的模式创建格式化程序，同时指定Locale。
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH:mm:ss");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH:mm:ss 'in' Z");
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy/MMM/dd EE HH:mm", Locale.CHINA);

        LocalDateTime localDateTime1 = LocalDateTime.now();
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        String format1 = localDateTime1.format(dtf1);
        String format2 = zonedDateTime1.format(dtf2);
        String format3 = localDateTime1.format(dtf3);
        System.out.println(format1);
        System.out.println(format2);
        System.out.println(format3);
    }
}
