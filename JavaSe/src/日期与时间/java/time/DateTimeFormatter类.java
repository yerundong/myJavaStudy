package 日期与时间.java.time;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateTimeFormatter类 {
    /**
     * @获得ISO格式的格式化对象
     */
    @Test
    public void getISO() {
        // <注> 这些ISO格式的实例都储存在静态变量中，直接取
        DateTimeFormatter dtf1 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        DateTimeFormatter dtf2 = DateTimeFormatter.ISO_DATE_TIME;
    }

    /**
     * @获得本地格式化对象
     */
    @Test
    public void getLocalized() {
        // FormatStyle.SHORT/FormatStyle.LONG/FormatStyle.FULL/FormatStyle.MEDIUM
        // <注> 这些ISO格式的实例都储存在静态变量中，直接取
        DateTimeFormatter dtf1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.of("+8"));
        DateTimeFormatter dtf3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withZone(ZoneId.of("+8"));
        DateTimeFormatter dtf4 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1.format(dtf1));// 2020/12/11 下午10:57
        System.out.println(localDateTime1.format(dtf2));// 2020/12/11 下午10:57
        System.out.println(localDateTime1.format(dtf3));// 2020年12月12日星期六 +08:00 下午3:35:33
        System.out.println(localDateTime1.format(dtf4));// 2020年12月12日 下午3:36:54
    }

    /**
     * @自定义格式化对象
     */
    @Test
    public void ofPattern() {
        // <M> public static DateTimeFormatter ofPattern(String pattern)
        // <返> 使用指定的模式创建格式化程序。
        // public static DateTimeFormatter ofPattern(String pattern, Locale locale)
        // <返> 使用指定的模式创建格式化程序，同时指定Locale。
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH:mm:ss");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd EE 'at' HH:mm:ss 'in' Z");
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
