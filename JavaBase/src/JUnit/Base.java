package JUnit;

import org.junit.jupiter.api.Test;

/**
@简介：
    JUnit是一个Java语言的单元测试框架。它由Kent Beck和Erich Gamma建立，逐渐成为源于Kent Beck的sUnit的xUnit家族中最为成功的一个。
    JUnit有它自己的JUnit扩展生态圈。多数Java的开发环境都已经集成了JUnit作为单元测试的工具。
    JUnit是由 Erich Gamma 和 Kent Beck 编写的一个回归测试框架（regression testing framework）。
    Junit测试是程序员测试，即所谓白盒测试，因为程序员知道被测试的软件如何（How）完成功能和完成什么样（What）的功能。
    Junit是一套框架，继承TestCase类，就可以用Junit进行自动测试了。

@要求：
    1.测试类是公共的
    2.测试类只能有一个公共无参的构造函数
*/
public class Base {
    private String name;
    private int age;

    public void look(){
        System.out.println(name);
    }

    @Test
    public void test_look() {
        name = "张三";
        look();
    }

    public void says(String str){
        System.out.println(str);
    }

    @Test
    public void testSays(){
        says("hello teacher.junit");
    }

}
