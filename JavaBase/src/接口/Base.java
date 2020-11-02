package 接口;

/**
@接口（Interface）：
    接口，是Java语言中一种引用类型，是方法的集合，是多个类的公共规范。如果说类的内部封装了成员变量、构造方法和成员方法，
    那么接口的内部主要就是封装了方法，其中最重要的就是的：抽象方法。

@定义方式：
    public interface 接口名称 {
        // 接口内容
    }

@接口的命名规范： 大驼峰（MyInterface）

@接口与类的对比异同：
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
    11.接口不能书写代码块

@不同版本Java，包含的内容：
    Java 7包含的内容有：
        1. 常量
        2. 抽象方法

    Java 8，额外包含有：
        3. 默认方法
        4. 静态方法

    Java 9，额外包含有：
        5. 私有方法

@类实现接口：接口不能直接使用，必须有一个“实现类”来“实现”该接口。

@格式：public class 实现类名称 implements 接口名称[, 接口名称2, 接口名称3, ...] {
        // ...
      }

*/
public class Base {
    public static void main(String[] args) {
        // 报错：不能直接new接口
        // new InterfaceForMethod();
    }
}






















