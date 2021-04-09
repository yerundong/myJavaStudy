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

 @泛型方法中，类型传入的时间点： 在方法被调用的时候确定类型，通过实参来确定

 @注意事项：
    1.方法上泛型的差异不构成重载
 */
public class Base {
    @Test
    public void test(){
        Integer look = look(15);
        see('J', 16);

        run(new GenericClass<String, Integer>("Tom", 99), 66);
    }

    public <T> T look (T num) {
        return num;
    }

    public static <T,E> void see (E name, T num) {}

    // 泛型方法与泛型类组合使用
    public <T> void run (GenericClass<String, T> g, T t){
        System.out.println(t);
    }

    // 只有方法上定义了泛型才算泛型方法，以下不算泛型方法
    public void check (GenericClass<String, Integer> g){}

}
