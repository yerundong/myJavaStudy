package 枚举类.示例;

public enum Payment {
    // 枚举实例
    ALIPAY("支付宝", 1),
    WECHATPAY("微信", 2),
    CASH("现金", 3),
    CREDITCARD("信用卡", 4),
    UNKNOWN;

    // 属性
    private String paymentName;
    private int paymentCode;

    // 构造器
    Payment() {
        this.paymentName = "未知";
        this.paymentCode = 0;
    }

    Payment(String paymentName, int paymentCode) {
        this.paymentName = paymentName;
        this.paymentCode = paymentCode;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public int getPaymentCode() {
        return paymentCode;
    }

}
