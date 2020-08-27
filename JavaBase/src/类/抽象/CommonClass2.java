package 类.抽象;

public class CommonClass2 extends AbstctExtendsAbstct {

    // 爷爷类（AbsctClass）的says抽象方法已经被父类（AbstctExtendsAbstct）重写，
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
