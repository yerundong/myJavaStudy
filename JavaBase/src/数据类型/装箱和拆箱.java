package 数据类型;

/*
@包装类(Wrapper Class)：
    java语言是一个面向对象的语言，但并不是纯面向对象的语言，java中的基本数据类型不是面向对象的，我们在实际使用中经常将基本数据类型转换成对象，
    便于操作，比如，集合的操作中，这时，我们就需要利用包装类将基本类型数据转化成对象！


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
public class 装箱和拆箱 {
    public static void main(String[] args) {
        // 装箱
        // byte bt = new Byte((byte)126);
        byte bt = new Byte("126");

        // short st = new Short((short)123);
        short st = new Short("123");

        Integer num = new Integer(55);
        // Integer num = new Integer("55");

        long lng = new Long(66);
        // long lng = new Long("66");

        float ft = new Float(55.66);
        // float ft = new Float("55.66");

        double db = new Double(99.77);
        // double db = new Double("99.77");

        Character ct = new Character('a');

        boolean bol = new Boolean(false);
        // boolean bol = new Boolean("false");

        // 拆箱
        byte bt_ = Byte.valueOf(bt);
        short st_ = Short.valueOf(st);
        int num_ = Integer.valueOf(num);
        long lng_ = Long.valueOf(lng);
        float ft_ = Float.valueOf(ft);
        double db_ = Double.valueOf(db);
        char ct_ = Character.valueOf(ct);
        boolean bol_ = Boolean.valueOf(bol);

        System.out.println(bt);
        System.out.println(bt_);

        System.out.println(st);
        System.out.println(st_);

        System.out.println(num);
        System.out.println(num_);

        System.out.println(lng);
        System.out.println(lng_);

        System.out.println(ft);
        System.out.println(ft_);

        System.out.println(db);
        System.out.println(db_);

        System.out.println(ct);
        System.out.println(ct_);

        System.out.println(bol);
        System.out.println(bol_);

        // 自动装箱
        Byte bt1 = 123;
        Integer int1 = 1;
        Boolean bool1 = true;
        boolean bool2 = true;
        bool1.equals(true);
        // bool2.equals(true);// 报错

        // ...

        // 自动拆箱
        int1 = int1+1;
    }
}
