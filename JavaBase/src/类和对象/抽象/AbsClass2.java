package 类和对象.抽象;

/**
 * @Description 抽象类 继承 抽象类
 */
public abstract class AbsClass2 extends AbsClass1 {

    // 这里只重写了一个抽象方法，还有其他的抽象方法未重写
    // 只能重写所有抽象方法，或也声明为一个抽象类
    @Override
    public void says() {
        System.out.println("i am AbsClass2 says");
    }

}
