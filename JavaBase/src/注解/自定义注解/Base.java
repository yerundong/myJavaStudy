package 注解.自定义注解;

import 注解.自定义注解.lib.*;

/*
 @自定义注解： 自定义注解自动继承了 java.lang.annotation.Annotation 接口

 @关键字： @interface

 @声明格式：
     public @interface AnnotationName{
        ...
     }

 @使用格式： @AnnotationName(...)

 @注： 注解内部成员只有成员变量一种。

 @成员变量（配置参数）： Annotation 的成员变量在 Annotation 定义中以【无参数方法】的形式来声明。其方法名和返回值定义了该成员的名字和类型。

    @无默认声明格式： type valueName();
    @有默认声明格式： type valueName() default value;

    @类型： 配置参数的类型只能是八种基本数据类型、String 类型、Class类型、enum类型、Annotation类型及以上所有类型的数组。
    @建议： 如果只有一个配置参数，建议使用参数名为 value
    @传入格式： (valueName = value)
    @注：
        1.没有配置参数，或者所有配置参数都有默认值时，可以省略(...)
        2.如果只有一个参数成员，且名称为 value，可以省略 valueName =
        3.没有成员的 Annotation 称为标记，包含成员的 Annotation 称为元数据 Annotation

@注： 自定义注解必须配上注解的信息处理流程才有意义。



 */
public class Base {

    @NoneParam
    public void noneParams() {
    }

    @OneParam(tip = 1)
    public void OneParam() {
    }

    @OneValueParam("hello")
    public void OneValueParam() {
    }

    @MultiParam(value = {"hi"}, key = 'a')
    public void MultiParam() {
    }

    @DefaultParam
    public void DefaultParam() {
    }
}
