package 导入;

import 接口.静态方法.TestClass;
import 类.Student;

/*
@ 规则：import 包名称.类名称；例如：import 类.JavaBean.TestJavaBean;

@ 两种导入声明:
    1.单类型导入(single-type-import) 例：import 类.JavaBean.TestJavaBean;
    2.按需类型导入(type-import-on-demand) 例:import import 接口.*;

@ 按需类型导入虽然不会降低Java代码的执行效率，但有以下缺点:
    1.编译速度：在一个很大的项目中，它们会极大的影响编译速度.但在小型项目中使用在编译时间上可以忽略不计。
    2.命名冲突：解决避免命名冲突问题的答案就是使用全名。而按需导入恰恰就是使用导入声明初衷的否定。
    3.说明问题：毕竟高级语言的代码是给人看的，按需导入看不出使用到的具体类型。
    4.无名包问题：如果在编译单元的顶部没有包声明，Java编译器首选会从无名包中搜索一个类型，然后才是按需类型声明。如果有命名冲突就会产生问题。

@ 注意：
    1.所属同一包的同级类，省略导包
    2.java.lang下的包的类，省略导包
    3.其他情况都需要显示地用import导入包，才能使用

 */
public class Import {
    public static void main(String[] args) {
        new Student();
        new TestClass();
    }
}
