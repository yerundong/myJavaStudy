package 类.内部类.成员内部类;

public class OuterClass {
    int num = 10;
    int age1 = 10;
    static int year = 2020;

    // 非静态成员内部类
    public class InnerClass{

        int num = 20;
        int age2 = 20;
        public void says(){
            System.out.println("非静态成员内部类执行了");

            int num = 30;
            int age3 = 30;

            // 访问内外部成员变量和局部变量
            // 不重名时：
            // System.out.println(age1);// 10
            // System.out.println(age2);// 20
            // System.out.println(age3);// 30
            // 重名时，完整格式：
            // System.out.println(num);// 30
            // System.out.println(this.num);// 20
            // System.out.println(OuterClass.this.num);// 10

            // 访问外部静态变量
            // System.out.println(OuterClass.year);// 30
            // new StaticInnerClass();
        }
    }

    // 静态成员内部类
    public static class StaticInnerClass{
        public void see(){
            System.out.println("静态成员内部类执行了");
        }
    }

    public void cook(){
        // 通过成员方法访问非静态成员内部类
        new InnerClass().says();

        // 通过成员方法访问静态成员内部类
        new StaticInnerClass().see();
    }
}
