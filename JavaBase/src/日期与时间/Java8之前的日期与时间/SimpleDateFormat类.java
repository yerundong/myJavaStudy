package 日期与时间.Java8之前的日期与时间;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @SimpleDateFormat类： 用于对Date对象进行格式化和解析的类，继承DateFormat类。是一个以与语言环境有关的方式来格式化和解析日期的具体类。
 * @注： SimpleDateFormat是线程不安全的
 * @作用： 许进行格式化（日期 -> 文本）、解析（文本 -> 日期）和规范化。
 * @模式字母: 请参考截图
 * @快速记忆： 格式化、解析、Date -> 字符串、字符串 -> Date、线程不安全
 */


public class SimpleDateFormat类 {

    /**
     * @Description 构造器
     */
    @Test
    public void constructor() {
        // <CM> SimpleDateFormat()：用默认的模式和默认语言环境的日期格式符号构造 SimpleDateFormat 对象
        // <CM> SimpleDateFormat(String pattern)：用特定的日期时间的字母模式构造 SimpleDateFormat 对象
        // ...
        // <注> pattern里，非模式字母的字符串（特别是英文字母）需用''包裹，避免引起歧义。中文、数字、符号可以省略''包裹
        SimpleDateFormat df1 = new SimpleDateFormat();
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        SimpleDateFormat df3 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        SimpleDateFormat df4 = new SimpleDateFormat("yyyy年MM月dd'日' HH时mm分ss秒 E 666 'hahaha~'");
        System.out.println(df1);
        System.out.println(df4.format(new Date()));
    }

    /**
     * @Description 格式化
     */
    @Test
    public void format() {
        // <M> public final String format(Date date)
        // <返> 用特定的格式规则将Date 格式化为字符串
        // <M> public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition pos) ???
        SimpleDateFormat df1 = new SimpleDateFormat();
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS E");
        SimpleDateFormat df3 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date date = new Date();
        System.out.println(df1.format(date));// 2020/12/4 下午5:12
        System.out.println(df2.format(date));// 2020-12-04 17:12:51:971
        System.out.println(df3.format(date));// 2020年12月04日 17时13分11秒

    }

    /**
     * @Description 解析
     */
    @Test
    public void parse() throws ParseException {
        // <M> public Date parse(String source)
        // <返> 解析字符串的特定格式的文本 source，生成 Date。
        // <注> 如果 source 不符合 SimpleDateFormat 对象的规则，就会报错：ParseException
        SimpleDateFormat df1 = new SimpleDateFormat();
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        // System.out.println(df1.parse("2020/8/30 11:24"));// 规则不符合，无法解析，报错
        // System.out.println(df2.parse("2021-08-30 11:59:56"));// 规则不符合，无法解析，报错
        System.out.println(df1.parse("2020/8/30 下午11:24"));
        System.out.println(df2.parse("2021-08-30 11:59:56:274"));
    }

    @Test
    public void toPattern_applyPattern() {
        // <M> public String toPattern()
        // <返> 返回 SimpleDateFormat 对象的模式字母串 pattern
        // <M> public void applyPattern(String pattern)
        // <改> 重设 SimpleDateFormat 对象的模式字母串 pattern
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String pattern = df1.toPattern();
        System.out.println(pattern);// yyyy-MM-dd HH:mm:ss:SSS

        SimpleDateFormat df2 = new SimpleDateFormat();
        df2.applyPattern(pattern);
        System.out.println(df2.toPattern());// yyyy-MM-dd HH:mm:ss:SSS
    }

    @Test
    public void clone_() {
        // <M> public Object clone()
        // <返> 拷贝 SimpleDateFormat 对象，并返回
        SimpleDateFormat df1 = new SimpleDateFormat();
        Object df2 = df1.clone();
        System.out.println(df1 == df2);// false
        System.out.println(df1.equals(df2));// true
    }

    @Test
    public void equals() {
        // <M> public boolean equals(Object obj)
        // <返> 比较日期的时间值是否相等，比较内容
        SimpleDateFormat df1 = new SimpleDateFormat();
        SimpleDateFormat df2 = new SimpleDateFormat();
        System.out.println(df1.equals(df2));// true
        System.out.println(new Date(3898891904921L) == (new Date(3898891904921L)));// false


    }
}
