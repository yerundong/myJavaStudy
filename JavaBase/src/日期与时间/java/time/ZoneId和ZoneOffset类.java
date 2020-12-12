package 日期与时间.java.time;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;

public class ZoneId和ZoneOffset类 {

    @Test
    public void of(){
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        System.out.println(zoneId);// Asia/Shanghai
    }
}
