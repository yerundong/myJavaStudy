package Lambda表达式;

import Lambda表达式.Lib.Interface1;
import Lambda表达式.Lib.Interface2;
import Lambda表达式.Lib.Interface3;
import Lambda表达式.Lib.Interface4;
import org.junit.jupiter.api.Test;

/*
@Lambda表达式:Lambda 表达式，也可称为闭包，它是推动 Java 8 发布的最重要新特性。Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
    使用 Lambda 表达式可以使代码变的更加简洁紧凑。

@本质：作为【函数式接口】的实例。它表达的是对象而不是函数。

@格式：
    parameter -> expression;
    或
    (parameters) ->{ statements; }

    ->：lambda操作符或箭头操作符
    parameter：形参列表，其实就是接口中抽象方法的形参列表
    expression：lambda体，重写的抽象方法的方法体

@举例：(o1, o2) -> Integer(o1, o2);

@以下是lambda表达式的重要特征:
    可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
    可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
    可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
    可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。

 */
public class Lambda {

    /**
     * @无参
     */
    @Test
    public void test1() {
        Interface1 inst1 = new Interface1() {
            @Override
            public void say() {
                System.out.println("say1");
            }
        };

        // 可以省略new、接口名，@Override、方法名，只留形参和方法体
        Interface1 inst2 = () -> {
            System.out.println("say2");
        };

        // 仅有一条执行语句的方法体，可以省略{}
        Interface1 inst3 = () -> System.out.println("say3");

        inst1.say();
        inst2.say();
        inst3.say();
    }

    /**
     * @有返回
     */
    @Test
    public void test2() {
        Interface2 inst1 = new Interface2() {
            @Override
            public String say() {
                String str = "say1";
                System.out.println(str);
                return str;
            }
        };

        Interface2 inst2 = () -> {
            String str = "say2";
            System.out.println(str);
            return str;
        };

        // 仅有一条执行语句且有返回的方法体，可以省略{}，箭头后面写返回数据
        Interface2 inst3 = () -> "say3";

        inst1.say();
        inst2.say();
        String say3 = inst3.say();
        System.out.println(say3);
    }

    /**
     * @单参
     */
    @Test
    public void test3() {
        Interface3 inst1 = new Interface3() {
            @Override
            public String say(String str) {
                System.out.println(str);
                return str;
            }
        };

        Interface3 inst2 = (String str) -> {
            System.out.println(str);
            return str;
        };

        // 形参的类型可以省略，类型推断
        Interface3 inst3 = (str) -> {
            System.out.println(str);
            return str;
        };

        // 如果仅有一个形参的方法还可以省略()
        Interface3 inst4 = str -> {
            System.out.println(str);
            return str;
        };

        inst1.say("say1");
        inst2.say("say2");
        inst3.say("say1");
        inst4.say("say2");
    }

    /**
     * @多参
     */
    @Test
    public void test4() {
        Interface4 inst1 = new Interface4() {
            @Override
            public String say(String str, int count) {
                System.out.println(str + ":" + count);
                return str;
            }
        };

        Interface4 inst2 = (String str, int count) -> {
            System.out.println(str + ":" + count);
            return str;
        };

        Interface4 inst3 = (str, count) -> {
            System.out.println(str + ":" + count);
            return str;
        };

        inst1.say("say1", 1);
        inst2.say("say2", 2);
        inst2.say("say3", 3);
    }
}
