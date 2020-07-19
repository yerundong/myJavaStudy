package 类;
/*
    包装类(Wrapper Class)
    java语言是一个面向对象的语言，但并不是纯面向对象的语言，java中的基本数据类型不是面向对象的，
    我们在实际使用中经常将基本数据类型转换成对象，便于操作，比如，集合的操作中，这时，我们就需要利用包装类将基本类型数据转化成对象！
    基本类型      包装类（引用类型，包装类都位于java.lang包下）
    byte        Byte
    short       Short
    int         Integer     【特殊】
    long        Long
    float       Float
    double      Double
    char        Character   【特殊】
    boolean     Boolean

    装箱：基本类型 --> 包装类型
    拆箱：包装类型 --> 基本类型
    <ps> 从JDK 1.5+开始，支持自动装箱、自动拆箱。
*/
public class 包装类 {
    public static void main(String[] args) {
        Byte bt = new Byte("126");
        Short st = new Short("123");
        Integer num = new Integer("55");
        Long lng = new Long("55");
        Float ft = new Float("55.66");
        Double db = new Double("99.66");
        Character ct = new Character('a');
        Boolean bol = new Boolean(false);


        System.out.println(bt);
        System.out.println(st);
        System.out.println(num);
        System.out.println(lng);
        System.out.println(ft);
        System.out.println(db);
        System.out.println(ct);
        System.out.println(bol);
    }
}
