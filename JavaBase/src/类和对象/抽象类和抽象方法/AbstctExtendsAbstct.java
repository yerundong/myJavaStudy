package 类和对象.抽象类和抽象方法;

public abstract class AbstctExtendsAbstct extends AbsctClass {

    // 这里只重写了一个抽象方法，还有其他的抽象方法未重写
    // 只能重写所有抽象方法，或也声明为一个抽象类

    @Override
    public void says() {
        System.out.println("i am AbstctExtendsAbstct says");
    }

}
