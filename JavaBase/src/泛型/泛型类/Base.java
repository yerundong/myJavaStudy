package 泛型.泛型类;

import org.junit.jupiter.api.Test;

/**
 @泛型类： 泛型类的声明和非泛型类的声明类似，除了在类名后面添加了类型参数声明部分。和泛型方法一样，泛型类的类型参数声明部分也包含一个或多个类型参数，
    参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。因为他们接受一个或多个参数，这些类被称为参数化的类或参数化的类型。

 @声明格式：
    class GenericClass<T>{
        ...
    }
 @类型传入格式：
    1.无变量接收：new ClassName<Type>();
    2.有变量接收：ClassName<Type> Var = new ClassName<Type>();
      注：JDK7.0以后，增加类型推断，后面的泛型参数可省略：ClassName<Type> Var = new ClassName<>();
         但后面的尖括号<>不可省略，省略了<>等于不使用泛型

 @泛型类中，类型传入的时间点： 在类被实例化、继承的时候确定类型
    注意：泛型类（父）被继承时可选择确定（参考SubClass1），或不确定类型参数，引用子类的泛型参数，让子类实例化的时候确定类型（参考SubClass2）

 @注意事项：
    1.类中的非静态成员可以访问并使用类定义的泛型参数，静态成员不可访问
    2.类成员定义的泛型参数优先级大于类定义的泛型参数，若重复，定义的泛型会覆盖类的泛型参数
    3.不同泛型参数的引用不能互相赋值
 */

public class Base {
    /**
     * @Description 实例化时的泛型传入
     */
    @Test
    public void test1(){
        new GenericClass<String, Integer>();
        GenericClass<String, Integer> stringInteger1 = new GenericClass<String, Integer>("Tom", 13);// 完整写法
        GenericClass stringInteger2 = new GenericClass<String, Integer>("Tom", 13);// 类型推断 √
        GenericClass<String, String> stringInteger3 = new GenericClass<>("Tom", "13");// 类型推断 √
        GenericClass<String, Integer> stringInteger4 = new GenericClass("Tom", "13");// 不使用泛型 x
    }

    /**
     * @Description
     */
    @Test
    public void test2(){
        SubClass1 subClass1 = new SubClass1();
        SubClass2<Double, Float> subClass2 = new SubClass2<>();
        Character age = subClass1.getAge();
        String name = subClass1.getName();
        Float age1 = subClass2.getAge();
        Double name1 = subClass2.getName();
    }

    /**
     * @Description 不同泛型参数的引用不能互相赋值
     */
    @Test
    public void test3(){
        GenericClass<String, Integer> stringInteger1 = new GenericClass<>("Tom", 13);
        GenericClass<String, String> stringInteger2 = new GenericClass<>("Tom", "13");
        // stringInteger1 = stringInteger2;// 编译报错
    }
}
