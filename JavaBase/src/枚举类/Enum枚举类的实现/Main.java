package 枚举类.Enum枚举类的实现;

import org.junit.jupiter.api.Test;

public class Main {
    @Test
    public void test(){
        WeekDays.MONDAY.connect();
        WeekDays.FRIDAY.connect();
        WeekDays.FRIDAY.pull();
    }
}
