package 泛型.泛型类;

public class GenericClass<E,T> {
    private E name;
    private T age;

    public GenericClass() {
    }

    public GenericClass(E name, T age) {
        this.name = name;
        this.age = age;
    }

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
