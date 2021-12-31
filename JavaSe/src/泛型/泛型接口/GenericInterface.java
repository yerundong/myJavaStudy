package 泛型.泛型接口;

public interface GenericInterface<T> {
    default void look(T t){
        System.out.println(t);
    };

    T see(T t);

    // static void run(T t){};// 静态成员不能访问接口定义的泛型

    static <K> void run(K k){
        System.out.println(k);
    };
}
