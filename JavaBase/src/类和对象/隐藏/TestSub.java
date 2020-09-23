package 类和对象.隐藏;

public class TestSub extends TestSuper {
    // 隐藏父类name
    public String name = "TestSub name，隐藏父类name";

    // 隐藏父类tip
    public static String tip = "TestSub tip，隐藏父类tip";

    // 隐藏父类的静态方法
    public static void says (){
        System.out.println("我是子类says，隐藏了父类的静态方法");
    }

    // public TestSub() {}
    //
    // public TestSub(String name) {
    //     super(name);
    // }
    //
    // @Override
    // public String says (){
    //     System.out.println("我是重写方法！" );
    //     return "我是重写方法！";
    // }

    // 静态方法的重载
    // public static void look (int num){
    //     System.out.println("我是子类look1");
    // }



}
