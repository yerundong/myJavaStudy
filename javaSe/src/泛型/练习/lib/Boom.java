package 泛型.练习.lib;

public class Boom<T, V> {
    private final Class<T> clazzT;
    private final Class<V> clazzV;

    public Boom(Class<T> clazzT, Class<V> clazzV) {
        this.clazzT = clazzT;
        this.clazzV = clazzV;
    }

    public Class<T> getClazzT() {
        return clazzT;
    }

    public Class<V> getClazzV() {
        return clazzV;
    }
}
