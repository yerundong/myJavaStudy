package 泛型.泛型接口;

import org.junit.jupiter.api.Test;

/**
 @泛型接口:

 @声明格式：
    修饰符 interface interfaceName<T> {
        ...
    }

 @类型传入格式：
    修饰符 class ClassName implements interfaceName<Type> {
        ...
    }

 @泛型接口中，类型传入的时间点： 在接口被实现的时候确定类型
 */
public class Base implements GenericInterface<String> {

    @Test
    public void test(){
        look("a");
        see("a");
        GenericInterface.run(555);
    }

    @Override
    public String see(String s) {
        return null;
    }
}
