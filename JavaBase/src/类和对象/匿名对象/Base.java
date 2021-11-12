package 类和对象.匿名对象;

import java.util.Scanner;

public class Base {
    public static void main(String[] args) {
        new Base.Guys().name = "扶苏";
        new Base.Guys().says();

        // 匿名对象直接调用
        int num = new Scanner(System.in).nextInt();
        System.out.println("我输入了数字：" + num);
    }

    static class Guys {
        String name;

        public void says() {
            System.out.println("name: " + name);
        }
    }
}

