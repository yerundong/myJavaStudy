package 类和对象.this关键字;

public class TestThis {
    public int num = 250;
    public static int num2 = 260;

    public TestThis() {
        this(150);// this充当本类的构造函数
        this.says2();
        // 等同于
        // says2();
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
