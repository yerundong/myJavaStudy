package 设计模式.单例模式;

/**
 @单例模式：
 */
public class Base {
    public static void main(String[] args) {

        // Singleton singleton = new Singleton();// 不可在外部实例

        HungrySingleton singleton1 = HungrySingleton.getInstance();
        HungrySingleton singleton2 = HungrySingleton.getInstance("张三");
        System.out.println(singleton1 == singleton2);
    }
}
