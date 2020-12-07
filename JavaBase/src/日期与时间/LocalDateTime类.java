package 日期与时间;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class LocalDateTime类 {
    /**
     * @Description 构造器
     */
    @Test
    public void constructor() {
        // <CM> Date()：获取当前日期对象
        // <CM> Date(long ms)：获取指定日期对象，ms：毫秒，long类型
        // <注> 底层是用 System.currentTimeMillis() 获取系统时间并储存
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        System.out.println("localDateTime：" + localDateTime);
        System.out.println("localDate：" + localDate);
        System.out.println("localTime：" + localTime);

    }
}
