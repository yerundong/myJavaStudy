package 接口.多重继承;

public interface SuperInterface2 {
    // 常量
    public static final String MY_CONST = "SuperInterface2 MY_CONST";

    // 抽象方法
    public abstract void abs();
    public abstract void abs2();

    // 默认方法
    public default void def(){
        System.out.println("SuperInterface2 def");
    }
    public default void def2(){
        System.out.println("SuperInterface2 def2");
    }

    // 静态方法
    public static void stac(){
        System.out.println("SuperInterface2 stac");
    }
    public static void stac2(){
        System.out.println("SuperInterface2 stac2");
    }
}
