package 日期与时间.java.time;

import org.junit.jupiter.api.Test;

import java.time.Instant;

public class Instant类 {
    /**
     * @
     */
    @Test
    public void now(){
        Instant now = Instant.now();
        System.out.println(now);
    }

    /**
     * @
     */
    @Test
    public void getEpochSecond(){
        Instant instant = Instant.now();
        long epochSecond = instant.getEpochSecond();
        System.out.println(epochSecond);// 1607503461
    }

    /**
     * @
     */
    @Test
    public void toEpochMilli(){
        Instant instant = Instant.now();
        long epochMilli = instant.toEpochMilli();
        System.out.println(epochMilli);// 1607503451326
    }
}
