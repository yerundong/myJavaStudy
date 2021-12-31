package 接口.继承和实现组合;

public abstract class MySuperClass {
    public static final String MY_CONST = "MySuperClass MY_CONST";
    public String TIP = "MySuperClass TIP";

    public abstract void says();

    public void cook(){
        System.out.println("MySuperClass cook()");
    };

    public void look(){
        System.out.println("MySuperClass look()");
    };

    public static void see(){
        System.out.println("MySuperClass see()");
    };
}
