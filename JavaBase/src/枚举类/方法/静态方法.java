package 枚举类.方法;

import org.junit.jupiter.api.Test;
import 枚举类.示例.Payment;

import java.util.Arrays;

/**
 *
 */
public class 静态方法 {
    @Test
    public void values() {
        // <SM> public static EnumName[] values();
        // <返回> 返回所有枚举实例常量名称构成的数组
        Payment[] values = Payment.values();
        System.out.println(Arrays.toString(values));// [ALIPAY, WECHATPAY, CASH, CREDITCARD]
    }

    @Test
    public void valueOf() {
        // <SM> public static EnumName valueOf(String name);
        // <返回> 返回指定枚举实例常量名称 name 所对应的枚举实例
        Payment creditcard = Payment.valueOf("CREDITCARD");
        // 跟以下类似：
        // Payment creditcard = Payment.CREDITCARD;

        System.out.println(creditcard);
    }
}
