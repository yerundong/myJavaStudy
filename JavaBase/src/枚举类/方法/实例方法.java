package 枚举类.方法;

import org.junit.jupiter.api.Test;
import 枚举类.示例.Payment;

public class 实例方法 {
    @Test
    public void toString_() {
        // <M> public String toString()
        // <返回> 返回枚举实例的常量名称
        Payment creditcard = Payment.CREDITCARD;
        System.out.println(creditcard.toString());
    }
}
