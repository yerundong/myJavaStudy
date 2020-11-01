package 设计模式.单例模式;

/**
 * @Description 单例模式-饿汉模式
 * @Author 叶润东
 * @Date 2020/11/1
 * @Version 1.0
 */
public class HungrySingleton {
    private String name;

    private HungrySingleton() {
    }

    private HungrySingleton(String name) {
        this.name = name;
    }

    private static HungrySingleton instance = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return instance;
    }

    public static HungrySingleton getInstance(String name) {
        return new HungrySingleton(name);
    }
}
