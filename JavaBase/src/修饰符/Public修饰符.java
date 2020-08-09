package 修饰符;
/*
访问范围：public > protected > (default) > private

public：访问限制最宽的修饰符，一般称之为“公共的”。被其修饰的类、属性以及方法不仅可以跨类访问，而且允许跨包（package）访问。

1.public修饰类的属性和方法:
    1.跨包访问

2.public修饰类:
    1.跨包访问
    2.一个.java文件只能有一个public类输出
    3.可以修饰普通类和内部类
*/
public class Public修饰符 {
    public static void main(String[] args) {
        Tom tom = new Tom();
        System.out.println(tom.plnum);

        // 不能修饰变量
        // public int num = 321;// 报错
    }
}
class Tom {
    public int plnum = 123;
}

