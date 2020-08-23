package 类.Final修饰符.Final类成员;
/*
@ final成员方法：final方法不可被重写、隐藏，但可以被重载，成为最终方法

@ 成员变量：
    1.成员变量有默认值，所以必须直接赋值，或者构造函数进行赋值，二者选其一
    2.子类可以隐藏
*/
public class Main {
    public static void main(String[] args) {
        SubClass subclass = new SubClass();

        SuperClass.look();
        SubClass.look();
    }
}
