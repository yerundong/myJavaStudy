package 类和对象.内部类.局部内部类;

/**
 @局部内部类：定义在方法内的类

 @注意事项：
     1.局部内部类只能在该方法内访问，方法外无法访问
     2.局部内部类不允许使用权限修饰符（public，default...），因为没有意义，它只能在方法内访问
     3.局部内部类只能通过所在的方法去使用

 @局部内部类访问该方法内的局部变量的情况：
     1.该变量必须是【final】的，原因：因为局部变量是跟方法走的，而局部内部类是new出来的，是在堆中的，两者声明周期不同，所以局部变量必须不变
     2.从Java 8+开始，只要局部变量事实不变，那么final关键字可以省略
 */
public class Base {

    public static void main(String[] args) {
        Base outCla = new Base();
        outCla.says();
    }

    // 外部类的成员变量
    int num = 10;// ①

    // 外部类的成员方法
    public void says(){

        // 如果被局部内部类访问，规定必须是final变量（jdk1.8以上可以省略final）
        // 因为内部类也会生成独立的直接码文件，
        int num = 20;// ②
        // num = 10;// 报错，被局部内部类访问无法更改，必须是final

        // 局部内部类
        class InnerClass{
            // 若局部内部类的成员变量③和局部变量②重名，则访问不到方法的局部变量②了（Naming Shadow）
            int num = 30;// ③

            public void look(){

                System.out.println("局部内部类的look执行了");

                System.out.println(num);// ③或②
                // System.out.println(this.num);// ③
                System.out.println(Base.this.num);// ①
            }
        }

        InnerClass innerCla = new InnerClass();
        innerCla.look();

    }
}
