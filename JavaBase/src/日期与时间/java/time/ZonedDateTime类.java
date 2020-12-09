package 日期与时间.java.time;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 @ZonedDateTime： LocalDateTime总是表示本地日期和时间，要表示一个带时区的日期和时间，我们就需要ZonedDateTime。

 @注： 涉及到时区时，千万不要自己计算时差，否则难以正确处理夏令时。

 @快速记忆： 带时区的LocalDateTime，方法与LocalDateTime类似
 */
public class ZonedDateTime类 {
    @Test
    public void now(){
        // <SM> public static ZonedDateTime now()
        // <返> 返回当前时区的当前日期时间的 ZonedDateTime 对象
        // <SM> public static ZonedDateTime now(ZoneId zone)
        // <返> 返回特定时区的当前日期时间的 ZonedDateTime 对象
        ZonedDateTime zdt1 = ZonedDateTime.now(); // 默认时区
        ZonedDateTime zdt2 = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(zdt1);
        System.out.println(zdt2);
    }

    @Test
    public void test(){

    }
}
