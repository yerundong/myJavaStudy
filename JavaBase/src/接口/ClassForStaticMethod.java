package 接口;
/*
@ ClassForStaticMethod：实现InterfaceForStaticMethod接口的实现类

*/
public class ClassForStaticMethod implements InterfaceForStaticMethod {

    // 静态方法不可重写
    // @Override
    public void says() {
        System.out.println("我是ClassForStaticMethod的成员方法says，与InterfaceForStaticMethod的静态方法无关");
    }

}
