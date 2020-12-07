package 日期与时间;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.Date;

/**
 @Time： 继承自 java.util.Date，基本大部分方法已过时，不建议使用
 */
public class Time类 {
    /**
     * @Description 构造器
     */
    @Test
    public void constructor() {
        Time time = new Time(new Date().getTime());
        System.out.println(time);
    }
}
