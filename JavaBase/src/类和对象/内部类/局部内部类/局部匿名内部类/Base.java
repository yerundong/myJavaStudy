package 类和对象.内部类.局部内部类.局部匿名内部类;

import org.junit.jupiter.api.Test;
import 类和对象.内部类.局部内部类.局部匿名内部类.lib.TestClass;
import 类和对象.内部类.局部内部类.局部匿名内部类.lib.TestInterface;

public class Base {
    /**
     * @ 局部匿名内部类-子类继承
     */
    @Test
    public void test1() {
        TestClass obj1 = new TestClass() {
            @Override
            public void says() {
                System.out.println("局部匿名内部类-子类继承执行！");
            }
        };
        obj1.says();
    }

    /**
     * @ 局部匿名内部类-实现类
     */
    @Test
    public void test2() {
        TestInterface obj2 = new TestInterface() {
            @Override
            public void look() {
                System.out.println("局部匿名内部类-实现类执行！");
            }
        };

        // lambda写法
        // TestInterface obj2 = () -> System.out.println("局部匿名内部类-实现类执行！");

        obj2.look();
    }

    /**
     * 局部匿名内部类 + 匿名对象
     */
    @Test
    public void test3() {
        new TestClass() {
            @Override
            public void says() {
                System.out.println("匿名内部类 + 匿名对象 执行！");
            }
        }.says();
    }

    public String d = "我是变量d";

    /**
     * @测试-局部匿名内部类引用外部变量问题
     */
    @Test
    public void test4() {
        String a = "我是变量a";
        String b = "我是隐式常量b";
        final String c = "我是常量c";
        new TestInterface() {
            @Override
            public void look() {
                // System.out.println(a);// 引用局部变量，编译报错
                System.out.println(d);// 引用外部类变量，允许
                // b = "";// 内部修改局部变量，编译报错

                System.out.println(c);// 引用外部类常量，允许
            }
        }.look();

        // lambda表达式同样也有这个问题
        // ((TestInterface) () -> {
        //     System.out.println(d);
        // }).look();

        a = "";
        d = "";
    }
}
