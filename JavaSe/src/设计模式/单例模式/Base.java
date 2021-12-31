package 设计模式.单例模式;

public class Base {
    public static void main(String[] args) {

        // new HungrySingleton();// 不可在外部实例化

        HungrySingleton hungry1 = HungrySingleton.getInstance();
        HungrySingleton hungry2 = HungrySingleton.getInstance();
        System.out.println(hungry1 == hungry2);

        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();
        System.out.println(lazy1 == lazy2);
    }
}
