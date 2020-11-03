package 类和对象.抽象;

/**
 * @Description 普通类 继承 抽象类
 */
public class CommonClass1 extends AbsClass1 {

    public CommonClass1() {
    }

    public CommonClass1(int num) {
        super(num);
    }

    // 重写抽象方法
    @Override
    public void says() {
        System.out.println("i am CommonClass1 says");
    }

    @Override
    public void run() {
        System.out.println("i am CommonClass1 run");
    }

    // class AbsInsideClass {
    //     public void joke(){};
    //
    //     public void fanny(){
    //
    //     };
    // }
}
