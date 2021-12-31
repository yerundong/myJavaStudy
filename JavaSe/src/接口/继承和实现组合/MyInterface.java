package 接口.继承和实现组合;

public interface MyInterface {
    String MY_CONST = "MyInterface MY_CONST";
    String TIP = "MyInterface TIP";

    void says();

    void cook();

    default void look(){
        System.out.println("MyInterface look()");
    };

    static void see(){
        System.out.println("MyInterface see()");
    };
}
