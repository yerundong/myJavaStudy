package 日期与时间.练习;

import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description Three days fishing and tow days drying net.
 */
public class Fishing {
    @Test
    public void test() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = sdf.parse("2000-01-01");
        Date end = end = sdf.parse("2000-01-03");
        String fishingOrDrying = fishingOrDrying(start, end);
        System.out.println(fishingOrDrying);
    }

    public String fishingOrDrying(Date start, Date end) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s1 = sdf.format(start);
        String s2 = sdf.format(end);
        Date START = sdf.parse(s1);// 清除年月日以外的时间字段
        Date END = sdf.parse(s2);// 清除年月日以外的时间字段

        long disMs = END.getTime() - START.getTime();
        long disDay = disMs / 86400000 + 1;
        long rest = disDay % 5;
        final String FISHING = "FISHING";
        final String DRYING = "DRYING";
        if(rest > 3){
            return DRYING;
        }else{
            return FISHING;
        }
    }
}
