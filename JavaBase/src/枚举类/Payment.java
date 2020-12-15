package 枚举类;

/**

 @枚举： 枚举（enum）类型是Java 5新增的特性，它是一种新的类型，允许用常量来表示特定的数据片断，而且全部都以类型安全的形式来表示。

 @声明格式：
    public enum Payment {
        ...
    }

 @特性：
     1.Enum和Class、Interface的地位一样
     2.使用enum定义的枚举类默认继承了java.lang.Enum，而不是继承Object类。
     3.Enum枚举类可以实现一个或多个接口。
     4.非抽象的 Enum 枚举类固定使用 final 修饰，不能显式修饰，不可以被继承,
     5.Enum枚举类的toString方法继承至Enum，返回枚举实例的常量名，直接打印枚举实例，输出的是枚举实例的常量名（ALIPAY）

 @枚举实例：
    @定义格式：
        1.有参：
            枚举实例名1(...), 枚举实例名2(...), 枚举实例名3(...), ... 枚举实例名4(...);
        2.无参：
            枚举实例名, 枚举实例名2, 枚举实例名3, ... 枚举实例名4;

    @定义位置: 必须在类中第一行声明，否则报错
    @特性： 固定是公共静态的常量（public static final），不能显式修饰

 @属性： 与寻常类一致，一般是私有的（private）

 @构造器：
    @声明格式：
        枚举名(...){
            ...
        }

    @特性： 固定是私有的（private），否则报错，可以省略
 */
public enum Payment {
    // 枚举实例
    ALIPAY("支付宝"),
    WECHATPAY("微信"),
    CASH("现金"),
    CREDITCARD("信用卡"),
    UNKNOWN;

    // 属性
    private String paymentName;

    // 构造器
    Payment() {
        this.paymentName = "未知";
    }
    Payment(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getPaymentName() {
        return paymentName;
    }
}
