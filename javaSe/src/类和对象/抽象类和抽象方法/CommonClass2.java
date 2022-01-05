package 类和对象.抽象类和抽象方法;

/**
 * @Description 普通类 继承 抽象类
 */
public class CommonClass2 extends AbsClass2 {

    // 爷爷类（AbsClass1）的says抽象方法已经被爸爸类（AbsClass2）重写，
    // 这里可以不用重写，也可以重写，看需求

    // @Override
    // public void says(){
    //     System.out.println("i am CommonClass2 says");
    // }

    @Override
    public void run() {
        System.out.println("i am CommonClass2 run");
    }
}
