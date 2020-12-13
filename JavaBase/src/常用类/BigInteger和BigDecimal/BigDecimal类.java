package 常用类.BigInteger和BigDecimal;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 @BigDecimal： 一般的 Float 类和 Double 类可以用来做科学计算或工程计算，双精度浮点型变量double可以处理16位有效数，但在商业计算中，要求数字精度更高，
    故用到 java.math.BigDecimal类 。BigDecimal类支持不可变的、任意精度的有符号十进制定点数。
    BigDecimal所创建的是对象，故我们不能使用传统的+、-、*、/等算术运算符直接对其对象进行数学运算，而必须调用其相对应的方法。
    方法中的参数也必须是BigDecimal的对象。构造器是类的特殊方法，专门用来创建对象，特别是带有参数的对象。

 @注：
     1.不可变性：BigDecimal的操作方法不会改变主对象
     2.重写了toString方法

 @快速记忆： 任意精度整数、不可用运算符、内置操作符的对应物和java.lang.Math 的所有相关方法及更多运算、不可变性、toString

 */
public class BigDecimal类 {

    /**
     * @Description 构造器
     */
    @Test
    public void constructor(){
        // <C> public BigDecimal(String val)
        // <C> public BigDecimal(double val)
        // <注> 参数类型为double的构造方法的结果有一定的不可预知性，不建议使用。
        // <C> public BigDecimal(long val)
        // <C> public BigDecimal(int val)
        // <More>
        BigDecimal bigDecimal1 = new BigDecimal("3.123456789012345678901234567890");
        BigDecimal bigDecimal2 = new BigDecimal(0.1);
        BigDecimal bigDecimal3 = new BigDecimal(132234567897999L);
        BigDecimal bigDecimal4 = new BigDecimal(123);
        System.out.println(bigDecimal1);// 3.123456789012345678901234567890
        System.out.println(bigDecimal2);// 0.1000000000000000055511151231257827021181583404541015625
        System.out.println(bigDecimal3);// 132234567897999
        System.out.println(bigDecimal4);// 123
    }

    /**
     * @Description 绝对值
     */
    @Test
    public void abs(){
        // <M> public BigDecimal abs()
        // <返> 绝对值 ||
        BigDecimal bigDecimal1 = new BigDecimal("-123456789012345678901234567890");
        System.out.println(bigDecimal1.abs());
        System.out.println(bigDecimal1);// 不可变
    }

    /**
     * @Description 加上
     */
    @Test
    public void add(){
        // <M> public BigDecimal add(BigDecimal augend)
        // <返> 加上 +
        BigDecimal bigDecimal1 = new BigDecimal("123.6666");
        BigDecimal bigDecimal2 = new BigDecimal("123.454");
        System.out.println(bigDecimal1.add(bigDecimal2));
    }

    /**
     * @Description 减去
     */
    @Test
    public void subtract(){
        // <M> public BigDecimal subtract(BigDecimal subtrahend)
        // <返> 减去 -
        BigDecimal bigDecimal1 = new BigDecimal("124.666");
        BigDecimal bigDecimal2 = new BigDecimal("123.555");
        System.out.println(bigDecimal1.subtract(bigDecimal2));
    }

    /**
     * @Description 乘以
     */
    @Test
    public void multiply(){
        // <M> public BigDecimal multiply(BigDecimal multiplicand)
        // <返> 乘以 ×
        BigDecimal bigDecimal1 = new BigDecimal("124.123");
        BigDecimal bigDecimal2 = new BigDecimal("2.2222");
        System.out.println(bigDecimal1.multiply(bigDecimal2));
    }

    /**
     * @Description 除以
     */
    @Test
    public void divide(){
        // <M>  public BigDecimal divide(BigDecimal divisor)
        // <返> 除以 ➗
        // <注> 舍小数取整
        BigDecimal bigDecimal1 = new BigDecimal("333.3333333333333333333333333333");
        BigDecimal bigDecimal2 = new BigDecimal("3");
        BigDecimal bigDecimal3 = new BigDecimal("10.3333333333333333333333333333");
        System.out.println(bigDecimal1.divide(bigDecimal2));

        // 除不尽，需要指定精度，否则报错
        // java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
        // System.out.println(bigDecimal3.divide(bigDecimal2));
        // System.out.println(bigDecimal3.divide(bigDecimal2, 10, BigDecimal.ROUND_HALF_UP));
    }

    /**
     * @Description 取余
     */
    @Test
    public void remainder(){
        // <M> public BigDecimal remainder(BigDecimal divisor)
        // <返> 余以，取余 %
        BigDecimal bigDecimal1 = new BigDecimal("3.333333333334");
        BigDecimal bigDecimal2 = new BigDecimal("3");
        System.out.println(bigDecimal1.remainder(bigDecimal2));// 0.333333333334
    }

    /**
     * @Description 除以和余以
     */
    @Test
    public void divideAndRemainder(){
        // <M> public BigDecimal[] divideAndRemainder(BigDecimal divisor)
        // <返> 除以和余以，置于数组返回 ➗%
        BigDecimal bigDecimal1 = new BigDecimal("3.3333333333333333");
        BigDecimal bigDecimal2 = new BigDecimal("3");
        BigDecimal[] bigDecimals = bigDecimal1.divideAndRemainder(bigDecimal2);
        System.out.println(Arrays.toString(bigDecimals));// [1.0000000000000000, 0.3333333333333333]
    }

    /**
     * @Description 次方
     */
    @Test
    public void pow(){
        // <M> public BigDecimal pow(int n)
        // <返> 次方
        BigDecimal bigDecimal1 = new BigDecimal("2.22222222222");
        System.out.println(bigDecimal1.pow(2));
    }

    /**
     * @Description 比较
     */
    @Test
    public void compareTo(){
        // <M>  public int compareTo(BigDecimal val)
        // <返> 比较
        // <注> 前后补0不影响大小比较
        BigDecimal bigDecimal1 = new BigDecimal("3.33");
        BigDecimal bigDecimal2 = new BigDecimal("4.44");
        BigDecimal bigDecimal3 = new BigDecimal("3.330");
        BigDecimal bigDecimal4 = new BigDecimal("03.33");
        System.out.println(bigDecimal1.compareTo(bigDecimal2));// -1
        System.out.println(bigDecimal2.compareTo(bigDecimal1));// 1
        System.out.println(bigDecimal1.compareTo(bigDecimal3));// 0
        System.out.println(bigDecimal1.compareTo(bigDecimal4));// 0
    }

    /**
     * @Description 判等
     */
    @Test
    public void equals(){
        // <M> public boolean equals(Object x)
        // <返> 判等
        // <注> 前补0不影响判等，后补0影响判等（精度不等）
        BigDecimal bigDecimal1 = new BigDecimal("3.3");
        BigDecimal bigDecimal2 = new BigDecimal("3.3");
        BigDecimal bigDecimal3 = new BigDecimal("0003.3");
        BigDecimal bigDecimal4 = new BigDecimal("3.3000");
        System.out.println(bigDecimal1.equals(bigDecimal2));// true
        System.out.println(bigDecimal1.equals(bigDecimal3));// true
        System.out.println(bigDecimal1.equals(bigDecimal4));// false
    }

    /**
     * @Description 取大 取小
     */
    @Test
    public void max_min(){
        // <M> public BigDecimal max(BigDecimal val)
        // <M> public BigDecimal min(BigDecimal val)
        // <返> 取大 取小
        BigDecimal bigDecimal1 = new BigDecimal("3.3333333");
        BigDecimal bigDecimal2 = new BigDecimal("3.444444444");
        System.out.println(bigDecimal1.max(bigDecimal2));// 3.444444444
        System.out.println(bigDecimal1.min(bigDecimal2));// 3.3333333
    }

    /**
     * @Description 转换为 long\int\short\byte\float\double
     */
    @Test
    public void xxxValue(){
        // <M> public long longValue\intValue\shortValue\byteValue\floatValue\doubleValue()
        // <返> 将此 BigDecimal 转换为 long\int\short\byte\float\double。
        // <注>
        //      1.BigDecimal转整数类型将舍去小数
        //      2.如果超过所转换的最大容纳位数，将损失精度
        BigDecimal bigDecimal1 = new BigDecimal("3.333333");
        BigDecimal bigDecimal2 = new BigDecimal("3.3333333333333333333333333");
        System.out.println(bigDecimal1.longValue());// 3
        System.out.println(bigDecimal1.longValue());// 3
        System.out.println(bigDecimal1.intValue());// 3
        System.out.println(bigDecimal1.shortValue());// 3
        System.out.println(bigDecimal1.byteValue());// 3
        System.out.println(bigDecimal1.floatValue());// 3.333333
        System.out.println(bigDecimal1.doubleValue());// 3.333333
        System.out.println(bigDecimal2.floatValue());// 3.3333333
        System.out.println(bigDecimal2.doubleValue());// 3.3333333333333335
    }


}
