package 接口;
/*
@ ClassForDefaultMethod：实现InterfaceForDefaultMethod接口的实现类

*/
public class ClassForDefaultMethod implements InterfaceForDefaultMethod {

    @Override
    public void says1() {
        System.out.println("i am ClassForDefaultMethod says1");
    }

    // 默认方法不是必需重写，因为他不是抽象的
    // @Override
    // public void says2() {
    //
    // }
}
