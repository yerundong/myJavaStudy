package 修饰符.权限修饰符;
/**
@Java语言提供了很多修饰符，主要分为以下两类：
    1.访问（权限）修饰符，通常放在语句的最前端（public，default...）
    2.非访问修饰符（final，static...）

@Java支持4种不同的访问权限：
    1.public : 对所有类可见。使用对象：类、接口、类成员
    2.protected : 对同一包内的类和所有子类可见。使用对象：类成员、类和对象.内部类。 注意：不能修饰外部类。
    3.default (即默认，什么也不写）: 在同一包内可见，不使用任何修饰符。使用对象：类、接口、类成员。
    4.private : 仅在同一类内可见。使用对象：类成员、类和对象.内部类。 注意：不能修饰外部类

@访问范围： public > protected > (default) > private

@修饰对象：
    1.接口、类的成员
    2.类、接口

*/
public class Base {
}
