package 枚举类;

import org.junit.jupiter.api.Test;

/**
 @枚举类： 当一个类的对象是有限个的，确定的，这个类称为枚举类。

 @建议：
 1.当我们需要一组有限个数的常量时，建议使用枚举类
 2.当枚举类只有一个对象时，可以用单例模式实现

 @两种方式：
    1.自定义枚举类（JDK 5.0之前），参见Season
    2.enum关键字定义枚举类（JDK 5.0之后），参见Season
 */
public class Base {
    @Test
    public void test(){
        Season spring = Season.SPRING;
        Season winter = Season.WINTER;
        System.out.println(spring);
    }
}
