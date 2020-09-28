package 类和对象;

import java.util.Scanner;

/*
@ 定义：创建对象没有显式地赋给一个变量名，即为匿名对象

＠　格式：
    普通对象
    类名称 对象名 = new 类名称();

    匿名对象
    new 类名称().method();

@ 注意事项：匿名对象只能使用唯一的一次，下次再用不得不再创建一个新对象。

@ 使用建议：如果确定有一个对象只需要使用唯一的一次，就可以用匿名对象。
 */
public class 匿名对象 {
    public static void main(String[] args) {
        new 匿名对象.Guys().name = "扶苏";
        new 匿名对象.Guys().says();

        // 匿名对象直接调用
        int num = new Scanner(System.in).nextInt();
        System.out.println("我输入了数字：" + num);
    }

    static class Guys{
        String name;
        public void says(){
            System.out.println("name: " + name);
        }
    }
}

