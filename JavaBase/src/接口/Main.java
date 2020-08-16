package 接口;
/*
@ 接口（Interface）：接口在JAVA编程语言中是一个抽象类型，是抽象方法的集合，即多个类的公共规范。一个类通过继承接口的方式，从而来继承接口的抽象方法。
                接口是一种引用数据类型，最重要的内容就是其中的：抽象方法。

@ 定义方式：public interface 接口名称 {
        // 接口内容
    }

@ 接口与类的对比异同：
    1.接口并不是类，编写接口的方式和类很相似，但是它们属于不同的概念。
    2.类描述对象的属性和方法；接口则包含类要实现的方法。
    3.接口不能用于实例化对象。
    4.接口没有构造方法。
    5.一个接口可以有多个方法，但所有的方法必须是抽象方法。
    6.接口不是被类继承了，而是要被类实现。
    7.接口支持多继承，而类只支持单继承。
    8.接口文件保存在.java 结尾的文件中，文件名使用接口名。
    9.接口的字节码文件保存在 .class 结尾的文件中。
    10.接口不能包含成员变量，除了 static 和 final 变量。

@ 不同版本Java，包含的内容
    Java 7包含的内容有：
        1. 常量
        2. 抽象方法

    Java 8，额外包含有：
        3. 默认方法
        4. 静态方法

    Java 9，额外包含有：
        5. 私有方法

@ 类实现接口：接口不能直接使用，必须有一个“实现类”来“实现”该接口。

@ 格式：public class 实现类名称 implements 接口名称 {
        // ...
      }

@ 注意事项：
    1.普通实现类必须有覆盖重写接口中所有的抽象方法；
    2.抽象实现类可以选择覆盖重写接口中的抽象方法；

*/
public class Main {
    public static void main(String[] args) {
        // 报错：不能直接new接口
        // new InterfaceForMethod();

        // 抽象方法：
        ClassForAbstractMethod obj1 = new ClassForAbstractMethod();
        obj1.says1();
        obj1.says2();

        // 默认方法
        ClassForDefaultMethod obj2 = new ClassForDefaultMethod();
        obj2.says1();
        obj2.says2();

        // 静态方法
        ClassForStaticMethod obj3 = new ClassForStaticMethod();
        obj3.says();
        InterfaceForStaticMethod.says();
    }
}






















