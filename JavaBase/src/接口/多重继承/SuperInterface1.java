package 接口.多重继承;

public interface SuperInterface1 {
    // 常量
    public static final String MY_CONST = "SuperInterface1 MY_CONST";

    // 抽象方法
    public abstract void abs();
    public abstract void abs1();

    // 默认方法
    public default void def(){
        System.out.println("SuperInterface1 def");
    }
    public default void def1(){
        System.out.println("SuperInterface1 def1");
    }

    // 静态方法
    public static void stac(){
        System.out.println("SuperInterface1 stac");
    }
    public static void stac1(){
        System.out.println("SuperInterface1 stac1");
    }
}
