package Object类.toString;

/**
@定义： 返回该对象的字符串表示。通常，toString 方法会返回一个“以文本方式表示”此对象的字符串。
    结果应是一个简明但易于读懂的信息表达式。建议所有子类都重写此方法。

@源码：
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

@toString重写情况：
    1.基本类型的包装类（Byte，Integer...）：重写，
    2.字符串String：重写，返回实体内容
    3.Date类：重写，返回实体内容
    4.File类：重写，返回实体内容
    4.其他引用类型（对象、数组）：没有重写，
*/

public class Main {
    public static void main(String[] args) {
        OverrideToString amu = new OverrideToString("阿姆斯特朗", 69);
        System.out.println(amu);// OverrideToString{name='阿姆斯特朗', age=69}
    }
}
