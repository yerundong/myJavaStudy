package 枚举类;

import org.junit.jupiter.api.Test;
import 枚举类.示例.Payment;
import 枚举类.示例.Season;

public class Base {
    @Test
    public void test_season() {
        Season spring = Season.SPRING;
        Season winter = Season.WINTER;
        System.out.println(spring);
    }

    @Test
    public void test_payment() {
        Payment cash = Payment.CASH;
        System.out.println(cash);
    }
}
