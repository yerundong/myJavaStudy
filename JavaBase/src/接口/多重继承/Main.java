package 接口.多重继承;

public class Main {
    public static void main(String[] args) {
        ImplClass obj = new ImplClass();
        // 常量
        System.out.println(ImplClass.MY_CONST);

        // 抽象方法
        obj.abs();
        obj.abs1();
        obj.abs2();

        // 默认方法
        obj.def();
        obj.def1();
        obj.def2();

        // 静态方法
        SuperInterface1.stac();
        SuperInterface1.stac1();
        SuperInterface2.stac();
        SuperInterface2.stac2();
    }
}
