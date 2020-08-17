package 包和源文件相关规则;

/*
@ Java 包：包主要用来对类和接口进行分类。当开发 Java 程序时，可能编写成百上千的类，因此很有必要对类和接口进行分类。

@ Java 类：类可以看成是创建 Java 对象的模板

@ 包、源文件、类、接口的命名规范：打驼峰（MyClass）

@ 注意事项：
    1.一个源文件中最多只能有一个 public 类，且 public 类名必须与源文件名一致（原因：为了在import公共类时提高效率）
    2.一个源文件可以有多个非 public 类，可以跟文件名不同
    3.一个包下不能有重复名称的同级类
    4.如果一个类定义在某个包中，那么 package 语句应该在源文件的首行。
    5.如果源文件包含 import 语句，那么应该放在 package 语句和类定义之间。如果没有 package 语句，那么 import 语句应该在源文件中最前面。
    6.import 语句和 package 语句对源文件中定义的所有类都有效。在同一源文件中，不能给不同的类不同的包声明。
    7.虽然一个源文件可以存放多个类，但为了为了便于管理，一般一个源文件放一个类
*/
public class Main {
    public static void main(String[] args) {

    }
}
