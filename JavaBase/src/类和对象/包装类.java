package 类和对象;

/*
@ 包装类(Wrapper Class)：
    java语言是一个面向对象的语言，但并不是纯面向对象的语言。基本数据类型不是面向对象的，它们不具有继承性、多态性、封装性。
    在实际使用中经常将基本数据类型转换成对象，便于操作，比如，集合的操作中，这时，我们就需要利用包装类将基本类型数据转化成对象！

@ 特性：
    1.基本类型不可调用方法、属性等对象才有的特性
    2.包装类不可直接使用算术运算符，需要先转成基本类型
    3.从JDK 1.5+开始，支持自动装箱、自动拆箱，可省略装箱、拆箱的步骤

@ 基本类型与包装类的对应关系：
    基本类型      包装类（引用类型，包装类都位于java.lang包下）
    byte        Byte
    short       Short
    int         Integer     【特殊】
    long        Long
    float       Float
    double      Double
    char        Character   【特殊】
    boolean     Boolean

@ 装箱与拆箱：
    装箱：基本类型 --> 包装类对象
    拆箱：包装类对象 --> 基本类型

@ 装箱与拆箱的原因：
    1.基本类型无法直接访问方法和属性
    2.包装类对象无法直接参与运算，需要转为基本类型。

@ 从JDK 1.5+开始，支持自动装箱、自动拆箱
    @ 自动装箱格式：Type var = value;
*/
public class 包装类 {
    public static void main(String[] args) {
        // @ 装箱

        // @ Byte
        // Byte(byte value)
        // Byte(String s)：s必须是数字字符串
        Byte bt = new Byte("123");

        // @ Short
        // Short(short value)
        // Short(String s)：s必须是数字字符串
        Short st = new Short("123");

        // @ Integer
        // Integer(int value)
        // Integer(String s)：s必须是数字字符串
        Integer num = new Integer(55);

        // @ Long
        // Long(long value)
        // Long(String s)：s必须是数字字符串
        Long lng = new Long(66);

        // @ Float
        // Float(double value)
        // Float(float value)
        // Float(String s)：s必须是数字字符串
        Float ft = new Float(55.66);

        // @ Double
        // Double(double value)
        // Double(String s)：s必须是数字字符串
        Double db = new Double(99.77);

        // @ Character
        // Character(char value)
        Character ct = new Character('a');

        // @ Boolean
        // Boolean(boolean value)
        // Boolean(String s)：s推荐是布尔值字符串（忽略大小写），布尔值字符串返回对应布尔值，其他都返回false
        Boolean bol = new Boolean(false);
        Boolean bol1 = new Boolean("True");// true
        Boolean bol2 = new Boolean("true");// true
        Boolean bol3 = new Boolean("false");// false
        Boolean bol4 = new Boolean("ttt");// false
        Boolean bol5 = new Boolean("123");// false

        // @ 装箱之后具有类和对象的特性，如下：
        bt.equals(bol3);
        ct.toString();

        // @ 拆箱
        // xxxValue()
        byte bt_ = bt.byteValue();
        short st_ = st.shortValue();
        int num_ = num.intValue();
        long lng_ = lng.longValue();
        float ft_ = ft.floatValue();
        double db_ = db.doubleValue();
        char ct_ = ct.charValue();
        boolean bol_ = bol.booleanValue();

        // @ 自动装箱
        // 从JDK 1.5+开始，支持自动装箱、自动拆箱
        Byte bt1 = 123;
        Integer int1 = 1;
        Boolean bool1 = true;
        boolean bool2 = true;
        bool1.equals(true);

        // @ 自动拆箱
        byte bt1_ = bt1;
        int int1_ = int1;
        int1.equals(true);// 报错
    }
}
