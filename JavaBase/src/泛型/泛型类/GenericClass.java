package 泛型.泛型类;

import 示例.Person;

public class GenericClass<E,T>  {
    private E name;
    private T age;

    public GenericClass() {
    }

    public GenericClass(E name, T age) {
        this.name = name;
        this.age = age;
    }

    // 这里的 V 是来自方法的泛型参数，E是来自类的泛型参数
    public <V> V look(V p, E n){
        System.out.println(n);
        return p;
    }

    // 这里的E,T都是来自方法的泛型参数，虽然他们与类的泛型参数相同，但被覆盖了
    public <E,T> void see(E e, T t){
    }

    class Game{
        private T tip;
    }

    // 静态方法无法访问类上定义的泛型；如果静态方法操作的引用数据类型不确定的时候，必须要将泛型定义在方法上。
    // public static void slip(T t){}// 编译报错
    public static <T> void slip(T t){}

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }
}
