package 泛型.泛型方法;

/**
 @泛型方法

 @声明规则：
    修饰符 <E,T...> returnType methodName (paramType A...){
        ...
    }
 */
public class Base {
    public <E,T> E look (E name, T num) {
        return name;
    }

    public static <E,T> void see (E name, T num) {

    }
}
