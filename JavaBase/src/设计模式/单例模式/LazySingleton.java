package 设计模式.单例模式;

/**
 * @Description 单例模式-懒汉式
 * @Author 叶润东
 * @Date 2020/11/1
 * @Version 1.0
 */
public class LazySingleton {
    private String name;

    private LazySingleton() {
    }

    private static LazySingleton instance;

    public static LazySingleton getInstance() {
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}

