package 泛型.泛型方法;

import org.junit.jupiter.api.Test;
import 泛型.泛型类.GenericClass;

/**
 @泛型方法

 @声明格式：
    修饰符 <T> returnType methodName (param){
        ...
    }

 @类型传入格式：
    methodName(Type param);

 @泛型方法中，类型传入的时间点： 在方法被调用的时候确定类型，通过实参的类型来来确定

 @注意事项：
    1.方法上泛型的差异不构成重载
 */
public class Base {
    @Test
    public void test(){
        GenericClass gc = look('a', 15);
        System.out.println(gc.getName());
        System.out.println(gc.getAge());

        see('J', 16);

        run(new GenericClass<String, Integer>("Tom", 99), 66);
    }

    public <T, E> GenericClass<T, E> look (T p1, E p2) {
        return new GenericClass<>(p1, p2);
    }

    public static <T,E> void see (E name, T num) {}

    // 泛型方法与泛型类组合使用
    public <T> void run (GenericClass<String, T> g, T t){
        System.out.println(t);
    }

    // 只有方法上定义了泛型才算泛型方法，以下不算泛型方法
    public void check (GenericClass<String, Integer> g){}

}
