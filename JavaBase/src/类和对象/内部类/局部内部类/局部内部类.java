package 类和对象.内部类.局部内部类;

import org.junit.jupiter.api.Test;

public class 局部内部类 {
    @Test
    public void test() {
        局部内部类 outCla = new 局部内部类();
        outCla.says();
    }

    // 外部类的成员变量
    int num = 10;// ①

    // 外部类的成员方法
    public void says() {

        // 若方法局部变量被局部内部类访问，规定必须是final变量（jdk1.8以上可以省略final）
        // 因为内部类也会生成独立的直接码文件，
        int num = 20;// ②
        // num = 10;// 报错，被局部内部类访问无法更改，必须是final

        // 局部内部类
        class InnerClass {
            // 若局部内部类的成员变量③和局部变量②重名，则访问不到方法的局部变量②了（Naming Shadow）
            int num = 30;// ③

            public void look() {

                System.out.println("局部内部类的look执行了");

                System.out.println(num);// ③或②
                // System.out.println(this.num);// ③
                System.out.println(局部内部类.this.num);// ①
            }
        }

        InnerClass innerCla = new InnerClass();
        innerCla.look();

    }
}
