package 权限修饰符.Public修饰符;

/*
@ public：访问限制最宽的修饰符，一般称之为“公共的”。被其修饰的类、变量以及方法不仅可以跨类访问，而且允许跨包（package）访问。

@ 可见性：任意处。

@ 修饰对象：任意对象。

@ 注意事项:
    1.一个源文件只能有一个public类输出
*/

public class Main {
    public static void main(String[] args) {
        TestPublic tom = new TestPublic();
        System.out.println(tom.plnum);

        // 不能修饰变量
        // public int num = 321;// 报错
    }
}
