package 常用类.Object.toString;

/**
@定义： 返回该对象的字符串表示。通常，toString 方法会返回一个“以文本方式表示”此对象的字符串。
    结果应是一个简明但易于读懂的信息表达式。建议所有子类都重写此方法。

@源码：
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

@重写了toString的常见类： 包装类（Byte，Integer...）、String、Date、File、BigInteger、BigDecimal...

@未重写了toString的常见类： 数组...
*/

public class Main {
    public static void main(String[] args) {
        OverrideToString amu = new OverrideToString("阿姆斯特朗", 69);
        System.out.println(amu);// OverrideToString{name='阿姆斯特朗', age=69}
    }
}
