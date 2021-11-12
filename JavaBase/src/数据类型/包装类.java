package 数据类型;

public class 包装类 {
    public static void main(String[] args) {
        // ----------- 装箱 -----------
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

        // 包装类打印结构还是和基本类型一样
        System.out.println(db);

        // ----------- 拆箱 -----------
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
