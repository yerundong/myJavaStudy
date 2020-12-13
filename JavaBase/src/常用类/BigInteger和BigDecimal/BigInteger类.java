package 常用类.BigInteger和BigDecimal;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;

/**
 @BigInteger： Integer能存储的最大整型值为 (2^31)-1，Long类也是有限的，最大为(2^63)-1。如果要表示再大的整数，他们都无能为力，更不用说进行运算了。
     java.math包的BigInteger可以表示不可变的任意精度的整数。BigInteger提供所有Java的基本整数操作符的对应物，并提供 java.lang.Math 的所有相关方法。
     另外， BigInteger 还提供以下运算：模算术、 GCD 计算、质数测试、素数生成、位操作以及一些其他操作。

 @注：
    1.不可变性：BigInteger的操作方法不会改变主对象
    2.重写了toString方法

 @快速记忆： 任意精度整数、不可用运算符、内置操作符的对应物和java.lang.Math 的所有相关方法及更多运算、不可变性、toString

 */
public class BigInteger类 {
    /**
     * @Description 构造器
     */
    @Test
    public void constructor(){
        // <C><More> public BigInteger(String val)
        // <More>
        BigInteger bigInteger1 = new BigInteger("123456789012345678901234567890");
        System.out.println(bigInteger1);
    }

    /**
     * @Description 绝对值
     */
    @Test
    public void abs(){
        // <M> public BigInteger abs()
        // <返> 绝对值 ||
        BigInteger bigInteger1 = new BigInteger("-123456789012345678901234567890");
        System.out.println(bigInteger1.abs());
        System.out.println(bigInteger1);// 不可变
    }

    /**
     * @Description 加上
     */
    @Test
    public void add(){
        // <M> public BigInteger add(BigInteger val)
        // <返> 加上 +
        BigInteger bigInteger1 = new BigInteger("123");
        BigInteger bigInteger2 = new BigInteger("123");
        System.out.println(bigInteger1.add(bigInteger2));
    }

    /**
     * @Description 减去
     */
    @Test
    public void subtract(){
        // <M> public BigInteger(String val)
        // <返> 减去 -
        BigInteger bigInteger1 = new BigInteger("124");
        BigInteger bigInteger2 = new BigInteger("123");
        System.out.println(bigInteger1.subtract(bigInteger2));
    }

    /**
     * @Description 乘以
     */
    @Test
    public void multiply(){
        // <M> public BigInteger multiply(BigInteger val)
        // <返> 乘以 ×
        BigInteger bigInteger1 = new BigInteger("124");
        BigInteger bigInteger2 = new BigInteger("2");
        System.out.println(bigInteger1.multiply(bigInteger2));
    }

    /**
     * @Description 除以
     */
    @Test
    public void divide(){
        // <M>  public BigInteger divide(BigInteger val)
        // <返> 除以 ➗
        // <注> 舍小数取整
        BigInteger bigInteger1 = new BigInteger("134");
        BigInteger bigInteger2 = new BigInteger("3");
        System.out.println(bigInteger1.divide(bigInteger2));
    }

    /**
     * @Description 取余
     */
    @Test
    public void remainder(){
        // <M>  public BigInteger remainder(BigInteger val)
        // <返> 余以，取余 %
        BigInteger bigInteger1 = new BigInteger("124");
        BigInteger bigInteger2 = new BigInteger("3");
        System.out.println(bigInteger1.remainder(bigInteger2));
    }

    /**
     * @Description 除以和余以
     */
    @Test
    public void divideAndRemainder(){
        // <M>  public BigInteger divideAndRemainder(BigInteger val)
        // <返> 除以和余以，置于数组返回 ➗%
        BigInteger bigInteger1 = new BigInteger("124");
        BigInteger bigInteger2 = new BigInteger("3");
        BigInteger[] bigIntegers = bigInteger1.divideAndRemainder(bigInteger2);
        System.out.println(Arrays.toString(bigIntegers));// [41, 1]
    }

    /**
     * @Description 模以
     */
    @Test
    public void mod(){
        // <M>  public BigInteger mod(BigInteger m)
        // <返> 模以，取模
        BigInteger bigInteger1 = new BigInteger("124");
        BigInteger bigInteger2 = new BigInteger("3");
        System.out.println(bigInteger1.mod(bigInteger2));
    }

    /**
     * @Description 次方
     */
    @Test
    public void pow(){
        // <M>  public BigInteger pow(int exponent)
        // <返> 次方
        BigInteger bigInteger1 = new BigInteger("2");
        System.out.println(bigInteger1.pow(3));
    }

    /**
     * @Description 比较
     */
    @Test
    public void compareTo(){
        // <M>  public int compareTo(BigInteger val)
        // <返> 比较
        // <注> 前补0不影响大小比较
        BigInteger bigInteger1 = new BigInteger("123");
        BigInteger bigInteger2 = new BigInteger("0123");
        BigInteger bigInteger3 = new BigInteger("124");
        System.out.println(bigInteger1.compareTo(bigInteger2));// 0
        System.out.println(bigInteger1.compareTo(bigInteger3));// -1
        System.out.println(bigInteger3.compareTo(bigInteger1));// 1
    }

    /**
     * @Description 判等
     */
    @Test
    public void equals(){
        // <M> public boolean equals(Object x)
        // <返> 判等
        // <注> 前补0不影响判等
        BigInteger bigInteger1 = new BigInteger("123");
        BigInteger bigInteger2 = new BigInteger("123");
        BigInteger bigInteger3 = new BigInteger("000123");
        System.out.println(bigInteger1.equals(bigInteger2));// true
        System.out.println(bigInteger1.equals(bigInteger3));// true
    }

    /**
     * @Description 取大 取小
     */
    @Test
    public void max_min(){
        // <M> public BigInteger max(BigInteger val)
        // <返> 取大 取小
        BigInteger bigInteger1 = new BigInteger("123");
        BigInteger bigInteger2 = new BigInteger("124");
        System.out.println(bigInteger1.max(bigInteger2));// 124
        System.out.println(bigInteger1.min(bigInteger2));// 123
    }

    /**
     * @Description 转换为 long\int\short\byte
     */
    @Test
    public void xxxValue(){
        // <M> public long longValue\intValue\shortValue\byteValue()
        // <返> 将此 BigInteger 转换为 long\int\short\byte。
        // <注> 如果超过所转换的最大容纳位数，将损失精度
        BigInteger bigInteger1 = new BigInteger("1234567890123456");
        BigInteger bigInteger2 = new BigInteger("123456789012345678901234567890");
        System.out.println(bigInteger1.longValue());// 1234567890123456
        System.out.println(bigInteger2.longValue());// -4362896299872285998
        System.out.println(bigInteger2.intValue());// 1312754386
        System.out.println(bigInteger2.shortValue());// 2770
        System.out.println(bigInteger2.byteValue());// -46
    }
}
