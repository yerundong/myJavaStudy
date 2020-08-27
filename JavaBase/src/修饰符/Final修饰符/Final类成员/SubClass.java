package 修饰符.Final修饰符.Final类成员;

public class SubClass extends SuperClass {
    public String name = "SubClass name";
    public static String tip = "SubClass tip";

    // 报错：无法对final方法重写
    // @Override
    // public final void says(){}

    // 可以对final方法重载
    public final void says(int num){}

    // 报错：静态的final方法同样也无法隐藏
    // public static void look(){
    //     System.out.println("SubClass look");
    // }
}
