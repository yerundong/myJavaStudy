package 数据类型;

import org.junit.Test;

/***

@缓存 包装类内部有一个 XxxCache 的静态结构（如：IntegerCache），如果我们自动装箱的范围在：-128~127之间，就会缓存在 XxxCache.cache 这个数组里，
如果再次调用，直接使用缓存中的地址，不会再去 new 了。

@目的 提高效率

*/
public class 包装类的缓存 {
    @Test
    public void test1(){
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);// false 引用类型，new了，地址不一样

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);// true 引用类型，使用缓存，地址一样

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);// false 引用类型，超出缓存，new了，地址不一样
        // 解释：超出了缓存的范围，重新new了

        // 其他数字类型也是一样

        Byte bt1 = 125;
        Byte bt2 = 125;
        System.out.println(bt1 == bt2);// true

        Long ln1 = 128l;
        Long ln2 = 128l;
        System.out.println(ln1 == ln2);// false
    }
}
