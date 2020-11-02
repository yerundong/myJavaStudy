package 类和对象.final修饰符.final类成员;

public class SubClass extends SuperClass {
    public String NAME = "SubClass NAME";
    public static String tip = "SubClass tip";

    // 报错：无法对final方法重写
    // @Override
    // public final void says(){}

    // 报错：静态的final方法同样也无法隐藏
    // public static void look(){
    //     System.out.println("SubClass look");
    // }

    // 可以对final方法重载
    public void says(int num){}
}
