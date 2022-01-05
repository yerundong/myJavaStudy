package 类和对象.类的成员.静态成员;

public class Main {
    public static void main(String[] args) {
        System.out.println("main函数执行！！！");

        StaticMember sm = new StaticMember("郭靖");

        // 静态属性
        System.out.println(sm.country);// 正确，不推荐，这种写法在编译之后也会被javac翻译成为“类名称.静态变量名”
        System.out.println(StaticMember.country); // 正确，推荐

        // 静态方法
        sm.run();// 正确，不推荐 这种写法在编译之后也会被javac翻译成为“类名称.静态方法名”
        StaticMember.run(); // 正确，推荐
        StaticMember.setCountry("宋");

        // 静态内部类
        new StaticMember.StaticInsideClass();
    }
}

