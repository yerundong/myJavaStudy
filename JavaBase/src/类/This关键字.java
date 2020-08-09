package 类;
/*
    this关键字：
        1.用于访问本类的成员变量\静态变量，以及调用成员方法\静态方法
        2.充当本类的构造函数this()\this(...)
        3.静态方法中不能使用this
* */
public class This关键字 {
    public static void main(String[] args) {
        new TestThis();
    }
}
class TestThis {
    public int num = 250;
    public static int num2 = 260;

    public TestThis() {
        this(150);
        this.says2();
        System.out.println(this.num);
    }

    public TestThis(int num) {
        this.num = num;
    }

    public void says(){
        System.out.println("says: " + this.num2);
    }

    public void says2(){
        this.says();
        this.says3();
    }

    public static void says3(){
        // this.says2();// 报错
    }
}

