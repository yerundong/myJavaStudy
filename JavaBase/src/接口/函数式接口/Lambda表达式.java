package 接口.函数式接口;

import org.junit.jupiter.api.Test;
import 接口.函数式接口.lib.Interface1;
import 接口.函数式接口.lib.Interface2;
import 接口.函数式接口.lib.Interface3;
import 接口.函数式接口.lib.Interface4;

public class Lambda表达式 {

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
