package 接口.静态方法;

/*
@ ClassForStaticMethod：实现InterfaceForStaticMethod接口的实现类

*/
public class TestClass implements TestInterface {

    // 静态方法不可重写，可隐藏
    // @Override
    public void says() {
        System.out.println("我是TestClass的成员方法says，与TestInterface的静态方法无关");
    }

}
