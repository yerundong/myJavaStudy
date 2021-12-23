package 泛型.练习.lib;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Father<T, V> {
    private T name;
    private V age;
    private Class<T> clazz;

    {
        // 此处this指向子类
        Class clazz = this.getClass();
        Type type = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] types = parameterizedType.getActualTypeArguments();
        this.clazz = (Class<T>) types[0];

        for (Type ty : types) {
            System.out.println(ty);
        }
    }

    public Father() {
    }

    public Father(T name, V age) {
        this.name = name;
        this.age = age;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public V getAge() {
        return age;
    }

    public void setAge(V age) {
        this.age = age;
    }

    public Class<T> getClazz() {
        return clazz;
    }
}
