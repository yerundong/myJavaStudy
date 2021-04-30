package 泛型.泛型类;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    注意：泛型类（父）被继承时，可选择完全确定父类类型（参考SubClass1），或者完全保留父类类型，让子类实例化的时候确定类型（参考SubClass2），
        或者部分保留、部分确定父类类型（参考SubClass3）， 或者擦除父类类型（参考SubClass4）


 @注意事项：
    1.类中的非静态成员可以访问并使用类定义的泛型参数，静态成员不可访问
    2.类成员定义的泛型参数优先级大于类定义的泛型参数，若重复，定义的泛型会覆盖类的泛型参数
    3.不同泛型参数的引用不能互相赋值，参考例test3
    4.静态方法不能使用类的泛型，但可以有自己的泛型，因为静态方法加载时，泛型有可能还未传入（实例化）
    5.泛型类是无法继承自 Throwable 类（包括异常类（Exception\Error）），即异常类等不能使用泛型，
        参考：https://blog.csdn.net/ziwang_/article/details/56288597
    6.泛型只是变量，泛型不能充当类直接拿来创建（new），new后面只能是具体的类，但是可以作为类型强转的变量，参考例test4

 */

public class Base {
    /**
     * @Description 实例化时的泛型传入，各种写法
     */
    @Test
    public void test1(){
        GenericClass<String, Integer> stringInteger1 = new GenericClass<String, Integer>("Tom", 13);// 完整写法
        GenericClass<String, Integer> stringInteger2 = new GenericClass<>("Tom", 13);// 类型推导 √
        GenericClass<String, Integer> stringInteger5 = new GenericClass("Tom", 13);// 类型推导 √
        String tom1 = new GenericClass<>("Tom", 13).getName();// 类型推导 √

        GenericClass stringInteger3 = new GenericClass<String, Integer>("Tom", 13);// 泛型擦除 x
        GenericClass stringInteger4 = new GenericClass<>("Tom", 13);// 泛型擦除 x
        // GenericClass<> stringInteger6 = new GenericClass<String, Integer>("Tom", 13);// 错误写法 x
        Object tom2 = new GenericClass("Tom", 13).getName();// 泛型擦除 x

    }

    /**
     * @Description 继承时的泛型确定
     */
    @Test
    public void test2(){
        // SubClass1非泛型类（完全确定）
        SubClass1 subClass1 = new SubClass1();
        String name1 = subClass1.getName();

        // SubClass2为泛型类（完全保留）
        SubClass2<Double, Float> subClass2 = new SubClass2<>();
        Double name2 = subClass2.getName();

        // SubClass3为泛型类（部分保留，部分确定）
        SubClass3<Integer> subClass3 = new SubClass3<>();
        String name3 = subClass3.getName();
        Integer age3 = subClass3.getAge();

        // SubClass4为泛型类（完全擦除）
        SubClass4<Character, List<Integer>> subClass4 = new SubClass4<>();
        Object name = subClass4.getName();
        Object age = subClass4.getAge();
    }

    /**
     * @Description 不同泛型参数的引用不能互相赋值
     */
    @Test
    public void test3(){
        GenericClass<String, Integer> stringInteger1 = new GenericClass<>("Tom", 13);
        GenericClass<String, String> stringInteger2 = new GenericClass<>("Tom", "13");
        // stringInteger1 = stringInteger2;// 编译报错

        // 通配泛型可以赋值
        List<String> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        List<?> list3 = new ArrayList<>();
        // list1 = list2;// 编译报错
        list3 = list1;
        list3 = list2;


    }

    /**
     * @Description 不可充当具体的类，只能是变量
     */
    @Test
    public <T> void test4(){
        // T[] ts = new T[10];// 错误写法
        // T t = new T();// 错误写法

        T[] objects = (T[])new Objects[10];// 允许
    }
}
