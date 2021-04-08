package 泛型.泛型类;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 @泛型类： 泛型类的声明和非泛型类的声明类似，除了在类名后面添加了类型参数声明部分。和泛型方法一样，泛型类的类型参数声明部分也包含一个或多个类型参数，
    参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。因为他们接受一个或多个参数，这些类被称为参数化的类或参数化的类型。

 @声明规则：
    class GenericClass<E,T...>{
        ...
    }
 */

public class Base {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        // integers.add('a');

    }

    @Test
    public void test(){
        GenericClass<String, Integer> stringInteger1 = new GenericClass<String, Integer>();
        GenericClass<String, Integer> stringInteger2 = new GenericClass<String, Integer>("Tom", 13);

        System.out.println(stringInteger1.getName());
        System.out.println(stringInteger2.getName());
    }
}
