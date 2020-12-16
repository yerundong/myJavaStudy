package 枚举类;

/**

 @枚举： 枚举（enum）类型是Java 5新增的特性，它是一种新的类型，允许用常量来表示特定的数据片断，而且全部都以类型安全的形式来表示。

 @声明格式：
    public enum Payment {
        ...
    }

 @解释：
    尽管 enum 看起来像是一种新的数据类型，事实上，enum是一种受限制的类，并且具有自己的方法。
    创建enum时，编译器会为你生成一个相关的类，这个类继承自 java.lang.Enum。

 @特性：
     1.Enum和Class、Interface的地位一样
     2.使用enum定义的枚举类默认继承了java.lang.Enum，而不是继承Object类，除此之外不能继承其他类和其他enum类。
     3.非抽象的 Enum 枚举类固定使用 final 修饰，不能显式修饰，不可以被继承
     4.Enum 枚举类的构造函数是私有的
     5.Enum枚举类跟类一样，可以实现一个或多个接口。
     6.Enum枚举类的toString方法继承至Enum，返回枚举实例的常量名，直接打印枚举实例，输出的是枚举实例的常量名（ALIPAY）
     7.Enum枚举类不能抽象
     8.可以有静态方法

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
